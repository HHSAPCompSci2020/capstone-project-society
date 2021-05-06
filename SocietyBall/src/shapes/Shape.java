package shapes;

import java.awt.Color;
import processing.core.PApplet;

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

	public void shift(double xMouse, double yMouse) {
		x = xMouse;
		y = yMouse;
	}

	public void draw(PApplet surface) {
		if (filled)
			surface.fill(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue());
		else
			surface.noFill();
		surface.strokeWeight(stroke);
		surface.stroke(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue());
	}

	public abstract boolean isPointInside(double xInput, double yInput);

}
