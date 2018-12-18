package ss.week2;


public class ThreeWayLampEnum {

	
	
	private Setting settings;
	/**
	 * @param settings - enum that determines the state of the light (off, low, medium or high)
	 */
	//@requires settings == Setting.OFF;
	public ThreeWayLampEnum(Setting settings) {
		this.settings = settings; 
	}	 
	
	/** 
	 * @return setting
	 */

	public Setting getSetting() {
		System.out.println("The current setting is: " + settings);
		return settings;
	}

	
	public void changeSetting() {
		
		switch (settings) { 
			case OFF:
				System.out.println("The lamp changes to low");
				this.settings = Setting.LOW;
				break;
			case LOW:
				System.out.println("The lamp changes to medium");
				this.settings = Setting.MEDIUM;
				break;
			case MEDIUM:
				System.out.println("The lamp changes to high");
				this.settings = Setting.HIGH;
				break;
			case HIGH:
				System.out.println("The lamp changes to off");
				this.settings = Setting.OFF;
				break;			
		
		}		
	}
	
	public static void main(String[] args) {
		ThreeWayLampEnum lamp = new ThreeWayLampEnum(Setting.OFF);
		lamp.getSetting();
		lamp.changeSetting();
		lamp.getSetting();
		lamp.changeSetting();
		lamp.getSetting();
		lamp.changeSetting();
		lamp.getSetting();
		lamp.changeSetting();
		lamp.getSetting();
	}
}
