package ss.week1;

public class ThreeWayLamp {

	private int setting;
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	
	public ThreeWayLamp(int setting) {
		setting = OFF;
		
	}	
	
	public int getSetting() {
		return setting;
	}

	public void changeSetting() {
		setting = (setting + 1) % 4;
	}
	
	
	public static void main(String[] args) {
		ThreeWayLamp lamp = new ThreeWayLamp(0);
		System.out.println(lamp.getSetting());
		lamp.changeSetting();
		System.out.println(lamp.getSetting());
		lamp.changeSetting();
		System.out.println(lamp.getSetting());
		lamp.changeSetting();
		System.out.println(lamp.getSetting());
		lamp.changeSetting();
		System.out.println(lamp.getSetting());
	}
}
