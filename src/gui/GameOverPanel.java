package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import general.gui.GamePanel;
import general.gui.GeneralPanel;
import general.utilities.InternalBorderRound;

public class GameOverPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton restart;
	protected JButton exit;
	protected JButton home;
	protected JLabel lblBg;
	protected JLabel lblBg_2;
	protected JLabel lblRes;
	protected JLabel lblScore;
	protected JLabel lblTime;
	protected JPanel btnPanel;
	protected GamePanel gamePanel;
	protected Color color_1;
	protected Color color_2;
	
	public GameOverPanel(GUI gui, GamePanel gamePanel, String res, String score, String time) {
		super(gui);
		this.gamePanel = gamePanel;
		setBackground(this.gui.getImageFactory().getColorDefault());
		restart = new JButton(this.gui.getImageFactory().getRestart());
		exit = new JButton(this.gui.getImageFactory().getExit());
		home = new JButton(this.gui.getImageFactory().getHome());
		lblBg = new JLabel();
		lblBg_2 = new JLabel();
		lblRes = new JLabel(res);
		lblScore = new JLabel(score);
		lblTime = new JLabel(time);
		btnPanel = new JPanel();
		color_1 = gui.getImageFactory().getColorDefault();
		color_2 = gui.getImageFactory().getDefaultMarkColor();
		
		createButtons();
		createLabels();
	}
	
	private void createLabels() {
		int borderSize = (int) Math.round(2 * scaleFactor);
		int borderRadius = (int) Math.round(64 * scaleFactor);
		
		int x = (int) Math.round(((1920-600)/2) * scaleFactor);
		int y = (int) Math.round(((1080-700)/2) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(700 * scaleFactor);
		lblBg.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-660)/2) * scaleFactor);
		y = (int) Math.round(((1080-760)/2) * scaleFactor);
		w = (int) Math.round(660 * scaleFactor);
		h = (int) Math.round(760 * scaleFactor);
		lblBg_2.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-700)/2 + 20) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		lblRes.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-700)/2 + 220) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-700)/2 + 370) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblTime.setBounds(x,y,w,h);
		
		lblBg.setOpaque(true);
		lblBg.setBackground(color_1);
		
		lblBg_2.setOpaque(true);
		lblBg_2.setBackground(color_2);
		lblBg_2.setBorder(new InternalBorderRound(borderSize, borderRadius, lblBg.getBackground()));
		
		lblRes.setOpaque(true);
		lblRes.setFont(font.deriveFont(Math.round(150 * scaleFactor) *1.0f));
		lblRes.setForeground(gui.getImageFactory().getColorForeground());
		lblRes.setBackground(color_2);
		lblRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblRes.setBorder(new InternalBorderRound(borderSize, borderRadius, lblBg.getBackground()));
		
		lblScore.setOpaque(true);
		lblScore.setFont(font.deriveFont(Math.round(75 * scaleFactor) *1.0f));
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setBackground(color_2);
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblScore.setBorder(new InternalBorderRound(borderSize, borderRadius, lblBg.getBackground()));
		
		lblTime.setOpaque(true);
		lblTime.setFont(font.deriveFont(Math.round(75 * scaleFactor) *1.0f));
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblTime.setBackground(color_2);
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTime.setBorder(new InternalBorderRound(borderSize, borderRadius, lblBg.getBackground()));
		
		add(lblRes);
		add(lblScore);
		add(lblTime);
		add(lblBg);
		add(lblBg_2);
	}
	
	private void createButtons() {
		int borderSize = (int) Math.round(10 * scaleFactor);
		int borderRadius = (int) Math.round(96 * scaleFactor);
		
		int x = (int) Math.round(((1920-600)/2) * scaleFactor);
		int y = (int) Math.round(((1080-700)/2 + 500) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(200 * scaleFactor);
		btnPanel.setBounds(x, y, w, h);
		btnPanel.setLayout(new GridLayout(0,3));
		btnPanel.setBackground(color_1);
		
		restart.setBackground(color_2);
		restart.setFocusable(false);
		restart.addMouseListener(getMouseAdapter());
		restart.setBorder(new InternalBorderRound(borderSize, borderRadius, gamePanel.getBackground()));
		restart.addActionListener(e -> gamePanel.restart());
		
		home.setBackground(color_2);
		home.setFocusable(false);
		home.addMouseListener(getMouseAdapter());
		home.setBorder(new InternalBorderRound(borderSize, borderRadius, gamePanel.getBackground()));
		home.addActionListener(e -> gui.setPanel(new InitialPanel(gui)));
		
		exit.setBackground(color_2);
		exit.setFocusable(false);
		exit.addMouseListener(getMouseAdapter());
		exit.setBorder(new InternalBorderRound(borderSize, borderRadius, gamePanel.getBackground()));
		exit.addActionListener(e -> System.exit(0));
		
		add(btnPanel);
		btnPanel.add(restart);
		btnPanel.add(home);
		btnPanel.add(exit);
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getDefaultMarkColor().brighter());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(gui.getImageFactory().getDefaultMarkColor());
			}

		};
	}
}
