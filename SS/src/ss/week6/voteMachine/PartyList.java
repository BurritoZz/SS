package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable{
    
    private List<String> parties;
    
    public PartyList() {
	parties = new ArrayList<String>();
    }
    
    public void addParty(String party) {
    	if (party != null && !parties.contains(party)) {
	    parties.add(party);
	}
    	setChanged();
	notifyObservers("party");
    }
    
    public boolean hasParty(String party) {
	return parties.contains(party);
    }

    public List<String> getParties() {
	return parties;
    }
    
}