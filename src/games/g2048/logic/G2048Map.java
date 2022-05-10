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
	
	public G2048Map(G2048Game game) {
		super(game);
		this.rnd = NRandom.getInstance();
		this.unusable = new GraphicCell(game.getImageFactory().getSquircle(), game.getImageFactory().getEmptyColor());
		this.totalOccupiedCells = 0;
		
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
		int next = 0;


		for (int c = 0; c < 4; c++) {
			act = 3;
			next = 2;
			for (int r = 3; r > 0; r--) {
				if(piece[act][c].isFree()) {
					if(!piece[next][c].isFree()) {
						piece[act][c].put(piece[next][c].getGraphicCell(), piece[next][c].getNum());
						piece[next][c].clear();
						act--;
					}
				}
				else
					act--;
				next--;

			}
		}
		putNumber();
	}
	
	public void putNumber() {
		int r = 0;
		int c = 0;
		int num = 0;
		boolean stop = false;
		
		while(!stop) { 
			r = (Math.abs(rnd.nextInt()) % 4);
			c = (Math.abs(rnd.nextInt()) % 4);
			num = (Math.abs(rnd.nextInt()) % 10);
			putCells(r, c, num);
			stop = true;
		}
		totalOccupiedCells++;
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
