/**
 * 
 */
package ss.week7.account;

/**
 * @author ®ik
 *
 */
public class AccountSync {
	private static final double AMOUNT = 12;
	private static final int FREQ = 12;
	public static void main(String[] args)	{
		Account acc = new Account();
		Thread thread1 = new MyThread(AMOUNT, FREQ, acc);
		Thread thread2 = new MyThread(-AMOUNT, FREQ, acc);
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(acc.getBalance());
	}
}
