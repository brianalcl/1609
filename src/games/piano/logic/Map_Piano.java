package games.piano.logic;

import general.logic.Map;

public class Map_Piano extends Map{
	protected Game_Piano game;
	
	public Map_Piano(Game_Piano game) {
		super(game, false);
		this.game = game;
	}
	
}
