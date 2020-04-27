package client.ui;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import client.controller.EasyFilmController;
import serialization.UserData;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateList extends JFrame {
	private JButton addFilm;
	private JButton exit;
	private JButton removeFilm;
	private JButton back;
	private JList<String> list;
	private DefaultListModel<String> dlmList;
	private JList<String> filmList;
	private DefaultListModel<String> dlmFilms;
	private JLabel available;
	private JLabel newList;
	private JButton save;
	private JTextField listName;
	private JTextField textField;
	
	public CreateList(UserData user, EasyFilmController controller) {
		
		/** This is the info of the creation of the window
		 * 
		 */
		 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550,430);
		setLocation(600,175);
		setResizable(false);
		getContentPane().setLayout(null);
		
		/** This is a Window that allows the user to create lists from scratch by moving films to one side to the other
		 * 
		 */
		
		/** This List loads every film available
		 * 
		 */
		
		list = new JList();
		list.setBounds(40, 40, 200, 300);
		getContentPane().add(list);
		
		available = new JLabel("Available Films");
		available.setFont(new Font("Tahoma", Font.BOLD, 10));
		available.setBounds(40, 10, 200, 20);
		getContentPane().add(available);
		
		/** This list shows every film that will be a part of the list
		 * 
		 */
		
		filmList = new JList();
		filmList.setBounds(311, 40, 200, 300);
		getContentPane().add(filmList);
		
		newList = new JLabel("Your New List");
		newList.setFont(new Font("Tahoma", Font.BOLD, 10));
		newList.setBounds(311, 10, 200, 20);
		getContentPane().add(newList);
		
		/** This buttons allow to move films to one list to the other
		 * 
		 */
		
		addFilm = new JButton(">");
		addFilm.setFont(new Font("Tahoma", Font.BOLD, 10));
		addFilm.setBounds(255, 130, 39, 39);
		getContentPane().add(addFilm);
		
		removeFilm = new JButton("<");
		removeFilm.setFont(new Font("Tahoma", Font.BOLD, 10));
		removeFilm.setBounds(255, 179, 39, 39);
		getContentPane().add(removeFilm);
		
		save = new JButton("SAVE");
		save.setFont(new Font("Tahoma", Font.BOLD, 10));
		save.setBounds(245, 310, 60, 30);
		getContentPane().add(save);
		
		back = new JButton("");
		back.setBounds(10, 10, 25, 25);
		getContentPane().add(back);
		
		exit = new JButton("");
		exit.setBounds(500, 11, 25, 25);
		getContentPane().add(exit);
		
		textField = new JTextField();
		textField.setBounds(40, 362, 473, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
//		btnNewButton_3.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				UserUI u = new UserUI();
//				u.setVisible(true);
//			}
//		});
		
		/** This part contains the different listeners of the window
		 * 
		 */
		
		/* This buttons allows to control the app 
		 * exitbtn allows to close the application 
		 * backbtn allows to go to the previous application
		 * */
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserUI ui = new UserUI(null, controller);
				ui.setVisible(true);
			}
		});
		
		/* This buttons allows to control the app 
		 * saves the list with the selected name
		 * */
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String listname = textField.getName();
				
			}
		});
		
		/* This buttons move films to one side to the other
		 * addFilm allows move a film from the full list of films to the one of the list 
		 * removeFilm allows to remove a film from the list
		 * */
		
		addFilm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		removeFilm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
