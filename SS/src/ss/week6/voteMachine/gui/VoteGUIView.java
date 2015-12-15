package ss.week6.voteMachine.gui;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

import ss.week6.voteMachine.PartyList;
import ss.week6.voteMachine.VoteList;
import ss.week6.voteMachine.VoteMachine;
import ss.week6.voteMachine.VoteView;

public class VoteGUIView implements VoteView {
	private VoteMachine voteMachine;
	private VoteFrame voteFrame;
	private ResultJFrame uitslagJFrame;

	public VoteGUIView(VoteMachine machine) {
		this.voteMachine = machine;
	}

	public void start() {
		VoteFrame stemFrame = new VoteFrame(this);
		ResultJFrame uitslagJFrame = new ResultJFrame(this);

		uitslagJFrame.setVisible(true);
		stemFrame.setVisible(true);

		this.uitslagJFrame = uitslagJFrame;
		this.voteFrame = stemFrame;

		boolean running = true;
		while (running) {
			String line = readString("What is your command? ");
			String[] words = line.split(" ");
			if (words.length == 3 && words[0].equals("ADD")
					&& words[1].equals("PARTY")) {
				this.voteMachine.addParty(words[2]);
			} else if (words.length == 1 && words[0].equals("PARTIES")) {
				this.voteMachine.getParties();
			} else if (words.length == 1 && words[0].equals("EXIT")) {
				running = false;
			} else {
				print("Unknown command");
			}
		}
	}

	public VoteMachine getVoteMachine() {
		return this.voteMachine;
	}

	public void showVotes(Map<String, Integer> votes) {
		this.uitslagJFrame.update(votes);
	}

	public void showParties(List<String> parties) {
		this.voteFrame.update(parties);
	}

	public void showError(String message) {
		print("Oops: " + message);
	}

	@Override
	public void update(Observable object, Object argument) {
		if (argument instanceof String) {
			if (argument.equals("party")) {
				this.voteFrame.update(((PartyList) object).getParties());
			} else if (argument.equals("vote")) {
				this.uitslagJFrame.update(((VoteList) object).getVotes());
			}
		}

	}

	private static Scanner in = new Scanner(System.in);

	private static void print(String message) {
		System.out.println(message);
	}

	private static String readString(String prompt) {
		String result = null;
		System.out.print(prompt);
		if (in.hasNextLine()) {
			result = in.nextLine();
		}
		return result;
	}
}
