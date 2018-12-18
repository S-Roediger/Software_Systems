package ss.week6;

import java.util.Scanner;

public class Words {

	
	public void words() {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a sentence.");	
		String a;
		int i = 0;
		while (!(a = in.next()).equals("end")) {
			System.out.println("Word " + i + ": " + a + "\r");
			i++;
		}
		System.out.flush();
		in.close();
		System.out.println("Word " + i + ": end" + "\r");
		System.out.println("End of program");
	}
	
	public static void main(String[] args) {
		Words w = new Words();
		w.words();
	}
}
