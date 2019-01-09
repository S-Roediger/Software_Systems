package ss.week7.account;

public class MyThread extends Thread {

	double theAmount;
	int theFrequency;
	Account theAccount;
	
	public MyThread(double amount, int frequency, Account account) {
		this.theAmount = amount;
		this.theFrequency = frequency;
		this.theAccount = account;
	}
	
	@Override
	public void run() {
		System.out.println("I am " + currentThread().getName() + " and I start with this balance " + theAccount.balance);
		for (int i = 0; i < theFrequency; i++) {
			System.out.println("I am " + currentThread().getName() + " the current balance is: " + theAccount.balance + ", and I add the following amount " + theAmount + ", now the balance is this: " + theAccount.balance);
			theAccount.transaction(theAmount);
		}
		System.out.println("In between balance from Thread: " + currentThread().getName() + ", " +theAccount.getBalance());
	}
	
}
