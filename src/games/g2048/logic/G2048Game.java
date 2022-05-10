package games.g2048.logic;

import games.g2048.gui.G2048Panel;
import general.logic.Game;

public class G2048Game extends Game{
	
	protected Player player;
	
	public G2048Game(G2048Panel panel) {
		super(panel);
		this.player = new Player(new G2048Map(this), this.panel.getImageFactory());
	}

	public void moveUp() {
		player.moveUp();
	}

	public void moveDown() {
		player.moveDown();
		
	}

	public void moveRight() {
		player.moveRight();
	}

	public void moveLeft() {
		player.moveLeft();
	}
	
	public void lose() {
		super.lose();
	}
}
