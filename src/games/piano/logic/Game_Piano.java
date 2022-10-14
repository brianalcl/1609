package games.piano.logic;

import games.piano.gui.Panel_Piano;
import games.piano.thread.Clock_Piano;
import general.logic.Game;

public class Game_Piano extends Game{
	protected Player_Piano player;
	protected Tile_Piano tile_1;
	protected Tile_Piano tile_2;
	protected Tile_Piano tile_3;
	protected Tile_Piano tile_4;
	protected Clock_Piano clock_piano;
	protected int tick;
	
	public Game_Piano(Panel_Piano panel) {
		super(panel);
		Map_Piano map = new Map_Piano(this);
		this.player = new Player_Piano(map, this.panel.getImageFactory());
		this.clock_piano = new Clock_Piano(this, 400);
		this.tile_1 = new Tile_Piano(map, this.panel.getImageFactory());
		this.tile_2 = new Tile_Piano(map, this.panel.getImageFactory());
		this.tile_3 = new Tile_Piano(map, this.panel.getImageFactory());
		this.tile_4 = new Tile_Piano(map, this.panel.getImageFactory());
		this.tick = 0;
		this.clock_piano.start();
	}
	
	public synchronized void run() {
		if(tick >= 0)
			tile_1.charge();
		if(tick >= 5)
			tile_2.charge();
		if(tick >= 10)
			tile_3.charge();
		if(tick >= 15)
			tile_4.charge();
		
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
		isClick = tile_1.click(pos);
		isClick = isClick || tile_2.click(pos);
		isClick = isClick || tile_3.click(pos);
		isClick = isClick || tile_4.click(pos);
		if(!isClick) {
			lose();
		}
	}
	
	
	@Override
	public void addPoints(int points) {
		super.addPoints(points);
		if(this.points % 1000 == 0) {
			addLevel();
			if(clock_piano.getStep() > 40)
				clock_piano.setStep(clock_piano.getStep() - 20);
		}
	}
	
	@Override
	public void lose() {
		super.lose();
	}
	
}