package shapes;

import processing.core.PApplet;

public class Ball extends Shape {

	private final float radius;

	public Ball(double x, double y) {
		super(x, y);
		radius = 20f;
	}

	
	public void move(double xMouse, double yMouse) {
		x = xMouse;
		y = yMouse;
	}

	public boolean isPointInside(double xInput, double yInput) {
		boolean isInside = false;
		if ((xInput > x - 0.5 * radius && xInput < x + 0.5 * radius)
				&& (y - 0.5 * radius < yInput && yInput < y + 0.5 * radius)) {

			isInside = true;
		}
		return isInside;

	}

	public void draw(PApplet surface) {
		super.draw(surface);
		surface.circle((float) x, (float) y, radius);
	}

}
