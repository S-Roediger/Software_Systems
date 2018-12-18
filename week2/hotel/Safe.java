package ss.week2.hotel;

public class Safe {
	//@private invariant open ==> active;
	//@private invariant password != null;
	private Password password;
	private boolean active;
	private boolean open;

	/**
	 * Constructor Safe.
	 */
	//@ensures (isActive() == true || isActive() == false);
	//@ensures (isOpen() == true || isOpen() == false);
	//@ensures getPassword() != null;
	public Safe() {
		this.password = new Password();
		active = false;
		open = false; 
	}
	
	//--------- Queries ----------------//
	
	/**
	 * Indicates whether the safe is active.
	 * @return true when safe is active and false when safe is inactive
	 */
	//@ensures (\result == true || \result == false);
	/* @pure */public boolean isActive() {
		return active;
	}
	
	/**
	 * Indicates whether the safe is open.
	 * @return true when safe is open and false when safe is closed
	 */
	//@ensures (\result == true || \result == false);
	/* @pure */public boolean isOpen() {
		return open;
	}
	
	/**
	 * Returns the password.
	 * @return password object on which the method testWord can be called to check the password.
	 */
	//@ensures \result != null;
	/* @pure */public Password getPassword() {
		return password;
	}
	
	//-------- Commands ---------------//
	
	/**
	 * Activates the safe if the password is correct.
	 * @param password
	 */
	//@requires password != null;
	//@ensures (isActive() == true || isActive() == false);
	public void activate(String password) {
		if (this.password.testWord(password)) {
			active = true;
		}
	}
	
	/**
	 * Closes the safe and deactivates it.
	 */
	//@ensures (isOpen() == false && isActive() == false);
	public void deactivate() {
		open = false;
		active = false;
	}
	
	/**
	 * Opens the safe if it is active and the correct password was given.
	 * @param password
	 */
	//@requires password != null;
	//@ensures (isOpen() == true || isOpen() == false);
	public void open(String password) {
		assert this.password.acceptable(password) : "The given password was not acceptable"; 
		if (active && this.password.testWord(password)) {
			open = true;
		}
	}
	/**
	 * Closes the safe, but does not change its activity status.
	 */
	//@ensures isOpen() == false;
	public void close() {
		open = false;
	}
	
	public static void main(String[] args) {
		Safe safe = new Safe();
		safe.activate("start1");
		safe.open("pass ");
	}
}
