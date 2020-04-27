package client.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;import java.awt.Component;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import client.controller.EasyFilmController;
import serialization.FilmData;
import server.easyFilminData.Actor;
import server.easyFilminData.Director;
import server.easyFilminData.Film;
import server.easyFilminData.FilmList;

import javax.swing.JList;
import java.awt.Font;
import javax.swing.JComboBox;

public class FilmUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel poster;
	private JButton backbtn;
	private JButton exitbtn;
	private JLabel titleLabel;
	private JLabel titleName;
	private JLabel directorLabel;
	private JLabel directorName;
	private JLabel actorLabel;
	private JLabel actorName;
	private JButton addWatchlist;
	private JButton addWatched;
	private JLabel watched;
	private JButton post;
	private JList list;
	private JButton addToList;
	private JTextField textField;
	private JButton upbtn;
	private JButton downbtn;
	private JLabel lblNewLabel;
	private JComboBox<FilmList> listSelection;
	private FilmData film;

	private EasyFilmController controller;
	
	public FilmUI(FilmData film, EasyFilmController controller) {
		this.film = film;
		this.controller = controller;
		
		/** This is the information of the creation of the window
		 * 
		 */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(650,450);
		setLocation(600,175);
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		/** Creates an UI to be able to see every film available in our DB
		 * 
		 */
		poster = new JLabel();
		poster.setBounds(10, 50, 145, 200);
		poster.setIcon(new ImageIcon("src\\main\\resources\\inglorious_basterds.png")); //Example
		//Uncomment when FilmData is retrieved from server
		//poster.setIcon(new ImageIcon(film.getPoster()));
		getContentPane().add(poster);
		
		/** This is the part that allows the control of the window to exit an go back
		 * 
		 */
		
		backbtn = new JButton("<-");
		backbtn.setBounds(10, 10, 30, 25);
		getContentPane().add(backbtn);
		
		exitbtn = new JButton("x");
		exitbtn.setBounds(601, 10, 30, 25);
		getContentPane().add(exitbtn);
		
		/** This part is where all the info related to the film is displayed
		 * 
		 */
		
		titleLabel = new JLabel("Title:");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		titleLabel.setBounds(165, 50, 45, 13);
		getContentPane().add(titleLabel);
		
		titleName = new JLabel("Inglorious Basterds");
		titleName.setBounds(220, 50, 285, 13);
		getContentPane().add(titleName);
		
		directorLabel = new JLabel("Director:");
		directorLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		directorLabel.setBounds(165, 73, 54, 13);
		getContentPane().add(directorLabel);
		
		directorName = new JLabel("Quentin Tarantino"); //Example
		//Uncomment when FilmData is retrieved from server
//		String directors ="";
//		for(Director a : film.getDirector()) {
//			if(directors.equals("")) {
//				directors += a.getName();	
//			}else {
//				directors += ", " + a.getName();
//			}
//		}		
//		directorName = new JLabel(directors);
		directorName.setBounds(220, 73, 285, 13);
		getContentPane().add(directorName);
		
		actorLabel = new JLabel("Actors:");
		actorLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		actorLabel.setBounds(165, 96, 45, 13);
		getContentPane().add(actorLabel);
		
		actorName = new JLabel("Brad Pitt, Christoph Waltz"); //Example
		//Uncomment when FilmData is retrieved from server
//		String actors ="";
//		for(Actor a : film.getActors()) {
//			if(actors.equals("")) {
//				actors += a.getName();	
//			}else {
//				actors += ", " + a.getName();
//			}
//		}		
//		actorName = new JLabel(actors);
		actorName.setBounds(220, 96, 285, 13);
		getContentPane().add(actorName);
		
		/** This is the part that implements a button to add films to a Watchlist
		 * And an icon that shows if the film has been watched or not
		 * 
		 */
		
		addWatchlist = new JButton("");
		addWatchlist.setIcon(new ImageIcon("src\\main\\resources\\Watchlist.png")); 
		addWatchlist.setBounds(165, 229, 35, 35);
		getContentPane().add(addWatchlist);
		
		watched = new JLabel("");
		watched.setIcon(new ImageIcon("src\\main\\resources\\Watch.png"));
		watched.setBounds(220, 229, 35, 35);
		getContentPane().add(watched);
		
		/**This part implements a way to write, post and read comments
		 * 
		 */
		
		textField = new JTextField();
		textField.setBounds(10, 300, 575, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		list = new JList();
		list.setBounds(10, 335, 615, 75);
		getContentPane().add(list);
		
		post = new JButton("");
		post.setBounds(600, 300, 25, 25);
		getContentPane().add(post);
		
		/** This is the part that allows the user to rate films
		 * 
		 */
		
		upbtn = new JButton(">");
		upbtn.setBounds(10, 270, 30, 25);
		getContentPane().add(upbtn);
		
		lblNewLabel = new JLabel("5");
		lblNewLabel.setBounds(40, 275, 20, 13);
		getContentPane().add(lblNewLabel);
		
		downbtn = new JButton("<");
		downbtn.setBounds(50, 270, 30, 25);
		getContentPane().add(downbtn);
		
		/** This part allows the user to add films to the selected list
		 * 
		 */
		
		addToList = new JButton("");
		addToList.setBounds(590, 230, 35, 35);
		getContentPane().add(addToList);
		
		listSelection = new JComboBox<FilmList>();
		listSelection.setBounds(350, 230, 225, 35);
		getContentPane().add(listSelection);
		
		/** This part is the one that implements the listeners of the different buttons
		 * 
		 */
		
		exitbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserUI ui = new UserUI(null, controller);
				ui.setVisible(true);
			}
		});
		
		//Action Listeners Watchlist / Watched
		addWatched.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addToList("watched", film.getTitle());
				
			}
		});
		addWatchlist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addToList("watchlist", film.getTitle());
				
			}
		});
		
	}
	public static void main(String[] args) {
		FilmData f = new FilmData();
		EasyFilmController e = new EasyFilmController("127.0.0.1","8080");
		FilmUI fu = new FilmUI(f, e);
		fu.setVisible(true);
	}
}