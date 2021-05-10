package shapes;

import processing.core.PApplet;

/**
 * @author Richard Zhang
 */
public class Mine extends Shape {

	private final float extent;

	/***
	 * Creates a mine at points x, y in the drawing surface.
	 * 
	 * @param x X-coordinate provided by mouse click
	 * @param y Y-coordinate provided by mouse click
	 */
	public Mine(double x, double y) {
		super(x, y);
		extent = 10f;
	}

	@Override
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
		surface.color(255, 0, 0);
		surface.circle((float) x, (float) y, extent);
	}

}
