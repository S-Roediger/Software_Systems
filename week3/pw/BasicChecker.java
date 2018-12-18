package ss.week3.pw;

import java.util.Random;

public class BasicChecker implements Checker {

	private Password pass;
	public static String INITPASS;
	
	public BasicChecker() {
		pass = new Password(this);
		this.INITPASS = pass.getFactoryPassword();
	}

	public boolean acceptable(String suggestion) {
		return (!suggestion.contains(" ") && suggestion.length() > 6);
	}

	
	
	public String generatePassword() {
		
		Random random = new Random();
		String str = "";
		str = str + random.nextInt();
		return str;
	}

	public static void main(String[] args) {
		BasicChecker checker = new BasicChecker();
		System.out.println(checker.generatePassword());
	}
}
