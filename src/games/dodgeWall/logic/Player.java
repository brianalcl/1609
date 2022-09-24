package games.dodgeWall.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;

public class Player {
	protected Cell[][] player;
	protected Factory imageFactory;
	protected DodgeWallMap map;
	protected GraphicCell representation_1;
	protected GraphicCell representation_2;
	
	public Player(DodgeWallMap map, Factory imageFactory) {
		this.player = new Cell[3][3];
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation_1 = new GraphicCell(this.imageFactory.getSquircle(), this.imageFactory.getColorDefault());
		this.representation_2 = new GraphicCell(this.imageFactory.getEmpty(), this.imageFactory.getColorEmpty());
		
		player[0][0] = this.map.getCell(3, 0);
		player[0][0].put(representation_1);
		player[0][1] = this.map.getCell(3, 1);
		player[0][1].put(representation_1);
		player[0][2] = this.map.getCell(3, 2);
		player[0][2].put(representation_2);
		
		player[1][0] = this.map.getCell(4, 0);
		player[1][0].put(representation_2);
		player[1][1] = this.map.getCell(4, 1);
		player[1][1].put(representation_1);
		player[1][2] = this.map.getCell(4, 2);
		player[1][2].put(representation_1);
		
		player[2][0] = this.map.getCell(5, 0);
		player[2][0].put(representation_1);
		player[2][1] = this.map.getCell(5, 1);
		player[2][1].put(representation_1);
		player[2][2] = this.map.getCell(5, 2);
		player[2][2].put(representation_2);
	}
	
	public void moveUp() {
		if(checkUp()) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					player[r][c].clear();
			
			player[0][0] = this.map.getCell(6, 0);
			player[0][0].put(representation_1);
			player[0][1] = this.map.getCell(6, 1);
			player[0][1].put(representation_1);
			player[0][2] = this.map.getCell(6, 2);
			player[0][2].put(representation_2);
			
			player[1][0] = this.map.getCell(7, 0);
			player[1][0].put(representation_2);
			player[1][1] = this.map.getCell(7, 1);
			player[1][1].put(representation_1);
			player[1][2] = this.map.getCell(7, 2);
			player[1][2].put(representation_1);
			
			player[2][0] = this.map.getCell(8, 0);
			player[2][0].put(representation_1);
			player[2][1] = this.map.getCell(8, 1);
			player[2][1].put(representation_1);
			player[2][2] = this.map.getCell(8, 2);
			player[2][2].put(representation_2);
		}
		else
			map.lose();
	}
	
	public void moveDown() {
		
		if(checkDown()) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					player[r][c].clear();
			
			player[0][0] = this.map.getCell(0, 0);
			player[0][0].put(representation_1);
			player[0][1] = this.map.getCell(0, 1);
			player[0][1].put(representation_1);
			player[0][2] = this.map.getCell(0, 2);
			player[0][2].put(representation_2);
			
			player[1][0] = this.map.getCell(1, 0);
			player[1][0].put(representation_2);
			player[1][1] = this.map.getCell(1, 1);
			player[1][1].put(representation_1);
			player[1][2] = this.map.getCell(1, 2);
			player[1][2].put(representation_1);
			
			player[2][0] = this.map.getCell(2, 0);
			player[2][0].put(representation_1);
			player[2][1] = this.map.getCell(2, 1);
			player[2][1].put(representation_1);
			player[2][2] = this.map.getCell(2, 2);
			player[2][2].put(representation_2);
		}
		else
			map.lose();
	}
	
	public void moveCenter() {
		
		if(checkCenter()) {
			for(int r = 0; r < 3; r++)
				for(int c = 0; c < 3; c++)
					player[r][c].clear();
			
			player[0][0] = this.map.getCell(3, 0);
			player[0][0].put(representation_1);
			player[0][1] = this.map.getCell(3, 1);
			player[0][1].put(representation_1);
			player[0][2] = this.map.getCell(3, 2);
			player[0][2].put(representation_2);
			
			player[1][0] = this.map.getCell(4, 0);
			player[1][0].put(representation_2);
			player[1][1] = this.map.getCell(4, 1);
			player[1][1].put(representation_1);
			player[1][2] = this.map.getCell(4, 2);
			player[1][2].put(representation_1);
			
			player[2][0] = this.map.getCell(5, 0);
			player[2][0].put(representation_1);
			player[2][1] = this.map.getCell(5, 1);
			player[2][1].put(representation_1);
			player[2][2] = this.map.getCell(5, 2);
			player[2][2].put(representation_2);
		}
		else
			map.lose();
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
