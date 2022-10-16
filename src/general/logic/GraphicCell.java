package general.logic;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;

public class GraphicCell extends JLabel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public GraphicCell(Icon icon, Color color) {
		super();
		setOpaque(true);
		setIcon(icon);
		setBackground(color);
	}
	
}
