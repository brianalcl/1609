package general.gui;
import javax.swing.JPanel;

import games.collect.gui.CollectPanel;
import games.dodgeWall.gui.DodgeWallPanel;
import games.g2048.gui.G2048Panel;
import games.minesweeper.gui.MinesweeperPanel;
import games.shot.gui.ShotPanel;
import games.snake.gui.SnakePanel;
import games.sudoku.gui.SudokuPanel;
import games.tetris.gui.TetrisPanel;
import general.utilities.InternalBorderRound;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InitialPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton[][] matrix;
	protected JButton btnConfiguration;
	protected JPanel panel;
	public InitialPanel(GUI gui) {
		super(gui);
		matrix = new JButton[3][3];
		panel = new JPanel();
		createPanel();
		putBottons();
		setBackground(this.gui.getImageFactory().getColorDefault());
	}
	
	private void createPanel() {
		int x = (int) Math.round(((1920 - 600) / 2) * scaleFactor);
		int y = (int) Math.round(((1080 - 600) / 2) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(600 * scaleFactor);
		panel.setBounds(x,y,w,h);
		
		panel.setLayout(new GridLayout(matrix.length, matrix[0].length));
		panel.setBackground(gui.getImageFactory().getColorDefault());
		add(panel);
	}
	
	private void putBottons() {
		int borderSize = (int) Math.round(10 * scaleFactor);
		int borderRadius = (int) Math.round(96 * scaleFactor);
		
		btnConfiguration = new JButton(gui.getImageFactory().getConfiguration());
		btnConfiguration.setBackground(gui.getImageFactory().getColorDefault());
		btnConfiguration.setFocusable(false);
		btnConfiguration.addMouseListener(getMouseAdapter());
		btnConfiguration.addActionListener(e -> gui.setPanel(new ConfigurationPanel(this.gui)));
		btnConfiguration.setBounds(0, 0, (int) Math.round(200 * scaleFactor), (int) Math.round(200 * scaleFactor));
		btnConfiguration.setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
		add(btnConfiguration);
		
		
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				matrix[r][c] = new JButton(gui.getImageFactory().getGameIcon("empty"));
				matrix[r][c].setBackground(gui.getImageFactory().getColorDefault());
				matrix[r][c].setFocusable(false);
				matrix[r][c].setBorder(new InternalBorderRound(borderSize, borderRadius, panel.getBackground()));
				matrix[r][c].addMouseListener(getMouseAdapter());
				panel.add(matrix[r][c]);
			}
		}
		matrix[0][0].setIcon(gui.getImageFactory().getGameIcon("snake"));
		matrix[0][0].addActionListener(e -> gui.setPanel(new SnakePanel(this.gui)));
		matrix[0][1].setIcon(gui.getImageFactory().getGameIcon("dodgeWall"));
		matrix[0][1].addActionListener(e -> gui.setPanel(new DodgeWallPanel(this.gui)));
		matrix[0][2].setIcon(gui.getImageFactory().getGameIcon("g2048"));
		matrix[0][2].addActionListener(e -> gui.setPanel(new G2048Panel(this.gui)));
		matrix[1][0].setIcon(gui.getImageFactory().getGameIcon("shot"));
		matrix[1][0].addActionListener(e -> gui.setPanel(new ShotPanel(this.gui)));
		matrix[1][1].setIcon(gui.getImageFactory().getGameIcon("sudoku"));
		matrix[1][1].addActionListener(e -> gui.setPanel(new SudokuPanel(this.gui)));
		matrix[1][2].setIcon(gui.getImageFactory().getGameIcon("minesweeper"));
		matrix[1][2].addActionListener(e -> gui.setPanel(new MinesweeperPanel(this.gui)));
		matrix[2][0].setIcon(gui.getImageFactory().getGameIcon("tetris"));
		matrix[2][0].addActionListener(e -> gui.setPanel(new TetrisPanel(this.gui)));
		matrix[2][1].setIcon(gui.getImageFactory().getGameIcon("collect"));
		matrix[2][1].addActionListener(e -> gui.setPanel(new CollectPanel(this.gui)));
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getMarkColor(e.getComponent().getBackground(), -10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getMarkColor(e.getComponent().getBackground(), 10));
			}

		};
	}
}
