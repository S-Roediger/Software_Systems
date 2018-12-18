package ss.week2.hotel;

public class Password {

	
	public static final String INITIAL = "start1";
	private String password;
	
	
	/***
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Password() {
		this.password = INITIAL;
	}
	/***
	 * Test if a given string is an acceptable password. 
	 * Not acceptable: A word with less than 6 characters 
	 * or a word that contains a space.
	 * @param suggestion - Word that should be tested
	 * @return true If suggestion is acceptable
	 */
	public boolean acceptable(String suggestion) {
		if (suggestion.contains(" ") || suggestion.length() < 6) {
			return false;
		}
		return true;
	}
	
	/***
	 * Tests if a given word is equal to the current password.
	 * @param test - Word that should be tested
	 * @return true If test is equal to the current password
	 */
	public boolean testWord(String test) {
		if (test.equals(password)) {
			return true;
		}
		return false;
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
