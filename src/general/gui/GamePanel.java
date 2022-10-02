package general.gui;


import javax.swing.JLabel;
import javax.swing.JPanel;

import factory.Factory;
import general.logic.Map;
import general.utilities.InternalBorderRound;

import java.awt.GridLayout;


public abstract class GamePanel extends GeneralPanel{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel[][] matrix;
	protected JPanel panel;
	protected JLabel lblTime;
	protected JLabel lblLevel;
	protected JLabel lblScore;
	protected JLabel lblKeyboard;
	protected JLabel lblMouse;
	protected JLabel lblBg;
	
	public GamePanel(GUI gui, boolean isHorizontal) {
		super(gui);
		panel = new JPanel();		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");
		lblKeyboard = new JLabel("");
		lblMouse = new JLabel("");
		lblBg = new JLabel("");
		
		setBackground(this.gui.getImageFactory().getColorDefault());
		panel.setBackground(gui.getImageFactory().getMarkColor(gui.getImageFactory().getColorDefault(), -20));
		lblBg.setBackground(gui.getImageFactory().getMarkColor(gui.getImageFactory().getColorDefault(), 20));
		
		if(isHorizontal)
			createHorizontal();
		else
			createVertical();
		
		createStats();
		createCentralPanel();
		addControls();
	}
	
	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
	
	protected abstract void addControls();
	
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

	public Factory getImageFactory() {
		return gui.getImageFactory();
	}	
	
	private void createStats() {
		int x = (int) Math.round(160 * scaleFactor);
		int y = (int) Math.round(0 * scaleFactor);
		int w = (int) Math.round(500 * scaleFactor);
		int h = (int) Math.round(100 * scaleFactor);
		int borderSize = (int) Math.round(2 * scaleFactor);
		int borderRadius = (int) Math.round(64 * scaleFactor);
		
		
		lblTime.setBounds(x, y, w, h);
		
		x = (int) Math.round(710 * scaleFactor);
		y = (int) Math.round(0 * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblLevel.setBounds(x, y, w, h);
		
		x = (int) Math.round(1260 * scaleFactor);
		y = (int) Math.round(0 * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblScore.setBounds(x, y, w, h);		
		
		lblTime.setFont(font.deriveFont(Math.round(80 * scaleFactor) * 1.0f));
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblTime.setOpaque(true);
		lblTime.setBackground(panel.getBackground());
		
		lblTime.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		
		lblLevel.setFont(font.deriveFont(Math.round(80 * scaleFactor) * 1.0f));
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setForeground(gui.getImageFactory().getColorForeground());
		lblLevel.setOpaque(true);
		lblLevel.setBackground(panel.getBackground());
		lblLevel.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		
		lblScore.setFont(font.deriveFont(Math.round(80 * scaleFactor) * 1.0f));
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setOpaque(true);
		lblScore.setBackground(panel.getBackground());
		lblScore.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		
		add(lblTime);
		add(lblLevel);
		add(lblScore);
	}

	private void createVertical() {
		matrix = new JLabel[Map.COLUMN][Map.ROW];
		
		int x = (int) Math.round((1920/2 - 675) * scaleFactor);
		int y = (int) Math.round((1080 - 180) * scaleFactor);
		int w = (int) Math.round(375 * scaleFactor);
		int h = (int) Math.round(150 * scaleFactor);
		lblKeyboard.setBounds(x, y, w, h);
		
		x = (int) Math.round((1920/2 + 300) * scaleFactor);
		y = (int) Math.round((1080 - 180) * scaleFactor);
		w = (int) Math.round(102 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		lblMouse.setBounds(x, y, w, h);
		
		add(lblKeyboard);
		add(lblMouse);
	}
	
	private void createHorizontal() {
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		
		int x = (int) Math.round((1920 - 477)/2 * scaleFactor);
		int y = (int) Math.round((1080 - 180) * scaleFactor);
		int w = (int) Math.round(375 * scaleFactor);
		int h = (int) Math.round(150 * scaleFactor);
		lblKeyboard.setBounds(x, y, w, h);
		
		x = (int) Math.round(((1920 - 477)/2 + 375) * scaleFactor);
		y = (int) Math.round((1080 - 180) * scaleFactor);
		w = (int) Math.round(102 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		lblMouse.setBounds(x, y, w, h);
		
		add(lblKeyboard);
		add(lblMouse);
	}

	private void createCentralPanel() {
		int cellSize = Math.round(Math.round(54 * scaleFactor));
		
		int borderSize = (int) Math.round(2 * scaleFactor);
		int borderRadius = (int) Math.round(64 * scaleFactor);
		
		int x = (int) Math.round(((getWidth() - (matrix[0].length  * cellSize)) / 2));
		int y = (int) Math.round(((getHeight() + lblLevel.getHeight() - (matrix.length * cellSize)) / 2));
		int w = (int) Math.round(matrix[0].length * cellSize);
		int h = (int) Math.round(matrix.length * cellSize);
		
		int lblBgX = (int) Math.round(((getWidth() - (matrix[0].length + 1) * cellSize) / 2));
		int lblBgY = (int) Math.round(((getHeight()  + lblLevel.getHeight() - (matrix.length + 1) * cellSize) / 2));
		int lblBgW = (int) Math.round((matrix[0].length + 1) * cellSize);
		int lblBgH = (int) Math.round((matrix.length + 1) * cellSize);
		
		
		
		panel.setLayout(new GridLayout(Map.COLUMN, Map.ROW));
		
		if(w < h) {
			panel.setLayout(new GridLayout(Map.COLUMN, Map.ROW));
			panel.setBounds(x, y, w, h);
			lblBg.setBounds(lblBgX, lblBgY, lblBgW, lblBgH);
		}
			
		else {
			panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
			panel.setBounds(x, y, w, h);
			lblBg.setBounds(lblBgX, lblBgY, lblBgW, lblBgH);
		}
		add(panel);
		
		lblBg.setOpaque(true);
		lblBg.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		add(lblBg);
		
		for(int r = matrix.length-1; r >= 0; r--) {
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new JLabel();
				matrix[r][c].setFont(font.deriveFont(Math.round(70 * scaleFactor) * 1.0f));
				matrix[r][c].setForeground(gui.getImageFactory().getColorForeground());
				matrix[r][c].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				matrix[r][c].setOpaque(true);
				panel.add(matrix[r][c]);
			}
		}
	}
}
