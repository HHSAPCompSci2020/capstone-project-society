import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import java.util.concurrent.TimeUnit;
import java.util.Date;

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
	private Mine left[] = new Mine[3];
	private Mine right[] = new Mine[3];
	private Paddle p1;
	private Paddle p2;
	private int height;
	private int length;
	private boolean hasGameStarted;
	private int numLeftMines;
	private int numRightMines;
	private Point random;
	


	public DrawingSurface() {
		
		b = new Ball(10, 10);
		p1 = new Paddle(50, 100);
		p2 = new Paddle(350, 100);
		height = 300;
		length = 400;
		hasGameStarted = false;
		random = new Point();
		random.setLocation((Math.random() - 0.5) * 4, (Math.random() - 0.5) * 4);
		numLeftMines = 0;
		numRightMines = 0 ;
	}

	public void draw() {
		background(255); // Clear the screen with a white background
		textSize(12);
		fill(0);

		b.draw(this);
		p1.draw(this);
		p2.draw(this);

		pushStyle();

		fill(0);
		textSize(10);
		text("The left side can place 3 mines with left click. The right side can place 3 mines with right click.",15,15);
	
		popStyle();
		
		if (left[0].isPointInside(left[0].getX(), left[0].getY()) || left[1].isPointInside(left[1].getX(), left[1].getY()) || left[2].isPointInside(left[2].getX(), left[2].getY())) {
	        try {
	            TimeUnit.SECONDS.sleep(2);
	        } catch (InterruptedException e) {
	            System.err.format("IOException: %s%n", e);
	        }
		}
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
	
	public void mouseReleased() {
		if (numLeftMines < 2) {
			if (mouseButton == LEFT) {
				
			}
		}
	}
	
	
}
