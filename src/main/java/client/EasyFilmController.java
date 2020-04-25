package client;

import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import easyFilminDAO.EasyFilminJDO;
import easyFilminData.User;
import serialization.MessageData;
import serialization.FilmData;
import serialization.FilmListData;
import serialization.UserData;
import ui.FilmListUI;
import ui.UserUI;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class EasyFilmController {

	private Client client; 
	private WebTarget webTarget; 
	private static Logger logger = Logger.getLogger(EasyFilmController.class.getName());

	public EasyFilmController(String hostname, String port) { 
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
	}

	/** REGISTERS a new User in the db giving its parameters 
	 * @param login - nick of the user
	 * @param icon  - icon of the user
	 * @param email - email of the user
	 * @param password - pass of the user
	 */
	public void registerUser(String login, String icon, String email, String password) {
		WebTarget registerUserWebTarget = webTarget.path("server/register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);
		userData.setEmail(email);
		userData.setIcon(icon);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}

	/** CHECKS if the login is correct
	 * @param login - login of the user
	 * @param password - pass of the user
	 * @return boolean - if correct true else false 
	 */
	public boolean login(String login, String password) {
		WebTarget loginWebTarget = webTarget.path("server/login");		
		Invocation.Builder invocationBuilder = loginWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);

		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if(response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
			String responseMessage2 = response.readEntity(String.class);
			logger.error("* ERROR: '" + responseMessage2 + "'");
			return false;
			
		}else if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
			return false;
			
		}else {
			return true;
		}
	}


	/** RETRIEVES an UserData Object from the server that is passed in the login
	 * @param nick - nick of user
	 * @return UserData - UserData object from that user
	 */
	public UserData getUser(String nick) {
		WebTarget getUserWebTarget = webTarget.path("server/getUser"+"/"+nick);
		GenericType<UserData> genericType = new GenericType<UserData>() {};
		UserData usData = getUserWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		return usData;
		}
	
	/** RETRIEVES a FilmData object from the server
	 * @param name - title of the film
	 * @return film - FilmData (serialized)
	 */
	public FilmData getFilm(String name) {
		WebTarget getFilmWebTarget = webTarget.path("server/getFilm"+"/"+name); 
		GenericType<FilmData> genericType = new GenericType<FilmData>() {};
		FilmData film = getFilmWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		return film;
	}

	/** RETRIEVES a FilmListData object from the server
	 * @param name -name of the filmList
	 * @return list - list of films (serialized) FilmListData
	 */
	public FilmListData getFilmList(String name) {
		WebTarget getFilmListWebTarget = webTarget.path("server/getFilmList"+"/"+name); 
		GenericType<FilmListData> genericType = new GenericType<FilmListData>() {};
		FilmListData film = getFilmListWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		return film;
	}

	/** This methods adds a given film to a list unless this list is already in the list
	 * or if that film is in watchList and we are adding to watched, this will delete the movie from
	 * watchList
	 * @param filmTitle - title of the film to add
	 */
	public void addToList(String listName, String filmTitle) {
		WebTarget addToListWebTarget = webTarget.path("server/addToList"+"/"+filmTitle); 
		Invocation.Builder invocationBuilder = addToListWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(listName, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: " + response.getStatus());
		} else {
			logger.info("Film correctly added");
		}

	}

	
	public static void main(String[] args) {
		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];

		//Some example methods 
		EasyFilmController easFilCon = new EasyFilmController(hostname, port); 
		easFilCon.registerUser("egui2", "Image2", "11111@opendeusto.es","1234"); 
		easFilCon.registerUser("Marcos", "Image3", "33333@opendeusto.es","1235");
		easFilCon.login("egui2", "1234"); 
		easFilCon.login("Marcos", "1235");
		EasyFilminJDO prueba= new EasyFilminJDO();
		//prueba.startBD();
	}

}
