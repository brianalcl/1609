package games.g2048.logic;

import java.util.Iterator;
import java.util.Random;

import general.logic.GraphicCell;
import general.logic.Map;
import general.random.NRandom;

public class G2048Map extends Map{
	
	protected Random rnd;
	protected GraphicCell unusable;
	protected int totalOccupiedCells;
	protected Piece[][] piece;
	protected boolean move;
	
	public G2048Map(G2048Game game) {
		super(game);
		this.rnd = NRandom.getInstance();
		this.unusable = new GraphicCell(game.getImageFactory().getSquircle(), game.getImageFactory().getEmptyColor());
		this.totalOccupiedCells = 0;
		this.move = false;
		
		piece = new Piece[4][4];
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				piece[r][c] = new Piece(r, c, this, game.getImageFactory());
				piece[r][c].clear();
			}
		}
		
		charge();
		putNumber();
	}
	
	public void charge() {
		for(int c = 0; c < 2; c++) 
			for(int r = 1; r < ROW; r++) 
				matrix[r][c].put(unusable);
		
		for(int c = 14; c < 16; c++) 
			for(int r = 1; r < ROW; r++) 
				matrix[r][c].put(unusable);
		
		for(int c = 0; c < 16; c++)
			matrix[0][c].put(unusable);

	}
	
	public void moveUp() {
		int act = 0;
		for (int c = 0; c < 4; c++) {
			act = 3;
			for (int r = 2; r >= 0; r--) {
				if(piece[act][c].equals(piece[r][c])) {
					piece[act][c].put(piece[r][c].getNum() * 2);
					game.addPoints(piece[r][c].getNum() * 2);
					piece[r][c].clear();
					act--;
					totalOccupiedCells--;
					move = true;
				}
				else {
					if(!piece[act][c].isFree() && !piece[r][c].isFree())
						act--;
					if(piece[act][c].isFree() && !piece[r][c].isFree()) {
						piece[act][c].put(piece[r][c].getNum());
						piece[r][c].clear();
						move = true;
					}
				}
			}
		}
		if(move) {
			move = false;
			putNumber();
		}
	}
	
	public void moveDown() {
		int act = 0;
		for (int c = 0; c < 4; c++) {
			act = 0;
			for (int r = 1; r <= 3; r++) {
				if(piece[act][c].equals(piece[r][c])) {
					piece[act][c].put(piece[r][c].getNum() * 2);
					game.addPoints(piece[r][c].getNum() * 2);
					piece[r][c].clear();
					act++;
					totalOccupiedCells--;
					move = true;
				}
				else {
					if(!piece[act][c].isFree() && !piece[r][c].isFree())
						act++;
					if(piece[act][c].isFree() && !piece[r][c].isFree()) {
						piece[act][c].put(piece[r][c].getNum());
						piece[r][c].clear();
						move = true;
					}
				}
			}
		}
		if(move) {
			move = false;
			putNumber();
		}
	}
	
	public void moveRight() {
		int act = 0;
		for (int r = 0; r < 4; r++) {
			act = 3;
			for (int c = 2; c >= 0; c--) {
				if(piece[r][act].equals(piece[r][c])) {
					piece[r][act].put(piece[r][c].getNum() * 2);
					game.addPoints(piece[r][c].getNum() * 2);
					piece[r][c].clear();
					act--;
					totalOccupiedCells--;
					move = true;
				}
				else {
					if(!piece[r][act].isFree() && !piece[r][c].isFree())
						act--;
					if(piece[r][act].isFree() && !piece[r][c].isFree()) {
						piece[r][act].put(piece[r][c].getNum());
						piece[r][c].clear();
						move = true;
					}
				}
			}
		}
		if(move) {
			move = false;
			putNumber();
		}
	}
	
	public void moveLeft() {
		int act = 0;
		for (int r = 0; r < 4; r++) {
			act = 0;
			for (int c = 1; c <= 3; c++) {
				if(piece[r][act].equals(piece[r][c])) {
					piece[r][act].put(piece[r][c].getNum() * 2);
					game.addPoints(piece[r][c].getNum() * 2);
					piece[r][c].clear();
					act++;
					totalOccupiedCells--;
					move = true;
				}
				else {
					if(!piece[r][act].isFree() && !piece[r][c].isFree())
						act++;
					if(piece[r][act].isFree() && !piece[r][c].isFree()) {
						piece[r][act].put(piece[r][c].getNum());
						piece[r][c].clear();
						move = true;
					}
				}
			}
		}
		if(move) {
			move = false;
			putNumber();
		}
	}
	
	public void putNumber() { 
		int r = 0;
		int c = 0;
		int num = 0;
		boolean stop = false;
		
		while(!stop && totalOccupiedCells < 16) { 
			r = (Math.abs(rnd.nextInt()) % 4);
			c = (Math.abs(rnd.nextInt()) % 4);
			num = (Math.abs(rnd.nextInt()) % 10);
			if(piece[r][c].isFree()) {
				putCells(r, c, num);
				stop = true;
			}
		}
		
		if(stop) {
			totalOccupiedCells++; 
		}
		
		if(totalOccupiedCells == 16) {
			check();
			stop = true;
		}
		
	}
	
	public void check() {
		boolean is = false;
		
		for (int r = 0; r < 4 && !is; r++)
			for(int c = 0; c < 3 && !is; c++) {
				is = piece[r][c].equals(piece[r][c+1]);
			}

		for(int c = 0; c < 4 && !is; c++)
			for (int r = 0; r < 3 && !is; r++){
				is = piece[r][c].equals(piece[r+1][c]);
			}
		
		if(!is) {
			lose();
		}
	}
	
	private void putCells(int r, int c, int i) {
		
		if(i == 0) {
			piece[r][c].put(4);
		}
		else {
			piece[r][c].put(2);
		}
	}
	
}
