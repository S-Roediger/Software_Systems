package ss.week3.bill;

public class StringPrinter implements Printer {

	private String line;
	
	@Override
	public void printLine(String text, double price) { 
		line = format(text, price);
		
	}
	
	public String getResult() {
		return line;
	}

}
