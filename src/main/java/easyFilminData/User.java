package easyFilminData;



import java.util.Set;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

import java.util.ArrayList;
import java.util.HashSet;

@PersistenceCapable
public class User {
	@PrimaryKey
	String nickname=null;
	String icon;
	String email;
	String password=null;
	
	@Persistent(mappedBy="user", dependentElement="true")
	@Join
	Set<Message> messages = new HashSet<Message>();
	ArrayList<Film> movies = new ArrayList<>();
	ArrayList<Comment> comments = new ArrayList<>();
	
	
	
	public User(String nickname,String icon, String email, String password) {
		this.nickname = nickname;
		this.password = password;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}
	
	public void postComment(Comment c) {
		comments.add(c);
	}

	public void deleteComment(Comment c) {
		comments.remove(c);
	}
	
	
	public void addMovie(Film movie) { //create a movie list when clicking Add button
		movies.add(movie);
	}

	public void removeMovie(Film movie) { //remove movie from list
		movies.remove(movie);
	}
	public ArrayList<Film> getMovies() { //display list of movies
		return movies;
	}
	
	public ArrayList<Comment> getComments() { //display list of comments
		return comments;
	}

	public void setMovies(ArrayList<Film> movies) {
		this.movies = movies;
	}

	public String getNickname() {
		return this.nickname;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIcon() {
		return this.icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	 public Set<Message> getMessages() {return this.messages;}
	 
	 public String toString() {
		StringBuffer messagesStr = new StringBuffer();
		for (Message message: this.messages) {
			messagesStr.append(message.toString() + " - ");
		}
        return "User: login --> " + this.nickname + ", password -->  " + this.password + ", messages --> [" + messagesStr + "]";
    }
}

