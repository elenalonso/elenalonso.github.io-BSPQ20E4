package easyFilminData;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;


	@PersistenceCapable
	@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)


public class Comment {
	protected User user;
	protected Film film;
	protected String text;

public Comment(User user,Film film,String text) {
	this.user=user;
	this.film=film;
	this.text=text;
	}
public String getText()
{
    return text;
}

public Film getFilm()
{
    return film;
}

public User getUser()
{
    return user;
}

public void setText(String text)
{
    this.text = text;
}

public void setFilm(Film film)
{
    this.film = film;
}

public void setUser(User user)
{
    this.user = user;
}




}
