
package Presentation;

import businnessLogic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientUi extends JFrame {

	Icon myAccountsIcon = new ImageIcon("src/myaccounts.png");
	JButton button1 = new JButton(myAccountsIcon);
	JLabel label1 = new JLabel("<html><font color='white'>My Accounts</font></html>");

	Icon transferIcon = new ImageIcon("src/transferMoney.png");
	JButton button2 = new JButton(transferIcon);
	JLabel label2 = new JLabel("<html><font color='white'>Transfer Money</font></html>");

	Icon payIcon = new ImageIcon("src/payBills.png");
	JButton button3 = new JButton(payIcon);
	JLabel label3 = new JLabel("<html><font color='white'>Pay Bills</font></html>");

	Icon repIcon = new ImageIcon("src/report.png");
	JButton button4 = new JButton(repIcon);
	JLabel label4 = new JLabel("<html><font color='white'>Create Report</font></html>");

	JPanel panel = new JPanel();
	Access loggedclient = new Access();

	int idclient;

	public ClientUi(int idclient) {

		super("Manage your accounts");
		this.idclient = idclient;
		setSize(300, 300);
		setLocation(500, 280);
		panel.setLayout(null);

		button1.setBounds(20, 20, 100, 80);
		panel.add(button1);
		label1.setBounds(35, 95, 100, 30);
		panel.add(label1);

		button2.setBounds(160, 20, 100, 80);
		panel.add(button2);
		label2.setBounds(165, 95, 100, 30);
		panel.add(label2);

		button3.setBounds(20, 140, 100, 80);
		panel.add(button3);
		label3.setBounds(40, 215, 100, 30);
		panel.add(label3);

		button4.setBounds(160, 140, 100, 80);
		panel.add(button4);
		label4.setBounds(165, 215, 100, 30);
		panel.add(label4);

		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		actionMyAccounts();
	}

	public int getIdclient() {
		return idclient;
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
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				MyAccountsUi myaccountsui = null;
				try {
					myaccountsui = new MyAccountsUi(idclient);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ClientUi.class.getName()).log(Level.SEVERE, null, ex);
				}
				myaccountsui.setVisible(true);

			}

		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				TransferMoneyUI mytransferui = null;
				try {
					mytransferui = new TransferMoneyUI(idclient);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ClientUi.class.getName()).log(Level.SEVERE, null, ex);
					JOptionPane.showMessageDialog(null, "Enter id");
				}
				mytransferui.setVisible(true);

			}

		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PayBillsUI payUI = null;
				try {
					payUI = new PayBillsUI(idclient);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ClientUi.class.getName()).log(Level.SEVERE, null, ex);
				}
				payUI.setVisible(true);

			}

		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ReportUI repUI = null;
				try {
					repUI = new ReportUI(idclient);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ClientUi.class.getName()).log(Level.SEVERE, null, ex);
				}
				repUI.setVisible(true);

			}

		});

	}

}
