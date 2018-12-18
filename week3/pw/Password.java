package ss.week3.pw;

import java.lang.System;

public class Password {

	
	
	private String password;
	private Checker checker;
	private String factoryPassword = "4588456546";
	
	
	/***
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Password(Checker checker) {
		this.password = factoryPassword;
		this.checker = checker;
	}
	
	public Password() {
		this.password = factoryPassword;
		this.checker = new BasicChecker();
	}
	/***
	 * Test if a given string is an acceptable password. 
	 * Not acceptable: A word with less than 6 characters 
	 * or a word that contains a space.
	 * @param suggestion - Word that should be tested
	 * @return true If suggestion is acceptable
	 */
	public boolean acceptable(String suggestion) {
		return (!suggestion.contains(" ") && suggestion.length() > 6);
	}
	
	/**
	 * 
	 * @return factoryPassword
	 */
	public String getFactoryPassword() {
		return factoryPassword;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Checker getChecker() {
		return checker;
	}
	
	
	/***
	 * Tests if a given word is equal to the current password.
	 * @param test - Word that should be tested
	 * @return true If test is equal to the current password
	 */
	public boolean testWord(String test) {
		return (test.equals(password)); 
	}
	
	/***
	 * Changes the password.
	 * @param oldpass - The current password
	 * @param newpass - The new password
	 * @return true if old is equal to the current password 
	 * and that newpass is an acceptable password
	 */
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			this.password = newpass;
			return true;
		}
		return false;
	}
	

}
