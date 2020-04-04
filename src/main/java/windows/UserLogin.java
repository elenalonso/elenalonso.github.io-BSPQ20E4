package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserLogin extends JFrame{
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JButton exit;
	public UserLogin() {
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUser.setBounds(72, 73, 80, 23);
		getContentPane().add(lblUser);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpass.setBounds(72, 139, 80, 23);
		getContentPane().add(lblpass);
		
		textField = new JTextField();
		textField.setBounds(162, 72, 267, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 139, 267, 22);
		getContentPane().add(passwordField);
		
		btnNewButton = new JButton();
		btnNewButton.setText("Accept");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(329, 247, 100, 30);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaGeneral vg = new VentanaGeneral();
				vg.setSize(720, 480);
				vg.setVisible(true);
			}
		});
		
		exit = new JButton("X");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 5));
		exit.setBounds(441, 10, 35, 35);
		getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}