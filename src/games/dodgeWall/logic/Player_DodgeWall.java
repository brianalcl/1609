package games.dodgeWall.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import sound.Sound;

public class Player_DodgeWall {
	protected Cell[][] player;
	protected Factory imageFactory;
	protected Sound sound;
	protected Map_DodgeWall map;
	protected GraphicCell representation;
	
	public Player_DodgeWall(Map_DodgeWall map, Factory imageFactory, Sound sound) {
		this.player = new Cell[3][3];
		this.map = map;
		this.imageFactory = imageFactory;
		this.sound = sound;
		this.representation = new GraphicCell(this.imageFactory.getCapsule(), this.map.getFreeCell().getBackground());
		
		player[0][0] = this.map.getCell(3, 0);
		player[0][0].put(representation);
		player[0][1] = this.map.getCell(3, 1);
		player[0][1].put(representation);
		
		player[1][1] = this.map.getCell(4, 1);
		player[1][1].put(representation);
		player[1][2] = this.map.getCell(4, 2);
		player[1][2].put(representation);
		
		player[2][0] = this.map.getCell(5, 0);
		player[2][0].put(representation);
		player[2][1] = this.map.getCell(5, 1);
		player[2][1].put(representation);
	}
	
	public void moveUp() {
		if(checkUp()) {
			clear();
			
			player[0][0] = this.map.getCell(6, 0);
			player[0][0].put(representation);
			player[0][1] = this.map.getCell(6, 1);
			player[0][1].put(representation);
			
			player[1][1] = this.map.getCell(7, 1);
			player[1][1].put(representation);
			player[1][2] = this.map.getCell(7, 2);
			player[1][2].put(representation);
			
			player[2][0] = this.map.getCell(8, 0);
			player[2][0].put(representation);
			player[2][1] = this.map.getCell(8, 1);
			player[2][1].put(representation);
		}
		else
			map.lose();
	}
	
	public void moveDown() {
		if(checkDown()) {
			clear();
			
			player[0][0] = this.map.getCell(0, 0);
			player[0][0].put(representation);
			player[0][1] = this.map.getCell(0, 1);
			player[0][1].put(representation);
			
			player[1][1] = this.map.getCell(1, 1);
			player[1][1].put(representation);
			player[1][2] = this.map.getCell(1, 2);
			player[1][2].put(representation);
			
			player[2][0] = this.map.getCell(2, 0);
			player[2][0].put(representation);
			player[2][1] = this.map.getCell(2, 1);
			player[2][1].put(representation);
		}
		else
			map.lose();
	}
	
	public void moveCenter() {
		if(checkCenter()) {
			clear();
			
			player[0][0] = this.map.getCell(3, 0);
			player[0][0].put(representation);
			player[0][1] = this.map.getCell(3, 1);
			player[0][1].put(representation);
			
			player[1][1] = this.map.getCell(4, 1);
			player[1][1].put(representation);
			player[1][2] = this.map.getCell(4, 2);
			player[1][2].put(representation);
			
			player[2][0] = this.map.getCell(5, 0);
			player[2][0].put(representation);
			player[2][1] = this.map.getCell(5, 1);
			player[2][1].put(representation);
		}
		else
			map.lose();
	}
	
	private void clear() {
		sound.moveSound();
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(player[r][c] != null)
					player[r][c].clear();
			}
		}
				
	}
	
	private boolean checkUp() {
		boolean check = true;
		
		check = check && this.map.getCell(7, 0).isFree();
		check = check && this.map.getCell(7, 1).isFree();
		check = check && this.map.getCell(7, 2).isFree();
		
		return check;
	}
	
	private boolean checkCenter() {
		boolean check = true;
		
		check = check && this.map.getCell(4, 0).isFree();
		check = check && this.map.getCell(4, 1).isFree();
		check = check && this.map.getCell(4, 2).isFree();
		
		return check;
	}
	
	private boolean checkDown() {
		boolean check = true;
		
		check = check && this.map.getCell(1, 0).isFree();
		check = check && this.map.getCell(1, 1).isFree();
		check = check && this.map.getCell(1, 2).isFree();
		
		return check;
	}
	
}
