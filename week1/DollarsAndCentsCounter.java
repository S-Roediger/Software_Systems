package ss.week1;

public class DollarsAndCentsCounter {

	private int dollars;
	private int cents;
	
	/***
	 * @ensure this.dollars() >= 0;
	 * @return
	 */
	
	public int dollars() {
		return dollars;
	}
	
	/***
	 * @ensure 0 <= this.cents() && this.cents() <= 99
	 */
	
	public int cents() {
		return cents;
	}
	
	
	/***
	 * Add the specified cents and dollars to this counter
	 * @param dollars
	 * @param cents
	 */
	public void add(int dollars, int cents) {
		if ( dollars >= 0 && cents >= 0) {
			this.dollars = this.dollars + dollars + (this.cents+cents)/100;
			this.cents = (this.cents + cents) % 100;
		}

		
	}
	
	/***
	 * Reset the counter to 0
	 * @ensure 
	 */
	
	public void reset() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	public static void main(String[] args) {
		DollarsAndCentsCounter counter = new DollarsAndCentsCounter();
		
	}
}
