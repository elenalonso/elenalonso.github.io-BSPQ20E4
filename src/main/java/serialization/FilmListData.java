package serialization;

import java.util.ArrayList;

import easyFilminData.Film;

public class FilmListData {
	
	private String name;
	private ArrayList<String> filmList;
	
	//Use this constructor or create a different one to deal with your particular case of Data displaying in the client
	public FilmListData() {
		
	}
	public FilmListData(String name, ArrayList<String> filmList) {
		this.name = name;
		this.filmList = filmList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getFilmList() {
		return filmList;
	}
	public void setFilmList(ArrayList<String> filmList) {
		this.filmList = filmList;
	}
	
	
	
}
