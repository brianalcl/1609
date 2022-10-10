package games.collect.logic;

import general.logic.Map;

public class CollectMap extends Map{
	protected CollectGame game;
	
	public CollectMap(CollectGame game) {
		super(game, false);
		this.game = game;
	}
}
