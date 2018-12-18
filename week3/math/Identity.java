package ss.week3.math;

public class Identity implements Function, Integrable {
	
	private double y;
	
	public Identity() {
		
	}
	
	public double apply(double y) {
		this.y = y;
		return y;
	} 

	public Function derivative() {
		Function func = new Constant(1);
		return func;
	}
	
	public Integrable integral() {
		Integrable i = new Identity();
		i.apply(y);
		return i;
	}
	
	public String toString() {
		return "" + this.y;
	}

	public static void main(String[] args) {
		Function func = new Identity();
		Print.print(func);
	}


	
}
