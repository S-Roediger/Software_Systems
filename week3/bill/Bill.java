package ss.week3.bill;

public class Bill {
	
	Printer p;
	double sum;
	String finalBill = null;
	boolean closed = false;
	
	
	public Bill(Printer p) {
		this.p = p;
		sum = 0.0;
	}
	
	public void addItem(Bill.Item item) {
		p.format(item.toString(), item.getAmount());
		sum += item.getAmount();
	}
	
	public void close() {
		finalBill = p.format("Total", sum);
		closed = true; //je kan hierna wel nog verder
		
	}
	
	public double getSum() {
		return sum;
	}
	
	public String toString() {
		if (closed) {
			return "Final Bill: " + finalBill;
		}
		return "Sum: " + sum;
	}
	
	public static interface Item {
		
		public double getAmount();
		
		public String toString();
	}

}
