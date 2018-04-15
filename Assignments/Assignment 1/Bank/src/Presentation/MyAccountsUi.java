
package Presentation;

import businnessLogic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class MyAccountsUi extends JFrame {

	JPanel panel1 = new JPanel();
	private JTextArea textArea;

	JComboBox<String> comboIbans;
	JTextArea detailsText = new JTextArea(6, 20);

	Access loggedclient = new Access();
	int idclient;

	MyAccountsUi(int idclient) throws ClassNotFoundException {

		super("Account details");
		this.idclient = idclient;
		setSize(400, 400);
		setLocation(500, 280);
		panel1.setLayout(null);

		JLabel l1 = new JLabel("Select account: ");
		l1.setBounds(100, 20, 150, 60);
		panel1.add(l1);

		String[] ibans = new String[20];
		ArrayList<String> ibansVector = loggedclient.getMyIBANs(idclient);
		for (int i = 0; i < ibansVector.size(); i++) {
			ibans[i] = ibansVector.get(i);
		}

		comboIbans = new JComboBox<String>(ibans);
		comboIbans.setBounds(100, 60, 200, 20);
		panel1.add(comboIbans);

		textArea = new JTextArea(40, 80);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		Font font = new Font("Verdana", Font.BOLD, 11);
		textArea.setFont(font);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		JScrollPane scrollPaneA = new JScrollPane(textArea);
		scrollPaneA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel1.add(scrollPaneA);
		scrollPaneA.setBounds(100, 100, 200, 150);
		textArea.append("");

		getContentPane().add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();
	}

	public void appendtext(String str) {
		textArea.setText("");
		textArea.append(str);
	}

	public void actionMyAccounts() {
		comboIbans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				JComboBox<String> combo = (JComboBox<String>) ae.getSource();

				String details = new String();
				try {
					details = loggedclient.getAccDetails(comboIbans.getSelectedItem().toString());
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(MyAccountsUi.class.getName()).log(Level.SEVERE, null, ex);
				}
				appendtext(details);

			}

		});

	}

}
