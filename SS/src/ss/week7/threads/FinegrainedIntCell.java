/**
 * 
 */
package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ®ik
 *
 */
public class FinegrainedIntCell implements IntCell {
	private int value;
	private boolean consumed = false;
	final Lock L = new ReentrantLock();
	final Condition notEmpty = L.newCondition();
	final Condition notFull = L.newCondition();

	@Override
	public void setValue(int val) {
		L.lock();
		try {
			while (!consumed) {
				notFull.await();
			}
			value = val;
			consumed = false;
			notEmpty.signal();
			L.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getValue() {
		L.lock();
		try {
			while (consumed) {
				notEmpty.await();
			}
			consumed = true;
			notFull.signal();
			L.unlock();
			return value;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
}