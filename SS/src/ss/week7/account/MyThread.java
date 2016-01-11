/**
 * 
 */
package ss.week7.account;

/**
 * @author ®ik
 *
 */
public class MyThread extends Thread {
	private double theAmount;
	private int theFrequency;
	private Account theAccount;
	public MyThread(double amount, int frequency, Account account)	{
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}
	
	public void run()	{
		while (theFrequency > 0)	{
			theAccount.transaction(theAmount);
			theFrequency--;
		}
	}
}
