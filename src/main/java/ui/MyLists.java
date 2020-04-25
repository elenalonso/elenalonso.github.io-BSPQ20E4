package ui;

import javax.swing.JFrame;
import javax.swing.JList;

import client.EasyFilmController;
import easyFilminData.FilmList;
import easyFilminData.User;
import serialization.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MyLists extends JFrame{
	private EasyFilmController controller;
	private JButton exit;
	private JButton back;
	private JList list;
	private JLabel info;
	private JComboBox<FilmList> filmList;
	
	public MyLists(EasyFilmController cont) {
		this.controller = cont;
		
		/** This is the part that contains the info of the window
		 * 
		 */
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500,450);
		setLocation(600,175);
		setResizable(false);
		getContentPane().setLayout(null);
		
		/** This window allows the user to see all his/her lists
 		 * 
		 */
		
		/** This is the list and combobox that allows to select and visualize the lists
		 * 
		 */
		
		list = new JList();
		list.setBounds(40, 75, 400, 300);
		getContentPane().add(list);
		
		info = new JLabel("My Lists:");
		info.setBounds(40, 52, 45, 13);
		getContentPane().add(info);
		
		filmList = new JComboBox<FilmList>();
		filmList.setBounds(220, 44, 220, 21);
		getContentPane().add(filmList);
		
		/** This buttons allow to control the window
		 * 
		 */
		
		exit = new JButton("");
		exit.setBounds(461, 10, 25, 25);
		getContentPane().add(exit);
		
		back = new JButton("");
		back.setBounds(10, 10, 25, 25);
		getContentPane().add(back);
		
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
				UserData usData = new UserData();
				UserUI u = new UserUI(usData, cont);
				u.setVisible(true);
			}
		});
		
	}
	
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController("127.0.0.1","8080");

		MyLists ui = new MyLists(e);
		ui.setVisible(true);
	}

}
