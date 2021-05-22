package shapes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;

public class Ball extends Shape {

	private final float extent;

	/**
	 * Creates a ball at points x, y in the drawing surface.
	 * 
	 * @param x X-coordinate 
	 * @param y Y-coordinate 
	 */
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

	/**
	 * Sets the velocities of the ball to new values
	 * @param vX new x-Velocity
	 * @param vY new y-Velocity
	 */
	public void setVelocities(double vX, double vY) {
		super.vX = vX;
		super.vY = vY;
	}

	/**
	 * Reverses the x and y velocity of the ball
	 * 
	 */
	public void reverseVelocties() {
		super.vX = -super.vX;
		super.vY = -super.vY;
	}

	public void act() {
		x += vX;
		y += vY;
		if (0 > x || x > 400) {
//			vX = -vX;
			vY = -vY;
		}
		if (0 > y || y > 350) {
			vY = -vY;
		}

	}

	public void move(double newX, double newY) {
		vX = newX;
		vY = newY;
	}

	/**
	 * Gets an ArrayList of all the corners of the ball.
	 * 
	 * @return corners All four corners of the ball in Point
	 */
	public ArrayList<Point> getCorners() {
		ArrayList<Point> corners = new ArrayList<Point>(4);
		corners.add(new Point((int) x, (int) (y + extent / 2)));
		corners.add(new Point((int) x, (int) (y - extent / 2)));
		corners.add(new Point((int) (x - extent / 2), (int) y));
		corners.add(new Point((int) (x + extent / 2), (int) y));

		return corners;

	}
}
