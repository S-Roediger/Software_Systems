package ss.week4.hotel;

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item {

	double price;
	
	public PricedSafe(double price) {
		this.price = price;
		
	}
	
	@Override
	public double getAmount() {
		return price;
	}
	
	@Override
	public String toString() {
		return "The price of this safe is: " + price; 
	}

}
