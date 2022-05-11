package general.gui;
import javax.swing.JPanel;

import games.dodgeWall.gui.DodgeWallPanel;
import games.g2048.gui.G2048Panel;
import games.snake.gui.SnakePanel;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InitialPanel extends GeneralPanel{
	protected JButton[][] matrix;
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
		int x = (int) Math.round(((1920 - 600) / 2) * widthScaleFactor);
		int y = (int) Math.round(((1080 - 600) / 2) * heightScaleFactor);
		int w = (int) Math.round(600 * widthScaleFactor);
		int h = (int) Math.round(600 * heightScaleFactor);
		panel.setBounds(x,y,w,h);
		
		panel.setLayout(new GridLayout(matrix.length, matrix[0].length));
		panel.setBackground(gui.getImageFactory().getColorDefault());
		add(panel);
	}
	
	private void putBottons() {
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				matrix[r][c] = new JButton(gui.getImageFactory().getIcon("empty"));
				matrix[r][c].setBackground(gui.getImageFactory().getColorDefault());
				matrix[r][c].setFocusable(false);
				matrix[r][c].setBorderPainted(false);
				matrix[r][c].addMouseListener(getMouseAdapter());
				panel.add(matrix[r][c]);
			}
		matrix[0][0].setIcon(gui.getImageFactory().getIcon("snake"));
		matrix[0][0].addActionListener(e -> gui.setPanel(new SnakePanel(this.gui)));
		matrix[0][1].setIcon(gui.getImageFactory().getIcon("dodgeWall"));
		matrix[0][1].addActionListener(e -> gui.setPanel(new DodgeWallPanel(this.gui)));
		matrix[0][2].setIcon(gui.getImageFactory().getIcon("g2048"));
		matrix[0][2].addActionListener(e -> gui.setPanel(new G2048Panel(this.gui)));
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getColorDefault().darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getColorDefault());
			}

		};
	}
}
