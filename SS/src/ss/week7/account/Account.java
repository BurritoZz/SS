package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;
	private final Lock L = new ReentrantLock();
	private final Condition ALLOWED = L.newCondition();

	public void transaction(double amount) throws InterruptedException {
	    L.lock();
	    while (balance + amount <= -1000) {
		ALLOWED.await();
	    }
	    balance = balance + amount;
	    ALLOWED.signal();
	    L.unlock();
	}
	public double getBalance() {
	    try {
		L.lock();
		return balance;
	    } finally {
		L.unlock();
	    }
	}
}
