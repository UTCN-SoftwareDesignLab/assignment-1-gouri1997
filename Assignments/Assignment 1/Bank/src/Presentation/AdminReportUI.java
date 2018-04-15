
package Presentation;

import businnessLogic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminReportUI extends JFrame {
	JPanel panel1 = new JPanel();
	private JButton b1 = new JButton(" Create Report ");
	Transactions transreport = new Transactions();
	JTextField tfamount = new JTextField(10);
	JTextField tfamount1 = new JTextField(10);
	private Writer writer = null;
	JLabel l9;

	AdminReportUI() {

		super("Create Report");
		setSize(400, 300);
		setLocation(500, 280);
		panel1.setLayout(null);

		JLabel l1 = new JLabel("Create Report: ");
		l1.setBounds(30, 20, 150, 60);
		panel1.add(l1);

		JLabel l3 = new JLabel("From date (yyyy-mm-dd): ");
		l3.setBounds(30, 50, 150, 60);
		panel1.add(l3);

		tfamount.setBounds(200, 70, 110, 20);
		panel1.add(tfamount);

		JLabel l4 = new JLabel("To date (yyyy-mm-dd): ");
		l4.setBounds(30, 90, 150, 60);
		panel1.add(l4);

		tfamount1.setBounds(200, 110, 110, 20);
		panel1.add(tfamount1);

		b1.setBounds(80, 140, 200, 20);
		panel1.add(b1);
		b1.setVisible(true);

		l9 = new JLabel();
		l9.setBounds(30, 170, 150, 60);
		panel1.add(l9);

		getContentPane().add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();

	}

	public void actionMyAccounts() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String datefrom = tfamount.getText();
				String dateto = tfamount1.getText();

				try {
					if (tfamount.getText() == " " && tfamount1.getText() == " ") {
						JOptionPane.showMessageDialog(null, "Enter data!");
					} else {
						writer = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream("ReportAdmin.txt"), "utf-8"));

						System.lineSeparator();
						writer.write(transreport.getReportbyAdmin(datefrom, dateto));
						System.out.println(transreport.getReportbyAdmin("2016-02-02", "2016-03-30"));

						System.out.println("********");
						l9.setText("Report created!");
					}

				} catch (IOException ex) {

				} catch (ClassNotFoundException ex) {
					Logger.getLogger(AdminReportUI.class.getName()).log(Level.SEVERE, null, ex);
				} finally {
					try {
						writer.close();
					} catch (Exception ex) {
					}
				}

			}
		});

	}

}
