package ss.week6.voteMachine.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VoteFrame extends JFrame {
	private static final String INIT_MESSAGE = "(Choose a party)";
	// Graphical components components
	private JComboBox partyChoice;
	private JButton okButton;
	private JLabel messageLabel;

	protected VoteGUIView view;

	/**
	 * Construeert een StemFrame voor een aangegeven Uitslag.
	 * 
	 * @require uitslag != null
	 */
	public VoteFrame(VoteGUIView view) {
		// Initialisation of graphical components
		super("Voting");

		this.view = view;
		setLayout(new BorderLayout());

		messageLabel = new JLabel("Make your choice");
		add(messageLabel, BorderLayout.NORTH);

		partyChoice = new JComboBox();
		partyChoice.addItem(INIT_MESSAGE);
		add(partyChoice, BorderLayout.CENTER);

		okButton = new JButton("OK");
		okButton.setEnabled(false);
		add(okButton, BorderLayout.EAST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		partyChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (partyChoice.getSelectedIndex() > 0) {
					messageLabel.setText("Change your choice or press \"OK\"");
					okButton.setEnabled(true);
				} else {
					messageLabel.setText("Make your choice");
					okButton.setEnabled(false);
				}
			}
		});

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VoteFrame.this.view.getVoteMachine().vote(
						(String) partyChoice.getSelectedItem());
				partyChoice.setSelectedIndex(0);
				messageLabel.setText("Make your choice");
				okButton.setEnabled(false);
			}
		});
		pack();
	}

	/**
	 * Ververst de lijst partijen in de <code>Choice</code> op basis van de
	 * waargenomen verandering in de <code>Uitslag</code>
	 */
	public void update(List<String> parties) {
		partyChoice.setEnabled(false);
		partyChoice.removeAllItems();
		partyChoice.addItem(INIT_MESSAGE);
		for (String party : parties) {
			partyChoice.addItem(party);
		}
		partyChoice.setEnabled(true);
	}
}
