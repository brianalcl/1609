package general.gui;

import javax.swing.JLabel;

import imageFactory.DarkImageFactory;
import imageFactory.ImageFactory;

import javax.swing.JPanel;

import general.logic.Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


public abstract class GeneralGamePanel extends GeneralPanel{
	
	private JLabel[][] matrix;
	private JPanel panel;
	private JLabel lblBg;
	protected JLabel lblTime;
	protected JLabel lblLevel;
	protected JLabel lblScore;
	private Font fontLabels;
	protected JLabel lblKeyboard;
	protected JLabel lblMouse;
	
	public GeneralGamePanel(GUI gui) {
		super(gui);
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		panel = new JPanel();		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");
		lblBg = new JLabel("");
		lblKeyboard = new JLabel("");
		lblMouse = new JLabel("");
		
		createCentralPanel();
		createLabels();
	}
	
	private void createLabels() {
		lblBg.setSize(gui.getImageFactory().getScreenResolution());
		lblBg.setLocation(0, 0);
		lblBg.setIcon(gui.getImageFactory().getMap());
		add(lblBg);
		
		int x = (int) Math.round(160 * widthScaleFactor);
		int y = (int) Math.round(30 * heightScaleFactor);
		int w = (int) Math.round(500 * widthScaleFactor);
		int h = (int) Math.round(100 * heightScaleFactor);
		lblTime.setBounds(x,y,w,h);
		
		x = (int) Math.round(710 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblLevel.setBounds(x,y,w,h);
		
		x = (int) Math.round(1260 * widthScaleFactor);
		y = (int) Math.round(30 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round((1920 - 477)/2 * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(375 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblKeyboard.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920 - 477)/2 + 375) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(102 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblMouse.setBounds(x,y,w,h);
		
		fontLabels = font.deriveFont(Math.round(80*widthScaleFactor)*1.0f);
		
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setFont(fontLabels);
		lblLevel.setFont(fontLabels);
		lblScore.setFont(fontLabels);
		lblTime.setForeground(gui.getImageFactory().getForegroundColor());
		lblLevel.setForeground(gui.getImageFactory().getForegroundColor());
		lblScore.setForeground(gui.getImageFactory().getForegroundColor());
		add(lblTime);
		add(lblLevel);
		add(lblScore);
		add(lblKeyboard);
		add(lblMouse);
	}
	
	private void createCentralPanel() {
		
		int x = (int) Math.round(((1920 - 800) / 2) * widthScaleFactor);
		int y = (int) Math.round(((1080 - 450) / 2) * heightScaleFactor);
		int w = (int) Math.round(800 * widthScaleFactor);
		int h = (int) Math.round(450 * heightScaleFactor);
		
		panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
		panel.setBounds(x,y,w,h);
		panel.setBackground(gui.getImageFactory().getEmptyColor());
		
		add(panel);
		
		for(int r = Map.ROW-1; r >= 0; r--) 
			for(int c = 0; c < Map.COLUMN; c++) {
				matrix[r][c] = new JLabel();
				matrix[r][c].setOpaque(true);
				panel.add(matrix[r][c]);
			}
	}

	public void setPoints(String score) {
		lblScore.setText("Score: " + score);	
	}

	public void setTime(String time) {
		lblTime.setText("Time: " + time);
	}

	public void setLevel(String level) {
		lblLevel.setText("Level: " + level);
	}

	public void changeCell(JLabel graphicCell, int row, int column) {
		matrix[row][column].setIcon(graphicCell.getIcon());
		matrix[row][column].setBackground(graphicCell.getBackground());
	}

	public ImageFactory getImageFactory() {
		return gui.getImageFactory();
	}

	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
}
