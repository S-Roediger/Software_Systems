package ss.week2;

public class ThreeWayLamp {

	
	/**
	 * @invariant setting >= 0 && setting <= 3 
	 */
	//@private invariant setting >= 0 && setting <= 3;
	private int setting;
	//@private invariant OFF == 0;
	public static final int OFF = 0;
	//@private invariant LOW == 1;
	public static final int LOW = 1;
	//@private invariant MEDIUM == 2;
	public static final int MEDIUM = 2;
	//@private invariant HIGH == 3;
	public static final int HIGH = 3;
	
	/**
	 * @param setting - integer that determines the state of the light (off, low, medium or high)
	 */
	//@requires setting >= 0 && setting <= 3;
	public ThreeWayLamp(int setting) {
		this.setting = setting;
		
	}	 
	
	/**
	 * @return setting
	 */
	//@ensures \result >= 0 && \result <= 3;
	/* @pure */
	public int getSetting() {
		return setting;
	}


	//@ensures getSetting() >= 0 && getSetting() <= 3;
	//@ensures this.OFF == \old(HIGH);
	//@ensures this.LOW == \old(OFF);
	//@ensures this.MEDIUM == \old(LOW);
	//@ensures this.HIGH == \old(MEDIUM);
	public void changeSetting() {
		setting = (setting + 1) % 4;
	}
	
}
