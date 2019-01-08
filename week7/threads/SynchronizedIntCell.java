package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {

	private boolean consumed = true;
	private int value = 0;
	
	@Override
	public synchronized void setValue(int val) {
		while (!consumed) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		consumed = false;
		this.notify();
		this.value = val;
	}

	@Override
	public synchronized int getValue() {
		while (consumed) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		consumed = true;
		this.notify();
		return this.value;
	}
}
