
package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminUi extends JFrame {
	JPanel panel1 = new JPanel();

	private JButton b1 = new JButton(" Administrate Clients Table ");
	private JButton b2 = new JButton(" Administrate Accounts Table ");
	private JButton b3 = new JButton(" Create Report ");

	AdminUi() {
		super("Account details");

		setSize(370, 250);
		setLocation(500, 280);
		panel1.setLayout(null);

		b1.setBounds(50, 20, 250, 40);
		panel1.add(b1);
		b1.setVisible(true);

		b2.setBounds(50, 80, 250, 40);
		panel1.add(b2);
		b2.setVisible(true);

		b3.setBounds(50, 140, 250, 40);
		panel1.add(b3);
		b3.setVisible(true);

		getContentPane().add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		actionMyAccounts();

	}

	public void actionMyAccounts() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				CRUDClientsUI crudclui = new CRUDClientsUI();
				crudclui.setVisible(true);
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				CRUDAccountsUI crudaccui = new CRUDAccountsUI();
				crudaccui.setVisible(true);
			}

		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				AdminReportUI adminreportui = new AdminReportUI();
				adminreportui.setVisible(true);
			}

		});

	}
}
