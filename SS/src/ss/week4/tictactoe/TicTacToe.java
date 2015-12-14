package ss.week4.tictactoe;
import ss.week5.*;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	private static Player s0;
	private static Player s1;
    public static void main(String[] args) {
    	if (args.length < 1)	{
    		args = new String[2];
    		args[0] = "Rik";
    		args[1] = "-N";
    	}
    	if (args[0].startsWith("-"))	{
    		if (args[0].equals("-S"))	{
    			s0 = new ComputerPlayer(Mark.XX, new SmartStrategy());
    		} else {
    			s0 = new ComputerPlayer(Mark.XX);
    		}
    	} else {
    		s0 = new HumanPlayer(args[0], Mark.XX);
    	}
    	if (args[1].startsWith("-"))	{
    		if (args[1].equals("-S"))	{
    			s1 = new ComputerPlayer(Mark.OO, new SmartStrategy());
    		} else {
    			s1 = new ComputerPlayer(Mark.OO);
    		}
    	} else {
    		s1 = new HumanPlayer(args[1], Mark.OO);
    	}
    	new Game(s0, s1).start();
    }
}