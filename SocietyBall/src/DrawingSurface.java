import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import shapes.Ball;
import shapes.Mine;
import shapes.Obstacle;
import shapes.Paddle;

/**
 * 
 * @author Daniel Huber and Richard Zhang and Ryan Tsai
 * 
 * 
 */
public class DrawingSurface extends PApplet {

	private Ball b;
	private Mine left[];
	private Mine right[];
	private Paddle p1;
	private Paddle p2;
	private int height;
	private int length;
	private int numLeftMines;
	private int numRightMines;
	private int p1point;
	private int p2point;
	private double velocity;
	private double velocity2;
	private boolean gameOver;
	private boolean up_p1, down_p1, left_p1, right_p1, up_p2, down_p2, left_p2, right_p2;
	private Obstacle o1;
	private Obstacle o2;
	boolean sprint_p1, sprint_p2;

	/**
	 * no args constructor
	 */
	public DrawingSurface() {
		int x = (int) (Math.random() * 150);
		int y = (int) (Math.random() * 400);
		height = 300;
		length = 400;
		b = new Ball(length / 2, height / 2);
		p1 = new Paddle(50, 100);
		p2 = new Paddle(350, 100);
		left = new Mine[3];
		right = new Mine[3];

		numLeftMines = 0;
		numRightMines = 0;
		p1point = 0;
		p2point = 0;
		velocity = 2;
		velocity2 = 2;
		gameOver = false;
		o1 = new Obstacle(x, y);
		o2 = new Obstacle((int) (Math.random() * 150 + 250), (int) Math.random() * 200);
	}

	/**
	 * Draws all the objects, and repeats continuously while program is running.
	 */
	public void draw() {
		background(255); // Clear the screen with a white background
		textSize(12);
		fill(0);

//		stroke(0,255,0);
		b.setColor(Color.green, Color.white);
		b.draw(this);
//		this.color(0, 255, 0);

		stroke(150);
		this.line(length / 2, 0, length / 2, height + 100);

		p1.setColor(Color.red, Color.yellow);
		p1.draw(this);

		p2.setColor(Color.blue, Color.pink);
		p2.draw(this);
		b.act();
		p1.act();
		p2.act();

		o1.setColor(Color.BLACK, Color.black);
		o2.setColor(Color.BLACK, Color.black);

		o1.draw(this);

		o2.draw(this);

		pushStyle();

		fill(0);
		textSize(10);
		text("The left side can place 3 mines with right click. \nThe right side can place 3 mines with left click. \nOnce you placed the mines, press 'B' on your keyboard to start. \nPress 'q' to sprint for Player 1(left) \nPress '.' to sprint for Player 2(Right).",
				15, height - 20);
		text(p1point + "   " + p2point, length / 2 - 9, 50);

		popStyle();

		for (int x = 0; x < b.getCorners().size(); x++) {
//			if (p1.isPointInside(b.getX(), b.getY())) {
			if (p1.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
//				b.reverseVelocties();
				b.setvX(Math.abs(b.getvX() + 0.2));
				b.setvY(Math.abs(b.getvY() + 0.2));

			}
			if (p2.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
//				b.reverseVelocties();
				// b.setvX(b.getvX() + p2.getvX());
				// b.setvY(b.getvY() + p2.getvY());
				b.setvX(-Math.abs(b.getvX() - 0.2));
				b.setvY(-Math.abs(b.getvY() - 0.2));
			}
			if (o1.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
				b.reverseVelocties();
			}

			if (o1.isPointInside(p1.getCorners().get(x).getX(), p1.getCorners().get(x).getY())) {
				velocity = 0.3;
			} else if (!sprint_p1)
				velocity = 2;

			if (o2.isPointInside(b.getCorners().get(x).getX(), b.getCorners().get(x).getY())) {
				b.reverseVelocties();
			}

			if (o2.isPointInside(p2.getCorners().get(x).getX(), p2.getCorners().get(x).getY())) {
				velocity2 = 0.3;
			} else if (!sprint_p2)
				velocity2 = 2;
		}

		// Checks if out of bounds/Score keeping
		if (b.getX() > 400 && !gameOver) {
			p1point++;
			b.resetPosition(length / 2, height / 2);
			p1.resetPosition(50, height / 2);
			p2.resetPosition(length - 50 - p2.width, height / 2);
			b.move((Math.random() + 0.5) * 2, (Math.random() - 0.5) * 2);
		}

		if (b.getX() < 0 && !gameOver) {
			p2point++;
			b.resetPosition(length / 2, height / 2);
			p1.resetPosition(50, height / 2);
			p2.resetPosition(length - 50 - p2.width, height / 2);
			b.move((Math.random() + 0.5) * -2, (Math.random() - 0.5) * 2);
		}

		// victory condition
		if (p1point == 10) {
			victory(true);
		}
		if (p2point == 10) {
			victory(false);
		}

		// deals with mines
		if (numLeftMines == 3 && numRightMines == 3) {
			// draws the mines
			left[0].setColor(Color.blue, Color.blue);
			left[1].setColor(Color.blue, Color.blue);
			left[2].setColor(Color.blue, Color.blue);

			left[0].draw(this);
			left[1].draw(this);
			left[2].draw(this);

			stroke(104, 102, 0);
			right[0].setColor(Color.red, Color.red);
			right[1].setColor(Color.red, Color.red);
			right[2].setColor(Color.red, Color.red);
			right[0].draw(this);
			right[1].draw(this);
			right[2].draw(this);

			// checks whether paddles touch mines
			if (p1.isPointInside(left[0].getX(), left[0].getY())) {
				p1.freeze();
				left[0].setX(length + 10000);
				left[0].setY(height + 10000);
			}
			if (p1.isPointInside(left[1].getX(), left[1].getY())) {
				p1.freeze();
				left[1].setX(length + 10000);
				left[1].setY(height + 10000);
			}
			if (p1.isPointInside(left[2].getX(), left[2].getY())) {
				p1.freeze();
				left[2].setX(length + 10000);
				left[2].setY(height + 10000);
			}

			if (p2.isPointInside(right[0].getX(), right[0].getY())) {
				p2.freeze();
				right[0].setX(length + 10000);
				right[0].setY(height + 10000);
			}
			if (p2.isPointInside(right[1].getX(), right[1].getY())) {
				p2.freeze();
				right[1].setX(length + 10000);
				right[1].setY(height + 10000);
			}
			if (p2.isPointInside(right[2].getX(), right[2].getY())) {
				p2.freeze();
				right[2].setX(length + 10000);
				right[2].setY(height + 10000);
			}

		}

		// left paddle movement
		if (!p1.isFrozen()) {

			if (up_p1 && p1.getY() > 0) {
				p1.move(0, -velocity);
			}
			if (right_p1 && p1.getX() < length / 2 - 15) {
				p1.move(velocity, 0);
			}
			if (left_p1 && p1.getX() > 0) {
				p1.move(-velocity, 0);
			}
			if (down_p1 && p1.getY() < height) {
				p1.move(0, velocity);
			}
//			if (sprint_p1) {
//				velocity = 5;
//				System.out.println("sprint");
//			}

		}

		// right paddle movement
		if (!p2.isFrozen()) {
			if (up_p2 && p2.getY() > 0) {
				p2.move(0, -velocity2);
			}
			if (right_p2 && p2.getX() < length) {
				p2.move(velocity2, 0);
			}
			if (left_p2 && p2.getX() > length / 2) {
				p2.move(-velocity2, 0);
			}
			if (down_p2 && p2.getY() < height) {
				p2.move(0, velocity2);
			}
//			if (sprint_p2) {
//				velocity2 = 5;
//			}
		}

	}

	/**
	 * Detects movement during the game using the keyboard for both paddles.
	 */
	public void keyPressed() {
		if (key == 'w')
			up_p1 = true;
		if (key == 'd')
			right_p1 = true;
		if (key == 'a')
			left_p1 = true;
		if (key == 's')
			down_p1 = true;
		if (keyCode == UP)
			up_p2 = true;
		if (keyCode == RIGHT)
			right_p2 = true;
		if (keyCode == LEFT)
			left_p2 = true;
		if (keyCode == DOWN)
			down_p2 = true;
		if (key == 'q') {
			sprint_p1 = true;
			velocity = 4;
		}
		if (key == '.') {
			sprint_p2 = true;
			velocity2 = 4;
		}

	}

	/**
	 * Used to start ball movement initially, also used for two-player movement.
	 */
	public void keyReleased() {
//		System.out.println(velocity2);
		if (key == 'b') {
			b.move((Math.random() - 0.5) * 5, (Math.random() - 0.5) * 5);
		}
		if (key == 'w')
			up_p1 = false;
		if (key == 'd')
			right_p1 = false;
		if (key == 'a')
			left_p1 = false;
		if (key == 's')
			down_p1 = false;
		if (keyCode == UP)
			up_p2 = false;
		if (keyCode == RIGHT)
			right_p2 = false;
		if (keyCode == LEFT)
			left_p2 = false;
		if (keyCode == DOWN)
			down_p2 = false;
		if (key == 'q') {
			sprint_p1 = false;
		}
		if (key == '.') {
			sprint_p2 = false;
		}

	}

	/**
	 * Used to check if mouse is released, places mines at the release locations
	 * mouseX and mouseY
	 */
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

	/**
	 * Displays the victory screen after one player wins
	 * 
	 * @param p1winner if the player one(left) won the game or not.
	 */
	public void victory(boolean p1winner) {
		background(0, 0, 0);
		fill(255);
		textSize(30);
		pushStyle();

		if (p1winner) {
			text("Victory for Player 1!", length / 2 - 140, height - 20);
		} else {
			text("Victory for Player 2!", length / 2 - 140, height - 20);
		}
		text(p1point + "  " + p2point, length / 2 - 30, 150);
		popStyle();
		gameOver = true;
	}

}
