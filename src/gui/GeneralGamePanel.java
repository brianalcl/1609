package gui;

import javax.swing.JLabel;

import game.Game;
import game.Map;
import imageFactory.DarkImageFactory;
import imageFactory.ImageFactory;
import javax.swing.JPanel;

import java.awt.GridLayout;


public abstract class GeneralGamePanel extends GeneralPanel{
	
	private JLabel[][] matrix;
	private JPanel panel;
	protected JLabel lbl;
	
	public GeneralGamePanel(GUI gui) {
		super(gui);
		matrix = new JLabel[Map.ROW][Map.COLUMN];
		panel = new JPanel();
		createCentralPanel();
		lbl = new JLabel("");
		lbl.setSize(gui.getImageFactory().getScreenResolution());
		lbl.setIcon(gui.getImageFactory().getMap());		
		//TODO SACAR ENTRE LINEAS INI
		ImageFactory f = new DarkImageFactory(1920, 1080);
		lbl = new JLabel("");
		lbl.setSize(f.getScreenResolution());
		lbl.setIcon(f.getMap());	
		//TODO SACAR ENTRE LINEAS FIN
		add(lbl);
		
	}
	
	
	private void createCentralPanel() {
		repaint();
		int width = (int) gui.getImageFactory().getScreenResolution().getWidth();
		int height = (int) gui.getImageFactory().getScreenResolution().getHeight();
		int panelWidth = (int) width * 800 / ImageFactory.DEFAULT_WIDTH;
		int panelHeight = (int) height * 450 / ImageFactory.DEFAULT_HEIGHT;
		
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

	public void setPoints(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTime(String res) {
		// TODO Auto-generated method stub
		
	}

	public void setLevel(String string) {
		// TODO Auto-generated method stub
		
	}

	public void changeCell(JLabel graphicCell, int row, int column) {
		matrix[row][column].setIcon(graphicCell.getIcon());
		matrix[row][column].setBackground(graphicCell.getBackground());
	}

	public ImageFactory getImageFactory() {
		return gui.getImageFactory();
	}
}
