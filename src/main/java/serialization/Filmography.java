package serialization;

import java.util.ArrayList;

import easyFilminData.Actor;
import easyFilminData.Director;
import easyFilminData.Film;
import easyFilminData.Genre;

public class Filmography { //shows basic details of a film
	
		private String title;
		private int year;
		private ArrayList<ActorData> actor;
//	    private ArrayList<DirectorData> director;
	    private Genre genre;
	    private String sipnosis;

	    public Filmography() {

	    }

	    public Filmography(Film f) {
	    	this.title= f.getTitle();
	    	this.sipnosis=f.getDescription();
	 //   	this.year=f.getRelease().getYear();
	 //   	this.actor=f.getActors().g;
	    	this.genre=f.getGenre();
	    }
	    
	  /*
	   * NOT FINISHED - problems with actors and directors
	   *   
	   */
/* It was getting a bit messy with so many Data classes,
 *  have to re-think how to organize this class
 */
/*	    public UserData getUserData() {
	        return this.userData;
	    }

	    public void setMessageData(MessageData messageData) {
	        this.messageData = messageData;
	    }

	    public MessageData getMessageData() {
	        return this.messageData;
	    }
	}*/
}


