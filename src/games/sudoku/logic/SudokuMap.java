package games.sudoku.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import general.logic.GraphicCell;
import general.logic.Map;
import general.random.NRandom;

public class SudokuMap extends Map{
	
	protected Random rnd;
	protected SudokuCell[][]matrix;
	protected SudokuCell selected;
	protected SudokuGame game;
	protected int hide;
	protected java.util.Map<Integer, Integer> mapNumber;
	
	public SudokuMap(SudokuGame game) {
		super(game, false);
		this.game = game;
		this.rnd = NRandom.getInstance();
		matrix = new SudokuCell[COLUMN][ROW];
		mapNumber = new HashMap<>();
		selected = null;
		for(int r = 0; r < matrix.length; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new SudokuCell(r, c,this);
				matrix[r][c].clear();
			}
		chargeMapNumber();
		charge();
	}
	
	
	private void chargeMapNumber() {
		Set<Integer> set = new HashSet<>();
		int n = 0;
		boolean stop = false;
		for(int i=1; i<=9; i++) {
			stop = false;
			while(!stop) {
				n = Math.abs(rnd.nextInt() % 9) + 1;
				if(!set.contains(n)) {
					set.add(n);
					stop = true;
					mapNumber.put(i, n);
				}
			}
		}
		
	}

	public void charge() {
		BufferedReader bf; 
		FileReader fr;
		String line;
		int num = 0;
		try {
			fr = new FileReader("./gamesData/sudoku/table.txt");
			bf = new BufferedReader(fr);
			for(int r = 7; r < 16; r++) {
				line = bf.readLine();
				if(line != null) {
					for(int c = 0; c < 9; c++) {
						num = line.charAt(c) - 48;
						matrix[r][c].setNumber(mapNumber.get(num));
						matrix[r][c].put(createGraphicCell(matrix[r][c].getNumber()));
					}
				}
			}
			bf.close();
		}
		catch (IOException | NullPointerException | NumberFormatException e) {
		}
		move();
		hide();
	}
	
	private void hide() {
		int r = 0;
		int c = 0;
		int visible = 81;
		while(visible > 17) {
			r = Math.abs(rnd.nextInt() % 9) + 7;
			c = Math.abs(rnd.nextInt() % 9);
			matrix[r][c].put(createGraphicCell(0));
			if(!matrix[r][c].isEditable()) {
				hide++;
				matrix[r][c].setUserNumber(0); //VER
				matrix[r][c].setEditable();
			}
			
			visible--;
		}
	}


	private void move() { //swap rows and columns
		int n = 0;
		
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapRows(7,10);
		if(n == 2)
			swapRows(10,13);
		if(n == 3)
			swapRows(7,13);
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapRows(7,10);
		if(n == 2)
			swapRows(10,13);
		if(n == 3)
			swapRows(7,13);
		
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapColumns(0,3);
		if(n == 2)
			swapColumns(3,6);
		if(n == 3)
			swapColumns(0,6);
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapColumns(0,3);
		if(n == 2)
			swapColumns(3,6);
		if(n == 3)
			swapColumns(0,6);
		
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapRows(7,10);
		if(n == 2)
			swapRows(10,13);
		if(n == 3)
			swapRows(7,13);
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapRows(7,10);
		if(n == 2)
			swapRows(10,13);
		if(n == 3)
			swapRows(7,13);
		
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapColumns(0,3);
		if(n == 2)
			swapColumns(3,6);
		if(n == 3)
			swapColumns(0,6);
		n = Math.abs(rnd.nextInt() % 4);
		if(n == 1)
			swapColumns(0,3);
		if(n == 2)
			swapColumns(3,6);
		if(n == 3)
			swapColumns(0,6);
		
	}

	private void swapColumns(int i, int j) {
		int swap = 0;
		GraphicCell gc = null;
		for(int column = i; column < i+3; column++) { 
			for(int row = 7; row < 16; row++) {
				swap = matrix[row][column].getNumber();
				matrix[row][column].setNumber(matrix[row][j].getNumber());
				matrix[row][j].setNumber(swap);
				gc = matrix[row][column].getGraphicCell();
				matrix[row][column].put(matrix[row][j].getGraphicCell());
				matrix[row][j].put(gc);
			}
			j++;
		}
	}


	private void swapRows(int i, int j) {
		int swap = 0;
		GraphicCell gc = null;
		for(int row = i; row < i+3; row++) { 
			for(int column = 0; column < 9; column++) {
				swap = matrix[row][column].getNumber();
				matrix[row][column].setNumber(matrix[j][column].getNumber());
				matrix[j][column].setNumber(swap);
				gc = matrix[row][column].getGraphicCell();
				matrix[row][column].put(matrix[j][column].getGraphicCell());
				matrix[j][column].put(gc);
			}
			j++;
		}
	}

	public void changeCell(SudokuCell sudokuCell) {
		game.changeCell(sudokuCell);
	}

	private GraphicCell createGraphicCell(int n) {
		GraphicCell gc = new GraphicCell(null, game.getImageFactory().getColorDefault());
		switch (n) {
		case 0:
			gc.setText("");
			break;
		case 1:
			gc.setText("1");
			break;
		case 2:
			gc.setText("2");
			break;
		case 3:
			gc.setText("3");
			break;
		case 4:
			gc.setText("4");
			break;
		case 5:
			gc.setText("5");
			break;
		case 6:
			gc.setText("6");
			break;
		case 7:
			gc.setText("7");
			break;
		case 8:
			gc.setText("8");
			break;
		case 9:
			gc.setText("9");
			break;

		default:
			gc.setText("E");
			break;
		}
		return gc;
	}


	public void click(int row, int column) {

		if(row >= 7) {
			
			selected = matrix[row][column];
			
			for(int r = 7; r < 16; r++) 
				for(int c = 0; c < 9; c++) 
					matrix[r][c].unmark();

			for(int c = 0; c < 9; c++) 
				matrix[row][c].mark();

			for(int r = 7; r < 16; r++) 
				matrix[r][column].mark();

			int subMatrixR = 0;
			int subMatrixC = 0;

			if(row >= 7 && row < 10)
				subMatrixR = 7;
			if(row >= 10 && row < 13)
				subMatrixR = 10;
			if(row >= 13 && row < 16)
				subMatrixR = 13;

			if(column >= 0 && column < 3)
				subMatrixC = 0;
			if(column >= 3 && column < 6)
				subMatrixC = 3;
			if(column >= 6 && column < 9)
				subMatrixC = 6;

			for(int r = subMatrixR; r < subMatrixR + 3; r++) {
				for(int c = subMatrixC; c < subMatrixC +3; c++) {
					matrix[r][c].mark();
				}
			}
		}
	}


	public void put(int n) {
		if(selected != null && selected.isEditable()) {
			if(n != 0) {
				if(selected.getUserNumber() == 0)
					hide--;
			}
			else {
				if(selected.getUserNumber() != 0)
					hide++;
			}
			selected.setUserNumber(n);
			selected.put(createGraphicCell(n));
			System.out.println(hide);
		}
		check(); //Despues se agregara un boton para el check TODO
	}
	
	public void check() {
		boolean error = false;
		
		for(int r = 7; r < 16 && !error; r++)
			for(int c = 0; c < 9 && !error; c++) {
				error = matrix[r][c].error();
			}
		System.out.println(hide);
		if(!error && hide == 0)
			System.out.println("WIN");
	}
}
