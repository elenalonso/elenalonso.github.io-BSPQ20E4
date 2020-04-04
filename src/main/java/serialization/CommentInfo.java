package serialization;

import java.util.Date;

import easyFilminData.Comment;

public class CommentInfo {

	
	
	private String text;
	private Filmography film;
	private Date date;

	public CommentInfo(Comment c) {
	        this.text = c.getText();
	       this.date=c.getDate();
	        this.film = new Filmography(c.getFilm());
	       
	    }

	    public String getText() {
	        return this.text;
	    }

	    public void setName(String text) {
	        this.text = text;
	    }

	    public Date getDate() {
	        return this.date;
	    }

	    public Filmography getFilm() {
	        return this.film;
	    }

	    public void setFilm(Filmography f) {
	        this.film = f;
	    }
}
