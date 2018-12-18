package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class ComputerPlayer extends ss.week4.tictactoe.Player {

	Strategy s;
	
	
	
	public ComputerPlayer(Mark m, Strategy s) {
		super(s.getName() + " - " + m.name(), m);
		this.s = s;
	}
	
	public ComputerPlayer(Mark m) {
		super("Naive - " + m.name(), m);
		this.s = new NaiveStrategy();
	}
	
	@Override
	public int determineMove(Board board) {
		return s.determineMove(board, this.getMark());
	}

	
	public Strategy inspect() {
		return s;
	}
	
	public void update(Strategy strat) {
		this.s = strat;
	}
	
	
}
