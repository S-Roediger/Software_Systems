package ss.week7.threads;



public class TestConsole extends Thread {
	
	public TestConsole(String str) {
		super();
		this.setName(str);

	}

	private void sum() throws InterruptedException {
		
		int a = Console.readInt("Please, provide one integer.");
		Console.println(a+"");
		
		int b = Console.readInt("Please, provide one integer.");
		Console.println(b+"");
		
		
		Console.println(currentThread().getName() + " " + a + " " + b);
	

	}
	
	public void run() {
		try {
			sum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestConsole t = new TestConsole("Thread A");
		t.start();
		TestConsole tt = new TestConsole("Thread B");
		tt.start();
	}
	
}
