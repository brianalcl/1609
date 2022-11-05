package games.sudoku.logic;

import abstractFactory.AbstractFactory;
import general.logic.Cell;

public class Cell_Sudoku extends Cell{
	protected int number;
	protected int userNumber;
	protected boolean mark;
	protected boolean editable;
	protected AbstractFactory factory;
	
	public Cell_Sudoku(int row, int column, Map_Sudoku map, AbstractFactory factory) {
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
			gc.setBackground(factory.getColorDefault());
			map.changeCell(this);
			
		}
		
	}
	
	public void unmark() {
		if(mark) {
			mark = false;
			gc.setBackground(factory.getDefaultMarkColor());
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
