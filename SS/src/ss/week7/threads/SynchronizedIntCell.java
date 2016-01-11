package ss.week7.threads;

public class SynchronizedIntCell implements IntCell{

    private int value;
    private boolean consumed = true;
   
    @Override
    public synchronized void setValue(int val) {
	while (!consumed) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	consumed = false;
	value = val;
	notifyAll();
    }

    @Override
    public synchronized int getValue() {
	while (consumed) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	consumed = true;
	notifyAll();
	return value;
    }
    
}