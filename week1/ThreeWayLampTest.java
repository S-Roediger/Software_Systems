package ss.week1;

public class ThreeWayLampTest {
	
	ThreeWayLamp lamp;
	
	public ThreeWayLampTest() {
		this.lamp = new ThreeWayLamp(0);
	}

	
	private void runTest() {
		for(int i = 0; i < 4; i++) {
			System.out.println(lamp.getSetting());
			lamp.changeSetting();
		}
	}
	
	public static void main(String[] args) {
		ThreeWayLampTest lamp = new ThreeWayLampTest();
		lamp.runTest();
	}
}
