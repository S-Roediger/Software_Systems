package ss.week3.bill;

public interface Printer {

	/**
	 * 
	 * @param text - items that should be formatted
	 * @param price - prices that should be formatted
	 * @return a formatted line listing the item and price and ending on a newline. 
	 */
	public default String format(String text, double price) {
		return text + "              " + price + "\r";	
	}
	
	/**
	 * uses format to send the combination of text and price to the printer.
	 * @param text
	 * @param price
	 */
	public void printLine(String text, double price);
	
}
