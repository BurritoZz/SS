package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observer;

public interface VoteView extends Observer {
    public void start();
    public void showVotes(Map<String, Integer> votes);
    public void showParties(List<String> parties);
    public void showError(String message);

}
