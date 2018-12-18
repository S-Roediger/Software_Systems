package ss.week5;

import java.util.Random;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class SmartStrategy implements Strategy {

	String name = "Smart";
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		if (b.isEmptyField(4)) {
			return 4;
		}
		Board a = b.deepCopy();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			a = b.deepCopy();
			if (a.isEmptyField(i)) {
				a.setField(i, m); 
				if (a.hasColumn(m) || a.hasDiagonal(m) || a.hasRow(m)) {
					return i;
				}

			}
		}
		Board c = b.deepCopy();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			c = b.deepCopy();
			if (c.isEmptyField(i)) {
				c.setField(i, m.other()); 
				if (c.hasColumn(m.other()) || c.hasDiagonal(m.other()) || c.hasRow(m.other())) {
					return i;
				}

			}
		}
		Random r = new Random();
		int last = r.nextInt(9);
		while (!b.isEmptyField(last)) {
			last = r.nextInt(9);
		}
		return last;
	}
	

}
