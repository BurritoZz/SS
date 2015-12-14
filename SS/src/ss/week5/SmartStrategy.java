package ss.week5;

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
	Board test = b.deepCopy();
	if (test.isEmptyField(4)) {
	    return 4;
	}
	for (int i = 0; i < b.DIM * b.DIM; i++) {
	    test = b.deepCopy();
	    test.setField(i, m);
	    if (test.isWinner(m) && b.isEmptyField(i)) {
		return i;
	    }
	}
	for (int i = 0; i < b.DIM * b.DIM; i++) {
	    test = b.deepCopy();
	    test.setField(i, m.other());
	    if (test.isWinner(m.other()) && b.isEmptyField(i)) {
		return i;
	    }
	}
	return new NaiveStrategy().determineMove(b, m);
    }

}
