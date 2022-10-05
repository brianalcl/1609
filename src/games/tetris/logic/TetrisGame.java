package games.tetris.logic;

import games.tetris.gui.TetrisPanel;
import games.tetris.logic.tetromino.Tetromino;
import games.tetris.logic.tetromino.TetrominoI;
import games.tetris.logic.tetromino.TetrominoJ;
import games.tetris.logic.tetromino.TetrominoL;
import games.tetris.logic.tetromino.TetrominoO;
import games.tetris.logic.tetromino.TetrominoS;
import games.tetris.logic.tetromino.TetrominoT;
import games.tetris.logic.tetromino.TetrominoZ;
import games.tetris.threads.TetrisWatch;
import general.logic.Game;
import general.utilities.NRandom;

public class TetrisGame extends Game{
	
	private Tetromino tetromino;
	private TetrisWatch tetrisWatch;
	private TetrisMap tetrisMap;
	
	/**
	* Create a new Tetris game.
	* @param tetrisPanel. A tetrisPanel.
	*/
	public TetrisGame(TetrisPanel tetrisPanel) {
		super(tetrisPanel);
		this.tetrisMap = new TetrisMap(this);
		this.tetrisWatch = new TetrisWatch(this, 1000);
		this.tetromino = createTetromino();
		this.tetromino.show();
		this.tetrisWatch.start();
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
	private Tetromino createTetromino() {
		Tetromino tet = null;
		int n = Math.abs(NRandom.getInstance().nextInt(7)); 
		switch (n) {
		case 0:	
			tet = new TetrominoI(tetrisMap, panel.getImageFactory());
			break;
		case 1:	
			tet = new TetrominoL(tetrisMap, panel.getImageFactory());	
			break;
		case 2:	
			tet = new TetrominoJ(tetrisMap, panel.getImageFactory());
			break;
		case 3:	
			tet = new TetrominoO(tetrisMap, panel.getImageFactory());	
			break;
		case 4:	
			tet = new TetrominoS(tetrisMap, panel.getImageFactory());
			break;
		case 5:	
			tet = new TetrominoT(tetrisMap, panel.getImageFactory());
			break;
		case 6:	
			tet = new TetrominoZ(tetrisMap, panel.getImageFactory());
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
			if(tetrisWatch.getStep() > 100)
				tetrisWatch.setStep(tetrisWatch.getStep() - 100);
		}
	}
	
}
