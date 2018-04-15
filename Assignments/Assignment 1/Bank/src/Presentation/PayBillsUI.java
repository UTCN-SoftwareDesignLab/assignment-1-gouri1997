
package Presentation;

import businnessLogic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayBillsUI extends JFrame {

	JPanel panel1 = new JPanel();
	JLabel l5;
	JTextField tfamount = new JTextField(10);
	JComboBox<String> comboIbanSrc;
	JComboBox<String> comboIbanDst;
	Access loggedclient = new Access();
	RecipientsAccess recipaccess = new RecipientsAccess();
	int idclient;
	private JButton b1 = new JButton(" Pay ");

	PayBillsUI(int idclient) throws ClassNotFoundException {

		super("Pay Bills");
		this.idclient = idclient;
		setSize(400, 320);
		setLocation(500, 280);
		panel1.setLayout(null);

		JLabel l1 = new JLabel("Pay from: ");
		l1.setBounds(100, 20, 150, 60);
		panel1.add(l1);

		JLabel l2 = new JLabel("Select Recipient Account: ");
		l2.setBounds(100, 70, 150, 60);
		panel1.add(l2);

		String[] ibansRecip = new String[20];
		ArrayList<String> ibansRecipVector = recipaccess.getallRecip();

		for (int i = 0; i < ibansRecipVector.size(); i++) {
			ibansRecip[i] = ibansRecipVector.get(i);
		}
		comboIbanDst = new JComboBox<String>(ibansRecip);
		comboIbanDst.setBounds(100, 110, 200, 20);
		panel1.add(comboIbanDst);

		String[] ibans = new String[20];
		ArrayList<String> ibansVector = loggedclient.getMyIBANs(idclient);
		for (int i = 0; i < ibansVector.size(); i++) {
			ibans[i] = ibansVector.get(i);
		}

		comboIbanSrc = new JComboBox<String>(ibans);
		comboIbanSrc.setBounds(100, 60, 200, 20);
		panel1.add(comboIbanSrc);

		JLabel l3 = new JLabel("Amount: ");
		l3.setBounds(100, 130, 80, 60);
		panel1.add(l3);

		tfamount.setBounds(200, 150, 100, 20);
		panel1.add(tfamount);

		b1.setBounds(100, 190, 200, 20);
		panel1.add(b1);
		b1.setVisible(true);

		l5 = new JLabel();
		l5.setBounds(100, 210, 200, 60);
		panel1.add(l5);

		getContentPane().add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();

	}

	public void appendtexttolabel(String str) {
		l5.setText(str);

	}

	public boolean test(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void actionMyAccounts() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String ibansrc = comboIbanSrc.getSelectedItem().toString();
				String ibandst = comboIbanDst.getSelectedItem().toString();
				try {
					if (test(tfamount.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Enter an amount");
					} else {
						int amount = Integer.parseInt(tfamount.getText());
						appendtexttolabel(loggedclient.payBills(ibansrc, ibandst, amount));
					}
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(PayBillsUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
		});

	}
}
