package general.logic;

public abstract class Map {
	public static final int ROW = 9;
	public static final int COLUMN = 16;
	protected Cell[][] matrix;
	protected Game game;
	protected GraphicCell freeCell;
	
	public Map(Game game) {
		this.game = game;
		freeCell = new GraphicCell(game.getImageFactory().getEmpty(), game.getImageFactory().getColorEmpty());
		matrix = new Cell[ROW][COLUMN];
		
		for(int r = 0; r < ROW; r++) {
			for(int c = 0; c < COLUMN; c++) {
				matrix[r][c] = new Cell(r, c, this);
				matrix[r][c].clear();
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
	
	public void addPoints(int points) {
		game.addPoints(points);
	}
	
	public void win() {
		game.win();
	}
	
	public void lose() {
		game.lose();
	}
}
