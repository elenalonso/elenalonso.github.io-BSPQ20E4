package server.easyFilminData;
import javax.jdo.annotations.PersistenceCapable;

import java.util.Date;
import java.time.LocalDate;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


/**
 * Definition of a comment
 * @author BSPQ20-E4
 * @version 1.0
 * @since 2020-04-26
 */
@PersistenceCapable(detachable = "true")
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Comment {

	protected String filmTitle;
	protected String text;
	protected LocalDate date;

	public Comment() {
		
		this.filmTitle=null;
		this.text="";
		this.date=null;
		}
	
	/** Constructor of Comment
	 * 
	 * @param filmTitle - references the film on which the user is commenting
	 * @param text - data that contains what the message says
	 * @param date -represents the date when the comment was posted. It takes system's date
	 */
	
	public Comment(String filmTitle, String text, LocalDate date) {
		
		this.filmTitle=filmTitle;
		this.text=text;
		this.date=date;
		}
	public String getText()
	{
	    return text;
	}
	
	public String getFilmTitle()
	{
	    return filmTitle;
	}
	
	public LocalDate getDate()
	{
	    return date;
	}
	
	public void setText(String text)
	{
	    this.text = text;
	}
	
	public void setFilm(String filmTitle)
	{
	    this.filmTitle = filmTitle;
	}

}
