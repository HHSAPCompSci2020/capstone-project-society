import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import shapes.Ball;
import shapes.Mine;
import shapes.Paddle;

/**
 * 
 * @author Daniel Huber and Richard Zhang
 * 
 * 
 */
public class DrawingSurface extends PApplet {

	private Ball b;
	private Mine m;
	private Paddle p1;
	private Paddle p2;
	private int height;
	private int length;
	private boolean hasGameStarted;
	private Point random;

	public DrawingSurface() {
		m = new Mine(20, 100);
		b = new Ball(10, 10);
		p1 = new Paddle(50, 100);
		p2 = new Paddle(350, 100);
		height = 300;
		length = 400;
		hasGameStarted = false;
		random = new Point();
		random.setLocation((Math.random() - 0.5) * 4, (Math.random() - 0.5) * 4);
	}

	public void draw() {
		background(255); // Clear the screen with a white background
		textSize(12);
		fill(0);

		b.draw(this);
		m.draw(this);
		p1.draw(this);
		p2.draw(this);

		pushStyle();

		fill(0);
		textSize(10);
		text("press b to start ball moving", 15, 15);

		popStyle();

	}

	public void keyPressed() {
		if (key == 'w' && p1.getY() > 0) {
			p1.move(0, -2);
		}
		if (key == 'd' && p1.getX() < length / 2) {
			p1.move(2, 0);
		}
		if (key == 'a' && p1.getX() > 0) {
			p1.move(-2, 0);
		}
		if (key == 's' && p1.getY() < height) {
			p1.move(0, 2);
		}

		if (keyCode == UP && p2.getY() > 0) {
			p2.move(0, -2);
		}
		if (keyCode == DOWN && p2.getY() < height)
			p2.move(0, 2);
		if (keyCode == RIGHT && p2.getX() < length)
			p2.move(2, 0);
		if (keyCode == LEFT && p2.getX() > length / 2)
			p2.move(-2, 0);

		if (key == 'b') {
			if (hasGameStarted) {
				b.move(random.getX(), random.getY());
			}
			hasGameStarted = true;
		}
	}
}
