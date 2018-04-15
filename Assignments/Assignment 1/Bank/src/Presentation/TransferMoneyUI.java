
package Presentation;

import businnessLogic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

public class TransferMoneyUI extends JFrame {
	JPanel panel1 = new JPanel();
	JLabel l5;
	JTextField tfamount = new JTextField(10);
	JComboBox<String> comboIbanSrc;
	JComboBox<String> comboIbanDst;
	Access loggedclient = new Access();
	int idclient;
	private JButton b1 = new JButton(" Transfer ");

	TransferMoneyUI(int idclient) throws ClassNotFoundException {
		super("Transfer Money");
		this.idclient = idclient;
		setSize(400, 300);
		setLocation(500, 280);
		panel1.setLayout(null);

		JLabel l1 = new JLabel("Transfer from: ");
		l1.setBounds(100, 20, 150, 60);
		panel1.add(l1);

		JLabel l2 = new JLabel("To: ");
		l2.setBounds(100, 70, 150, 60);
		panel1.add(l2);

		ArrayList<String> ibansVector = loggedclient.getMyIBANs(idclient);
		
		String[] ibans=new String[20];
		 for(int i=0;i<ibansVector.size();i++) {
	        	ibans[i]=ibansVector.get(i);
		}

		comboIbanSrc = new JComboBox<String>(ibans);
		comboIbanSrc.setBounds(100, 60, 200, 20);
		panel1.add(comboIbanSrc);

		comboIbanDst = new JComboBox<String>(ibans);
		comboIbanDst.setBounds(100, 110, 200, 20);
		panel1.add(comboIbanDst);

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

	public void actionMyAccounts() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String ibansrc = comboIbanSrc.getSelectedItem().toString();
				String ibandst = comboIbanDst.getSelectedItem().toString();
				int amount = Integer.parseInt(tfamount.getText());
				try {
					if (tfamount.getText() == " ") {
						JOptionPane.showMessageDialog(null, "Enter an amount");
					} else {
						appendtexttolabel(loggedclient.transferMoney(ibansrc, ibandst, amount));
					}
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(TransferMoneyUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

		});

	}

}
