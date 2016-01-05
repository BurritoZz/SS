package ss.week5;

import ss.week4.tictactoe.*;

public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		// Midden
		if (b.isEmptyField(4))	{
			return 4;
		}
		
		// Offensief
		for (int i = 0; i < b.DIM * b.DIM; i += b.DIM)	{
			if (b.getField(i).equals(m) && b.getField(i + 1).equals(m) && b.isEmptyField(i + 2))	{
				return i + 2;
			}
			if (b.getField(i).equals(m) && b.getField(i + 2).equals(m) && b.isEmptyField(i + 1))	{
				return i + 1;
			}
			if (b.getField(i + 2).equals(m) && b.getField(i + 1).equals(m) && b.isEmptyField(i))	{
				return i;
			}
		}
		for (int i = 0; i < b.DIM; i++)	{
			if (b.getField(i).equals(m) && b.getField(i + b.DIM).equals(m) && b.isEmptyField(i + 2 * b.DIM))	{
				return i + 2 * b.DIM;
			}
			if (b.getField(i).equals(m) && b.getField(i + 2 * b.DIM).equals(m) && b.isEmptyField(i + b.DIM))	{
				return i + b.DIM;
			}
			if (b.getField(i + b.DIM).equals(m) && b.getField(i + 2 * b.DIM).equals(m) && b.isEmptyField(i))	{
				return i;
			}
		}
		if (b.getField(0).equals(m) && b.getField(4).equals(m) && b.isEmptyField(8))	{
			return 8;
		}
		if (b.getField(4).equals(m) && b.getField(8).equals(m) && b.isEmptyField(0))	{
			return 0;
		}
		if (b.getField(8).equals(m) && b.getField(0).equals(m) && b.isEmptyField(4))	{
			return 4;
		}
		if (b.getField(2).equals(m) && b.getField(4).equals(m) && b.isEmptyField(6))	{
			return 6;
		}
		if (b.getField(4).equals(m) && b.getField(6).equals(m) && b.isEmptyField(2))	{
			return 2;
		}
		if (b.getField(6).equals(m) && b.getField(2).equals(m) && b.isEmptyField(4))	{
			return 4;
		}
		
		// Defensief
		for (int i = 0; i < b.DIM * b.DIM; i += b.DIM)	{
			if (b.getField(i).equals(m.other()) && b.getField(i + 1).equals(m.other()) && b.isEmptyField(i + 2))	{
				return i + 2;
			}
			if (b.getField(i).equals(m.other()) && b.getField(i + 2).equals(m.other()) && b.isEmptyField(i + 1))	{
				return i + 1;
			}
			if (b.getField(i + 2).equals(m.other()) && b.getField(i + 1).equals(m.other()) && b.isEmptyField(i))	{
				return i;
			}
		}
		for (int i = 0; i < b.DIM; i++)	{
			if (b.getField(i).equals(m.other()) && b.getField(i + b.DIM).equals(m.other()) && b.isEmptyField(i + 2 * b.DIM))	{
				return i + 2 * b.DIM;
			}
			if (b.getField(i).equals(m.other()) && b.getField(i + 2 * b.DIM).equals(m.other()) && b.isEmptyField(i + b.DIM))	{
				return i + b.DIM;
			}
			if (b.getField(i + b.DIM).equals(m.other()) && b.getField(i + 2 * b.DIM).equals(m.other()) && b.isEmptyField(i))	{
				return i;
			}
		}
		if (b.getField(0).equals(m.other()) && b.getField(4).equals(m.other()) && b.isEmptyField(8))	{
			return 8;
		}
		if (b.getField(4).equals(m.other()) && b.getField(8).equals(m.other()) && b.isEmptyField(0))	{
			return 0;
		}
		if (b.getField(8).equals(m.other()) && b.getField(0).equals(m.other()) && b.isEmptyField(4))	{
			return 4;
		}
		if (b.getField(2).equals(m.other()) && b.getField(4).equals(m.other()) && b.isEmptyField(6))	{
			return 6;
		}
		if (b.getField(4).equals(m.other()) && b.getField(6).equals(m.other()) && b.isEmptyField(2))	{
			return 2;
		}
		if (b.getField(6).equals(m.other()) && b.getField(2).equals(m.other()) && b.isEmptyField(4))	{
			return 4;
		}
		
		// Dan maar zonder strategie
		return new NaiveStrategy().determineMove(b, m);
	}

}
