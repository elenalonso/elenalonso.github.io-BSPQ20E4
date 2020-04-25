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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import easyFilminData.Actor;
import easyFilminData.Director;
import easyFilminData.Film;
import easyFilminData.Genre;
import easyFilminData.User;
import easyFilminData.WatchList;
import easyFilminData.Watched;
import ui.FilmListUI;


public class EasyFilminJDO implements IEasyFilminDAO{
	
	private PersistenceManagerFactory pmf = null;
	private ArrayList<Actor> actores;
	private ArrayList<Director> directores;
	static int contVueltas =0;
	static Logger logger = Logger.getLogger(FilmListUI.class.getName());
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
			query.setFilter("name == '" + name + "'"); //we find the actor by his name
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
			query.setFilter("title == '" + title + "'"); //we find the film by his title
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

	
	@SuppressWarnings("null")
	@Override
	public void startBD() {
		// TODO Auto-generated method stub
		
		/**This method reads data from csv files to save it into the DB.
		 * 
		 * @param actores --> arrayList containing the actors' names which have been read from the 'Actors' field in films.csv
		 * @param directores --> arrayList containing the directors' names which have been read from the 'Directors' field in films.csv
		 * 
		 * each time a new row is read both arrayLists are set null so that it does not store actors/directors from previously read films
		 * 
		 * 
		 * 
		 * @param actors/directors -> arrayList used specifically to saveActor/Director (might not be used later on)
		 */
			
		try {
			
			CSVReader readFilms = new CSVReaderBuilder(new FileReader("src\\main\\resources\\films.csv")).withSkipLines(1).build(); 
			CSVReader readActors = new CSVReaderBuilder(new FileReader("src\\main\\resources\\actors.csv")).withSkipLines(1).build();
			CSVReader readDirectors = new CSVReaderBuilder(new FileReader("src\\main\\resources\\directors.csv")).withSkipLines(1).build(); 
			 
			ArrayList<Film> films = new ArrayList<Film>();
			ArrayList<Actor> actors = new ArrayList<Actor>();
			ArrayList<Director> directors = new ArrayList<Director>();
			
			String[] values = null;
		    try {
		    	logger.warn("We need to FIX this method");
				while ((values = readActors.readNext()) != null&&contVueltas<10){
					String name =values[0];
					String bday = values[1];
					
					System.out.println("Name:" +name+", bday:"+bday);
					
					actors.add(new Actor(name, null, null));
					for (Actor actor : actors) {
						saveActor(actor);
						contVueltas++;	
					}
					
					
				}
				contVueltas =0;
				while ((values = readDirectors.readNext()) != null&&contVueltas<10){
					String name =values[0];
					String bday = values[1];
					
					directors.add(new Director(name,null,bday));
					for (Director director : directors) {
						saveDirector(director);
					}
					contVueltas++;
				} 
				contVueltas = 0;
				while ((values = readFilms.readNext()) != null&&contVueltas<10){
					actores =null;
					directores=null;
					String title =values[0];
					//This doesnt work
					logger.warn("VALUES from FILMS in BD are not well retrieved");
//					String year = values[2];
//					String desc = values[3];
//					int dur = Integer.parseInt(values[4]);
//					String gen = values[5];
					Genre g = null;
					double rate = 2.5;
					String[] ac = {" ",""};
					String[] dr = {" ",""};
//					Genre g= new Genre(gen);
//					double rate = Double.parseDouble(values[6]);
//					String[] ac = values[7].toString().split("|");
//					for (String a : ac) {
//						actores.add(new Actor(a,null,null));
//					}
//					String[] dr =values[8].toString().split("|");
//					for (String d : dr) {
//						directores.add(new Director(d,null,null));
//					}
					//Uncomment when fixed 
					
//					films.add(new Film(title, null,year,desc,dur,g,rate,actores,directores));
					films.add(new Film(title, null,null,null,1,null,rate,null,null));
					for (Film film : films) {
						saveFilm(film);
				
					}
					logger.error("Without this cuentavueltas goes into an infinite loop");
					contVueltas++;
				}
				contVueltas =0;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (com.opencsv.exceptions.CsvValidationException cve) {
				cve.printStackTrace();
			}
		    
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void saveDirector(Director director) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert directors in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(director);
			
			
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
	public Director loadDirector(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("- Retrieving directors");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<Director> query = pm.newQuery(Director.class);
			query.setFilter("name == '" + name + "'"); //we find the film by his title
			query.setUnique(true);
			@SuppressWarnings("unchecked")
			Director director = (Director) query.execute();

			//End the transaction
			tx.commit();
			
			
			return director;
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving directors using a 'Query': " + ex.getMessage());
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
	public Watched loadWatched(String name) {
		// TODO Auto-generated method stub
				PersistenceManager pm = null;
				Transaction tx = null;
				
				try {
					System.out.println("- Retrieving watched");			
					//Get the Persistence Manager
					pm = pmf.getPersistenceManager();
					//Obtain the current transaction
					tx = pm.currentTransaction();		
					//Start the transaction
					tx.begin();

					Query<Watched> query = pm.newQuery(Watched.class);
					query.setFilter("name == '" + name + "'"); 
					query.setUnique(true);
					@SuppressWarnings("unchecked")
					Watched watched = (Watched) query.execute();

					//End the transaction
					tx.commit();
					
					
					return watched;
				} catch (Exception ex) {
					System.err.println(" $ Error retrieving directors using a 'Query': " + ex.getMessage());
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
	public void saveWatched(Watched watched) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert watched in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(watched);
			
			
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
	public WatchList loadWatchList(String name) {
		// TODO Auto-generated method stub
				PersistenceManager pm = null;
				Transaction tx = null;
				
				try {
					System.out.println("- Retrieving WatchList");			
					//Get the Persistence Manager
					pm = pmf.getPersistenceManager();
					//Obtain the current transaction
					tx = pm.currentTransaction();		
					//Start the transaction
					tx.begin();

					Query<WatchList> query = pm.newQuery(WatchList.class);
					query.setFilter("name == '" + name + "'"); 
					query.setUnique(true);
					@SuppressWarnings("unchecked")
					WatchList watchlist = (WatchList) query.execute();

					//End the transaction
					tx.commit();
					
					
					return watchlist;
				} catch (Exception ex) {
					System.err.println(" $ Error retrieving WatchList using a 'Query': " + ex.getMessage());
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
	public void saveWatchList(WatchList watchlist) {
		// TODO Auto-generated method stub
		PersistenceManager pm = null;
		Transaction tx = null;
		
		try {
			System.out.println("Insert watchlist in the DB");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			pm.makePersistent(watchlist);
			
			
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
}
