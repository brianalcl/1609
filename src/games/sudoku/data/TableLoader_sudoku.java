package games.sudoku.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import games.sudoku.logic.Map_Sudoku;

public class TableLoader_sudoku {
	protected Map_Sudoku map;
	
	public TableLoader_sudoku(Map_Sudoku map) {
		this.map = map;
	}
	
	public void load() {
		BufferedReader bf; 
		String line;
		int num = 0;
		try {
			InputStream inSt = getClass().getResourceAsStream("/gamesData/sudoku/table.txt");
			bf = new BufferedReader(new InputStreamReader(inSt));
			for(int r = 0; r < 9; r++) {
				line = bf.readLine();
				if(line != null) {
					for(int c = 0; c < 9; c++) {
						num = line.charAt(c) - 48;
						map.charge(r, c, num);
					}
				}
			}
			bf.close();
		}
		catch (IOException | NullPointerException | NumberFormatException e) {
		}
	}
}
