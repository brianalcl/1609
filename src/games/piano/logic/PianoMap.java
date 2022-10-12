package games.piano.logic;

import general.logic.Map;

public class PianoMap extends Map{
	protected PianoGame game;
	
	public PianoMap(PianoGame game) {
		super(game, false);
		this.game = game;
	}
	
}
