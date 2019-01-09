package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	protected double balance = 0.0;

	private static final ReentrantLock lock = new ReentrantLock();
	private static final Condition toLow = lock.newCondition();
	
	

	
	public void transaction(double amount) {
		lock.lock();
		while (balance+amount < -1000) {
			try {
				toLow.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Balance: " + balance + ", Amount: " +amount);
		balance = balance + amount;	
		System.out.println("Balance: " + balance + ", Amount: " +amount);
		toLow.signal();
		lock.unlock();
	}
	public double getBalance() {
		return balance;
	}
}
