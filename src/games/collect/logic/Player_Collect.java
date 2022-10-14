package games.collect.logic;

import factory.Factory;
import general.logic.Cell;
import general.logic.GraphicCell;
import sound.Sound;

public class Player_Collect {
	protected Cell[] player;
	protected Factory imageFactory;
	protected Map_Collect map;
	protected GraphicCell representation;
	
	public Player_Collect(Map_Collect map, Factory imageFactory) {
		this.map = map;
		this.imageFactory = imageFactory;
		this.representation = new GraphicCell(this.imageFactory.getTriangle(), this.map.getFreeCell().getBackground());
		player = new Cell[3];
		
		player[0] = this.map.getCell(0, 3);
		player[1] = this.map.getCell(0, 4);
		player[2] = this.map.getCell(0, 5);
		player[0].put(representation);
		player[1].put(representation);
		player[2].put(representation);
	}
	
	public void moveLeft() {

		if(player[0].getColumn() - 1 >= 0) {
			Sound.getInstance().moveSound();
			player[0].clear();
			player[1].clear();
			player[2].clear();

			player[0] = this.map.getCell(player[0].getRow(), player[0].getColumn() - 1);
			player[1] = this.map.getCell(player[1].getRow(), player[1].getColumn() - 1);
			player[2] = this.map.getCell(player[2].getRow(), player[2].getColumn() - 1);

			player[0].put(representation);
			player[1].put(representation);
			player[2].put(representation);
		}
	}
	
	public void moveRight() {
		if(player[2].getColumn() + 1 <= 8) {
			Sound.getInstance().moveSound();
			player[0].clear();
			player[1].clear();
			player[2].clear();

			player[0] = this.map.getCell(player[0].getRow(), player[0].getColumn() + 1);
			player[1] = this.map.getCell(player[1].getRow(), player[1].getColumn() + 1);
			player[2] = this.map.getCell(player[2].getRow(), player[2].getColumn() + 1);

			player[0].put(representation);
			player[1].put(representation);
			player[2].put(representation);
		}
	}
	
	
}
