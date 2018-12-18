package ss.week6;

import java.util.Scanner;

public class Hello {
	
	public void hello() {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, please enter your name. \r");
		String name = "";
		Boolean check = true;
		
		while (check) { 
			if (in.hasNextLine()) {
				name = in.nextLine();
			}
			
			System.out.println("Hello, " + name);
			System.out.println("Hello, please enter another name. \r");	
			if (name.length() == 0) {
				check = false;
			}
			name = "";
		}
		
	
		System.out.println("Goodbye!");
		in.close();
	}
	
	
	
	public static void main(String[] args) {
		Hello h = new Hello();
		h.hello();
	}
	
	
	
	
	
}
