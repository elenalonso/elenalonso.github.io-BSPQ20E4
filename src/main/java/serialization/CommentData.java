package serialization;

import java.util.Date;
import java.time.LocalDate;

import server.easyFilminData.Comment;

public class CommentData {
	
	private String filmTitle;
	private String text;
	private LocalDate date;

	public CommentData(Comment c) {
		this.filmTitle = c.getFilmTitle();
        this.text = c.getText();
        this.date = c.getDate();
       
    }
	 public String getFilmTitle() {
	        return this.filmTitle;
	    }

    public String getText() {
        return this.text;
    }

    public void setName(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return this.date;
    }

}
