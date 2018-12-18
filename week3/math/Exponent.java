package ss.week3.math;

public class Exponent implements Function, Integrable {
	
	//@private invariant n >= 0;
	private int n;

	
	public Exponent(int n) {
		assert n >= 0 : "Integer n must be positive, but is currently negative.";
		this.n = n;
	}

	public double apply(double y) { // math.pow kan ook
		if (this.n == 0) {
			return 1;
		} 
		double a = y;
		for (int i = 1; i < n; i++) {
			a *= a;
		} 
		return a;
			
		 
	}

	public Function derivative() {
		Constant c = new Constant(n);
		Exponent e = new Exponent(n-1);
		Constant cc = new Constant(e.apply(n-1)); // y is de exponent.. daarom werkt het
		Function prod = new LinearProduct(c, cc);
		return prod;
	}

	public Integrable integral() {
		return null;
	}

	public String toString() {
		return "x^"+this.n;
	}
	

	public static void main(String[] args) {
		Exponent ex = new Exponent(3);
		Print.print(ex);
	}


}
