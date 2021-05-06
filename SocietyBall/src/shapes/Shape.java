package shapes;

import java.awt.Color;
import processing.core.PApplet;

/**
 * 
 * @author Richard Zhang
 * 
 *
 */
public abstract class Shape {
	protected double x, y;
	private Color fillColor, strokeColor;
	private int stroke;
	protected double length, width;
	protected double xVelocity, yVelocity;
	private boolean filled;

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		stroke = 2;
		strokeColor = Color.black;
		fillColor = Color.white;
		filled = false;
	}

	/**
	 * The shape takes a new coordinate point and moves there. Could be from
	 * mouse(for mines) or for user input with(wasd/arrow keys)
	 * 
	 * @param xNew New X value assigned
	 * @param yNew New Y value assigned
	 */
	public abstract void move(double xNew, double yNew);

	/**
	 * Draws a new instance of a shape object.
	 * 
	 * @param surface used to access the method to draw the shapes
	 **/
	public void draw(PApplet surface) {
		if (filled)
			surface.fill(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue());
		else
			surface.noFill();
		surface.strokeWeight(stroke);
		surface.stroke(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue());
	}

	/**
	 * Checks if the point is inside the shape. Will be used to check collisions
	 * 
	 * @param xInput new xCoordinate
	 * @param yInput new y-Coordinate
	 * @return if the point is inside the shape
	 */
	public abstract boolean isPointInside(double xInput, double yInput);

	/**
	 * Outputs field x
	 * 
	 * @return x x-value
	 */
	public double getX() {
		return x;
	}

	/**
	 * Outputs field y
	 * 
	 * @return y y-value
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets field x to a new parameter
	 * 
	 * @param x new x value
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets field y to a new parameter.
	 * 
	 * @param y new y value
	 */
	public void setY(double y) {
		this.y = y;
	}

}
