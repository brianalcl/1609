package general.data;

import java.io.Serializable;

public class PlayersRegistry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected PlayerScore ps;
	
	public PlayersRegistry() {
		ps = new PlayerScore(0);
	}
	
	public void addPlayer(PlayerScore p) {
		if(ps.compareTo(p) < 0)
			ps = p;
	}

	public PlayerScore getScores() {
		return ps;
	}
}
