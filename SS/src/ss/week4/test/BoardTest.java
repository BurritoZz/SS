package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIndex() {
        assertEquals(0, board.index(0, 0));
        assertEquals(1, board.index(0, 1));
        assertEquals(3, board.index(1, 0));
        assertEquals(8, board.index(2, 2));
    }

    @Test
    public void testIsFieldIndex() {
        assertFalse(board.isField(-1));
        assertTrue(board.isField(0));
        assertTrue(board.isField(8));
        assertFalse(board.isField(9));
    }

    @Test
    public void testIsFieldRowCol() {
        assertFalse(board.isField(-1, 0));
        assertFalse(board.isField(0, -1));
        assertTrue(board.isField(0, 0));
        assertTrue(board.isField(2, 2));
        assertFalse(board.isField(2, 3));
        assertFalse(board.isField(3, 2));
    }

    @Test
    public void testSetAndGetFieldIndex() {
        board.setField(0, Mark.XX);
        assertEquals(Mark.XX, board.getField(0));
        assertEquals(Mark.EMPTY, board.getField(1));
    }

    @Test
    public void testSetFieldRowCol() {
        board.setField(0, 0, Mark.XX);
        assertEquals(Mark.XX, board.getField(0));
        assertEquals(Mark.EMPTY, board.getField(0, 1));
        assertEquals(Mark.EMPTY, board.getField(1, 0));
        assertEquals(Mark.EMPTY, board.getField(1, 1));
    }

    @Test
    public void testSetup() {
        assertEquals(Mark.EMPTY, board.getField(0));
        assertEquals(Mark.EMPTY, board.getField(Board.DIM * Board.DIM - 1));
    }

    @Test
    public void testReset() {
        board.reset();
        assertEquals(Mark.EMPTY, board.getField(0));
        assertEquals(Mark.EMPTY, board.getField(Board.DIM * Board.DIM - 1));
    }

    @Test
    public void testDeepCopy() {
        board.setField(0, Mark.XX);
        Board deepCopyBoard = board.deepCopy();
        deepCopyBoard.setField(0, Mark.OO);

        assertEquals(Mark.XX, board.getField(0));
        assertEquals(Mark.OO, deepCopyBoard.getField(0));
    }

    @Test
    public void testIsEmptyFieldIndex() {
        board.setField(0, Mark.XX);
        assertFalse(board.isEmptyField(0));
        assertTrue(board.isEmptyField(1));
    }

    @Test
    public void testIsEmptyFieldRowCol() {
        board.setField(0, 0, Mark.XX);
        assertFalse(board.isEmptyField(0, 0));
        assertTrue(board.isEmptyField(0, 1));
        assertTrue(board.isEmptyField(1, 0));
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < 8; i++) {
            board.setField(i, Mark.XX);
        }
        assertFalse(board.isFull());

        board.setField(8, Mark.XX);
        assertTrue(board.isFull());
    }

    @Test
    public void testGameOverFullBoard() {
        /**
         * xxo
         * oox
         * xxo
         */
        board.setField(0, 0, Mark.XX);
        board.setField(0, 1, Mark.XX);
        board.setField(0, 2, Mark.OO);
        board.setField(1, 0, Mark.OO);
        board.setField(1, 1, Mark.OO);
        board.setField(1, 2, Mark.XX);
        board.setField(2, 0, Mark.XX);
        board.setField(2, 1, Mark.OO);

        assertFalse(board.gameOver());
        board.setField(2, 2, Mark.XX);
        assertTrue(board.gameOver());
    }

    @Test
    public void testHasRow() {
        board.setField(0, Mark.XX);
        board.setField(1, Mark.XX);
        assertFalse(board.hasRow(Mark.XX));
        assertFalse(board.hasRow(Mark.OO));

        board.setField(2, Mark.XX);
        assertTrue(board.hasRow(Mark.XX));
        assertFalse(board.hasRow(Mark.OO));
    }

    @Test
    public void testHasColumn() {
        board.setField(0, Mark.XX);
        board.setField(3, Mark.XX);
        assertFalse(board.hasColumn(Mark.XX));
        assertFalse(board.hasColumn(Mark.OO));

        board.setField(6, Mark.XX);
        assertTrue(board.hasColumn(Mark.XX));
        assertFalse(board.hasColumn(Mark.OO));
    }

    @Test
    public void testHasDiagonalDown() {
        board.setField(0, 0, Mark.XX);
        board.setField(1, 1, Mark.XX);
        assertFalse(board.hasDiagonal(Mark.XX));
        assertFalse(board.hasDiagonal(Mark.OO));

        board.setField(2, 2, Mark.XX);
        assertTrue(board.hasDiagonal(Mark.XX));
        assertFalse(board.hasDiagonal(Mark.OO));
    }

    @Test
    public void testHasDiagonalUp() {
        board.setField(0, 2, Mark.XX);
        board.setField(1, 1, Mark.XX);
        assertFalse(board.hasDiagonal(Mark.XX));
        assertFalse(board.hasDiagonal(Mark.OO));

        board.setField(2, 0, Mark.XX);
        assertTrue(board.hasDiagonal(Mark.XX));
        assertFalse(board.hasDiagonal(Mark.OO));
    }

    @Test
    public void testIsWinner() {
        board.setField(0, Mark.XX);
        board.setField(1, Mark.XX);
        assertFalse(board.isWinner(Mark.XX));
        assertFalse(board.isWinner(Mark.OO));

        board.setField(2, Mark.XX);
        assertTrue(board.isWinner(Mark.XX));
        assertFalse(board.isWinner(Mark.OO));

        board.setField(0, 0, Mark.OO);
        board.setField(1, 1, Mark.OO);
        assertFalse(board.isWinner(Mark.XX));
        assertFalse(board.isWinner(Mark.OO));

        board.setField(2, 2, Mark.OO);
        assertFalse(board.isWinner(Mark.XX));
        assertTrue(board.isWinner(Mark.OO));
    }

    @Test
    public void testHasNoWinnerFullBoard() {
        /**
         * xxo
         * oox
         * xxo
         */
        board.setField(0, 0, Mark.XX);
        board.setField(0, 1, Mark.XX);
        board.setField(0, 2, Mark.OO);
        board.setField(1, 0, Mark.OO);
        board.setField(1, 1, Mark.OO);
        board.setField(1, 2, Mark.XX);
        board.setField(2, 0, Mark.XX);
        board.setField(2, 1, Mark.OO);
        board.setField(2, 2, Mark.XX);
        assertFalse(board.hasWinner());
    }

    @Test
    public void testHasWinnerRow() {
        board.setField(0, Mark.XX);
        board.setField(1, Mark.XX);
        assertFalse(board.hasWinner());

        board.setField(2, Mark.XX);
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerColumn() {
        board.setField(0, Mark.XX);
        board.setField(3, Mark.XX);
        assertFalse(board.hasWinner());

        board.setField(6, Mark.XX);
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonal() {
        board.setField(0, Mark.XX);
        board.setField(1, Mark.XX);
        assertFalse(board.hasWinner());

        board.setField(2, Mark.XX);
        assertTrue(board.hasWinner());
    }
}
