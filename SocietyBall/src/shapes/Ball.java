package shapes;

import processing.core.PApplet;

public class Ball extends Shape {

	private final float extent;

	public Ball(double x, double y) {
		super(x, y);
		extent = 20f;
	}

	public boolean isPointInside(double xInput, double yInput) {
		boolean isInside = false;
		if ((xInput > x - 0.5 * extent && xInput < x + 0.5 * extent)
				&& (y - 0.5 * extent < yInput && yInput < y + 0.5 * extent)) {

			isInside = true;
		}
		return isInside;

	}

	public void draw(PApplet surface) {
		super.draw(surface);
		surface.color(0, 0, 255);
		surface.circle((float) x, (float) y, extent);
	}

	public void setVelocities(double vX, double vY) {
		super.vX = vX;
		super.vY = vY;
	}

	public void act() {
		x += vX;
		y += vY;
		if (0 > x || x > 400 || 0 > y || y > 300) {
			vX = -vX;
			vY = -vY;
		}
	}

	public void move(double newX, double newY) {
		vX = newX;
		vY = newY;
	}
}
