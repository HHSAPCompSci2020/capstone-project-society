package shapes;

import processing.core.PApplet;

public class Obstacle extends Shape {

	public Obstacle(double x, double y) {
		super(x, y);
		this.x = x;
		this.y = y;
		
		// TODO Auto-generated constructor stub
	}
	
	public void draw(PApplet surface)
	{
		super.draw(surface);
		surface.line((float)x,(float)y,(float)(x+(float)5*Math.random()),(float)(y+(float)5*Math.random()));
	}

	@Override
	public boolean isPointInside(double xInput, double yInput) {
		// TODO Auto-generated method stub

		return false;
	}

}
