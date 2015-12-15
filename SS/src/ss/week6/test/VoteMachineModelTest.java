package ss.week6.test;

import org.junit.Before;
import org.junit.Test;
import ss.week6.voteMachine.PartyList;
import ss.week6.voteMachine.VoteList;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Testprogram for the model of the VoteMachine.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class VoteMachineModelTest {

    /** Testvariabele for a <tt>PartyList</tt> object. */
    private PartyList partyList;
    /** Testvariabele for a <tt>VoteList</tt> object. */
    private VoteList voteList;

    public static final String PARTY1 = "Party 1";
    public static final String PARTY2 = "Party 2";
    public static final String PARTY3 = "Party 3";

    @Before
    public void setUp() {
        partyList = new PartyList();
        voteList = new VoteList();
    }

    /** Test for the class <tt>PartyList</tt>.*/
    @Test
    public void partyListTest() {
        partyList.addParty(PARTY1);
        assertTrue(partyList.hasParty(PARTY1));
        assertFalse(partyList.hasParty(PARTY2));

        partyList.addParty(PARTY3);
        assertEquals(2, partyList.getParties().size());
    }

    /** Test for the class <tt>VoteList</tt>.*/
    @Test
    public void voteListTest() {
        assertTrue(voteList.getVotes() instanceof Map);

        assertEquals(null, voteList.getVotes().get(PARTY1));
        voteList.addVote(PARTY1);
        assertEquals(1, (int) voteList.getVotes().get(PARTY1));
    }
}
