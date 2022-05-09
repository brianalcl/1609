package games.g2048.logic;

import general.logic.Cell;
import general.logic.Map;

public class G2048Cell extends Cell{
	
	protected int num;

	public G2048Cell(int row, int column, Map map) {
		super(row, column, map);
		this.num = 0;
	}
	
	public boolean equals(G2048Cell g) {
		return g.num == num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
}
