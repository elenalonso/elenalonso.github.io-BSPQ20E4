package easyFilminData;

import java.sql.Date;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class JDO_Test_Main {
	
static Logger logger = Logger.getLogger(JDO_Test_Main.class.getName());

	@SuppressWarnings("unchecked")
	public static void main(String args[])
    {
		
    	System.out.println("Starting ....");
        // Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        logger.debug("DataNucleus AccessPlatform with JDO");
        logger.debug("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            logger.debug("Persisting actors");
       
			Actor actor = new Actor("Ac1", "z", "04-10-2014");
      
            pm.makePersistent(actor);
 
            tx.commit();
            logger.debug("Actor has been persisted");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
       
        logger.debug("End of Tutorial");
		pmf.close();
    }

}
