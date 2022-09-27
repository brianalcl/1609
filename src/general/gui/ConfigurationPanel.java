package general.gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import general.utilities.InternalBorderRound;


public class ConfigurationPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton[][] matrix;
	protected JPanel panel;
	protected Color colorDarkSlateGray;
	protected Color colorDarkCyan;
	protected Color colorDarkGreen;
	protected Color colorDarkOliveGreen;
	protected Color colorDarkGoldenRod;
	protected Color colorMediumOrchid;
	protected Color colorSienna;
	protected Color colorPurple;
	protected Color colorCrimson;
	
	public ConfigurationPanel(GUI gui) {
		super(gui);		
		
		colorDarkSlateGray = new Color(47, 79, 79);
		colorDarkCyan = new Color(20, 139, 139);
		colorDarkGreen = new Color(20, 100, 20);	
		colorDarkOliveGreen = new Color(85, 107, 47);
		colorDarkGoldenRod = new Color(164, 134, 21);
		colorMediumOrchid = new Color(186, 85, 211);
		colorSienna = new Color(160, 82, 45);
		colorPurple = new Color(128, 20, 128);
		colorCrimson = new Color(220, 20, 60);
		
		setBackground(this.gui.getImageFactory().getColorDefault());
		matrix = new JButton[3][3];
		panel = new JPanel();
		createPanel();
		putBottons();
	}
	
	private void createPanel() {
		int x = (int) Math.round(((1920 - 600) / 2) * widthScaleFactor);
		int y = (int) Math.round(((1080 - 600) / 2) * heightScaleFactor);
		int w = (int) Math.round(600 * widthScaleFactor);
		int h = (int) Math.round(600 * heightScaleFactor);
		panel.setBounds(x,y,w,h);
		panel.setLayout(new GridLayout(matrix.length, matrix[0].length));
		panel.setBackground(gui.getImageFactory().getMarkColor(gui.getImageFactory().getColorDefault(), -20));
		add(panel);
	}
	
	private void putBottons() {
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				matrix[r][c] = new JButton();
				matrix[r][c].setFocusable(false);
				matrix[r][c].setBorder(new InternalBorderRound(10, 10, 10, 10, 32, panel.getBackground()));
				matrix[r][c].addMouseListener(getMouseAdapter());
				panel.add(matrix[r][c]);
			}
		
		matrix[0][0].setBackground(colorDarkSlateGray);
		matrix[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorDarkSlateGray);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[0][1].setBackground(colorDarkGoldenRod);
		matrix[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorDarkGoldenRod);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[0][2].setBackground(colorSienna);
		matrix[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorSienna);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][0].setBackground(colorMediumOrchid);
		matrix[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorMediumOrchid);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][1].setBackground(colorDarkOliveGreen);
		matrix[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorDarkOliveGreen);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][2].setBackground(colorCrimson);
		matrix[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorCrimson);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][0].setBackground(colorDarkCyan);
		matrix[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorDarkCyan);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][1].setBackground(colorDarkGreen);
		matrix[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorDarkGreen);
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][2].setBackground(colorPurple);
		matrix[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(colorPurple);
				gui.setPanel(new InitialPanel(gui));
			}
		});
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
