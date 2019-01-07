package ss.week7.threads;

import java.util.Scanner;

public class TestConsole extends Thread {
	
	public TestConsole(String str) {
		super();
		this.setName(str);

	}

	private synchronized void sum() throws InterruptedException {
		//Scanner sc = new Scanner(System.in);
		int a = Console.readInt("Please, provide an integer.");
		int b = Console.readInt("Please, provide an integer.");
		//sc.close();
		String a1 = a + b + "";
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
