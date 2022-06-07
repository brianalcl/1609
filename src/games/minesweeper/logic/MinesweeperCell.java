package games.minesweeper.logic;

import general.logic.Cell;

public class MinesweeperCell extends Cell{
	protected boolean editable;
	protected boolean bomb;
	protected boolean flag;
	
	public MinesweeperCell(int row, int column, MinesweeperMap map) {
		super(row, column, map);
		this.editable = true;
		this.bomb = false;
		this.flag = false;
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
