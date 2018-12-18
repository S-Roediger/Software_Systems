package ss.week6;

public class WrongArgumentException extends Exception {

	
	public WrongArgumentException() {
		super();
	}
	
	public String getMessage() {
		return "error: arguments are incorrect";
	}
	
}
