package shapes;

import java.awt.Color;
import processing.core.PApplet;

/**
 * 
 * @author Daniel Huber and Richard Zhang
 * 
 *
 */
public class Shape {
	protected double x;
	protected double y;
	private Color fillColor;
	private Color strokeColor;
	private int stroke;
	protected double length, width;
	protected double vX;
	protected double vY;
	private boolean filled;
	private int windowLength;
	private int windowHeight;

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		stroke = 2;
		strokeColor = Color.black;
		fillColor = Color.white;
		filled = false;
		vX = 0;
		vY = 0;
		windowLength = 400;
		windowHeight = 300;
	}

	// Call this inside of draw, always getting called
	public void act() {
//		x += vX;
//		y += vY;
//		if (0 > x || x > 400) {
////			vX = -vX;
//			vY = -vY;
//		}
//		if(0 > y || y > 300) {
//			vY = -vY;
//		}

//		move(x, y);

// Change the x,y coordinates here
		// If this is hitting the top or bottom;
		if (0 > x || x > windowLength || 0 > y || y > windowHeight) {
			vX = -vX;
			vY = -vY;
		}
	}

	/**
	 * The shape takes a new velocity and then makes it the velocity of the shape.
	 * Could be from mouse(for mines) or for user input with(wasd/arrow keys)
	 * 
	 * @param newX New X value assigned
	 * @param newY New Y value assigned
	 */
	public void move(double newX, double newY) {
		vX = newX;
		vY = newY;
		x += vX;
		y += vY;

//		// Change the velocities here
//		vX = newX;
//		vY = newY;
	}

	/**
	 * Checks if the point is inside the shape. Will be used to check collisions
	 * 
	 * @param xInput new xCoordinate
	 * @param yInput new y-Coordinate
	 * @return if the point is inside the shape
	 */
	public boolean isPointInside(double xInput, double yInput) {
		return false;
	}

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

	public void resetPosition(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Sets field vX to a new parameter.
	 * 
	 * @param vX new vX value
	 */
	public void setvX(double vX) {
		this.vX = vX;
	}

	/**
	 * Sets field vY to a new parameter.
	 * 
	 * @param vY new vY value
	 */
	public void setvY(double vY) {
		this.vY = vY;
	}

	/**
	 * Draws a new instance of a shape object.
	 * 
	 * @param surface used to access the method to draw the shapes
	 **/
	public void draw(PApplet surface) {
//		surface.noFill();
		surface.fill(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue());

		surface.strokeWeight(stroke);
		surface.stroke(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue());
	}

	/**
	 * Outputs field vX
	 * 
	 * @return vX x Velocity of shape
	 */
	public double getvX() {
		return vX;
	}

	/**
	 * Outputs field vY
	 * 
	 * @return vY y-Velocity of shape
	 */
	public double getvY() {
		return vY;
	}

	/**
	 * Sets the shape's stroke and fill method to new RGB values
	 * @param stroke new color for shape stroke
	 * @param fill new fill color for shape
	 */
	public void setColor(Color stroke, Color fill) {
		strokeColor = stroke;
		fillColor = fill;
	}
}
