package ss.week6.challenge.ttt;


/**
 * Class for maintaining the Tic Tac Toe game. Lab assignment Module 2
 * 
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Game
{

    // -- Instance variables -----------------------------------------

    /*@
       private invariant board != null;
     */
    /**
     * The board.
     */
    private Board board;

    /**
     * Index of the current player.
     */
    private Mark current;

    // -- Constructors -----------------------------------------------

    public Game() {
        board = new Board();
        current = Mark.XX;
    }

    // -- Queries ----------------------------------------------------

    /**
     * Returns the board.
     */
    public /*@ pure */ Board getBoard() {
        return board;
    }

    /**
     * Returns the mark of the player whose turn it is.
     */
    public /*@ pure */ Mark getCurrent() {
        return current;
    }


    // -- Commands ---------------------------------------------------


    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
    public void reset() {
        current = Mark.XX;
        board.reset();
    }

    /*@
       requires 0 <= i & i < Board.DIM * Board.DIM;
       requires this.getBoard().isEmptyField(i);
     */
    /**
     * Sets the current mark in field i. 
     * Passes the turn to the other mark.
     * @param    i the index of the field where to place the mark
     */
    public void takeTurn(int i) {
        board.setField(i, current);
        current = current.other();
    }


}
