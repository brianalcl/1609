package general.utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class InternalBorderRound extends AbstractBorder{
	
	private static final long serialVersionUID = 1L;
	private int top;
	private int right;
	private int bottom;
	private int left;
	private int radius;
	private Color color;
	private final RenderingHints antialising = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	public InternalBorderRound(Color color) {
		this.top = 1;
		this.right = 1;
		this.bottom = 1;
		this.left = 1;
		this.color = color;
		this.radius = 16;
	}
	
	public InternalBorderRound(int top, int right, int bottom, int left, int radius, Color color) {
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		this.color = color;
		this.radius = radius;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.addRenderingHints(antialising);
		
		Shape outer;
		Shape inner;
		outer = new RoundRectangle2D.Float(x, y, width, height, 0, 0);
		inner = new RoundRectangle2D.Float(x + left, y + top, width - left - right, height - top - bottom, radius, radius);
		
		Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
		
		path.append(outer, false);
		path.append(inner, false);
		
		g2d.fill(path);
		g2d.setColor(color);
		
	}
}
