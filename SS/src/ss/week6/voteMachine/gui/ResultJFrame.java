package ss.week6.voteMachine.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import ss.week6.voteMachine.VoteList;

/**
 * P2 prac wk3.
 * UitslagJFrame: GUI voor een Uitslag.
 * @author  Arend Rensink en Theo Ruys
 * @version 2005.02.15
 */
public class ResultJFrame extends JFrame {
	// Grafische componenten
	private JTextArea resultField;
	private JLabel messageLabel;



	/** Construeert een UitslagJFrame die een gegeven uitslag observeert. */
	public ResultJFrame(VoteGUIView view) {
		// Initialisatie grafische componenten
		super("Result");
		Container cc = getContentPane();
		cc.setLayout(new FlowLayout());

		messageLabel = new JLabel("Votes:");
		cc.add(messageLabel);

		resultField = new JTextArea("", 10, 20);
		resultField.setEditable(false);
		cc.add(resultField);

		setSize(250, 255);

	}

	/** Zet de uitslag op het tekstveld, met 1 regel per partij. */
	public void update(Map<String,Integer> votes) {
		resultField.setText("");

		for(Map.Entry<String,Integer> entry: votes.entrySet()){
			resultField.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}

	}
}
