package ss.week7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;
    private static final Lock L = new ReentrantLock();
    private static Condition CONTAINS = L.newCondition();

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public void run() {
	L.lock();
	if (toe.contains("two")) {
	    try {
		CONTAINS.await();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	text.concat(toe);
	if (toe.contains("one")) {
	    CONTAINS.signal();
	}
	L.unlock();
    }

    public static void main(String[] args) {
        Thread t1 = new ConcatThread("one;");
        Thread t2 = new ConcatThread("two;");
        t1.start();
        t2.start();
        try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
        System.out.println(text);
    }
}
