package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		
		while (true)	{
			int willekeur = (int) Math.rint(Math.random() * (b.DIM * b.DIM - 1));
			if (b.isField(willekeur) && b.isEmptyField(willekeur))	{
				return willekeur;
			}
		}
	}
}