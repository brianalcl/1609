package general.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import general.gui.GamePanel;


public class StatsData implements Serializable {

	private static final long serialVersionUID = 1L;
	protected GamePanel panel;

	public StatsData(GamePanel panel) {
		this.panel = panel;
	}
	
	public PlayersRegistry load() throws ClassNotFoundException, IOException {
		PlayersRegistry topPlayers = null;

		try{ 
			FileInputStream file = new FileInputStream(panel.getFileToSavePath());
			ObjectInputStream in = new ObjectInputStream(file);
			
			topPlayers = (PlayersRegistry) in.readObject();
			in.close();
			
		} catch (FileNotFoundException e) {
			topPlayers = new PlayersRegistry();
		}

		return topPlayers;
	}

	public void save(PlayersRegistry topPlayers) throws IOException {
		FileOutputStream file = new FileOutputStream(panel.getFileToSavePath());	
		ObjectOutputStream out = new ObjectOutputStream(file);	
		out.writeObject(topPlayers);
		out.close();
	}

}
