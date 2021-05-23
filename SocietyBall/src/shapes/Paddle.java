package shapes;

import processing.core.PApplet;

/**
 * 
 * @author Daniel Huber and Ryan Tsai
 * 
 *
 */

public class Paddle extends Shape {

	public float length, width;
	private int freezeLength = 1000;
	private long freezeTime = 0;
	
	/**
	 * Creates a paddle at points x, y in the drawing surface.
	 * length is set to 40f, width to 15f
	 * 
	 * @param x X-coordinate of upper-left corner
	 * @param y Y-coordinate of upper-left corner
	 * 
	 */
	public Paddle(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
		length = 40f;
		width = 15f;
	}

	public boolean isFrozen() {
		return (System.currentTimeMillis() < freezeTime + freezeLength);
	}
	
	public void freeze() {
		freezeTime = System.currentTimeMillis();
	}
	
	public boolean isPointInside(double xInput, double yInput) {
		boolean inside = false;
		if (x < xInput && xInput < x + width && y < yInput && yInput < y + length) {
			inside = true;
		}
//		System.out.println(xInput + " " + yInput);

		return inside;
	}
	

	
	public void draw(PApplet surface) {
		super.draw(surface);
		surface.rect((float) x, (float) y, (float) width, (float) length);
//		System.out.println(x + " " + y);
		
	}

	/**
	 * Doubles the velocity of the paddle if sprint is called and sprinting is true.
	 * @param sprinting if the paddle is currently sprinting
	 */
	public void sprint(boolean sprinting) {
		boolean sprinted = false;
		System.out.println("Spriting");
		vX = 2 * vX;
		vY = 2 * vY;
		if (sprinting) {
		
//			sprinted = true;
		} else if (sprinted) {
			vX = 0.5 * vX;
			vY = 0.5 * vY;
		}

	}

}
