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
	
	//AQUÍ HAY QUE METER LAS LISTAS + WATCHLIST y WATCHED
	ArrayList<FilmList> lists;
	Watched watched = new Watched("Watched");
	WatchList watchList = new WatchList("WatchList");
	
	
	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
		lists = new ArrayList<>();
		lists.add(watched);
		lists.add(watchList);
	}
	public User(String nickname,String icon, String email, String password) {
		this.nickname = nickname;
		this.icon = icon;
		this.email = email;
		this.password = password;
		lists = new ArrayList<>();
		lists.add(watched);
		lists.add(watchList);
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}
	/**
	 * 
	 * @param c: comment posted by a user when clicking 'Post' button,
	 * comments will be displayed in a film's profile showing the user (nickname and icon) who wrote it
	 */
	public void postComment(Comment c) {
		comments.add(c);
	}
	/*
	 * deletes a comment posted by a user and will be deleted both from a film's and user's profile
	 */
	public void deleteComment(Comment c) {
		comments.remove(c);
	}
	
	/**
	 * 
	 * @param movie: the film is added into a list when clicking 'Add' button
	 */
	public void addMovie(Film movie) { 
		movies.add(movie);
	}
	/**
	 * 
	 * @param movie: the film is removed from a list when clicking 'Remove' button
	 */
	public void removeWatchedMovie(Film movie) { 
		movies.remove(movie);
	}
	public ArrayList<Film> getMovies() { //will be replaced by Watched/WatchList
		return movies;
	}
	/**
	 * displays a user's list of posted comments
	 * @return all comments written by a user in different movie profiles
	 */
	public ArrayList<Comment> getComments() { 
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
	
	 public ArrayList<FilmList> getLists() {
		return lists;
	}
	public void setLists(ArrayList<FilmList> lists) {
		this.lists = lists;
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

