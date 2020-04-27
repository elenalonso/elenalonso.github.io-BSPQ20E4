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
	private JTextField listName;
	
	public CreateList(UserData user, EasyFilmController controller) {
		
		/** This is the info of the creation of the window
		 * 
		 */
		 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550,400);
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
		available.setFont(new Font("Verdana", Font.BOLD, 12));
		available.setBounds(40, 10, 200, 20);
		getContentPane().add(available);
		
		/** This list shows every film that will be a part of the list
		 * 
		 */
		
		filmList = new JList();
		filmList.setBounds(311, 40, 200, 300);
		getContentPane().add(filmList);
		
		newList = new JLabel("Your New List");
		newList.setFont(new Font("Verdana", Font.BOLD, 12));
		newList.setBounds(311, 10, 200, 20);
		getContentPane().add(newList);
		
		/** This buttons allow to move films to one list to the other
		 * 
		 */
		
		addFilm = new JButton(">");
		addFilm.setBounds(255, 130, 39, 39);
		getContentPane().add(addFilm);
		
		removeFilm = new JButton("<");
		removeFilm.setBounds(255, 179, 39, 39);
		getContentPane().add(removeFilm);
		
		JButton btnNewButton_2 = new JButton("SAVE");
		btnNewButton_2.setBounds(245, 310, 60, 30);
		getContentPane().add(btnNewButton_2);
		
		back = new JButton("");
		back.setBounds(10, 10, 25, 25);
		getContentPane().add(back);
		
		exit = new JButton("");
		exit.setBounds(500, 11, 25, 25);
		getContentPane().add(exit);
		
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
		
	}
}
