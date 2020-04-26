package serialization;

import java.util.Date;
import easyFilminData.Comment;

public class CommentData {
	
	private String filmTitle;
	private String text;
	private Date date;

	public CommentData(Comment c) {
		this.filmTitle = c.getFilmTitle();
        this.text = c.getText();
        this.date = c.getDate();
       
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

}
