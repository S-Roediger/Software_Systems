package ss.week5;

import java.util.Random;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

	private String name = "Naive";
	//private int[] fields = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
	
	public String getName() {
		return name;
	}

	public int determineMove(Board b, Mark m) {
		Random r = new Random();
		int a = r.nextInt(9);
		while (!b.isEmptyField(a)) {
			a = r.nextInt(9);
		}
		return a;
	}

}
