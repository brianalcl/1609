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
	}
	private void createStats() {
		int x = (int) Math.round(160 * widthScaleFactor);
		int y = (int) Math.round(0 * heightScaleFactor);
		int w = (int) Math.round(500 * widthScaleFactor);
		int h = (int) Math.round(100 * heightScaleFactor);
		lblTime.setBounds(x,y,w,h);
		
		x = (int) Math.round(710 * widthScaleFactor);
		y = (int) Math.round(0 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblLevel.setBounds(x,y,w,h);
		
		x = (int) Math.round(1260 * widthScaleFactor);
		y = (int) Math.round(0 * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblScore.setBounds(x,y,w,h);		
		
		lblTime.setFont(font.deriveFont(Math.round(80 * widthScaleFactor) * 1.0f));
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblTime.setOpaque(true);
		lblTime.setBackground(panel.getBackground());
		lblTime.setBorder(new InternalBorderRound(1, 1, 1, 1, 64, getBackground()));
		
		lblLevel.setFont(font.deriveFont(Math.round(80 * widthScaleFactor) * 1.0f));
		lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLevel.setForeground(gui.getImageFactory().getColorForeground());
		lblLevel.setOpaque(true);
		lblLevel.setBackground(panel.getBackground());
		lblLevel.setBorder(new InternalBorderRound(1, 1, 1, 1, 64, getBackground()));
		
		lblScore.setFont(font.deriveFont(Math.round(80 * widthScaleFactor) * 1.0f));
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setOpaque(true);
		lblScore.setBackground(panel.getBackground());
		lblScore.setBorder(new InternalBorderRound(1, 1, 1, 1, 64, getBackground()));
		
		add(lblTime);
		add(lblLevel);
		add(lblScore);
	}

	private void createVertical() {
		matrix = new JLabel[Map.COLUMN][Map.ROW];
		
		int x = (int) Math.round((1920/2 - 675) * widthScaleFactor);
		int y = (int) Math.round((1080 - 180) * heightScaleFactor);
		int w = (int) Math.round(375 * widthScaleFactor);
		int h = (int) Math.round(150 * heightScaleFactor);
		lblKeyboard.setBounds(x,y,w,h);
		
		x = (int) Math.round((1920/2 + 300) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(102 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblMouse.setBounds(x,y,w,h);
		
		add(lblKeyboard);
		add(lblMouse);
	}
	
	private void createHorizontal() {
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		
		int x = (int) Math.round((1920 - 477)/2 * widthScaleFactor);
		int y = (int) Math.round((1080 - 180) * heightScaleFactor);
		int w = (int) Math.round(375 * widthScaleFactor);
		int h = (int) Math.round(150 * heightScaleFactor);
		lblKeyboard.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920 - 477)/2 + 375) * widthScaleFactor);
		y = (int) Math.round((1080 - 180) * heightScaleFactor);
		w = (int) Math.round(102 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblMouse.setBounds(x,y,w,h);
		
		add(lblKeyboard);
		add(lblMouse);
	}

	private void createCentralPanel() {
		int cellWidth = Math.round(Math.round(54 * widthScaleFactor));
		int cellHeight = Math.round(Math.round(54 * heightScaleFactor));
		
		int x = (int) Math.round(((getWidth() - (matrix[0].length  * cellWidth)) / 2));
		int y = (int) Math.round(((getHeight() + lblLevel.getHeight() - (matrix.length * cellHeight)) / 2));
		int w = (int) Math.round(matrix[0].length * cellWidth);
		int h = (int) Math.round(matrix.length * cellHeight);
		
		int lblBgX = (int) Math.round(((getWidth() - (matrix[0].length + 1) * cellWidth) / 2));
		int lblBgY = (int) Math.round(((getHeight()  + lblLevel.getHeight() - (matrix.length + 1) * cellHeight) / 2));
		int lblBgW = (int) Math.round((matrix[0].length + 1) * cellWidth);
		int lblBgH = (int) Math.round((matrix.length + 1) * cellHeight);
		
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
		lblBg.setBorder(new InternalBorderRound(1, 1, 1, 1, 64, getBackground()));
		add(lblBg);
		
		for(int r = matrix.length-1; r >= 0; r--) 
			for(int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = new JLabel();
				matrix[r][c].setFont(font.deriveFont(Math.round(70 * widthScaleFactor) * 1.0f));
				matrix[r][c].setForeground(gui.getImageFactory().getColorForeground());
				matrix[r][c].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
		matrix[row][column].setText(graphicCell.getText());
		matrix[row][column].setBorder(graphicCell.getBorder());
	}

	public Factory getImageFactory() {
		return gui.getImageFactory();
	}

	protected abstract void addControls();

	public abstract void lose();
	
	public abstract void win();
	
	public abstract void restart();
}
