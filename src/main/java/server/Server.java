package server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import serialization.MessageData;
import serialization.UserData;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import easyFilminDAO.EasyFilminJDO;
import easyFilminDAO.IEasyFilminDAO;
import easyFilminData.Message;
import easyFilminData.User;

/**
 * This class is in charge of handling the calls from the controller and cast them to the Data Access Layer
 *
 */
@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class Server {

	private int cont = 0;
	private IEasyFilminDAO iDAO = null;

	public Server() {
		this.iDAO = new EasyFilminJDO();
	}


	/** Checks if the login is correct
	 * @param us
	 * @return a Response with an OK/Not OK message 
	 */
	@POST
	@Path("/login")
	public Response login(UserData us) {
		User user = null;
		//IEasyFilminDAO iDAO = new EasyFilminJDO();
		user = iDAO.loadUser(us.getLogin());
		
		if (user != null && us.getPassword().equals(user.getPassword())) {
			cont++;
			System.out.println(" * Client number: " + cont);
			return Response.ok("Login OK").build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}

	
	/** REGISTERS a new User in the db 
	 * @param userData
	 * @return Reponse saying if Register is OK or NOT
	 */
	@POST
	@Path("/register")
	public Response registerUser(UserData userData) {
		
		User user = null;
		user = new User(userData.getLogin(), userData.getIcon(), userData.getEmail(),userData.getPassword());
		//IEasyFilminDAO iDAO = new EasyFilminJDO();
		iDAO.saveUser(user);
		return Response.ok().build();	
        
        
	}
	
	/** 
	 * @param login
	 * @return
	 */
	@GET
	@Path("/getUser/{nick}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserData login(@PathParam("nick") String login) {
		User user = null;
		user = iDAO.loadUser(login);
					
			System.out.println(" * Client number: " + cont);
			UserData usData = new UserData(user.getNickname(), user.getPassword(), user.getIcon(),user.getEmail());
			//messageData.setMessage(directedMessage.getMessageData().getMessage());
			return usData;
	}

	
	// Example method
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hola. Mensaje desde el servidor").build();
	}
	
}


