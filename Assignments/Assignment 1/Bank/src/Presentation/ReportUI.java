
package Presentation;

import businnessLogic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class ReportUI extends JFrame {
	JPanel panel1 = new JPanel();
	JComboBox<String> comboIbanSrc;
	private JButton b1 = new JButton(" Create Report ");
	Access loggedclient = new Access();
	Transactions transreport = new Transactions();

	JTextField tfamount = new JTextField(10);
	JTextField tfamount1 = new JTextField(10);
	int idclient;
	private Writer writer = null;
	int i = 0;

	ReportUI(int idclient) throws ClassNotFoundException {
		super("Create Report");
		this.idclient = idclient;

		setSize(400, 300);
		setLocation(500, 280);
		panel1.setLayout(null);

		JLabel l1 = new JLabel("Select an account: ");
		l1.setBounds(30, 5, 150, 60);
		panel1.add(l1);

		ArrayList<String> ibansVector = loggedclient.getMyIBANs(idclient);
		String[] ibans = new String[20];
		for (int i = 0; i < ibansVector.size(); i++) {
			ibans[i] = ibansVector.get(i);
		}
		comboIbanSrc = new JComboBox<String>(ibans);
		comboIbanSrc.setBounds(30, 50, 280, 20);
		panel1.add(comboIbanSrc);

		JLabel l3 = new JLabel("From date (yyyy-mm-dd): ");
		l3.setBounds(30, 80, 150, 60);
		panel1.add(l3);

		tfamount.setBounds(200, 100, 110, 20);
		panel1.add(tfamount);

		JLabel l4 = new JLabel("To date (yyyy-mm-dd): ");
		l4.setBounds(30, 120, 150, 60);
		panel1.add(l4);

		tfamount1.setBounds(200, 140, 110, 20);
		panel1.add(tfamount1);

		b1.setBounds(80, 170, 200, 20);
		panel1.add(b1);
		b1.setVisible(true);

		getContentPane().add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();

	}

	public void actionMyAccounts() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String ibansrc = comboIbanSrc.getSelectedItem().toString();
				String datefrom = tfamount.getText();
				String dateto = tfamount1.getText();
				try {
					System.out.println(transreport.getReport(datefrom, dateto, ibansrc));
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
				}

				try {
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Report.txt"), "utf-8"));

					System.lineSeparator();
					writer.write(transreport.getReport(datefrom, dateto, ibansrc));

				} catch (IOException ex) {

				} catch (ClassNotFoundException ex) {
					Logger.getLogger(ReportUI.class.getName()).log(Level.SEVERE, null, ex);
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
