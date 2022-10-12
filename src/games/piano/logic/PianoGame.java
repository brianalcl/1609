package games.piano.logic;

import games.piano.gui.PianoPanel;
import games.piano.thread.PianoWatch;
import general.logic.Game;

public class PianoGame extends Game{
	protected Player player;
	protected PianoWall wall_1;
	protected PianoWall wall_2;
	protected PianoWall wall_3;
	protected PianoWall wall_4;
	protected PianoWall wall_5;
	protected PianoWall wall_6;
	protected PianoWatch pianoWatch;
	protected int tick;
	protected boolean clicked;
	
	public PianoGame(PianoPanel panel) {
		super(panel);
		PianoMap map = new PianoMap(this);
		this.player = new Player(map, this.panel.getImageFactory());
		this.pianoWatch = new PianoWatch(this, 400);
		this.wall_1 = new PianoWall(map, this.panel.getImageFactory());
		this.wall_2 = new PianoWall(map, this.panel.getImageFactory());
		this.wall_3 = new PianoWall(map, this.panel.getImageFactory());
		this.wall_4 = new PianoWall(map, this.panel.getImageFactory());
		this.wall_5 = new PianoWall(map, this.panel.getImageFactory());
		this.wall_6 = new PianoWall(map, this.panel.getImageFactory());
		this.tick = 0;
		this.clicked = false;
		this.pianoWatch.start();
	}
	
	public synchronized void run() {
		if(tick >= 0)
			wall_1.charge();
		if(tick >= 5)
			wall_2.charge();
		if(tick >= 10)
			wall_3.charge();
		if(tick >= 15)
			wall_4.charge();
		
		if(tick < 15) {
			tick++;
		}
		
	}
	
	public void left() {
		click(0);
	}
	
	public void center() {
		click(1);
	}
	
	public void right() {
		click(2);
	}
	
	public void click(int pos) {
		boolean isClick = false;
		isClick = wall_1.click(pos);
		isClick = isClick || wall_2.click(pos);
		isClick = isClick || wall_3.click(pos);
		isClick = isClick || wall_4.click(pos);
		if(!isClick) {
			lose();
		}
	}
	
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(pianoWatch.getStep() > 40)
				pianoWatch.setStep(pianoWatch.getStep() - 20);
		}
	}
	
	@Override
	public void lose() {
		super.lose();
	}
	
}