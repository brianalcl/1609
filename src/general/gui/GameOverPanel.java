package general.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOverPanel extends GeneralPanel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected JButton restart;
	protected JButton exit;
	protected JButton home;
	protected JLabel lblBg;
	protected JLabel lblRes;
	protected JLabel lblScore;
	protected JLabel lblTime;
	protected GamePanel panel;
	
	public GameOverPanel(GUI gui, GamePanel panel, String res, String score, String time) {
		super(gui);
		this.panel = panel;
		setBackground(this.panel.getBackground());
		restart = new JButton(this.gui.getImageFactory().getRestart());
		exit = new JButton(this.gui.getImageFactory().getExit());
		home = new JButton(this.gui.getImageFactory().getHome());
		lblRes = new JLabel(res);
		lblScore = new JLabel(score);
		lblTime = new JLabel(time);
		lblBg = new JLabel(this.gui.getImageFactory().getGuiGameOver());
		
		createButtons();
		createLabels();
	}
	
	private void createLabels() {
		
		int x = (int) Math.round(((1920-600)/2) * scaleFactor);
		int y = (int) Math.round(((1080-720)/2) * scaleFactor);
		int w = (int) Math.round(600 * scaleFactor);
		int h = (int) Math.round(720 * scaleFactor);
		lblBg.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-720)/2 + 50) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		lblRes.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-720)/2 + 250) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		y = (int) Math.round(((1080-720)/2 + 400) * scaleFactor);
		w = (int) Math.round(500 * scaleFactor);
		h = (int) Math.round(100 * scaleFactor);
		lblTime.setBounds(x,y,w,h);

		lblScore.setFont(font.deriveFont(Math.round(75*scaleFactor)*1.0f));
		lblTime.setFont(font.deriveFont(Math.round(75*scaleFactor)*1.0f));
		lblRes.setFont(font.deriveFont(Math.round(150*scaleFactor)*1.0f));
		
		
		lblRes.setForeground(gui.getImageFactory().getColorForeground());
		lblRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		lblScore.setForeground(gui.getImageFactory().getColorForeground());
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		lblTime.setForeground(gui.getImageFactory().getColorForeground());
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		add(lblRes);
		add(lblScore);
		add(lblTime);
		add(lblBg);

	}
	
	private void createButtons() {
		
		int x = (int) Math.round(((1920-600)/2 + 50) * scaleFactor);
		int y = (int) Math.round(((1080-720)/2 + 525) * scaleFactor);
		int w = (int) Math.round(150 * scaleFactor);
		int h = (int) Math.round(150 * scaleFactor);
		restart.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 225) * scaleFactor);
		y = (int) Math.round(((1080-720)/2 + 525) * scaleFactor);
		w = (int) Math.round(150 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		exit.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 400) * scaleFactor);
		y = (int) Math.round(((1080-720)/2 + 525) * scaleFactor);
		w = (int) Math.round(150 * scaleFactor);
		h = (int) Math.round(150 * scaleFactor);
		home.setBounds(x,y,w,h);		
		
		
		restart.setBackground(panel.getBackground());
		restart.setFocusable(false);
		restart.setBorderPainted(false);
		restart.addMouseListener(getMouseAdapter());
		
		exit.setBackground(panel.getBackground());
		exit.setFocusable(false);
		exit.setBorderPainted(false);
		exit.addMouseListener(getMouseAdapter());
		
		home.setBackground(panel.getBackground());
		home.setFocusable(false);
		home.setBorderPainted(false);
		home.addMouseListener(getMouseAdapter());
		
		restart.addActionListener(e -> panel.restart());
		home.addActionListener(e -> gui.setPanel(new InitialPanel(gui)));
		exit.addActionListener(e -> System.exit(0));
		
		add(restart);
		add(exit);
		add(home);
	}
	
	private MouseAdapter getMouseAdapter(){
		return new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(panel.getBackground().darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(panel.getBackground());
			}

		};
	}
}
