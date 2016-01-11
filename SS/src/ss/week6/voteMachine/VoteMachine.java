package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {

    private PartyList parties;
    private VoteList votes;
    private VoteView ui;
    
    public VoteMachine() {
	parties = new PartyList();
	votes = new VoteList();
	ui = new VoteGUIView(this);
	parties.addObserver(ui);
	votes.addObserver(ui);
    }
    
    public static void main(String[] args) {
	new VoteMachine().start();
    }
    
    public void start() {
	ui.start();
    }
    
    public void addParty(String party) {
	parties.addParty(party);
    }
    
    public void vote(String party) {
	votes.addVote(party);
    }
    
    public List<String> getParties() {
	return parties.getParties();
    }
    
    public Map<String, Integer> getVotes() {
	return votes.getVotes();
    }
}
