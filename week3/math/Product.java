package ss.week3.math;

public class Product implements Function {

	private Function a;
	private Function b;
	
	public Product(Function a, Function b) { 
		this.a = a;
		this.b = b;
		
	}
	
	public double apply(double y) {
		return a.apply(0) * b.apply(0);
	}

	public Function derivative() {
		Product pr = new Product(this.a.derivative(), this.b);
		Constant c = new Constant(pr.apply(0));
		Product pro = new Product(this.a, this.b.derivative());
		Constant cc = new Constant(pro.apply(0));
		Sum prod = new Sum(c, cc);
		return prod;
	}
	
	public String toString() { 
		return this.a + " * " + this.b;
	}

	public static void main(String[] args) {
		Function a = new Constant(1);
		Function b = new Constant(1);
		Product prod = new Product(a, b);
		Print.print(prod);
		
	}
	
	public Function getA() {
		return a;
	}
	
	public Function getB() {
		return b;
	}
	
}
