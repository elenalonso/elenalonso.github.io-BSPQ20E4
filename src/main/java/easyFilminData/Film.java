package easyFilminData;


import javax.jdo.annotations.PersistenceCapable;

import java.util.ArrayList;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

	
		@PersistenceCapable
		@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
	
public class Film implements Comparable<Film> {
	protected String title;
	protected String poster;
	protected String release;
	protected String description;
	protected Genre genre;
	protected double rating;
	protected ArrayList<Actor> actors;
	protected ArrayList<Director> director;
	
	protected String trailer;
	
	public Film() {
		
		this.title= "";
		this.poster="";
		this.release=null;
		this.description= "";
		this.genre=null;
		this.rating=0;
		this.actors=new ArrayList<>();
		this.director=new ArrayList<>();
		
		}
	
	public Film(String title,String poster, String release, String description, 
			Genre genre, double rating, ArrayList<Actor> actors, ArrayList<Director> director) {
		
		this.title= title;
		this.poster=poster;
		this.release=release;
		this.description= description;
		this.genre=genre;
		this.rating=rating;
		this.actors=actors;
		this.director=director;
		
		}
	public String getTitle()
	{
	    return title;
	}

	public String getPoster()
	{
	    return poster;
	}

	public String getRelease()
	{
	    return release;
	}
	public String getDescription()
	{
	    return description;
	}

	public Genre getGenre()
	{
	    return genre;
	}

	public double getRating()
	{
	    return rating;
	}
	
	public ArrayList<Actor> getActors() 
	{
	    return actors;
	}

	public ArrayList<Director> getDirector()
	{
	    return director;
	}
	
	
	
	public void setTitle(String title)
	{
	    this.title = title;
	}

	public void setPoster(String poster)
	{
	    this.poster = poster;
	}

	public void setRelease(String release)
	{
	    this.release = release;
	}

	public void setDescription(String description)
	{
	    this.description = description;
	}

	public void setRating(double rating)
	{
	    this.rating = rating;
	}

	public void setGenre(Genre genre)
	{
	    this.genre = genre;
	}
	
	public void setActors(ArrayList<Actor> actors)
	{
	    this.actors = actors;
	}

	public void setDirector(ArrayList<Director> director)
	{
	    this.director = director;
	}

	public int compareTo(Film f) {
		
		int i = this.title.compareTo(f.getTitle());
		
		if(i == 0) {
			return 0;
		}else if(i < 0){
			return -1;
		}else {
			return 1;
		}
		
	}
}
