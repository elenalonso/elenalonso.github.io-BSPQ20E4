package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import client.EasyFilmController;
import easyFilminData.User;
import serialization.UserData;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserLog extends JFrame{
	private EasyFilmController controller;
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JButton btnCreate;
	public UserLog(String hostname, String port) {
		
		controller = new EasyFilmController(hostname, port);
		
		this.setTitle( "EasyFilmin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(500,350);
		setLocation(600,175);
		setResizable(false);
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
		btnNewButton.setText("Login");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(329, 247, 100, 30);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// FUNCTIONALITY not implemented yet 
					// ATTENTION THIS MUST BE REMOVED AFTER DOING THESE TRIALS
				String pass = new String(passwordField.getPassword());
					// END OF REMOVABLE PART
				controller.login(textField.getText(), pass, "LoginHECHO");
				UserData us = new UserData();
				UserUI vg = new UserUI(us);
				vg.setSize(720, 480);
				vg.setVisible(true);
			}
		});
		
		btnCreate = new JButton();
		btnCreate.setText("Register");
		btnCreate.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCreate.setBounds(40, 247, 100, 30);
		getContentPane().add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserReg u = new UserReg(hostname,port);
				u.setVisible(true);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		
	}
		
}
