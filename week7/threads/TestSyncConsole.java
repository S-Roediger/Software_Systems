package ss.week7.threads;

public class TestSyncConsole extends Thread {

	Object dummy;
	
	public TestSyncConsole(String str, Object dummy) {
		super(str);
		this.dummy = dummy;
		

	}

	private void sum() throws InterruptedException {
		
		synchronized(dummy) {
			int a = 0;
			int b = 0;
			
			a = SyncConsole.readInt("Please, provide one integer.");
			SyncConsole.println(a+"");
			
			
			b = SyncConsole.readInt("Please, provide one integer.");
			SyncConsole.println(b+"");
			SyncConsole.println(currentThread().getName() + ": " + a + " + " + b);
		}
		
	}
	
	public void run() {
		try {
			sum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Object dummy = new Object();
		TestSyncConsole t = new TestSyncConsole("Thread A", dummy);
		TestSyncConsole tt = new TestSyncConsole("Thread B", dummy);
		t.start();
		tt.start();
	}
}
