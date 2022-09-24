package general.logic;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;

public class GraphicCell extends JLabel{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	protected Icon icon;
	protected Color color;
	
	public GraphicCell(Icon icon, Color color) {
		super();
		setOpaque(true);
		this.icon = icon;
		this.color = color;
		setImagen(this.icon, this.color);
	}

	public void setImagen(Icon icon, Color color) {
		setIcon(icon);
		setBackground(color);
		
	}
	
}
