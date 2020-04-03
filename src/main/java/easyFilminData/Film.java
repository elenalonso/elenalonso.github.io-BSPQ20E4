package easyFilminData;


	import javax.jdo.annotations.PersistenceCapable;
	import java.util.Date;
	import javax.jdo.annotations.Inheritance;
	import javax.jdo.annotations.InheritanceStrategy;

	
		@PersistenceCapable
		@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
	
public class Film {
	protected String title;
	protected String poster;
	protected Date release;
	protected String description;
	protected Genre genre;
	protected double rating;
	protected Actor[] actors;
	protected Director[] director;
	
	protected String trailer;
	
	public Film(String title,String poster, Date release, String description, 
			Genre genre, double rating, Actor[] actors, Director[] director) {
		
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

	public Date getRelease()
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
	
	public Actor[] getActors() //seguramente luego esto se cambie a ArrayList XD
	{
	    return actors;
	}

	public Director[] getDirector()
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

	public void setRelease(Date release)
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
	
	public void setActors(Actor[] actors)
	{
	    this.actors = actors;
	}

	public void setDirector(Director[] director)
	{
	    this.director = director;
	}
}
