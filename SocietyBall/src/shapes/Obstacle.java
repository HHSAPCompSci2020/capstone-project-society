package shapes;

import processing.core.PApplet;

/**
 * 
 * @author Ryan Tsai
 * 
 *
 */

public class Obstacle extends Shape {

	
	/**
	 * Creates a mine at points x, y in the drawing surface.
	 * 
	 * @param x Pre-coded X-coordinate
	 * @param y Pre-coded Y-coordinate
	 */
	public Obstacle(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet surface)
	{
		super.draw(surface);
		surface.line((float)x,(float)y,(float)(x+(float)10*Math.random()),(float)(y+(float)10*Math.random()));
		// System.out.println(x + " " + y);
	}
	
	public boolean isPointInside(double xInput, double yInput) {
		boolean inside = false;
		if (x < xInput && xInput < x + width && y < yInput && yInput < y + length)
			inside = true;
		return inside;
	}

}
