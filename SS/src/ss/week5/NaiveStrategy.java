/**
 * 
 */
package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;
import java.util.Set;

/**
 * @author max
 * @version v1.0
 */
public class NaiveStrategy implements Strategy {

	private String name = "Naive";
	
	/**
	 * Creates a NaiveStrategy.
	 */
	public NaiveStrategy() {
		Set fields = new Set();
	}

	/* (non-Javadoc)
	 * @see ss.week5.Strategy#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ss.week5.Strategy#determineMove(ss.week4.tictactoe.Board, ss.week4.tictactoe.Mark)
	 */
	@Override
	public int determineMove(Board b, Mark m) {
		// TODO Auto-generated method stub
		return 0;
	}

}
