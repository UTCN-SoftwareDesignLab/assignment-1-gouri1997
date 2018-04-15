
package Presentation;

import businnessLogic.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CRUDAccountsUI extends JFrame {
	JPanel panel1 = new JPanel();
	JTabbedPane panel = new JTabbedPane();
	JPanel panel2 = new JPanel(null);
	JPanel panel3 = new JPanel(null);
	JPanel panel4 = new JPanel(null);
	private JLabel label2 = new JLabel(" Insert Account: ");
	private JLabel label24 = new JLabel(" Delete Account: ");

	private JLabel label4 = new JLabel("IBAN:");
	private JLabel label5 = new JLabel("Amount:");
	private JLabel label6 = new JLabel("Currency:");
	private JLabel label7 = new JLabel("Account Type:");
	private JLabel label77 = new JLabel("ID Client:");

	private JLabel label21 = new JLabel("Update Account with IBAN = ");
	private JLabel label41 = new JLabel("Amount:");
	private JLabel label51 = new JLabel("Currency:");
	private JLabel label61 = new JLabel("Account Type:");

	private JLabel label9 = new JLabel("Insert Account IBAN: ");

	JLabel l5;
	JLabel l10;
	JLabel l64;

	private JTextField tf1 = new JTextField(15);
	private JTextField tf2 = new JTextField(15);
	private JTextField tf3 = new JTextField(15);
	private JTextField tf4 = new JTextField(15);
	private JTextField tf5 = new JTextField(15);
	private JTextField tf57 = new JTextField(15);

	private JTextField tf11 = new JTextField(15);
	private JTextField tf21 = new JTextField(15);
	private JTextField tf31 = new JTextField(15);
	private JTextField tf41 = new JTextField(15);
	private JTextField tf51 = new JTextField(15);

	private JTextField tf6 = new JTextField(15);

	private JTextField tf64 = new JTextField(15);

	private JButton button1 = new JButton(" INSERT ");
	private JButton button2 = new JButton(" SEARCH ");
	private JButton button3 = new JButton(" UPDATE ");
	private JButton button4 = new JButton(" DELETE ");

	private JTextArea textArea;

	ClientsAccess adclient = new ClientsAccess();
	Access accountcrud = new Access();

	CRUDAccountsUI() {
		super("Administrate Accounts Table");

		setSize(400, 380);
		setLocation(500, 280);
		panel1.setLayout(null);

		label2.setBounds(10, 30, 120, 50);
		panel1.add(label2);
		label2.setVisible(true);

		label4.setBounds(10, 60, 120, 50);
		panel1.add(label4);
		label4.setVisible(true);

		tf2.setBounds(100, 75, 100, 18);
		panel1.add(tf2);
		tf2.setVisible(true);

		label5.setBounds(10, 90, 120, 50);
		panel1.add(label5);
		label5.setVisible(true);

		tf3.setBounds(100, 105, 100, 18);
		panel1.add(tf3);
		tf3.setVisible(true);

		label6.setBounds(10, 120, 120, 50);
		panel1.add(label6);
		label6.setVisible(true);

		tf4.setBounds(100, 135, 100, 18);
		panel1.add(tf4);
		tf4.setVisible(true);

		label7.setBounds(10, 150, 120, 50);
		panel1.add(label7);
		label7.setVisible(true);

		tf5.setBounds(100, 165, 100, 18);
		panel1.add(tf5);
		tf5.setVisible(true);

		label77.setBounds(10, 180, 120, 50);
		panel1.add(label77);
		label77.setVisible(true);

		tf57.setBounds(100, 195, 100, 18);
		panel1.add(tf57);
		tf57.setVisible(true);

		button1.setBounds(10, 220, 190, 20);
		panel1.add(button1);
		button1.setVisible(true);

		l10 = new JLabel();
		l10.setBounds(10, 230, 200, 60);
		panel1.add(l10);

		label9.setBounds(10, 30, 120, 50);
		panel2.add(label9);
		label9.setVisible(true);

		tf6.setBounds(130, 48, 100, 18);
		panel2.add(tf6);
		tf6.setVisible(true);

		textArea = new JTextArea(40, 80);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		Font font = new Font("Verdana", Font.BOLD, 11);
		textArea.setFont(font);
		textArea.setForeground(Color.BLACK);

		textArea.setEditable(false);

		JScrollPane scrollPaneA = new JScrollPane(textArea);
		scrollPaneA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		panel2.add(scrollPaneA);
		scrollPaneA.setBounds(10, 130, 200, 100);
		textArea.append("");

		button2.setBounds(10, 90, 190, 20);
		panel2.add(button2);
		button2.setVisible(true);

		label21.setBounds(10, 30, 200, 50);
		panel3.add(label21);
		label21.setVisible(true);

		tf11.setBounds(170, 45, 100, 18);
		panel3.add(tf11);
		tf11.setVisible(true);

		label41.setBounds(10, 60, 120, 50);
		panel3.add(label41);
		label41.setVisible(true);

		tf21.setBounds(100, 75, 100, 18);
		panel3.add(tf21);
		tf21.setVisible(true);

		label51.setBounds(10, 90, 120, 50);
		panel3.add(label51);
		label51.setVisible(true);

		tf31.setBounds(100, 105, 100, 18);
		panel3.add(tf31);
		tf31.setVisible(true);

		label61.setBounds(10, 120, 120, 50);
		panel3.add(label61);
		label61.setVisible(true);

		tf41.setBounds(100, 135, 100, 18);
		panel3.add(tf41);
		tf41.setVisible(true);

		button3.setBounds(10, 165, 190, 20);
		panel3.add(button3);
		button3.setVisible(true);

		l5 = new JLabel();
		l5.setBounds(10, 180, 200, 60);
		panel3.add(l5);
		///////////////////////////////////////////////

		label24.setBounds(10, 30, 120, 50);
		panel4.add(label24);
		label24.setVisible(true);

		tf64.setBounds(130, 45, 100, 18);
		panel4.add(tf64);
		tf64.setVisible(true);

		button4.setBounds(10, 70, 190, 20);
		panel4.add(button4);
		button4.setVisible(true);

		l64 = new JLabel();
		l64.setBounds(10, 100, 200, 60);
		panel4.add(l64);

		panel.addTab("  Insert Account  ", panel1);
		panel.addTab("  Read Account  ", panel2);
		panel.addTab("  Update Account  ", panel3);
		panel.addTab("  Delete Account  ", panel4);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();

	}

	public void appendtext(String str) {
		textArea.setText("");
		textArea.append(str);
	}

	public boolean test(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void appendtexttolabel(String str) {
		l5.setText(str);

	}

	// INSERT
	public void actionMyAccounts() {
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String euro = "EURO";
				String ron = "RON";

				String spending = "Spending";
				String saving = "Saving";
				try {
					/*
					 * if (tf2.getText().equals("") || tf3.getText().equals("") ||
					 * tf4.getText().equals("") || tf5.getText().equals("") ||
					 * tf57.getText().equals("")) { JOptionPane.showMessageDialog(null,
					 * "Incorrect data!!"); } if (Integer.parseInt(tf3.getText()) < 0) {
					 * JOptionPane.showMessageDialog(null, "Negative balance!!"); } if
					 * (!(tf4.getText().equals(euro))) { JOptionPane.showMessageDialog(null,
					 * "Incorrect currency"); } if (!(tf4.getText().equals(ron))) {
					 * JOptionPane.showMessageDialog(null, "Incorrect currency"); } if
					 * (!(tf5.getText().equals(spending))) { JOptionPane.showMessageDialog(null,
					 * "Account can only be Saving/Spending"); } if
					 * (!(tf5.getText().equals(saving))) { JOptionPane.showMessageDialog(null,
					 * "Account can only be Saving/Spending"); }
					 */
					// else {
					l10.setText(accountcrud.insertAcc(tf2.getText(), Integer.parseInt(tf3.getText()), tf4.getText(),
							tf5.getText(), Integer.parseInt(tf57.getText())));
					// }

				} catch (ClassNotFoundException ex) {
					Logger.getLogger(CRUDAccountsUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (tf6.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Entered account type is wrong!");
				} else {
					try {
						appendtext(accountcrud.getAccDetails(tf6.getText()));
					} catch (ClassNotFoundException ex) {
						Logger.getLogger(CRUDAccountsUI.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String euro = "EURO";
				String ron = "RON";
				String spending = "Spending";
				String saving = "Saving";
				try {
					if (Integer.parseInt(tf21.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "Negative balance!");
					}
					if (!(tf41.getText().equals(spending))) {
						JOptionPane.showMessageDialog(null, "Account can only be Saving/Spending");
					}
					if (!(tf41.getText().equals(saving))) {
						JOptionPane.showMessageDialog(null, "Account can only be Saving/Spending");
					}
					if (!(tf31.getText().equals(euro))) {
						JOptionPane.showMessageDialog(null, "Incorrect currency");
					}
					if (!(tf31.getText().equals(ron))) {
						JOptionPane.showMessageDialog(null, "Incorrect currency");
					} else {
						appendtexttolabel(accountcrud.updateAcc(Integer.parseInt(tf21.getText()), tf31.getText(),
								tf41.getText(), tf11.getText()));
					}
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(CRUDAccountsUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String textID = tf64.getText();
				if (tf64.getText() == "") {
					JOptionPane.showMessageDialog(null, "Introduce an ID");
				} else {
					try {
						l64.setText(accountcrud.deleteAcc(tf64.getText()));
					} catch (ClassNotFoundException ex) {
						Logger.getLogger(CRUDAccountsUI.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});

	}

}
