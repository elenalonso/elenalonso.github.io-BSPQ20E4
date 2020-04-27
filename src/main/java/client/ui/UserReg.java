package client.ui;

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

import client.controller.EasyFilmController;
import serialization.UserData;
import server.easyFilminData.User;

public class UserReg extends JFrame {
	
	private EasyFilmController controller;
	
	private JTextField textField;
	private WebTarget webtarget; 
	private JButton bBack;
	private JButton bexit;
	private JPasswordField passwordField;
	private Client client;
	private JLabel lblUser;
	private JLabel lblpass;
	private JLabel lblEmail;
	private JTextField textField_1;
	public UserReg(EasyFilmController controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(500,325);
		setLocation(600,175);
		setResizable(false);

		getContentPane().setLayout(null);
		
		lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUser.setBounds(72, 73, 80, 23);
		getContentPane().add(lblUser);
		
		lblpass = new JLabel("Password");
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
		
		bBack = new JButton();
		bBack.setText("Create");
		bBack.setFont(new Font("Verdana", Font.BOLD, 12));
		bBack.setBounds(100, 208, 100, 30);
		getContentPane().add(bBack);
			
		bexit = new JButton("X");
		bexit.setFont(new Font("Tahoma", Font.PLAIN, 5));
		bexit.setBounds(441, 10, 35, 35);
		getContentPane().add(bexit);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		lblEmail.setBounds(72, 141, 80, 23);
		getContentPane().add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 140, 267, 23);
		getContentPane().add(textField_1);
		
		/** This part is the one that implements the listeners of the different buttons
		 * 
		 */
		
		bBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLog u = new UserLog(controller);
				u.setVisible(true);
			}
		});
		
		bRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getSelectedText();
				String email = textField_1.getText();
				controller.registerUser(username,password,username,email);
				dispose();
				UserData us = new UserData();
				UserUI u = new UserUI(us, controller);
				u.setSize(500, 350);
				u.setVisible(true);
			}
		});
				
	}
}
