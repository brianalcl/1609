package games.minesweeper.logic;

import java.util.Random;
import general.logic.GraphicCell;
import general.logic.Map;
import general.utilities.NRandom;

public class MinesweeperMap extends Map{
	
	protected Random rnd;
	protected MinesweeperCell[][]matrix;
	protected MinesweeperGame game;
	protected GraphicCell flag;
	protected GraphicCell empty;
	protected int size;
	protected int bombs;
	
	public MinesweeperMap(MinesweeperGame game) {
		super(game, false);
		this.game = game;
		this.rnd = NRandom.getInstance();
		this.matrix = new MinesweeperCell[COLUMN][ROW];
		this.flag = new GraphicCell(this.game.getImageFactory().getFlag(), this.game.getImageFactory().getColorDefault());
		freeCell = new GraphicCell(null, this.game.getImageFactory().getColorDefault());
		this.empty = new GraphicCell(game.getImageFactory().getEmpty(), game.getImageFactory().getColorEmpty());
		this.bombs = 15;
		this.size = (matrix.length - 2) * matrix[0].length - bombs;
		
		for(int r = 0; r < matrix.length; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new MinesweeperCell(r, c,this);
				matrix[r][c].clear();
			}
		
		for(int r = 0; r < 2; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c].setUneditable();
				matrix[r][c].put(empty);
			}
		charge(bombs);
	}
	
	private void charge(int count) {
		int r = 0;
		int c = 0;
		int p = 0;
		
		while(p < count) {
			r = Math.abs(rnd.nextInt() % (matrix.length - 2)) + 2;
			c = Math.abs(rnd.nextInt() % matrix[0].length);
			if(!matrix[r][c].isBomb()) {
				matrix[r][c].setBomb();
				setNumber(matrix[r][c]);
				p++;
			}
		}
	}
	
	private void setNumber(MinesweeperCell cell) {
		int r = 0;
		int c = 0;
		
		r = cell.getRow() - 1;
		c = cell.getColumn();
		if(r >= 2 && !matrix[r][c].isBomb()) {
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
			
		r = cell.getRow() + 1;
		c = cell.getColumn();
		if(r <= 15 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow();
		c = cell.getColumn() - 1;
		if(c >= 0 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow();
		c = cell.getColumn() + 1;
		if(c <= 8 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow() - 1;
		c = cell.getColumn() - 1;
		if(r >= 2 && c >= 0 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow() + 1;
		c = cell.getColumn() + 1;
		if(r <= 15 && c <= 8 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow() - 1;
		c = cell.getColumn() + 1;
		if(c <= 8 && r >= 2 && c >= 0 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
		
		r = cell.getRow() + 1;
		c = cell.getColumn() - 1;
		if(c >= 0 && r <= 15 && c <= 8 && !matrix[r][c].isBomb()){
			matrix[r][c].setNumber(matrix[r][c].getNumber()+1);
		}
	}
	
	public void changeCell(MinesweeperCell minesweeperCell) {
		game.changeCell(minesweeperCell);
	}

	public void click(int row, int column) {
		if(matrix[row][column].isBomb())
			lose();
		else {
			if(matrix[row][column].isEditable()) {
				show(row, column);
			}
		}
		if(size == 0)
			win();
	}
	
	public void show(int row, int column) {
		GraphicCell gc = new GraphicCell(null, this.game.getImageFactory().getColorDefault().brighter());
		mark(row, column, gc);
	}

	private void mark(int row, int column, GraphicCell gc) { //TODO I don't know if there is a more efficient way
		if((row >= 2 && row <= 15 && column >= 0 && column <= 8) && matrix[row][column].isEditable()) {
			gc.setText("");
			size--;
			if(matrix[row][column].getNumber() != 0) {
				gc.setText(matrix[row][column].getNumber()+"");
				matrix[row][column].setUneditable();
				matrix[row][column].put(gc);
			}
			else {
				matrix[row][column].setUneditable();
				matrix[row][column].put(gc);
				gc.setText("");
				
				mark(row - 1, column - 1, gc);
				mark(row + 1, column + 1, gc);
				mark(row - 1, column + 1, gc);
				mark(row + 1, column - 1, gc);
				mark(row, column + 1, gc);
				mark(row + 1, column, gc);
				mark(row, column - 1, gc);
				mark(row - 1, column, gc);
			}
		}

	}

	public void putFlag(int row, int column) {
		if(matrix[row][column].isEditable()) {
			if(!matrix[row][column].isFlag()) {
				matrix[row][column].put(flag);
				matrix[row][column].setFlag(true);
			}
			else {
				matrix[row][column].put(freeCell);
				matrix[row][column].setFlag(false);
			}
		}
	}
}
