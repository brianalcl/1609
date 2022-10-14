package games.shot.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import general.sound.Sound;

public class Player_Shoot {
	protected Cell player;
	protected Factory imageFactory;
	protected Map_Shoot map;
	protected GraphicCell representation;
	protected Shot_Shoot shot;
	
	public Player_Shoot(Map_Shoot map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getTriangle(), this.map.getFreeCell().getBackground());
		this.shot = new Shot_Shoot(this.map, this.imageFactory);
		
		this.player = this.map.getCell(0, 4);
		this.player.put(representation);
	}
	
	public void moveLeft() {
		
		if(player.getColumn() - 1 >= 0) {
			Sound.getInstance().moveSound();
			if(checkLeft()) {
				player.clear();
				player = this.map.getCell(player.getRow(), player.getColumn() - 1);
				player.put(representation);
			}
			else
				map.lose();
		}
	}
	
	public void moveRight() {
		
		if(player.getColumn() + 1 <= 8) {
			Sound.getInstance().moveSound();
			if(checkRight()) {
				player.clear();
				player = this.map.getCell(player.getRow(), player.getColumn() + 1);
				player.put(representation);
			}
			else
				map.lose();
		}
	}
	
	public boolean isShot(int r, int c) {
		return shot.isShot(r, c);
	}
	
	public void shot() {
		shot.putShot(player.getRow() + 1, player.getColumn());
	}
	
	public void moveShot() {
		shot.moveShot();
	}
	
	private boolean checkLeft() {
		return map.getCell(player.getRow(), player.getColumn() - 1).isFree();
	}
	
	private boolean checkRight() {
		return map.getCell(player.getRow(), player.getColumn() + 1).isFree();
	}
	
}
