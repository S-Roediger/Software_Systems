package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	public ArgumentLengthsDifferException(int a, int b) {
		super();
	}
	
	@Override
	public String getMessage() {
		return "error: length of command line arguments";
	}
	
}
