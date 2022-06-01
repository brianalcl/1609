package general.logic;

public abstract class Map {
	public static final int ROW = 9;
	public static final int COLUMN = 16;
	protected Cell[][] matrix;
	protected Game game;
	protected GraphicCell freeCell;
	
	public Map(Game game, boolean isHorizontal) {
		this.game = game;
		freeCell = new GraphicCell(game.getImageFactory().getEmpty(), game.getImageFactory().getColorEmpty());
		
		if(isHorizontal)
			matrix = new Cell[ROW][COLUMN];
		else
			matrix = new Cell[COLUMN][ROW];
		
		for(int r = 0; r < matrix.length; r++) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new Cell(r, c, this);
				matrix[r][c].clear();
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
