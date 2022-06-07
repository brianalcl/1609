package games.minesweeper.logic;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.NRandom;

public class MinesweeperMap extends Map{
	
	protected Random rnd;
	protected MinesweeperCell[][]matrix;
	protected MinesweeperGame game;
	protected GraphicCell flag;
	protected GraphicCell bomb;
	protected int hide;
	
	public MinesweeperMap(MinesweeperGame game) {
		super(game, false);
		this.game = game;
		this.rnd = NRandom.getInstance();
		this.matrix = new MinesweeperCell[COLUMN][ROW];
		this.flag = new GraphicCell(this.game.getImageFactory().getFlag(), this.game.getImageFactory().getColorDefault());
		this.bomb = new GraphicCell(this.game.getImageFactory().getBomb(), this.game.getImageFactory().getColorDefault());
		for(int r = 0; r < matrix.length; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new MinesweeperCell(r, c,this);
				matrix[r][c].clear();
			}
		for(int r = 0; r < 7; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c].setUneditable();
			}
		charge(10);
	}
	
	private void charge(int count) {
		int r = 0;
		int c = 0;
		int p = 0;
		
		while(p < count) {
				r = Math.abs(rnd.nextInt()%9) + 7;
				c = Math.abs(rnd.nextInt()%9);
				if(!matrix[r][c].isBomb()) {
					matrix[r][c].setBomb();
					matrix[r][c].put(bomb);
					p++;
				}
		}
	}
	
	
	public void changeCell(MinesweeperCell minesweeperCell) {
		game.changeCell(minesweeperCell);
	}

	public void click(int row, int column) {
		//TODO completar luego
	}

	public void putFlag(int row, int column) {
		if(row >= 7 && !matrix[row][column].isFlag()) {
			matrix[row][column].put(flag);
			matrix[row][column].setFlag(true);
		}
		else {
			matrix[row][column].put(freeCell);
			matrix[row][column].setFlag(false);
		}
	}
}
