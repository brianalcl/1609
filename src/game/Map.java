package game;

import imageFactory.ImageFactory;

public abstract class Map {
	protected final int ROW = 9;
	protected final int COLUMN = 16;
	protected Cell[][] matrix;
	protected Game game;
	protected GraphicCell freeCell;
	
	public Map(Game game) {
		this.game = game;
		matrix = new Cell[ROW][COLUMN];
		for(int r = 0; r < ROW; r++) {
			for(int c = 0; c < COLUMN; c++) {
				matrix[r][c] = new Cell(r, c, this);
				matrix[r][c].pop();
			}
		}
	}
	
	public Cell getCell(int r, int c) {
		return matrix[r][c];
	}
	
	public GraphicCell getFreeCell() {
		return freeCell;
	}
	
	public void changeCell(Cell cell) {
		game.changeCell(cell);
	}
}
