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
import serialization.DirectedMessage;
import serialization.MessageData;
import serialization.UserData;
import ui.UserUI;

public class EasyFilmController {

	private Client client; 
	private WebTarget webTarget; 

	public EasyFilmController(String hostname, String port) { 
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));
	}

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
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
		} else {
			System.out.println("User correctly registered");
		}
	}

	public void sayMessage(String login, String password, String message) {
		WebTarget sayHelloWebTarget = webTarget.path("server/sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

		DirectedMessage directedMessage = new DirectedMessage();
		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);

		directedMessage.setUserData(userData);

		MessageData messageData = new MessageData();
		messageData.setMessage(message);
		directedMessage.setMessageData(messageData);

		Response response = invocationBuilder.post(Entity.entity(directedMessage, MediaType.APPLICATION_JSON));
		if(response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
			String responseMessage2 = response.readEntity(String.class);
			System.out.println("* ERROR: '" + responseMessage2 + "'");
			
		}else if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			
		}else {
			String responseMessage = response.readEntity(String.class);
			System.out.println("* Message coming from the server: '" + responseMessage + "'");
		}
	}
	
	public boolean login(String login, String password) {
		WebTarget loginWebTarget = webTarget.path("server/login");		
		Invocation.Builder invocationBuilder = loginWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setLogin(login);
		userData.setPassword(password);

		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if(response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
			String responseMessage2 = response.readEntity(String.class);
			System.out.println("* ERROR: '" + responseMessage2 + "'");
			return false;
			
		}else if (response.getStatus() != Status.OK.getStatusCode()) {
			System.out.println("Error connecting with the server. Code: " + response.getStatus());
			return false;
			
		}else {
			// THIS IS SUPPOSE TO RETRIEVE an UserData Object from the server that is passed in the login
			return true;
		}
	}


	public UserData getUser(String nick) {
		// THIS IS SUPPOSE TO RETRIEVE an UserData Object from the server that is passed in the login
		WebTarget getUserWebTarget = webTarget.path("server/getUser"+"/"+nick);
		GenericType<UserData> genericType = new GenericType<UserData>() {};
		UserData usData = getUserWebTarget.request(MediaType.APPLICATION_JSON).get(genericType);
		return usData;
		}
	
	
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];

		EasyFilmController easFilCon = new EasyFilmController(hostname, port); 
		easFilCon.registerUser("egui2", "Image2", "11111@opendeusto.es","1234"); 
		easFilCon.registerUser("Marcos", "Image3", "33333@opendeusto.es","1235");
		easFilCon.login("egui2", "1234"); 
		easFilCon.sayMessage("Marcos", "1", "Esto no se debria ver");
		easFilCon.sayMessage("Marcos", "1235", "Sup guys, Marcos here");
		EasyFilminJDO prueba= new EasyFilminJDO();
		prueba.startBD();
	}

}