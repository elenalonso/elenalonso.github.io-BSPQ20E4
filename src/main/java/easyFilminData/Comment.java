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
