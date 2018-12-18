package ss.week3.pw;

import java.lang.System;

public class TimedPassword extends Password {

	private int validTime;
	long t1;
	long t2;

	
	public TimedPassword(int validTime) {
		super();
		this.validTime = validTime;
		t1 = System.currentTimeMillis();
	}
	
	public TimedPassword() {
		this.validTime = 1;
	}
	
	public boolean isExpired() {
		long t2 = System.currentTimeMillis();
		long time = t2 - t1;
		return time >= validTime; 
	}

	@Override
	public boolean setWord(String oldpass, String newpass) {
		super.setWord(oldpass, newpass);
		this.t1 = System.currentTimeMillis();
		return true;
	}
	 
}
