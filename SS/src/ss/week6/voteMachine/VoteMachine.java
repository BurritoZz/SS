package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

public class VoteMachine {

    private PartyList parties;
    private VoteList votes;
    private VoteTUIView vtui;
    
    public VoteMachine() {
	parties = new PartyList();
	votes = new VoteList();
	vtui = new VoteTUIView(this);
    }
    
    public static void main(String[] args) {
	new VoteMachine().start();
    }
    
    public void start() {
	vtui.start();
    }
    
    public void addParty(String party) {
	parties.addParty(party);
    }
    
    public void addVote(String party) {
	votes.addVote(party);
    }
    
    public List<String> getParties() {
	return parties.getParties();
    }
    
    public Map<String, Integer> getVotes() {
	return votes.getVotes();
    }
}
