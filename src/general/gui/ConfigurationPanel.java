package general.gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ConfigurationPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton[][] matrix;
	protected JPanel panel;
	
	
	public ConfigurationPanel(GUI gui) {
		super(gui);
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
		panel.setBackground(gui.getImageFactory().getColorDefault());
		add(panel);
	}
	
	private void putBottons() {
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				matrix[r][c] = new JButton();
				matrix[r][c].setFocusable(false);
				matrix[r][c].setBorderPainted(false);
				matrix[r][c].addMouseListener(getMouseAdapter());
				panel.add(matrix[r][c]);
			}
		
		matrix[0][0].setBackground(gui.getImageFactory().getColorDarkSlateGray());
		matrix[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkSlateGray());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[0][1].setBackground(gui.getImageFactory().getColorDarkGoldenRod());
		matrix[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkGoldenRod());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[0][2].setBackground(gui.getImageFactory().getColorSienna());
		matrix[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorSienna());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][0].setBackground(gui.getImageFactory().getColorMediumOrchid());
		matrix[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorMediumOrchid());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][1].setBackground(gui.getImageFactory().getColorDarkOliveGreen());
		matrix[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkOliveGreen());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[1][2].setBackground(gui.getImageFactory().getColorCrimson());
		matrix[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorCrimson());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][0].setBackground(gui.getImageFactory().getColorDarkCyan());
		matrix[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkCyan());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][1].setBackground(gui.getImageFactory().getColorDarkGreen());
		matrix[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkGreen());
				gui.setPanel(new InitialPanel(gui));
			}
		});
		
		matrix[2][2].setBackground(gui.getImageFactory().getColorDarkRed());
		matrix[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.getImageFactory().setColorDefault(gui.getImageFactory().getColorDarkRed());
				gui.setPanel(new InitialPanel(gui));
			}
		});
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(e.getComponent().getBackground().darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(e.getComponent().getBackground().brighter());
			}

		};
	}
	
}
