package ss.week4;

import ss.week3.math.Exponent;
import ss.week3.math.Function;
import ss.week3.math.Integrable;
import ss.week3.math.Print;

public class Polynomial implements ss.week3.math.Integrable {

	private double[] arr;
	
	public Polynomial(double[] arr) {
		this.arr = arr;
	}
	
	@Override
	public double apply(double y) {
		double x = arr[0];
		for (int i = 1; i < arr.length; i++) {
			Exponent yy = new Exponent(i);
			x += arr[i] * yy.apply(y);
		}
		return x;
	}

	@Override
	public Function derivative() {
		double[] result = new double[arr.length-1];
		for (int i = 1; i < arr.length; i++) {
			result[i-1] = arr[i] * i;
		}
		Polynomial p = new Polynomial(result);
		return p;
	}

	@Override
	public Integrable integral() {
		double[] result = new double[arr.length+1];
		result[0] = 0;
		for (int i = 0; i < arr.length; i++) {
			result[i+1] = arr[i] / (i+1);
		}
		Polynomial p = new Polynomial(result);
		return p;
	}
	
	public String toString() {
		return " " + this.arr;
	}

	public static void main(String[] args) {
		double arr[] = new double[] {1,2,3};
		Polynomial p = new Polynomial(arr);
		System.out.println(p.integral().apply(1));
		
	}
	
}
