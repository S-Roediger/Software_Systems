package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsoleLock extends Thread {

	private ReentrantLock lock;
	
	public TestSyncConsoleLock(String str, ReentrantLock lock) {
		super(str);
		this.lock = lock;
	}

	private void sum() {
		lock.lock();
		int a = SyncConsole.readInt("Please, provide one integer.");
		SyncConsole.println(a+"");
					
		int b = SyncConsole.readInt("Please, provide one integer.");
		SyncConsole.println(b+"");
					
					
		SyncConsole.println(currentThread().getName() + ": " + a + " + " + b); 
		lock.unlock();
	}
	
	public void run() {
		sum();
	}
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		TestSyncConsoleLock t = new TestSyncConsoleLock("Thread A", lock);
		t.start();
		TestSyncConsoleLock tt = new TestSyncConsoleLock("Thread B", lock);
		tt.start();
	}
}
