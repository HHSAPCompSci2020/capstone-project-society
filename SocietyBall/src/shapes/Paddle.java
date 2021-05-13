package shapes;

import processing.core.PApplet;

public class Paddle extends Shape {

	private float length, width;

	public Paddle(double x, double y) {
		super(x, y);
		length = 20f;
		width = 5f;
	}

	public boolean isPointInside(double xInput, double yInput) {
		boolean inside = false;
		if (x < xInput && xInput < x + width && y < yInput && yInput < y + length)
			inside = true;
		return inside;
	}

	public void draw(PApplet surface) {
		super.draw(surface);
		surface.rect((float) x, (float) y, (float) width, (float) length);
	}
	
	

}
