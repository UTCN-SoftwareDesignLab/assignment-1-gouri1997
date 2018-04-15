
package Presentation;

import businnessLogic.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUI extends JFrame {

	JPanel panellogin = new JPanel();
	JTextField tfuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);

	Icon warnIcon = new ImageIcon("src/Picture1.png");
	JButton button2 = new JButton(warnIcon);

	public LoginUI() {
		super("Login Autentification");
		setSize(300, 200);
		setLocation(500, 200);
		panellogin.setLayout(null);

		tfuser.setBounds(70, 30, 150, 20);
		pass.setBounds(70, 65, 150, 20);
		button2.setBounds(110, 100, 75, 18);

		panellogin.add(button2);
		panellogin.add(tfuser);
		panellogin.add(pass);

		getContentPane().add(panellogin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	LoginAccess log = new LoginAccess();

	public void actionlogin() {
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String usernamein = tfuser.getText();
				String passin = pass.getText();

				try {
					if (log.login(usernamein, passin).equals("client")) {
						ClientUi clientui = new ClientUi(log.getLoginClientId(usernamein, passin));
						System.out.println(log.getLoginClientId(usernamein, passin));
						clientui.setVisible(true);
						dispose();
					} else if (log.login(usernamein, passin).equals("admin")) {
						AdminUi adminui = new AdminUi();

						adminui.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
						tfuser.setText("");
						pass.setText("");
						tfuser.requestFocus();
					}
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}

}
