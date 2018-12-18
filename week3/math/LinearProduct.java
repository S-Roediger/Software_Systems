package ss.week3.math;

public class LinearProduct extends Product implements Integrable {


	
	public LinearProduct(Function a, Function b) { //je kan al dit testen ook voorkomen door af te dwingen dat functie met Constant en Functie aangeroepen wordt
		super(a,b); 
	}
	
	public double apply(double y) {
		return getA().apply(0) * getB().apply(0);
	}
	

	public Function derivative() {
		LinearProduct linprod = null;
		if (getA() instanceof Constant) { //stop met die checks
			linprod = new LinearProduct(getA(), getB().derivative());
			return linprod;
		} else if (getB() instanceof Constant) {
			linprod = new LinearProduct(getA().derivative(), getB());
			return linprod;
		}
		return linprod;
	}

	public Integrable integral() {
		Integrable integr = null;
		if (getA() instanceof Constant) {
			integr = new LinearProduct(getA(), getB());
			return integr;
		} else if (getB() instanceof Constant) {
			integr = new LinearProduct(getA().derivative(), getB());
			return integr;
		}
		return integr;
	}
	
	public static void main(String[] args) {
		Constant c = new Constant(1);
		Constant cc = new Constant(2);
		LinearProduct linprod = new LinearProduct(c, cc);
		Print.print(linprod);
	}

	
}
