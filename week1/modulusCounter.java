package ss.week1;

public class modulusCounter {

	private int max = 10;
	private int count;
	/**
	 * 
	 * @param max
	 */
	public modulusCounter(int max) {
		this.max = max;
		count = 0;
	}
	
	private int getCount() {
		return count;
	}
	
	private void increment() {
		if (count == max) {
			reset();
		} else {
			count++;
		}
	}
	
	private void reset() {
		count = 0;
	}
	
	public static void main(String[] args) {
		modulusCounter counter = new modulusCounter(10);
		for (int i = 0; i < 12; i++) {
			counter.increment();
			System.out.println(counter.getCount());
		}
		counter.reset();
		System.out.println(counter.getCount());


	}
}
