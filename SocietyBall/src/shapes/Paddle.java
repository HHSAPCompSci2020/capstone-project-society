package shapes;

public class Paddle extends Shape {

	private float length, width;

	public Paddle(double x, double y) {
		super(x, y);
		length = 20f;
		width = 5f;
	}



	@Override
	public boolean isPointInside(double xInput, double yInput) {
		boolean inside = false;
		if (x < xInput && xInput < x + width && y < yInput && yInput < y + length)
			inside = true;
		return inside;
	}

}
