package easyFilminDAO;

import java.util.List;


import easyFilminData.Actor;
import easyFilminData.Director;
import easyFilminData.Film;
import easyFilminData.User;

public interface IEasyFilminDAO {
	
	/**
	 * Stores the user received in a Database. 
	 * The type of storage may differ depending on the instance of this interface created.
	 * @param user the user object whose data will be stored
	 * @see User
	 */
	public void saveUser(User user);
	
	/**
	 * Returns a user object after searching for it in the DB. 
	 * @param username a string that matches the name of the returned user
	 * @return         the user that matches the username.
	 */
	public User loadUser(String username);
	
	/**
	 * Stores the actor received in a Database. 
	 * The type of storage may differ depending on the instance of this interface created.
	 * @param actor the actor object whose data will be stored.
	 * @see Actor
	 */
	public void saveActor(Actor actor);
	
	/**
	 * Returns an actor object after searching for it in the DB. 
	 * @param name a string that matches the name of the returned actor.
	 * @return     the actor that matches the name.
	 */
	public Actor loadActor(String name);
	
	/**
	 * Stores the film received in a Database.
	 * The type of storage may differ depending on the instance of this interface created.
	 * @param film the film object whose data will be stored.
	 * @see Film
	 */
	public void saveFilm(Film film);
	
	/**
	 * Returns an film object after searching for it in the DB. 
	 * @param title a string that matches the title of the returned film.
	 * @return      the film that matches the title.
	 */
	public Film loadFilm(String title);
	
	/**
	 * Returns a director object after searching for it in the DB
	 * @param name a string that matches the name of the returned director. 
	 * @return     the director that matches the name
	 */
	public Director loadDirector(String name);
	
	/**
	 * Stores the director received in a Database. 
	 * The type of storage may differ depending on the instance of this interface created.
	 * @param director the director object whose data will be stored.
	 * @see Director
	 */
	public void saveDirector(Director director);

	
	/**
	 * Loads the DB initially with predetermined data.
	 * This data mainly consists in Actors, Films and Directors.
	 */
	public void startBD();
	

}