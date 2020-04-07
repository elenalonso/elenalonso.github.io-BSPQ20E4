package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import serialization.UserData;

public class UserReg extends JFrame {
	private JTextField textField;
	private WebTarget webtarget; 
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JButton exit;
	private Client client;
	private JLabel lblEmail;
	private JTextField textField_1;
	public UserReg(String hostname, String port) {
		client = ClientBuilder.newClient();
		webtarget = client.target(String.format("http://%s:%s/rest", hostname, port));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(500,325);
		setLocation(600,175);
		setResizable(false);

		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUser.setBounds(72, 73, 80, 23);
		getContentPane().add(lblUser);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Verdana", Font.BOLD, 12));
		lblpass.setBounds(72, 106, 80, 23);
		getContentPane().add(lblpass);
		
		textField = new JTextField();
		textField.setBounds(162, 72, 267, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 108, 267, 22);
		getContentPane().add(passwordField);
		
		btnNewButton = new JButton();
		btnNewButton.setText("Create");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(376, 208, 100, 30);
		getContentPane().add(btnNewButton);
		
//		btnNewButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				UserLog u = new UserLog();
//				u.setSize(500, 350);
//				u.setVisible(true);
//			}
//		});
			
		exit = new JButton("X");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 5));
		exit.setBounds(441, 10, 35, 35);
		getContentPane().add(exit);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(72, 141, 80, 23);
		getContentPane().add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 140, 267, 23);
		getContentPane().add(textField_1);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getSelectedText();
				String email = textField_1.getText();
				sendRegistration(username,password,username,email);
				dispose();
				UserReg u = new UserReg(null, null);
				u.setSize(500, 350);
				u.setVisible(true);
			}
		});
		
	}
	public void sendRegistration(String username, String password, String icon, String email) {
		WebTarget registerTarget = webtarget.path("server/register");
		Invocation.Builder invocationBuilder = registerTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userdata = new UserData();
		Response response = invocationBuilder.post(Entity.entity(userdata, MediaType.APPLICATION_JSON));
		
	}
}
