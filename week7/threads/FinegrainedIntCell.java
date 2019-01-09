package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {

	private boolean consumed = true;
	private static final ReentrantLock lock = new ReentrantLock();
	private final Condition cconsumed = lock.newCondition();
	private final Condition produced = lock.newCondition();
	private int val;

	@Override
	public void setValue(int val) {
		lock.lock();
		
		while (!consumed) {
			try {
				cconsumed.await();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.val = val;
		produced.signal();
		consumed = false;
		lock.unlock();

	}

	@Override
	public int getValue() {
		lock.lock();

		while (consumed) {
			try {
				produced.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cconsumed.signal();
		consumed = true;
		lock.unlock();
		return val;
		
	
		
	}

}
