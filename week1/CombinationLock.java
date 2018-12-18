package ss.week1;

import java.util.ArrayList;

public class CombinationLock {

//	------------ instance variables --------------
	
	private int[] combination = new int[5];
	public static final int[] combinationList = new int[] {0,0,0,0,0};
	
	/**
	 * Constructor to initialize Combination Lock
	 */
	public CombinationLock() {
		this.combination = combinationList;
		
	}
	
// ------------ Queries -------------
	/**
	 * Checks whether combination is acceptable
	 * @return true if combination is acceptable, otherwise false
	 */
	private boolean acceptable(int[] comb) {
		if (comb.length == 5) {
			return true;
		}
		return false;
	}
	/**
	 * Tests whether a certain combination is correct for the lock
	 * @param comb - combination that is tested
	 * @return true if combination is correct, otherwise false
	 */
	private boolean testCombination(int[] comb) {
		for (int i = 0; i < 5; i++) {
			if (comb[i] != combination[i]) {
				return false;
			}
		}
		return true;
	}
	
	
// ----------- Commands ---------------	
	

	/**
	 * Sets a new combination, first checks whether current combination is entered correctly
	 * @param oldComb - checked against current combination
	 * @param newComb - set as new combination if current combination is entered correctly
	 */
	private void setCombination(int[] oldComb, int[] newComb) {
		if (testCombination(oldComb)) {
			this.combination = newComb;
		}
	}
	
	
	
	public static void main(String[] args) {
		CombinationLock lock = new CombinationLock();
		int[] testList = new int[] {1,2,3,4,5};
		System.out.println("Test random combination, should be false: " + lock.testCombination(testList));
		System.out.println("Test whether new combination is acceptable, should be true: " + lock.acceptable(testList));
		System.out.println("We are now setting the new combination");
		lock.setCombination(combinationList, testList);
		System.out.println("Test Combination, should be true now after setting new combination: " + lock.testCombination(testList));
		
	}
}
