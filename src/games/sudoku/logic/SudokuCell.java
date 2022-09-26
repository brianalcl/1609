package games.sudoku.logic;

import factory.Factory;
import general.logic.Cell;

public class SudokuCell extends Cell{
	protected int number;
	protected int userNumber;
	protected boolean mark;
	protected boolean editable;
	protected Factory factory;
	
	public SudokuCell(int row, int column, SudokuMap map, Factory factory) {
		super(row, column, map);
		this.number = 0;
		this.userNumber = 0;
		this.mark = false;
		this.editable = false;
		this.factory = factory;
	}
	
	public void mark() {
		if(!mark) {
			mark = true;
			gc.setBackground(factory.getMarkColor(gc.getBackground(), 20));
			map.changeCell(this);
			
		}
		
	}
	
	public void unmark() {
		if(mark) {
			mark = false;
			gc.setBackground(factory.getMarkColor(gc.getBackground(), -20));
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
