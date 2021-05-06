import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		textSize(12);
		fill(0);
		//text("Use the mouse wheel to change length, use UP/DOWN keys to change level.",0,15);
		
		stroke(0);
		//curve2.draw(this);		
	}
}
