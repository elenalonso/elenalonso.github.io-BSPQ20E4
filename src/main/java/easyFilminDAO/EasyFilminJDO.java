package easyFilminDAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import easyFilminData.User;


public class EasyFilminJDO implements IEasyFilminDAO{
	
	private PersistenceManagerFactory pmf = null;
	
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
			query.setFilter("Username == '" + username + "'"); //we find the user by his username
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

}
