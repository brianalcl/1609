package games.g2048.logic;

import java.awt.Color;
import java.util.HashMap;

import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.NRandom;

public class Map_G2048 extends Map{
	protected int totalOccupiedCells;
	protected Piece_G2048[][] piece;
	protected boolean move;
	protected java.util.Map<Integer, Color> mapColor;
	
	public Map_G2048(Game_G2048 game) {
		super(game, true);
		this.totalOccupiedCells = 0;
		this.move = false;
		this.piece = new Piece_G2048[4][4];
		this.mapColor = new HashMap<>();
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				this.piece[r][c] = new Piece_G2048(r, c, this, game.getImageFactory());
				this.piece[r][c].clear();
			}
		}
		
		createColors();
		charge();
		putNumber();
	}
	
	public void charge() {
		GraphicCell unusable = new GraphicCell(game.getImageFactory().getCircle(), freeCell.getBackground());
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
			r = (Math.abs(NRandom.getInstance().nextInt()) % 4);
			c = (Math.abs(NRandom.getInstance().nextInt()) % 4);
			num = (Math.abs(NRandom.getInstance().nextInt()) % 10);
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
	
	public Color getColorOfPiece(int n) {
		return mapColor.get(n);
	}
	
	private void putCells(int r, int c, int i) {
		
		if(i == 0) {
			piece[r][c].put(4);
		}
		else {
			piece[r][c].put(2);
		}
	}
	
	private void createColors() {
		Color baColor = game.getImageFactory().getColorDefault();
		for(int i = 2; i <= 65536; i = i * 2) {
			mapColor.put(i, baColor);
			baColor = game.getImageFactory().getMarkColor(baColor, 15);
		}
	}
}
