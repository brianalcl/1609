package games.sudoku.logic;


import general.logic.Cell;

public class SudokuCell extends Cell{
	protected int number;
	protected int userNumber;
	protected boolean mark;
	protected boolean editable;
	
	public SudokuCell(int row, int column, SudokuMap map) {
		super(row, column, map);
		this.number = 0;
		this.userNumber = 0;
		this.mark = false;
		this.editable = false;
	}

	public void mark() {
		if(!mark) {
			mark = true;
			gc.setBackground(gc.getBackground().brighter());
			map.changeCell(this);
		}
	}
	
	public void unmark() {
		if(mark) {
			mark = false;
			gc.setBackground(gc.getBackground().darker());
			map.changeCell(this);
		}
	}
	
	public void setEditable() {
		this.editable = true;
	}
	
	public boolean isEditable() {
		return editable;
	}
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber(int number) {
		this.number = number;
		userNumber = number;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	
	public boolean error() {
		if(userNumber != 0)
			return userNumber != number;
		else 
			return false;
	}
	
}
