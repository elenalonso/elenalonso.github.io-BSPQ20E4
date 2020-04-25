package ui;

import javax.swing.JFrame;
import javax.swing.JList;

import client.EasyFilmController;
import easyFilminData.User;
import serialization.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MyLists extends JFrame{
	private JButton btnNewButton;
	private EasyFilmController controller;
	public MyLists(EasyFilmController cont) {
		this.controller = cont;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,450);
		setLocation(600,175);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(40, 75, 400, 300);
		getContentPane().add(list);
		
		btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 10, 25, 25);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserData usData = new UserData();
				UserUI u = new UserUI(usData, cont);
				u.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("My Lists:");
		lblNewLabel.setBounds(40, 52, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(220, 44, 220, 21);
		getContentPane().add(comboBox);
	}
	
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController("127.0.0.1","8080");

		MyLists ui = new MyLists(e);
		ui.setVisible(true);
	}

}
