package games.sudoku.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;
import general.random.NRandom;

public class SudokuMap extends Map{
	
	protected Random rnd;
	protected SudokuCell[][]matrix;
	protected java.util.Map<Integer, Integer> mapNumber;
	
	public SudokuMap(SudokuGame game) {
		super(game, false);
		this.rnd = NRandom.getInstance();
		matrix = new SudokuCell[COLUMN][ROW];
		mapNumber = new HashMap<>();
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
		for(int column = i; column < i+3; column++) { 
			for(int row = 7; row < 16; row++) {
				swap = matrix[row][column].getNumber();
				matrix[row][column].setNumber(matrix[row][j].getNumber());
				matrix[row][j].setNumber(swap);
				matrix[row][column].put(createGraphicCell(matrix[row][column].getNumber()));
				matrix[row][j].put(createGraphicCell(matrix[row][j].getNumber()));
			}
			j++;
		}
	}


	private void swapRows(int i, int j) {
		int swap = 0;
		for(int row = i; row < i+3; row++) { 
			for(int column = 0; column < 9; column++) {
				swap = matrix[row][column].getNumber();
				matrix[row][column].setNumber(matrix[j][column].getNumber());
				matrix[j][column].setNumber(swap);
				matrix[row][column].put(createGraphicCell(matrix[row][column].getNumber()));
				matrix[j][column].put(createGraphicCell(matrix[j][column].getNumber()));
			}
			j++;
		}
	}


	private GraphicCell createGraphicCell(int n) {
		GraphicCell gc = null;
		switch (n) {
		case 1:
			gc = new GraphicCell(game.getImageFactory().get1(), game.getImageFactory().getColorDefault());
			break;
		case 2:
			gc = new GraphicCell(game.getImageFactory().get2(), game.getImageFactory().getColorDefault());
			break;
		case 3:
			gc = new GraphicCell(game.getImageFactory().get3(), game.getImageFactory().getColorDefault());
			break;
		case 4:
			gc = new GraphicCell(game.getImageFactory().get4(), game.getImageFactory().getColorDefault());
			break;
		case 5:
			gc = new GraphicCell(game.getImageFactory().get5(), game.getImageFactory().getColorDefault());
			break;
		case 6:
			gc = new GraphicCell(game.getImageFactory().get6(), game.getImageFactory().getColorDefault());
			break;
		case 7:
			gc = new GraphicCell(game.getImageFactory().get7(), game.getImageFactory().getColorDefault());
			break;
		case 8:
			gc = new GraphicCell(game.getImageFactory().get8(), game.getImageFactory().getColorDefault());
			break;
		case 9:
			gc = new GraphicCell(game.getImageFactory().get9(), game.getImageFactory().getColorDefault());
			break;

		default:
			gc = new GraphicCell(game.getImageFactory().get0(), game.getImageFactory().getColorDefault());
			break;
		}
		return gc;
	}
}