package server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import serialization.FilmData;
import serialization.FilmListData;
import serialization.MessageData;
import serialization.UserData;
import server.easyFilminDAO.EasyFilminJDO;
import server.easyFilminDAO.IEasyFilminDAO;
import server.easyFilminData.Film;
import server.easyFilminData.FilmList;
import server.easyFilminData.Message;
import server.easyFilminData.User;
import server.easyFilminData.WatchList;
import server.easyFilminData.Watched;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import client.controller.EasyFilmController;


/**
 * This class is in charge of handling the calls from the controller and cast them to the Data Access Layer
 *
 */
@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class Server {

	private int cont = 0;
	private IEasyFilminDAO iDAO = null;
	private Logger logger = Logger.getLogger(Server.class.getName());

	public Server() {
		this.iDAO = new EasyFilminJDO();
		
	}


	/** Checks if the login is correct
	 * @param us - UserData for a particular User
	 * @return a - Response with an OK/Not OK message 
	 */
	@POST
	@Path("/login")
	public Response login(UserData us) {
		User user = null;
		user = iDAO.loadUser(us.getLogin());
		
		if (user != null && us.getPassword().equals(user.getPassword())) {
			cont++;
			logger.debug(" * Client number: " + cont);
			return Response.ok("Login OK").build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}

	
	/** REGISTERS a new User in the db 
	 * @param userData - UserData in order to register a user
	 * @return Reponse - replying if Register is OK or NOT
	 */
	@POST
	@Path("/register")
	public Response registerUser(UserData userData) {
		logger.warn("THIS METHOD SHOULD CHECK WITH METHOD");
		User user = null;
//		try {
//			iDAO.loadUser(userData.getLogin());
//		}catch(Exception e) {
			user = new User(userData.getLogin(), userData.getIcon(), userData.getEmail(),userData.getPassword());
			iDAO.saveUser(user);
			return Response.ok().build();				
//		}
//        return Response.status(Status.BAD_REQUEST).entity("This user name is invalid").build();      
	}
	
	/** GETs a particular User by its nick
	 * @param login - nick of the user
	 * @return usData - return a UserData corresponding to the user
	 */
	@GET
	@Path("/getUser/{nick}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserData login(@PathParam("nick") String login) {
		User user = null;
		user = iDAO.loadUser(login);
				
		logger.debug(" * Client number: " + cont);
		UserData usData = new UserData(user);
		return usData;
	}

	/** GETs a list of all lists for a given user
	 * @param login - nick of the given user
	 * @return listsData - ArrayList of FilmListData
	 */
	@GET
	@Path("/getAllLists/{nick}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FilmListData> getAllLists(@PathParam("nick") String login) {
		User user = null;
		user = iDAO.loadUser(login);
		
		ArrayList<FilmList> lists = user.getLists();
		ArrayList<FilmListData> listsData = new ArrayList<FilmListData>();
		for(FilmList f : lists) {
			listsData.add(new FilmListData(f));
		}
		return listsData;
	}


	/** GETs a particular film by title 
	 * @param name - title of the film
	 * @return fData - film (serialized)
	 */
	@GET
	@Path("/getFilm/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public FilmData getFilm(@PathParam("name") String name) {
		Film f = null;
		try {
			f = iDAO.loadFilm(name);
		}catch(Exception e) {
			logger.debug("Exception retrieving film "+f.getTitle());
			logger.debug("Possibly "+f.getTitle()+" is not on the DB");
		}
		logger.debug(" * Client number: " + cont);
		
		FilmData fData = new FilmData(f);
		return fData;
	}

	/** GETs a particular filmlist by name
	 * @param name - name of the filmlist
	 * @return flData - filmListData (serialized)
	 */
	@GET
	@Path("/getFilmList/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public FilmListData getFilmList(@PathParam("name") String name) {
		FilmList fl = null;
		//fl = iDAO.loadFilmList(name);
		System.out.println(" * Client number: " + cont);
		//Constructor is needed, and think about how to pass this Data
		ArrayList<String> nameList = new ArrayList<>();
		for(Film f : fl.getFilmList()) nameList.add(f.getTitle());
		FilmListData flData = new FilmListData(name, nameList);
		return flData;
	}


	/** Adds a given film to a particular list (REGULAR LIST NOT IMPLEMENTED YET) 
	 * @param listName - the name of the list is passed implicitly as a String
	 * @param filmTitle - title of the film is passed explicitly in the path
	 * @return A Response whether is successfully added OK or not BAD.RESPONSE 
	 */
	@POST
	@Path("/addToList/{title}")
	public Response addToList(String listName, @PathParam("title") String filmTitle) {
		boolean repeated = false;
		Film film = iDAO.loadFilm(filmTitle);
		if(listName.contentEquals("watchlist")) {
			WatchList w = iDAO.loadWatchList("watchlist");
			for(Film f : w.getFilmList()) {
				if (f.getTitle().contentEquals(filmTitle)){ //If not repeated we add it to watchlist
					repeated = true;
					break;
				}
			}
			if(!repeated) w.addFilm(film);
			iDAO.saveWatchList(w);

		} else if(listName.contentEquals("watched")) {

			Watched w = iDAO.loadWatched("watched");
			for(Film f : w.getFilmList()) {
				if (f.getTitle().contentEquals(filmTitle)){
					repeated = true;
					break;
				}
				if(!repeated) {
					w.addFilm(film); //If not repeated we add it to watched
					WatchList wl = iDAO.loadWatchList("watchlist");
					for(Film fl : wl.getFilmList()) {
						if (fl.getTitle().contentEquals(filmTitle)){ 
							wl.removeFilm(filmTitle);
							break;
						}
					}
				}
				iDAO.saveWatched(w);
			}
		} else {
			FilmList fl = iDAO.loadFilmList(listName);
			fl.addFilm(film);
			//saveList() method?
			//iDAO.saveList();
						      
		}
		if(!repeated) return Response.ok().build();
		else return Response.status(Status.BAD_REQUEST).entity("This film is already on your filmList").build();
	}
	// Example method
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hola. Mensaje desde el servidor").build();
	}
	
}


