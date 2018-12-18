package ss.week3.pw;

public interface Checker {

	//@requires suggestion != null;
	//@ensures \result ==> true || \result ==> false;
	public boolean acceptable(String suggestion); //hier al default implementation
	
	//@ensures \result.length() >= 6 && !\result.contains(" ");
	public String generatePassword();
	
}
