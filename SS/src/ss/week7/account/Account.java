package ss.week7.account;

import java.util.concurrent.locks.*;

public class Account {
	protected double balance = 0.0;
	private static final Lock LOCK = new ReentrantLock();
	private static final Condition ISNOTEMPTY = LOCK.newCondition();

	public void transaction(double amount) {
		LOCK.lock();
		while (balance + amount < -1000)	{
			try {
				ISNOTEMPTY.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance = balance + amount;
		if (balance > -1000)	{
			ISNOTEMPTY.signalAll();
		}
		LOCK.unlock();
	}
	public double getBalance() {
		return balance;
	}
}
