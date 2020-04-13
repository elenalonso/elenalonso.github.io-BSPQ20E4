package easyFilminData;

import javax.jdo.annotations.PersistenceCapable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class FilmList {

	private String name;
	private ArrayList<Film> filmList;
	
	
	public FilmList(String name) {
		this.name = name;
		this.filmList = new ArrayList<Film>();
	}
	
	public void addFilm(Film film) {
		
		this.filmList.add(film);
		
	}
	
	public void removeFilm(String title){
		
		Iterator<Film> itr = this.filmList.iterator();
		while(itr.hasNext()) {
			Film f = (Film) itr.next();
			
			if(f.getTitle().equals(title)) {
				itr.remove();
				System.out.println("Film removed");
				return;
			}
			
		}
		System.out.println("The film trying to be removed could not be found");
	}
	
	public void sortFilmList() {
		Collections.sort(this.filmList);
	}
	
	
	
	public String getName() {
		return name;
	}


	public ArrayList<Film> getFilmList() {
		return filmList;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setFilmList(ArrayList<Film> filmList) {
		this.filmList = filmList;
	}
}
