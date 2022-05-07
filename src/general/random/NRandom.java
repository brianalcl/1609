package general.random;

import java.util.Random;

public class NRandom extends Random{
	private static NRandom instance;
	
	private NRandom() {
		
	}
	public static NRandom getInstance() {
		if(instance == null)
			instance = new NRandom();
		return instance;
	}
}
