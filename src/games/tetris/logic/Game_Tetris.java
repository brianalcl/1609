package games.tetris.logic;

import games.tetris.gui.Panel_Tetris;
import games.tetris.logic.tetromino.Tetromino_Tetris;
import games.tetris.logic.tetromino.TetrominoI_Tetris;
import games.tetris.logic.tetromino.TetrominoJ_Tetris;
import games.tetris.logic.tetromino.TetrominoL_Tetris;
import games.tetris.logic.tetromino.TetrominoO_Tetris;
import games.tetris.logic.tetromino.TetrominoS_Tetris;
import games.tetris.logic.tetromino.TetrominoT_Tetris;
import games.tetris.logic.tetromino.TetrominoZ_Tetris;
import games.tetris.threads.Clock_Tetris;
import general.logic.Game;
import general.utilities.NRandom;

public class Game_Tetris extends Game{
	
	private Tetromino_Tetris tetromino;
	private Clock_Tetris clock_tetris;
	private Map_Tetris tetrisMap;
	
	/**
	* Create a new Tetris game.
	* @param tetrisPanel. A tetrisPanel.
	*/
	public Game_Tetris(Panel_Tetris tetrisPanel) {
		super(tetrisPanel);
		this.tetrisMap = new Map_Tetris(this);
		this.clock_tetris = new Clock_Tetris(this, 1000);
		this.tetromino = createTetromino();
		this.tetromino.show();
		this.clock_tetris.start();
	}
	
	/**
	* Allows to control the tetromino.
	* @param operation a operation.
	*/
	public synchronized void operate(int operation) {
		switch (operation) {
		case MOVE_RIGHT: 
			tetromino.moveRight(); 
			break;
		case MOVE_LEFT: 
			tetromino.moveLeft(); 
			break;
		case ROTATE_LEFT: 
			tetromino.rotateLeft(); 
			break;
		case ROTATE_RIGHT: 
			tetromino.rotateRight(); 
			break;
		case MOVE_DOWN: 
			if(tetromino.moveDown()) checkLines();
			break;
		}
	}
	
	/**
	* Create a random tetromino.
	* @return A tetromino.
	*/
	private Tetromino_Tetris createTetromino() {
		Tetromino_Tetris tet = null;
		int n = Math.abs(NRandom.getInstance().nextInt(7)); 
		switch (n) {
		case 0:	
			tet = new TetrominoI_Tetris(tetrisMap, panel.getImageFactory());
			break;
		case 1:	
			tet = new TetrominoL_Tetris(tetrisMap, panel.getImageFactory());	
			break;
		case 2:	
			tet = new TetrominoJ_Tetris(tetrisMap, panel.getImageFactory());
			break;
		case 3:	
			tet = new TetrominoO_Tetris(tetrisMap, panel.getImageFactory());	
			break;
		case 4:	
			tet = new TetrominoS_Tetris(tetrisMap, panel.getImageFactory());
			break;
		case 5:	
			tet = new TetrominoT_Tetris(tetrisMap, panel.getImageFactory());
			break;
		case 6:	
			tet = new TetrominoZ_Tetris(tetrisMap, panel.getImageFactory());
			break;
		}
		
		return tet;
	}

	/**
	* Tells the tetrisMap to control the lines.
	*/
	private void checkLines() {
		tetrisMap.checkLines();
		tetromino = createTetromino();
		if(!tetromino.show()) {
			lose();
		}
	}
	
	/**
	 * Increase the score and every 1000 points increases a level.
	 */
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		int level = this.points / 1000;
		if(level != this.level) {
			addLevel();
			if(clock_tetris.getStep() > 100)
				clock_tetris.setStep(clock_tetris.getStep() - 100);
		}
	}
	
}
