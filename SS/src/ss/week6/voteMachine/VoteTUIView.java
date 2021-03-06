package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class VoteTUIView  implements Observer, VoteView{

    VoteMachine vm;
    
    public VoteTUIView(VoteMachine vm) {
	this.vm = vm;
    }

    public void showVotes(Map<String,Integer> map) {
	for (String k : map.keySet()) {
	    System.out.println(k + " (" + map.get(k) + ")");
	}
    }

    public void showParties(List<String> list) {
	for (String k : list) {
	    System.out.println(k);
	}
    }

    public void showError(String e) {
	System.out.println(e);
    }

    /**
     * Deze code werkt.
     * In het geval dat de code niet werkt, werkt hij niet.
     */
    public void start() {
	String answer, answerp1, answerpr = null;
	Scanner scanner = new Scanner(System.in);
	while (true) {
	   System.out.println("Type one of the following commands:");
	   System.out.println("VOTE [party], ADD PARTY [party], VOTES, PARTIES, EXIT or HELP");
	   answer = scanner.hasNextLine() ? scanner.nextLine() : null;
	   Scanner scanner2 = new Scanner(answer);
	   answerp1 = scanner2.next();
	   if (answer.toUpperCase().equals("EXIT")) {
	       break;
	   } else if (answer.toUpperCase().equals("VOTES")) {
	       showVotes(vm.getVotes());
	   } else if (answer.toUpperCase().equals("PARTIES")) {
	       showParties(vm.getParties());
	   } else if (answer.toUpperCase().equals("HELP")) {
	       System.out.println("Call 911");
	   } else if (answer.toUpperCase().contains("VOTE")) {
	       answerpr = scanner2.nextLine();
	       vm.addVote(answerpr.trim());
	   } else if (answer.toUpperCase().contains("ADD PARTY")) {
	       answerp1 = scanner2.next();
	       answerpr = scanner2.nextLine();
	       vm.addParty(answerpr.trim());
	   } else {
	       System.out.println("Error: command not recognised.");
	   }
	   scanner2.close();
	}   
	scanner.close();
    }

    @Override
    public void update(Observable o, Object arg) {
	System.out.println(arg + " added!");
    }
}