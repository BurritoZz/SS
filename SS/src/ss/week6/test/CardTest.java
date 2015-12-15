package ss.week6.test;

import org.junit.Before;
import org.junit.Test;
import ss.week6.cards.Card;

import java.io.*;

import static org.junit.Assert.assertEquals;


/**
 * Testprogram for the write and read methods in Card.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class CardTest {

    /** Testvariabele for a <tt>Card</tt> object. */
    private Card card;

    /** Path to where you will save the card files */
    private static final String PATH = ""; //Your path to the test folder

    @Before
    public void setUp() {
        card = new Card('H', 'J');
    }

    /** Test for writing and reading a card with text files.*/
    @Test
    public void testReadingWritingFiles() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(PATH + "card.txt"));
            card.write(writer);
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(PATH + "card.txt"));
            Card card2 = Card.read(reader);
            reader.close();
            assertEquals(card, card2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Test for writing and reading a card with data files.*/
    @Test
    public void testReadingWritingData() {
        try {
            DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(PATH + "card.dat"));
            card.write(dataOut);
            dataOut.close();

            DataInputStream dataIn = new DataInputStream(new FileInputStream(PATH + "card.dat"));
            Card card2 = Card.read(dataIn);
            dataIn.close();
            assertEquals(card, card2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Test for writing and reading a card with object files.*/
    @Test
    public void testReadingWritingObject() {
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(PATH + "card.obj"));
            card.write(objectOut);
            objectOut.close();

            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(PATH + "card.obj"));
            Card card2 = Card.read(objectIn);
            objectIn.close();
            assertEquals(card, card2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
