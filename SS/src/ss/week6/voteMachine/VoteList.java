package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable{
    
    Map<String, Integer> votes = new HashMap<String, Integer>();
    
    public void addVote(String party) {
	if (votes.containsKey(party)) {
	   int currVote = votes.get(party);
	   votes.remove(party);
	   votes.put(party, currVote + 1); 
	} else {
	    votes.put(party, 1);
	}
	setChanged();
	notifyObservers("vote");
    }
    
    public Map<String, Integer> getVotes() {
	return votes;
    }
}