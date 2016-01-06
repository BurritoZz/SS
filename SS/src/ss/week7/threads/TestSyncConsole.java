/**
 * 
 */
package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ®ik
 *
 */
public class TestSyncConsole extends Thread {
	private static final Lock L = new ReentrantLock();; 
	public TestSyncConsole(String naam)	{
		setName(naam);
	}
	public static void main(String[] args)	{
		new TestSyncConsole("1").start();
		new TestSyncConsole("2").start();
	}
	public void run()	{
		sum();
	}
	private void sum()	{
		L.lock();
		int een = SyncConsole.readInt("Thread " + getName() + ": get number 1? ");
		int twee = SyncConsole.readInt("Thread " + getName() + ": get number 2? ");
		SyncConsole.println("Thread " + getName() + ": " + een + " + " + twee + " = " + (een + twee));
		L.unlock();
	}
}