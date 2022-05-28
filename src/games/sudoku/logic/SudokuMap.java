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
		createCheck();
	}
	
	private void createCheck() {
		
		matrix[0][0].put(createGraphicCell(0));
		matrix[1][0].put(createGraphicCell(0));
		matrix[2][0].put(createGraphicCell(0));
		matrix[3][0].put(createGraphicCell(0));
		matrix[4][0].put(createGraphicCell(0));
		matrix[5][0].put(createGraphicCell(0));
		
		matrix[0][1].put(createGraphicCell(0));
		matrix[1][1].put(createGraphicCell(0));
		matrix[2][1].put(createGraphicCell(0));
		matrix[3][1].put(createGraphicCell(0));
		matrix[4][1].put(createGraphicCell(0));
		matrix[5][1].put(createGraphicCell(0));
		
		matrix[0][7].put(createGraphicCell(0));
		matrix[1][7].put(createGraphicCell(0));
		matrix[2][7].put(createGraphicCell(0));
		matrix[3][7].put(createGraphicCell(0));
		matrix[4][7].put(createGraphicCell(0));
		matrix[5][7].put(createGraphicCell(0));
		
		matrix[0][8].put(createGraphicCell(0));
		matrix[1][8].put(createGraphicCell(0));
		matrix[2][8].put(createGraphicCell(0));
		matrix[3][8].put(createGraphicCell(0));
		matrix[4][8].put(createGraphicCell(0));
		matrix[5][8].put(createGraphicCell(0));
		
		matrix[0][2].put(createGraphicCell(0));
		matrix[0][3].put(createGraphicCell(0));
		matrix[0][4].put(createGraphicCell(0));
		matrix[0][5].put(createGraphicCell(0));
		matrix[0][6].put(createGraphicCell(0));
		
		matrix[5][2].put(createGraphicCell('C'));
		matrix[5][3].put(createGraphicCell('H'));
		matrix[5][4].put(createGraphicCell('E'));
		matrix[5][5].put(createGraphicCell('C'));
		matrix[5][6].put(createGraphicCell('K'));
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

	private void charge() {
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
				matrix[r][c].setUserNumber(0);
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
		if(n < 10)
			n+=48;
		char c = (char)n;
		GraphicCell gc = null;
		if(selected != null)
			gc = new GraphicCell(null, selected.getGraphicCell().getBackground());
		else
			gc = new GraphicCell(null, game.getImageFactory().getColorDefault());
		if(c != '0')
			gc.setText(c+"");
		
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
		else {
			if(column >= 2 && column <= 6 && row == 5)
				if(selected != null)
					check();
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
		}
		
	}
	
	private void check() {
		boolean error = false;
		
		for(int r = 7; r < 16 && !error; r++)
			for(int c = 0; c < 9 && !error; c++) {
				error = matrix[r][c].error();
			}
		
		if(!error && hide == 0)
			win();
		
		matrix[1][3].clear();
		matrix[1][4].clear();
		matrix[1][5].clear();
		matrix[2][2].clear();
		matrix[2][6].clear();
		matrix[2][3].clear();
		matrix[2][4].clear();
		matrix[2][5].clear();
		matrix[1][2].clear();
		matrix[1][6].clear();
		
		if(!error) {
			matrix[1][3].put(createGraphicCell(0));
			matrix[1][4].put(createGraphicCell(0));
			matrix[1][5].put(createGraphicCell(0));
			matrix[2][2].put(createGraphicCell(0));
			matrix[2][6].put(createGraphicCell(0));
			matrix[4][3].put(createGraphicCell(0));
			matrix[4][5].put(createGraphicCell(0));
		}
		else {
			matrix[2][3].put(createGraphicCell(0));
			matrix[2][4].put(createGraphicCell(0));
			matrix[2][5].put(createGraphicCell(0));
			matrix[1][2].put(createGraphicCell(0));
			matrix[1][6].put(createGraphicCell(0));
			matrix[4][3].put(createGraphicCell(0));
			matrix[4][5].put(createGraphicCell(0));
		}
		
	}
}
