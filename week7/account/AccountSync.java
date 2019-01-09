package ss.week7.account;


public class AccountSync {
	
	public static void main(String[] args) {
		Account acc = new Account();
		double amount = 1.0;
		double minAmount = -100.0;
		int freq = 11;
		
		MyThread t = new MyThread(amount, freq, acc);
		MyThread tt = new MyThread(minAmount, freq, acc);
		t.start();
		tt.start();
	}
	

}
