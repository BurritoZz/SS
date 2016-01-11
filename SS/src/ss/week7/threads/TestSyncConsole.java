package ss.week7.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread{
    private static final Lock L = new ReentrantLock();
    
    public static void main(String[] args) {
	new TestSyncConsole().start();
	new TestSyncConsole().start();
    }

    public void run() {
	sum();
    }
    
    public void sum() {
	L.lock();
	int a = SyncConsole.readInt(getName() + ": Get number 1? ");
	int b = SyncConsole.readInt(getName() + ": Get number 2? ");
	SyncConsole.println(a + " + " + b + " = " + (a + b));
	L.unlock();
    }

}
