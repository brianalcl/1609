package general.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import games.snake.gui.SnakePanel;
import general.logic.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class InitialPanel extends GeneralPanel{
	JButton[][] matrix;
	private JPanel panel;
	public InitialPanel(GUI gui) {
		super(gui);
		matrix = new JButton[3][3];
		panel = new JPanel();
		createPanel();
		putBottons();
		setBackground(new Color(0,80,80));
	}
	
	private void createPanel() {
		
		int width = (int) gui.getImageFactory().getScreenResolution().getWidth();
		int height = (int) gui.getImageFactory().getScreenResolution().getHeight();
		int panelWidth = (int) 600;
		int panelHeight = (int) 600;
		panel.setLayout(new GridLayout(matrix.length, matrix[0].length));
		panel.setSize(600, 600);
		panel.setLocation((int)(width-panelWidth)/2, (int) (height-panelHeight)/2);
		panel.setBackground(gui.getImageFactory().getColorCyan());
		add(panel);
	}
	
	private void putBottons() {
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				matrix[r][c] = new JButton(gui.getImageFactory().getEmptyIcon());
				matrix[r][c].setBackground(new Color(0,80,80));
				matrix[r][c].setFocusable(false);
				matrix[r][c].setBorderPainted(false);
				matrix[r][c].addMouseListener(getMouseAdapter());
				panel.add(matrix[r][c]);
			}
		matrix[0][0].setIcon(gui.getImageFactory().getIcon("snake"));
		matrix[0][0].addActionListener(e -> startSnake());
		matrix[0][1].addActionListener(e -> gui.setPanel(new GameOverPanel(gui, null, "WIN", "SCORE: 00000", "TIME: 00:00")));
	}
	
	private void startSnake() {
		gui.setPanel(new SnakePanel(this.gui));
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(new Color(0,60,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(0,80,80));
			}

		};
	}
}
