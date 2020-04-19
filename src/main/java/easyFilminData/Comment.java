package easyFilminData;
import javax.jdo.annotations.PersistenceCapable;

import java.util.Date;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


	@PersistenceCapable
	@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)


public class Comment {

	protected Film film;
	protected String text;
	protected Date date;

	public Comment() {
		
		this.film=null;
		this.text="";
		this.date=null;
		}
	
	/**
	 * 
	 * @param film: references the film on which the user is commenting
	 * @param text: data that contains what the message says
	 * @param date -represents the date when the comment was posted. It takes system's date
	 */
	
public Comment(Film film,String text, Date date) {
	
	this.film=film;
	this.text=text;
	this.date=date;
	}
public String getText()
{
    return text;
}

public Film getFilm()
{
    return film;
}

public Date getDate()
{
    return date;
}

public void setText(String text)
{
    this.text = text;
}

public void setFilm(Film film)
{
    this.film = film;
}






}
