package general.utilities;

import java.util.Random;

public class NRandom extends Random{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private static NRandom instance;
	
	private NRandom() {
		
	}
	public static NRandom getInstance() {
		if(instance == null)
			instance = new NRandom();
		return instance;
	}
}
