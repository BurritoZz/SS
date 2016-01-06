package ss.week7.bounce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Bounce. View of a bouncing ball
 * @see BallPanel
 * @see Ball 
 */
public class Bounce extends JFrame {
	private JButton start;
	private BallPanel ballPanel;

	class BallThread extends Thread	{
		public void run()	{
			for (int i = 0; i < 1000; i++)	{
				ballPanel.addNewBall();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public Bounce() {
		setTitle("Bounce");
		ballPanel = new BallPanel();
		getContentPane().add("Center", ballPanel);
		JPanel controlPanel = new JPanel();
		start = new JButton("Start");
		controlPanel.add(start);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				(new BallThread()).start();
			}
		});
		getContentPane().add("South", controlPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new Bounce();
		f.setLocation(200, 200);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}
