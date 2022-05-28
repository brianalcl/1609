package general.utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.border.AbstractBorder;

public class LateralBorder extends AbstractBorder{
	private int top;
	private int right;
	private int bottom;
	private int left;
	private Color color;
	
	public LateralBorder() {
		this.top = 1;
		this.right = 1;
		this.bottom = 1;
		this.left = 1;
		this.color = Color.black;
	}
	
	public LateralBorder(int top, int right, int bottom, int left, Color color) {
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		this.color = color;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		
		Shape t;
		Shape r;
		Shape b;
		Shape l;
		
		t = new Rectangle2D.Float(x, y, width, top);
		r = new Rectangle2D.Float(width - right, y + top, right, height - bottom - top);
		b = new Rectangle2D.Float(x, height - bottom, width, bottom);
		l = new Rectangle2D.Float(x, y + top, left, height - bottom - top);
		
		Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
		
		path.append(t, false);
		path.append(r, false);
		path.append(b, false);
		path.append(l, false);
		
		g2d.fill(path);
	}
    
}
