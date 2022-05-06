package games.dodgeWall.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import games.dodgeWall.logic.DodgeWallGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.logic.Game;


public class DodgeWallPanel extends GamePanel{
	
	protected boolean stopKey;
	protected DodgeWallGame game;
	
	public DodgeWallPanel(GUI gui) {
		super(gui);
		game = new DodgeWallGame(this);
		setBackground(this.gui.getImageFactory().getColorDarkCyan());
		lblKeyboard.setIcon(gui.getImageFactory().getKeyboard1());
		stopKey = false;
		addControls();
	}
	
	private void addControls() {
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(stopKey) {
					moveCenter();
					stopKey = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(!stopKey && (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)) {
					moveUp();
					stopKey = true;
				}
				if(!stopKey && (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)) {
					moveDown();
					stopKey = true;
				}
			}
		});
	}
	
	private void moveCenter() {
		game.moveCenter();
	}
	
	private void moveUp() {
		
		game.moveUp();
	}

	private void moveDown() {
		game.moveDown();
	}
	
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}
	
	public void win() {
		gui.setPanel(new GameOverPanel(gui, this,"WIN", lblScore.getText(), lblTime.getText()));
	}
	
	public void restart() {
		gui.setPanel(new DodgeWallPanel(gui));
	}
}
