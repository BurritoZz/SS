package ss.week7.mandel;

/**
 * Class for drawing the Mandel in parallel
 */
class MandelThread extends Thread {
	MandelThread(MandelPanel mpArg) {
		this.mp = mpArg;
	}

	// overrides Thread.run
	// draws the fractal on the MandelPanel
	public void run() {
		mp.drawMandel();
	}

	private MandelPanel mp;
}
