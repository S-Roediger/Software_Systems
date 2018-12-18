package ss.week1;

public class Employee {

	private int hours = 40; //hours worked in the week
	private double rate = 7.5; //hourly pay rate (dollars)
	
	
	private double pay() {
		double pay = hours*rate;
		if(hours <= 40) {
			return pay;
		} else {
			return pay*1.5;
		}
	}
	
	public static void main(String[] args) {
		Employee Karen = new Employee();
		System.out.println("Karen's pay: " + Karen.pay());
	}
}
