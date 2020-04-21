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
import javax.swing.JList;
import java.awt.Font;

public class FilmUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel film;
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
	
	public FilmUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución	
		setSize(650,450);
		setLocation(600,175);
		
		getContentPane().setLayout(null);
		
		/** Creates an UI to be able to see every film available in our DB
		 * 
		 */
		film = new JLabel("");
		film.setBounds(10, 50, 145, 200);
		film.setIcon(new ImageIcon("src\\main\\resources\\inglorious_basterds.png"));
		getContentPane().add(film);
		
		backbtn = new JButton("New button");
		backbtn.setBounds(10, 10, 25, 25);
		getContentPane().add(backbtn);
		backbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserUI ui = new UserUI(null);
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
		
		directorName = new JLabel("Quentin Tarantino");
		directorName.setBounds(220, 73, 285, 13);
		getContentPane().add(directorName);
		
		actorLabel = new JLabel("Actors:");
		actorLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		actorLabel.setBounds(165, 96, 45, 13);
		getContentPane().add(actorLabel);
		
		actorName = new JLabel("Brad Pitt, Christoph Waltz");
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
		
	}
	public static void main(String[] args) {
		FilmUI fu = new FilmUI();
		fu.setVisible(true);
	}
}