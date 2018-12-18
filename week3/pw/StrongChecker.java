package ss.week3.pw;

import java.lang.Character;

public class StrongChecker extends BasicChecker {

		public boolean acceptable(String suggestion) {
			return (super.acceptable(suggestion) && Character.isLetter(suggestion.charAt(0)) && Character.isDigit(suggestion.charAt(suggestion.length()-1)));			
		}

}
