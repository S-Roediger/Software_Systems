package ss.week3.math;

public class Constant implements Function, Integrable {

	private double constant;
	
	public Constant(double x) {
		this.constant = x;
	}
	
	public double apply(double y) { 
		return constant;
	}

	public Function derivative() {
		Function deriv = new Constant(0);
		return deriv;
	}
	
	public String toString() {
		return "" + constant;
	}
	
	public static void main(String[] args) {
		Constant f = new Constant(2.0);
		Print.print(f);
	}

	public Integrable integral() {
		Integrable i = new Identity();
		i.apply(constant);
		return i;
	}


}
