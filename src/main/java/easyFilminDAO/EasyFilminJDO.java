package easyFilminDAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import easyFilminData.Actor;
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
		
		//Here we need to read the .csv and insert the appropiate data (with saveFilm(), saveActor())
		
		
	}
}
