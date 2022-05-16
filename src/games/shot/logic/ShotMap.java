package games.shot.logic;

import general.logic.Map;

public class ShotMap extends Map{
	
	protected ShotGame game;
	
	public ShotMap(ShotGame game) {
		super(game, false);
		this.game = game;
	}
	
	public void downLines() {
		boolean gameOver = false;

		for(int i = 0; i < matrix[1].length && !gameOver; i++) {
			gameOver = !matrix[1][i].isFree() && !game.isShot(1, i);
		}

		if(gameOver)
			lose();
		else
			for(int r = 1; r < matrix.length - 1 && !gameOver; r++) {
				for(int c = 0; c < matrix[0].length; c++) {
					if(!matrix[r][c].isFree() && game.isShot(r, c)) {
						if (!matrix[r+1][c].isFree() && !game.isShot(r+1, c)) {
							matrix[r+1][c].clear();
							matrix[r][c].clear();
						}
					}
					else {
						if(!matrix[r+1][c].isFree() && !game.isShot(r+1, c)) {
							matrix[r][c].put(matrix[r+1][c].getGraphicCell());
							matrix[r+1][c].clear();
						}
					}
				}
			}
	}

}
