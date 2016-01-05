package ss.week7.bounce;

import java.awt.Dimension;
import java.awt.Graphics; //Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Represents a bouncing ball
 * @version 2013-12-17
 */
public class Ball {
	public JPanel panel;

	/*@
	   requires panel != null;
	 */
	public Ball(JPanel panelArg) {
		this.panel = panelArg;
	}

	/** Draw the ball at position x,y on the Canvas box. */
	public void draw(Graphics g) {
		g.fillOval(x, y, BALL_DIAM, BALL_DIAM);
	}

	/**
	 * Collision of two balls has the effect that both balls 
	 * 'turn around' 180 degrees. Could be better
	 */
	public void collide(Ball other) {
		if (this.position().distance(other.position()) < BALL_DIAM) {
			int dxTemp = this.dx;
			int dyTemp = this.dy;
			this.dx = other.dx;
			this.dy = other.dy;
			other.dx = dxTemp;
			other.dy = dyTemp;
		}
	}

	/**
	 * Point is handy because we have a method for euclidian 
	 * distance (see implementation of collide).
	 * @return a Point as the position of the ball
	 */
	public Point position() {
		return new Point(x, y);
	}

	/** Move this ball. */
	public void move() {
		x += dx;
		y += dy;
		Dimension d = panel.getSize();
		if (x < 0) {
			x = 0;
			dx = -dx;
		} else if (x + BALL_DIAM >= d.width) {
			x = d.width - BALL_DIAM;
			dx = -dx;
		}

		if (y < 0) {
			y = 0;
			dy = -dy;
		} else if (y + BALL_DIAM >= d.height) {
			y = d.height - BALL_DIAM;
			dy = -dy;
		}
	}

	private static final int BALL_DIAM = 10; // diameter of the ball

	private int x = 0; // horizontal position of ball
	private int y = 0; // vertical   position of ball
	private int dx = 2; // horizontal displacement per move
	private int dy = 2; // vertical   displacment per move  
}
