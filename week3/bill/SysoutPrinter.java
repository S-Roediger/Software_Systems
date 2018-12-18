package ss.week3.bill;

public class SysoutPrinter implements Printer {

	@Override
	public void printLine(String text, double price) {
		Printer pr = new SysoutPrinter();
		System.out.println(pr.format(text, price));
		
	}

	public static void main(String[] args) {
		Printer pr = new SysoutPrinter();
		pr.printLine("Item ", 2.0);
	}
}
