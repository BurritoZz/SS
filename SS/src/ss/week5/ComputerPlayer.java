package ss.week5;

import ss.week4.tictactoe.*;

public class ComputerPlayer extends Player {
	private Strategy strategy;

	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark, mark);
		this.strategy = strategy;
	}
	public ComputerPlayer(Mark mark) {
		this(mark, new NaiveStrategy());
	}

	@Override
	public int determineMove(Board board)	{
		return strategy.determineMove(board, mark);
	}

}
