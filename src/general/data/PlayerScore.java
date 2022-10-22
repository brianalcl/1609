package general.data;

import java.io.Serializable;


public class PlayerScore implements Serializable, Comparable<PlayerScore> {
	
	private static final long serialVersionUID = 1L;
	private int score;
	
	public PlayerScore(int score) {
		this.score = score;
	}

	public String getScore() {
		return String.format("%05d", this.score);
	}
	
	@Override
	public int compareTo(PlayerScore playerScore) {
		int toReturn;
		if (playerScore == null) {
			throw new NullPointerException();
		}
		if (score < playerScore.score) {
			toReturn = -1;
		} else if (score > playerScore.score) {
			toReturn = 1;
		} else {
			toReturn = 0;
		}
		return toReturn;
	}
	
	
}
