package gui;

import javax.swing.JLabel;

import game.Map;
import imageFactory.DarkImageFactory;
import imageFactory.ImageFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;


public abstract class GeneralGamePanel extends GeneralPanel{
	
	private JLabel[][] matrix;
	private JPanel panel;
	protected JLabel lbl;
	private JLabel lblTime;
	private JLabel lblLevel;
	private JLabel lblScore;
	
	public GeneralGamePanel(GUI gui) {
		super(gui);
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		panel = new JPanel();
		createCentralPanel();
		lbl = new JLabel("");
		lbl.setSize(gui.getImageFactory().getScreenResolution());
		lbl.setIcon(gui.getImageFactory().getMap());		
		//TODO SACAR ENTRE LINEAS INI
		ImageFactory f = new DarkImageFactory(1280, 720);
		lbl = new JLabel("");
		lbl.setSize(f.getScreenResolution());
		lbl.setIcon(f.getMap());
		//TODO SACAR ENTRE LINEAS FIN
		add(lbl);
		createLabels();
		
		
	}
	
	private void createLabels() {
		Font fontLabels;
		
		lblTime = new JLabel("Time: 00:00");
		lblLevel = new JLabel("Level: 00");
		lblScore = new JLabel("Score: 00000");		
		
		
		if(gui.getImageFactory().getScreenResolution().getWidth() == ImageFactory.DEFAULT_WIDTH) {
			lblTime.setBounds(160, 30, 500, 100);
			lblLevel.setBounds(710, 30, 500, 100);
			lblScore.setBounds(1260, 30, 500, 100);
			fontLabels = font.deriveFont(81f);
		}
		else {
			lblTime.setBounds(107, 20, 333, 66);
			lblLevel.setBounds(474, 20, 333, 66);
			lblScore.setBounds(841, 20, 333, 66);
			fontLabels = font.deriveFont(54f);
		}
		
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
	}
	
	private void createCentralPanel() {
		//repaint();
//		int width = (int) gui.getImageFactory().getScreenResolution().getWidth();
//		int height = (int) gui.getImageFactory().getScreenResolution().getHeight();
//		int panelWidth = (int) width * 800 / ImageFactory.DEFAULT_WIDTH;
//		int panelHeight = (int) height * 450 / ImageFactory.DEFAULT_HEIGHT;
		
		int width = (int) gui.getImageFactory().getScreenResolution().getWidth();
		int height = (int) gui.getImageFactory().getScreenResolution().getHeight();
		//TODO
		width = 1280;
		height = 720;
		//TODO
		int panelWidth = (int) 800;
		int panelHeight = (int) 450;
		
		
		panel.setLayout(new GridLayout(Map.ROW, Map.COLUMN));
		panel.setSize(panelWidth, panelHeight);
		panel.setLocation((int)(width-panelWidth)/2, (int) (height-panelHeight)/2);
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
}
