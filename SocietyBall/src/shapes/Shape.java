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
	protected static double x;
	protected static double y;
	private Color fillColor, strokeColor;
	private int stroke;
	protected double length, width;
	protected static double xVelocity = 1;
	protected static double yVelocity = 1;
	private boolean filled;
	private int windowLength = 400;
	private int windowHeight = 300;

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		stroke = 2;
		strokeColor = Color.black;
		fillColor = Color.white;
		filled = false;
	}

	
	public void act() {
		double x = Shape.getX();
		double y = Shape.getY();
		Shape.move(x, y);

		if(0 > Shape.getX() || Shape.getX() > windowLength || 0 > Shape.getY() || Shape.getY() > windowHeight) {
			xVelocity = -xVelocity;
			yVelocity = -yVelocity;
		}	
	}
	
	
	/**
	 * The shape takes a new coordinate point and moves there. Could be from
	 * mouse(for mines) or for user input with(wasd/arrow keys)
	 * 
	 * @param xNew New X value assigned
	 * @param yNew New Y value assigned
	 */
	public static void move(double newX, double newY) {
		x = newX + xVelocity;
		y = newY + yVelocity;
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
	public static double getX() {
		return x;
	}

	/**
	 * Outputs field y
	 * 
	 * @return y y-value
	 */
	public static double getY() {
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
	
}
