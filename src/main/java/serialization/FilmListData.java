package serialization;

import java.util.ArrayList;

import easyFilminData.Film;

public class FilmListData {
	
	private String name;
	private ArrayList<Film> filmList;
	
	//Use this constructor or create a different one to deal with your particular case of Data displaying in the client
	public FilmListData() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Film> getFilmList() {
		return filmList;
	}
	public void setFilmList(ArrayList<Film> filmList) {
		this.filmList = filmList;
	}
	
	
	
}
