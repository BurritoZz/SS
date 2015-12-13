package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	public static void main(String[] args) {
		Player s0 = new HumanPlayer("Max", Mark.OO);
		Player s1 = new HumanPlayer("Floor", Mark.XX);
		Game game = new Game(s0, s1);
		game.start();
	}
}