package ss.week3.math;

public class Sum implements Function, Integrable {

	Function a;
	Function b;
	
	public Sum(Function a, Function b) {
		this.a = a;
		this.b = b;
	}
	
	public double apply(double y) {
		return a.apply(0) + b.apply(0);
	}

	public Function derivative() {
		Sum sum = new Sum(a.derivative(), b.derivative());
		return sum;
	}

	public String toString() {
		return this.a + " + " + this.b;
	}
	
	public static void main(String[] args) {
		Function a = new Constant(1);
		Function b = new Constant(1);
		Function func = new Sum(a, b);
		Print.print(func);
	}

	public Integrable integral() {
		Constant c = new Constant(a.apply(0));
		Constant cc = new Constant(b.apply(0));
		Integrable c1 = c.integral();
		Integrable cc1 = cc.integral();
		Sum sum = new Sum(c1, cc1);
		return sum;
	}
}
