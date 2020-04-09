package server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import serialization.DirectedMessage;
import serialization.MessageData;
import serialization.UserData;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

	/** This method returns a message 
	 * @param directedMessage the message to be displayed
	 * @return
	 */
	@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectedMessage directedMessage) {
		User user = null;
		//IEasyFilminDAO iDAO = new EasyFilminJDO();
		user = iDAO.loadUser(directedMessage.getUserData().getLogin());
		
		if (user != null && directedMessage.getUserData().getPassword().equals(user.getPassword())) {
			cont++;
			System.out.println(" * Client number: " + cont);
			MessageData messageData = new MessageData();
			messageData.setMessage(directedMessage.getMessageData().getMessage());
			return Response.ok(messageData).build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}
	
	@POST
	@Path("/register")
	public Response registerUser(UserData userData) {
		
		User user = null;
		user = new User(userData.getLogin(), userData.getIcon(), userData.getEmail(),userData.getPassword());
		//IEasyFilminDAO iDAO = new EasyFilminJDO();
		iDAO.saveUser(user);
		return Response.ok().build();	
        
        
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(DirectedMessage directedMessage) {
		User user = null;
		user = iDAO.loadUser(directedMessage.getUserData().getLogin());
		
		if (user != null && directedMessage.getUserData().getPassword().equals(user.getPassword())) {
			cont++;
			
			System.out.println(" * Client number: " + cont);
			UserData usData = directedMessage.getUserData();
			//messageData.setMessage(directedMessage.getMessageData().getMessage());
			return Response.ok(usData).build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}

	}

	// Example method
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hola. Mensaje desde el servidor").build();
	}
	
}


