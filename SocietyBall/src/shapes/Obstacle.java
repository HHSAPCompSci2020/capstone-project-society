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
	public Obstacle(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet surface)
	{
		super.draw(surface);
		surface.rect((float)x,(float)y,(float)(50),(float)(5));
		// System.out.println(x + " " + y);
	}
	
	public boolean isPointInside(double xInput, double yInput) {
		boolean inside = false;
		if (x < xInput && xInput < x + 25 && y < yInput && yInput < y + 25)
			inside = true;
		return inside;
	}

}
