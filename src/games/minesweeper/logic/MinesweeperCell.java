package games.minesweeper.logic;

import general.logic.Cell;

public class MinesweeperCell extends Cell{
	protected boolean editable;
	protected boolean bomb;
	protected boolean flag;
	protected int number;
	
	public MinesweeperCell(int row, int column, MinesweeperMap map) {
		super(row, column, map);
		this.editable = true;
		this.bomb = false;
		this.flag = false;
		this.number = 0;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setUneditable() {
		this.editable = false;
	}
	
	public void setBomb() {
		this.bomb = true;
	}
	
	public boolean isBomb() {
		return bomb;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isFlag() {
		return flag;
	}
}
