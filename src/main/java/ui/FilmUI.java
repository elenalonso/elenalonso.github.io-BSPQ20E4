package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import client.EasyFilmController;
import easyFilminData.Actor;
import easyFilminData.Director;
import easyFilminData.Film;
import serialization.FilmData;

import javax.swing.JList;
import java.awt.Font;

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
	private JLabel watched;
	private JButton post;
	private JList list;
	private JTextField textField;
	private JButton upbtn;
	private JButton downbtn;
	private JLabel lblNewLabel;
	private FilmData film;

	private EasyFilmController controller;
	
	public FilmUI(FilmData film, EasyFilmController controller) {
		this.film = film;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución	
		setSize(650,450);
		setLocation(600,175);
		
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
		
		backbtn = new JButton("New button");
		backbtn.setBounds(10, 10, 25, 25);
		getContentPane().add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserUI ui = new UserUI(null, controller);
				ui.setVisible(true);
			}
		});
		
		exitbtn = new JButton("New button");
		exitbtn.setBounds(601, 10, 25, 25);
		getContentPane().add(exitbtn);
		exitbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
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
		
		addWatchlist = new JButton("");
		addWatchlist.setIcon(new ImageIcon("src\\main\\resources\\Watchlist.png")); 
		addWatchlist.setBounds(165, 229, 35, 35);
		getContentPane().add(addWatchlist);
		
		watched = new JLabel("");
		watched.setIcon(new ImageIcon("src\\main\\resources\\Watch.png"));
		watched.setBounds(220, 229, 35, 35);
		getContentPane().add(watched);
		
		textField = new JTextField();
		textField.setBounds(10, 300, 575, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		list = new JList();
		list.setBounds(10, 335, 615, 75);
		getContentPane().add(list);
		
		post = new JButton("");
		post.setBounds(600, 300, 25, 21);
		getContentPane().add(post);
		
		upbtn = new JButton("");
		upbtn.setBounds(10, 270, 25, 25);
		getContentPane().add(upbtn);
		
		lblNewLabel = new JLabel("5");
		lblNewLabel.setBounds(40, 275, 20, 13);
		getContentPane().add(lblNewLabel);
		
		downbtn = new JButton("");
		downbtn.setBounds(50, 270, 25, 25);
		getContentPane().add(downbtn);

	}
	public static void main(String[] args) {
		FilmData f = new FilmData();
		EasyFilmController e = new EasyFilmController("127.0.0.1","8080");
		FilmUI fu = new FilmUI(f, e);
		fu.setVisible(true);
	}
}