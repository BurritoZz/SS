package ss.week7.mandel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * Graphical compontent for drawing a Mandelbrot fractal
 * @author Martin Kalin, aangepast door Arend Rensink
 * @version 15-01-2002
 */
class MandelPanel extends JPanel
{
	public void draw() {
		(new MandelThread(this)).start();
	}


	// draw the fractal 
	void drawMandel() {
		Graphics g = getGraphics();
		int width = getWidth();
		int height = getHeight();
		pixels = new Color[width][height];
		double xstep = DIV / width;
		double ystep = DIV / height;
		double y = Y_START;
		for (int j = 0; j < height; y += ystep, j++) {
			double x = X_START;
			for (int i = 0; i < width; x += xstep, i++) {
				double c1Real = x;
				double c1Imag = y;
				double c2Real = 0.0;
				double c2Imag = 0.0;
				int iter;
				double spread = 0.0;
				for (iter = 0; iter < MAX_COLORS && spread < MAX_SPREAD; iter++) {
					double real = c1Real + c2Real;
					double imag = c1Imag + c2Imag;
					c2Real = real * real - imag * imag;
					c2Imag = 2 * real * imag;
					spread = c2Real * c2Real + c2Imag * c2Imag;
				}
				g.setColor(COLORS[iter]);
				g.fillRect(i, j, 1, 1);
				pixels[i][j] = COLORS[iter]; // sla de tekening op
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	/** Storage of the pixels */
	private Color[][] pixels;

	/** 
	 * used to redraw (parts) of JComponent. For example if it was hidden under another window
	 * @param g the parts needs to be redrawn
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (pixels != null) {
			Rectangle bounds = g.getClipBounds();
			for (int i = bounds.x; i < bounds.x + bounds.width; i++) {
				for (int j = bounds.y; j < bounds.y + bounds.height; j++) {
					try {
						g.setColor(pixels[i][j]);
						g.fillRect(i, j, 1, 1);
					} catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static final double MAX_SPREAD = 4.0;
	private static final double LIMIT = 1.0;
	private static final double X_START = -1.5;
	private static final double Y_START = -1.0;
	private static final double DIV = 2.0;
	private static final Color[] COLORS;
	private static final int MAX_COLORS = 64;

	// below is a static initializer;
	// you can set static variables with an initial value
	// It is a kind of constructor for a class instead of a instance

	static {
		int maxRGB = 255, r = 0, g = 0, b = 0;
		COLORS = new Color[MAX_COLORS + 1];
		for (int i = 0; i < MAX_COLORS; i++) {
			COLORS[i] = new Color(r, g, b);
			r += MAX_COLORS;
			if (r > maxRGB) {
				r = 0;
				g += MAX_COLORS;
				if (g > maxRGB) {
					g = 0;
					b += MAX_COLORS;
				}
				if (b > maxRGB) {
					b = 0;
				}
			}
		}
		COLORS[MAX_COLORS] = Color.white;
	}
}
