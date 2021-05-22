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
 * @author Daniel Huber and Richard Zhang and Ryan Tsai
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
	private int p1point;
	private int p2point;
	private int velocity = 10;

	public DrawingSurface() {

		height = 300;
		length = 400;
		b = new Ball(height / 2, length / 2);
		p1 = new Paddle(50, 100);
		p2 = new Paddle(350, 100);
		hasGameStarted = false;
		numLeftMines = 0;
		numRightMines = 0;
		p1point = 0;
		p2point = 0;
	}

	public void draw() {
		background(255); // Clear the screen with a white background
		textSize(12);
		fill(0);

		this.color(255, 0, 0);
		b.draw(this);
		this.color(0, 255, 0);

		p1.draw(this);
		p2.draw(this);
		b.act();
		p1.act();
		p2.act();

		pushStyle();

		fill(0);
		textSize(10);
		text("The left side can place 3 mines with left click. The right side can place 3 mines with right click. Once you placed the mines, press 'B' on your keyboard to start.", 15,
				15);
		text(p1point + "  " + p2point, 200, 50);

		popStyle();

		// never true rn
		if (hasGameStarted == true) {
			if (left[0].isPointInside(left[0].getX(), left[0].getY())
					|| left[1].isPointInside(left[1].getX(), left[1].getY())
					|| left[2].isPointInside(left[2].getX(), left[2].getY())) {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					System.err.format("IOException: %s%n", e);
				}
			}

		}
		for (int x = 0; x < b.getCorners().size(); x++) {
//			if (p1.isPointInside(b.getX(), b.getY())) {
			if (p1.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
				b.reverseVelocties();
				System.out.println("Collision");
			}
			if (p2.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
//			b.reverseVelocties();
				// How do we want to test this type of interaction.
				b.setvX(b.getvX() + p2.getvX());
				b.setvY(b.getvY() + p2.getvY());
			}
		}

		// Checks if out of bounds/Score keeping
		if (b.getX() > 400) {
			p1point++;
			b.setX(200);
			b.setY(200);
			b.move((Math.random() - 0.5) * 4, (Math.random() - 0.5) * 4);
		}

		if (b.getX() < 0) {
			p2point++;
			b.setX(200);
			b.setY(200);
			b.move((Math.random() - 0.5) * 4, (Math.random() - 0.5) * 4);
		}
	
		if (numLeftMines == 3 && numRightMines == 3) {
			left[0].draw(this);
			left[1].draw(this);
			left[2].draw(this);
			right[0].draw(this);
			right[1].draw(this);
			right[2].draw(this);
		}
		
	}

	public void keyPressed() {
		if (key == 'w' && p1.getY() > 0) {
			p1.move(0, -velocity);
		}
		if (key == 'd' && p1.getX() < length / 2) {
			p1.move(velocity, 0);
		}
		if (key == 'a' && p1.getX() > 0) {
			p1.move(-velocity, 0);
		}
		if (key == 's' && p1.getY() < height) {
			p1.move(0, velocity);
		}

		if (keyCode == UP && p2.getY() > 0) {
			p2.move(0, -velocity);
		}
		if (keyCode == DOWN && p2.getY() < height)
			p2.move(0, velocity);
		if (keyCode == RIGHT && p2.getX() < length)
			p2.move(velocity, 0);
		if (keyCode == LEFT && p2.getX() > length / 2)
			p2.move(-velocity, 0);

	}

	public void keyReleased() {
		if (key == 'b') {
			b.move((Math.random() - 0.5) * 5, (Math.random() - 0.5) * 5);
		}
	}

	public void mouseReleased() {
		if (numLeftMines < 3) {
			if (mouseButton == LEFT) {
				left[numLeftMines] = new Mine((double) mouseX, (double) mouseY);
				numLeftMines++;
			}
		}
		if (numRightMines < 3) {
			if (mouseButton == RIGHT) {
				right[numRightMines] = new Mine((double) mouseX, (double) mouseY);
				numRightMines++;
			}
		}
	}

}
