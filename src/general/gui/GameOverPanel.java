package general.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GameOverPanel extends GeneralPanel{
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
		
		int x = (int) Math.round(((1920-600)/2) * widthScaleFactor);
		int y = (int) Math.round(((1080-720)/2) * heightScaleFactor);
		int w = (int) Math.round(600 * widthScaleFactor);
		int h = (int) Math.round(720 * heightScaleFactor);
		lblBg.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * widthScaleFactor);
		y = (int) Math.round(((1080-720)/2 + 50) * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		lblRes.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * widthScaleFactor);
		y = (int) Math.round(((1080-720)/2 + 250) * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblScore.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 50) * widthScaleFactor);
		y = (int) Math.round(((1080-720)/2 + 400) * heightScaleFactor);
		w = (int) Math.round(500 * widthScaleFactor);
		h = (int) Math.round(100 * heightScaleFactor);
		lblTime.setBounds(x,y,w,h);

		lblScore.setFont(font.deriveFont(Math.round(75*widthScaleFactor)*1.0f));
		lblTime.setFont(font.deriveFont(Math.round(75*widthScaleFactor)*1.0f));
		lblRes.setFont(font.deriveFont(Math.round(150*widthScaleFactor)*1.0f));
		
		
		lblRes.setForeground(gui.getImageFactory().getForegroundColor());
		lblRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		lblScore.setForeground(gui.getImageFactory().getForegroundColor());
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		lblTime.setForeground(gui.getImageFactory().getForegroundColor());
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		add(lblRes);
		add(lblScore);
		add(lblTime);
		add(lblBg);

	}
	
	private void createButtons() {
		
		int x = (int) Math.round(((1920-600)/2 + 50) * widthScaleFactor);
		int y = (int) Math.round(((1080-720)/2 + 525) * heightScaleFactor);
		int w = (int) Math.round(150 * widthScaleFactor);
		int h = (int) Math.round(150 * heightScaleFactor);
		restart.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 225) * widthScaleFactor);
		y = (int) Math.round(((1080-720)/2 + 525) * heightScaleFactor);
		w = (int) Math.round(150 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
		exit.setBounds(x,y,w,h);
		
		x = (int) Math.round(((1920-600)/2 + 400) * widthScaleFactor);
		y = (int) Math.round(((1080-720)/2 + 525) * heightScaleFactor);
		w = (int) Math.round(150 * widthScaleFactor);
		h = (int) Math.round(150 * heightScaleFactor);
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
