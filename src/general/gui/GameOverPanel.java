package general.gui;

import java.awt.Color;
import java.awt.Font;
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
	protected GeneralGamePanel panel;
	protected Font lblFont;
	
	public GameOverPanel(GUI gui, GeneralGamePanel panel, String res, String score, String time) {
		super(gui);
//		setBackground(panel.getBackground());
		setBackground(new Color(0,80,80));
		this.panel = panel;
		restart = new JButton();
		exit = new JButton();
		home = new JButton();
		lblRes = new JLabel(res);
		lblScore = new JLabel(score);
		lblTime = new JLabel(time);
		lblBg = new JLabel();
		
		lblFont = font.deriveFont(150f);
		createButtons();
		createLabels();
	}
	
	private void createLabels() {
		lblBg.setIcon(gui.getImageFactory().getGuiGameOver());
		lblRes.setBounds((getWidth()-600)/2 + 50, (getHeight()-720)/2 +50, 500, 150);
		lblScore.setBounds((getWidth()-600)/2 + 50, (getHeight()-720)/2 +250, 500, 100);
		lblTime.setBounds((getWidth()-600)/2 + 50, (getHeight()-720)/2 +400, 500, 100);
		lblBg.setBounds((getWidth()-600)/2, (getHeight()-720)/2, 600, 720);
		
		lblRes.setFont(lblFont);
		lblRes.setForeground(gui.getImageFactory().getForegroundColor());
		lblRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		lblScore.setFont(font.deriveFont(75f));
		lblScore.setForeground(gui.getImageFactory().getForegroundColor());
		lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		lblTime.setFont(font.deriveFont(75f));
		lblTime.setForeground(gui.getImageFactory().getForegroundColor());
		lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		add(lblRes);
		add(lblScore);
		add(lblTime);
		add(lblBg);

	}
	
	private void createButtons() {
		
		restart.setBackground(new Color(0,80,80));
		restart.setFocusable(false);
		restart.setBorderPainted(false);
		restart.addMouseListener(getMouseAdapter());
		restart.setBounds((getWidth()-600)/2 + 50, (getHeight()-720)/2 + 525, 150, 150);
		restart.setIcon(gui.getImageFactory().getRestart());
		
		exit.setBackground(new Color(0,80,80));
		exit.setFocusable(false);
		exit.setBorderPainted(false);
		exit.addMouseListener(getMouseAdapter());
		exit.setBounds((getWidth()-600)/2 + 225, (getHeight()-720)/2 + 525, 150, 150);
		exit.setIcon(gui.getImageFactory().getExit());
		
		home.setBackground(new Color(0,80,80));
		home.setFocusable(false);
		home.setBorderPainted(false);
		home.addMouseListener(getMouseAdapter());
		home.setBounds((getWidth()-600)/2 + 400, (getHeight()-720)/2 + 525, 150, 150);
		home.setIcon(gui.getImageFactory().getHome());
		
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
				e.getComponent().setBackground(new Color(0,60,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(0,80,80));
			}

		};
	}
}
