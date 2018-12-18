package ss.week4.tictactoe;

import ss.week5.ComputerPlayer;
import ss.week5.NaiveStrategy;
import ss.week5.SmartStrategy;
import ss.week5.Strategy;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */

public class TicTacToe {

	
	
    public static void main(String[] args) {
    	Player p1 = null;
   /* 	if (args != null) {
        	if (args[0].equals("-N")) {
        		Strategy s = new NaiveStrategy();
        		p1 = new ComputerPlayer(Mark.OO, s);
        	} else if (args[0].equals("-S")) {
        		Strategy sSmart = new SmartStrategy();
        		p1 = new ComputerPlayer(Mark.OO, sSmart);
        	}
    	} else {
    		p1 = new HumanPlayer("Bunny", Mark.OO);
    	}
    	*/
    	Strategy s = new NaiveStrategy();
    	p1 = new ComputerPlayer(Mark.OO, s);
    	Player p2 = new HumanPlayer("Honey", Mark.XX);
        Game game = new Game(p1, p2);
        game.start();
    }
}
