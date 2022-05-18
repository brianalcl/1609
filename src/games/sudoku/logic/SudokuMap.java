package games.sudoku.logic;

import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import general.random.NRandom;

public class SudokuMap extends Map{
	
	protected Random rnd;
	protected int totalOccupiedCells;
	protected boolean move;
	
	public SudokuMap(SudokuGame game) {
		super(game, false);
		this.rnd = NRandom.getInstance();
		this.totalOccupiedCells = 0;
		this.move = false;
		

		charge();
	}

	public void charge() {
		int subMatrixR = 0;
		int subMatrixC = 0;
		
		for (int r = 7; r < 16; r++) {
			for (int c = 0; c < 9; c++) {
				if((r==7 || r == 10 || r == 13) && (c==0 || c==3 || c==6)) {
					subMatrixR = r;
					subMatrixC = c;
				}
				createNumber(r, c, subMatrixR, subMatrixC);
			}
		}
	}
	
	public void createNumber(int r, int c, int subMatrixR, int subMatrixC) {
		boolean stop = false;
		int n = 0;
		while(!stop) {
			n = Math.round(rnd.nextInt() % 10); //TODO falta completar 
		}
	}
}
