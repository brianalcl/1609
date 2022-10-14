package games.collect.logic;

import general.logic.Map;

public class Map_Collect extends Map{
	protected Game_Collect game;
	
	public Map_Collect(Game_Collect game) {
		super(game, false);
		this.game = game;
	}
}
