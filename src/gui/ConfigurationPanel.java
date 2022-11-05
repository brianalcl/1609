package gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abstractFactory.DarkFactory;
import abstractFactory.LightFactory;
import general.gui.GeneralPanel;
import general.utilities.InternalBorderRound;


public class ConfigurationPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton[][] lightMatrix;
	protected JPanel lightPanel;
	protected Color light_1;
	protected Color light_2;
	protected Color light_3;
	protected Color light_4;
	protected Color light_5;
	protected Color light_6;
	protected Color light_7;
	protected Color light_8;
	protected Color light_9;
	
	protected JButton[][] darkMatrix;
	protected JPanel darkPanel;
	protected Color dark_1;
	protected Color dark_2;
	protected Color dark_3;
	protected Color dark_4;
	protected Color dark_5;
	protected Color dark_6;
	protected Color dark_7;
	protected Color dark_8;
	protected Color dark_9;
	
	protected JLabel lblBg;
	
	public ConfigurationPanel(GUI gui) {
		super(gui);		
		
		light_1 = new Color(205, 97, 85);
		light_2 = new Color(165, 105, 189);
		light_3 = new Color(84, 153, 199);	
		light_4 = new Color(69, 179, 157);
		light_5 = new Color(82, 190, 128);
		light_6 = new Color(245, 176, 65);
		light_7 = new Color(220, 118, 51);
		light_8 = new Color(153, 163, 164);
		light_9 = new Color(93, 109, 126);
		
		dark_1 = new Color(100, 30, 22);
		dark_2 = new Color(74, 35, 90);
		dark_3 = new Color(21, 67, 96);	
		dark_4 = new Color(11, 83, 69);
		dark_5 = new Color(24, 106, 59);
		dark_6 = new Color(126, 81, 9);
		dark_7 = new Color(110, 44, 0);
		dark_8 = new Color(66, 73, 73);
		dark_9 = new Color(23, 32, 42);
		
		setBackground(this.gui.getImageFactory().getColorDefault());
		darkMatrix = new JButton[3][3];
		darkPanel = new JPanel();
		
		lightMatrix = new JButton[3][3];
		lightPanel = new JPanel();
		createPanelLight();
		putBottonsLight();
		
		createPanelDark();
		putBottonsDark();
		
		lblBg = new JLabel();
		createLblBg();
	}
	
	private void createPanelLight() {
		int x = (int) Math.round(360 * scaleFactor);
		int y = (int) Math.round((1080 - 1000) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(600 * scaleFactor);
		lightPanel.setBounds(x,y,w,h);
		lightPanel.setLayout(new GridLayout(lightMatrix.length, lightMatrix[0].length));
		lightPanel.setBackground(gui.getImageFactory().getDefaultMarkColor());
		add(lightPanel);
	}
	
	private void createPanelDark() {
		int x = (int) Math.round((1920 - 960) * scaleFactor);
		int y = (int) Math.round((1080 - 1000) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(600 * scaleFactor);
		darkPanel.setBounds(x,y,w,h);
		darkPanel.setLayout(new GridLayout(darkMatrix.length, darkMatrix[0].length));
		darkPanel.setBackground(gui.getImageFactory().getDefaultMarkColor());
		add(darkPanel);
	}
	
	private void createLblBg() {
		int borderSize = (int) Math.round(2 * scaleFactor);
		int borderRadius = (int) Math.round(64 * scaleFactor);
		int x = (int) Math.round(340 * scaleFactor);
		int y = (int) Math.round((1080 - 1020) * scaleFactor);
		int w = (int) Math.round(1240 * scaleFactor);
		int h = (int) Math.round(640 * scaleFactor);
		
		lblBg.setBounds(x,y,w,h);
		lblBg.setOpaque(true);
		lblBg.setBackground(gui.getImageFactory().getDefaultMarkColor());
		lblBg.setBorder(new InternalBorderRound(borderSize, borderRadius, gui.getImageFactory().getColorDefault()));
		
		add(lblBg);
	}
	
	private void putBottonsLight() {
		int borderSize = (int) Math.round(10 * scaleFactor);
		int borderRadius = (int) Math.round(96 * scaleFactor);
		
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				lightMatrix[r][c] = new JButton();
				lightMatrix[r][c].setFocusable(false);
				lightMatrix[r][c].setBorder(new InternalBorderRound(borderSize, borderRadius, lightPanel.getBackground()));
				lightMatrix[r][c].addMouseListener(getMouseAdapter());
				lightPanel.add(lightMatrix[r][c]);
			}
		
		lightMatrix[0][0].setBackground(light_1);
		lightMatrix[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_1));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[0][1].setBackground(light_2);
		lightMatrix[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_2));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[0][2].setBackground(light_3);
		lightMatrix[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_3));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[1][0].setBackground(light_4);
		lightMatrix[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_4));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[1][1].setBackground(light_5);
		lightMatrix[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_5));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[1][2].setBackground(light_6);
		lightMatrix[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_6));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[2][0].setBackground(light_7);
		lightMatrix[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_7));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[2][1].setBackground(light_8);
		lightMatrix[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_8));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		lightMatrix[2][2].setBackground(light_9);
		lightMatrix[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new LightFactory(gui.getImageFactory().getScreenResolution(), light_9));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
	}
	
	private void putBottonsDark() {
		int borderSize = (int) Math.round(10 * scaleFactor);
		int borderRadius = (int) Math.round(96 * scaleFactor);
		
		for(int r = 0; r < 3; r++) 
			for(int c = 0; c < 3; c++) {
				darkMatrix[r][c] = new JButton();
				darkMatrix[r][c].setFocusable(false);
				darkMatrix[r][c].setBorder(new InternalBorderRound(borderSize, borderRadius, darkPanel.getBackground()));
				darkMatrix[r][c].addMouseListener(getMouseAdapter());
				darkPanel.add(darkMatrix[r][c]);
			}
		
		darkMatrix[0][0].setBackground(dark_1);
		darkMatrix[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_1));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[0][1].setBackground(dark_2);
		darkMatrix[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_2));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[0][2].setBackground(dark_3);
		darkMatrix[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_3));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[1][0].setBackground(dark_4);
		darkMatrix[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_4));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[1][1].setBackground(dark_5);
		darkMatrix[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_5));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[1][2].setBackground(dark_6);
		darkMatrix[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_6));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[2][0].setBackground(dark_7);
		darkMatrix[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_7));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[2][1].setBackground(dark_8);
		darkMatrix[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_8));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
		
		darkMatrix[2][2].setBackground(dark_9);
		darkMatrix[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setImageFactory(new DarkFactory(gui.getImageFactory().getScreenResolution(), dark_9));
				gui.setPanel(new InitialPanel(gui)); 
			}
		});
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(e.getComponent().getBackground().brighter());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(e.getComponent().getBackground().darker());
			}

		};
	}
	
}
