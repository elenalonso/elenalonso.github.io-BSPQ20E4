package easyFilminDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import easyFilminData.Actor;
import easyFilminData.Director;
import easyFilminData.Film;
import easyFilminData.User;


public class EasyFilminJDO implements IEasyFilminDAO{
	
	private PersistenceManagerFactory pmf = null;
	
	/**
	 * Initializes the attribute pmf (PersistenceManagerFactory).
	 * It is necessary in order to execute all the operations related to a JDO Database.
	 */
	public EasyFilminJDO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties"); 
	}

	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert users in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(user);
			
			
			//End the transaction
			tx.commit();
			System.out.println("Changes committed");
			
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				System.out.println("Changes rollbacked");
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				System.out.println("Closing the connection");
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
		
	}

	@Override
	public User loadUser(String username) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("- Retrieving users");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery(User.class);
			query.setFilter("nickname == '" + username + "'"); //we find the user by his username
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			User user = (User) query.execute();

			//End the transaction
			tx.commit();
			
			
			return user;
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving users using a 'Query': " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return null;
	}

	@Override
	public void saveActor(Actor actor) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert actors in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(actor);
			
			
			//End the transaction
			tx.commit();
			System.out.println("Changes committed");
			
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				System.out.println("Changes rollbacked");
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				System.out.println("Closing the connection");
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
		
	}

	@Override
	public Actor loadActor(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("- Retrieving actors");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<Actor> query = pm.newQuery(Actor.class);
			query.setFilter("Actor == '" + name + "'"); //we find the actor by his name
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			Actor actor = (Actor) query.execute();

			//End the transaction
			tx.commit();
			
			
			return actor;
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving actors using a 'Query': " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return null;
	}


	@Override
	public void saveFilm(Film film) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert films in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(film);
			
			
			//End the transaction
			tx.commit();
			System.out.println("Changes committed");
			
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
				System.out.println("Changes rollbacked");
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
				System.out.println("Closing the connection");
				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
			}
		}
		
	}


	@Override
	public Film loadFilm(String title) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("- Retrieving films");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<Film> query = pm.newQuery(Film.class);
			query.setFilter("Film == '" + title + "'"); //we find the film by his title
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			Film film = (Film) query.execute();

			//End the transaction
			tx.commit();
			
			
			return film;
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving films using a 'Query': " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return null;
	}

	
	@Override
	public void startBD() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Holi llegamos hasta aqui?");
			//CSVReader readFilms = new CSVReaderBuilder(new FileReader("src\\main\\resources\\films.csv")).withSkipLines(1).build(); //csv not yet created
			CSVReader readActors = new CSVReaderBuilder(new FileReader("src\\main\\resources\\actors.csv")).withSkipLines(1).build();
			//CSVReader readDirectors = new CSVReader(new FileReader("src\\main\\resources\\directors.csv")).withSkipLines(1).build(); 
			 
			//ArrayList<Film> films = new ArrayList<Film>();
			ArrayList<Actor> actors = new ArrayList<Actor>();
			//ArrayList<Director> directors = new ArrayList<Director>();
			
			String[] values = null;
		    try {
				while ((values = readActors.readNext()) != null){
					String name =values[0];
					//String bday = values[1];
					
					System.out.println("Name:" +name+", bday:");
					
					actors.add(new Actor(name, null, null));
					for (Actor actor : actors) {
						//saveActor(actor);
						
					}
					
					
					}
				/*
				while ((values = readDirectors.readNext()) != null){
					String name =values[0];
					String bday = values[1];
					
					directors.add(new Director(name,null,bday));
					for (Director director : directors) {
						saveDirector(director);
						
					}
					
					
					} */
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void saveDirector(Director director) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Director loadDirector(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
