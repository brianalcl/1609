package games.g2048.logic;

import java.util.Iterator;
import java.util.Random;

import general.logic.GraphicCell;
import general.logic.Map;
import general.random.NRandom;

public class G2048Map extends Map{
	
	protected Random rnd;
	protected GraphicCell unusable;
	protected GraphicCell emptyNumber;
	protected int totalOccupiedCells;
	protected G2048Cell[][] matrix;
	
	public G2048Map(G2048Game game) {
		super(game);
		this.rnd = NRandom.getInstance();
		this.unusable = new GraphicCell(game.getImageFactory().getSquircle(), game.getImageFactory().getEmptyColor());
		this.emptyNumber = new GraphicCell(game.getImageFactory().getEmptyNumber(), game.getImageFactory().getColorBrown());
		this.totalOccupiedCells = 0;
		this.matrix = new G2048Cell[ROW][COLUMN];
		
		for(int r = 0; r < ROW; r++) {
			for(int c = 0; c < COLUMN; c++) {
				matrix[r][c] = new G2048Cell(r, c, this);
				matrix[r][c].clear();
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
				if(matrix[(act)*2+2][c*3+3].isFree()) {
					if(!matrix[(next)*2+2][c*3+3].isFree()) {
						matrix[(act)*2+2][c*3+3].put(matrix[(next)*2+2][c*3+3].getGraphicCell());
						matrix[(next)*2+2][c*3+3].clear();
						paint(act*2+2, c*3+3);
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
			r = (Math.abs(rnd.nextInt()) % 4) * 2 + 2;
			c = (Math.abs(rnd.nextInt()) % 4) * 3 + 3;
			num = (Math.abs(rnd.nextInt()) % 10);
			putCells(r, c, num);
			stop = true;
		}
		totalOccupiedCells++;
	}

	private void putCells(int r, int c, int i) {
		if(i == 0) {
			matrix[r][c].put(new GraphicCell(game.getImageFactory().get4(), game.getImageFactory().getColorBrown()));
			matrix[r][c].setNum(4);
		}
		else {
			matrix[r][c].put(new GraphicCell(game.getImageFactory().get2(), game.getImageFactory().getColorBrown()));
			matrix[r][c].setNum(2);
		}
		paint(r,c);
	}
	
	private void paint(int r, int c) {
		matrix[r][c + 1].put(emptyNumber);
		matrix[r][c - 1].put(emptyNumber);
		matrix[r - 1][c].put(emptyNumber);
		matrix[r - 1][c + 1].put(emptyNumber);
		matrix[r - 1][c - 1].put(emptyNumber);
	}
	
}
