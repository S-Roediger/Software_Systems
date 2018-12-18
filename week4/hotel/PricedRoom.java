package ss.week4.hotel;

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item {

	double roomPrice;
	
	public PricedRoom(int number, double roomPrice, double safeCost) {
		super(number, new PricedSafe(safeCost));
		this.roomPrice = roomPrice;
		
	}
	@Override
	public String toString() {
		return "Room: " + this.getNumber() + ", price: " + roomPrice;
	}
	
	@Override
	public double getAmount() {	
		return roomPrice;
	}
	


	
	
}
