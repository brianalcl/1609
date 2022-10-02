package games.minesweeper.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import games.minesweeper.logic.MinesweeperGame;
import general.gui.GUI;
import general.gui.GameOverPanel;
import general.gui.GamePanel;
import general.utilities.InternalBorder;
import general.utilities.InternalBorderRound;

public class MinesweeperPanel extends GamePanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected MinesweeperGame game;
	
	public MinesweeperPanel(GUI gui) {
		super(gui, false);
		game = new MinesweeperGame(this);
		lblMouse.setIcon(gui.getImageFactory().getMouse());
		putBorder();
	}
	
	private void putBorder() {
		Color colorBorder = gui.getImageFactory().getColorDefault();
		colorBorder = gui.getImageFactory().getMarkColor(colorBorder, 20);
		int borderSize = (int) Math.round(3 * scaleFactor);
		int borderRadius = (int) Math.round(32 * scaleFactor);
		
		for(int r = 2; r < 16; r++) {
			for(int c = 0; c < 9; c++) {
				matrix[r][c].setBorder(new InternalBorderRound(borderSize, borderSize, borderSize, borderSize, borderRadius, colorBorder));
			}
		}
		matrix[0][2].setBorder(new InternalBorder(borderSize, 0, borderSize, borderSize, colorBorder));
		matrix[0][3].setBorder(new InternalBorder(borderSize, 0, borderSize, 0, colorBorder));
		matrix[0][4].setBorder(new InternalBorder(borderSize, 0, borderSize, 0, colorBorder));
		matrix[0][5].setBorder(new InternalBorder(borderSize, 0, borderSize, 0, colorBorder));
		matrix[0][6].setBorder(new InternalBorder(borderSize, borderSize, borderSize, 0, colorBorder));
	}
	
	@Override
	public void changeCell(JLabel graphicCell, int row, int column) {
		super.changeCell(graphicCell, row, column);
		matrix[row][column].setText(graphicCell.getText());
	}
	
	@Override
	public void lose() {
		gui.setPanel(new GameOverPanel(gui, this, "LOSE", lblScore.getText(), lblTime.getText()));
	}

	@Override
	public void win() {
		gui.setPanel(new GameOverPanel(gui, this, "WIN", lblScore.getText(), lblTime.getText()));
	}

	@Override
	public void restart() {
		gui.setPanel(new MinesweeperPanel(gui));
	}
	
	@Override
	protected void addControls() {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1)
					game.click(e.getX()/(panel.getWidth()/9), e.getY()/(panel.getHeight()/16));
				else
					if(e.getButton() == MouseEvent.BUTTON3)
						game.putFlag(e.getX()/(panel.getWidth()/9), e.getY()/(panel.getHeight()/16));
			}
		});
	}
}