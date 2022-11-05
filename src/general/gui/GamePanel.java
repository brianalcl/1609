package general.gui;


import javax.swing.JLabel;
import javax.swing.JPanel;

import abstractFactory.AbstractFactory;
import general.data.PlayerScore;
import general.data.StatsData;
import general.data.PlayersRegistry;
import general.logic.Map;
import general.utilities.InternalBorderRound;
import gui.GUI;
import sound.Sound;

import java.awt.GridLayout;
import java.io.IOException;


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
	protected JLabel lblHighScore;
	protected JLabel lblKeyboard;
	protected JLabel lblMouse;
	protected JLabel lblBg;
	protected int score;
	protected String fileToSavePath;
	
	public GamePanel(GUI gui, boolean isHorizontal) {
		super(gui);
		panel = new JPanel();		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");
		lblHighScore = new JLabel("High: 00000");
		lblKeyboard = new JLabel("");
		lblMouse = new JLabel("");
		lblBg = new JLabel("");
		score = 0;
		
		setBackground(this.gui.getImageFactory().getColorDefault());
		panel.setBackground(gui.getImageFactory().getDefaultMarkColor());
		lblBg.setBackground(panel.getBackground());
		
		if(isHorizontal)
			createHorizontal();
		else
			createVertical();
		
		createCentralPanel();
		createStats();
		addControls();
	}
	
	protected void load() {
		PlayersRegistry register;
		
		try {
			register = (new StatsData(this)).load();
			lblHighScore.setText("High: " + register.getScores().getScore());
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error to save.");
		}
	}
	
	protected void save() {
		
		PlayersRegistry register;
		StatsData sd;
		
		try {
			sd = new StatsData(this);
			register = sd.load();
			register.addPlayer(new PlayerScore(score));
			sd.save(register);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error to save.");
		}
	}
	
	public abstract String getFileToSavePath();
	
	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
	
	protected abstract void addControls();
	
	public void setPoints(String score) {
		this.score = Integer.parseInt(score);
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

	public AbstractFactory getImageFactory() {
		return gui.getImageFactory();
	}	
	
	public Sound getSound() {
		return gui.getSound();
	}
	
	private void createStats() {
		int borderSize = (int) Math.round(2 * scaleFactor);
		int borderRadius = (int) Math.round(64 * scaleFactor);
		
		int x = (int) Math.round(150 * scaleFactor);
		int y = (int) Math.round(25 * scaleFactor);
		int w = (int) Math.round(500 * scaleFactor);
		int h = (int) Math.round(100 * scaleFactor);
		lblTime.setBounds(x, y, w, h);
		
		x = (int) Math.round(150 * scaleFactor);
		y = (int) Math.round(150 * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblLevel.setBounds(x, y, w, h);
		
		x = (int) Math.round((1920 - 150 - 500) * scaleFactor);
		y = (int) Math.round(25 * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblScore.setBounds(x, y, w, h);		
		
		x = (int) Math.round((1920 - 150 - 500) * scaleFactor);
		y = (int) Math.round(150 * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblHighScore.setBounds(x, y, w, h);		
		
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
		
		lblHighScore.setFont(font.deriveFont(Math.round(80 * scaleFactor) * 1.0f));
		lblHighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHighScore.setForeground(gui.getImageFactory().getColorForeground());
		lblHighScore.setOpaque(true);
		lblHighScore.setBackground(panel.getBackground());
		lblHighScore.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		
		add(lblTime);
		add(lblLevel);
		add(lblScore);
		add(lblHighScore);
		
		lblKeyboard.setForeground(gui.getImageFactory().getColorForeground());
		lblKeyboard.setOpaque(true);
		lblKeyboard.setBackground(panel.getBackground());
		lblKeyboard.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		lblKeyboard.setVisible(false);
		
		lblMouse.setForeground(gui.getImageFactory().getColorForeground());
		lblMouse.setOpaque(true);
		lblMouse.setBackground(panel.getBackground());
		lblMouse.setBorder(new InternalBorderRound(borderSize, borderRadius, getBackground()));
		lblMouse.setVisible(false);
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
		
		int borderRadius = (int) Math.round(64 * scaleFactor);
		
		int w = matrix[0].length * cellSize;
		int h = matrix.length * cellSize;
		int x = (getWidth() - w) / 2;
		int y = (getHeight() - h) / 2;
		
		int lblBgW = (matrix[0].length + 1) * cellSize - cellSize/2;
		int lblBgH = (matrix.length + 1) * cellSize - cellSize/2;
		int lblBgX = (getWidth() - lblBgW) / 2;
		int lblBgY = (getHeight() - lblBgH) / 2;
		
		
		panel.setBounds(x, y, w, h);
		lblBg.setBounds(lblBgX, lblBgY, lblBgW, lblBgH);
		if(w < h) 
			panel.setLayout(new GridLayout(Map.COLUMN, Map.ROW));
		else
			panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
		
		add(panel);
		
		lblBg.setOpaque(true);
		lblBg.setBorder(new InternalBorderRound(0, borderRadius, getBackground()));
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
