import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import shapes.Ball;
import shapes.Mine;
import shapes.Paddle;

/**
 * 
 * @author Daniel Huber
 * 
 *
 */
public class DrawingSurface extends PApplet {

	private Paddle p;
	private Ball b;
	private Mine m;
	
	public DrawingSurface() {
		p = new Paddle(10,10);
		m = new Mine(20,100);
		b = new Ball(10,10);
		
		
	}
	
	public void draw() {
		background(255); // Clear the screen with a white background
		textSize(12);
		fill(0);

		b.draw(this);

		m.draw(this);
		
		p.draw(this);

		
	}	
	
	public void keyReleased() {
			if(key == 'w' ) {
				p.move(1,1);
			}
	}
}
