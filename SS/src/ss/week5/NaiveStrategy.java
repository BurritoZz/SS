/**
 * 
 */
package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

/**
 * @author max
 * @version v1.0
 */
public class NaiveStrategy implements Strategy {

	private String name = "Naive";

	/**
	 * Returns the name of the strategy.
	 * @return Returns the name of the strategy.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Generates random possible move.
	 * @param Board b - Board on which the game is played.
	 * @param Mark m - The mark used by the player.
	 * @return returns a valid move, or -1 if it failed (which should be impossible).
	 */
	@Override
	public int determineMove(Board b, Mark m) {
		int rand = (int) Math.rint(Math.random() * (b.DIM * b.DIM - 1));
		if (b.isEmptyField(rand)) {
			return rand;
		} else {
			determineMove(b, m);
		}
		return -1;
	}
}
