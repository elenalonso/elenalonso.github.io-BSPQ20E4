package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import serialization.FilmData;
import serialization.FilmListData;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FilmListUI extends JFrame{

	private JList<String> liFilms;
	public static DefaultListModel<String> dlmFilms;
	private JButton backbtn;
	private JButton addFilm;
	private JButton deleteFilm;
	private FilmListData filmList; 

	static Logger logger = Logger.getLogger(FilmListUI.class.getName());

	public FilmListUI(FilmListData flData) {
		this.filmList = flData;
		this.setTitle(flData.getName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(640,380);
		setLocation(600,175);
		setResizable(false);
		
		//Buttons
		backbtn = new JButton("<<");
		backbtn.setBounds(10, 10, 50, 25);
		addFilm = new JButton("ADD new");
		addFilm.setBounds(440, 280, 100, 25);
		deleteFilm = new JButton("DELETE");
		deleteFilm.setBounds(100, 280, 100, 25);
		getContentPane().add(backbtn);
		getContentPane().add(addFilm);
		getContentPane().add(deleteFilm);
		
		
		dlmFilms = new DefaultListModel<>();
		liFilms = new JList<String>(dlmFilms);
		if(!filmList.getFilmList().isEmpty()) {
			for(FilmData f: filmList.getFilmList()) dlmFilms.addElement(f.getTitle());		
			logger.debug("Displaying FILMS of FilmList "+filmList.getName() );
		}else {
			//This logger doesnt work yet
			logger.debug("No Films in this FilmList yet");
		}

		liFilms.setBounds(220,200,100,100);
		JPanel pCentral = new JPanel();
		pCentral.add(liFilms);
		
		getContentPane().add(pCentral);
		
	}
	
	public static void main(String[] args) {
		
		FilmListData flData = new FilmListData();
		ArrayList<FilmData> fl = new ArrayList<>();
		for(int i=0;i<5;i++) {
			FilmData a = new FilmData();
			a.setTitle("Peli"+i);
			fl.add(a);
		}
		flData.setFilmList(fl);
		flData.setName("A1");
		FilmListUI ui = new FilmListUI(flData);
		
		ui.setVisible(true);
	}
	
}
