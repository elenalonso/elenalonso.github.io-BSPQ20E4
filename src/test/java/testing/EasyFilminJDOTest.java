package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import server.easyFilminDAO.EasyFilminJDO;
import server.easyFilminDAO.IEasyFilminDAO;
import server.easyFilminData.Actor;
import server.easyFilminData.Director;
import server.easyFilminData.Film;
import server.easyFilminData.FilmList;
import server.easyFilminData.User;

public class EasyFilminJDOTest {
	static Logger logger = Logger.getLogger(EasyFilminJDOTest.class.getName());
	
	private User user = new User("UserTest1", "23", "test@opentest.test", "321");
	private Actor a = new Actor("ActorTest0",null,"1965-03-16");
	private Director d = new Director("DirectorTest1",null,"1954-09-10");
	private IEasyFilminDAO iDAO = new EasyFilminJDO();
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	public EasyFilminJDOTest() {
		// TODO Auto-generated constructor stub

	}
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(EasyFilminJDOTest.class);
		}
	
	
	
	@Test
	@PerfTest(invocations = 7)
	@Required(max = 5000)
	public void testSaveLoadUser() {
		iDAO = new EasyFilminJDO();
		User userLoaded = null;
		iDAO.saveUser(user);
		userLoaded = iDAO.loadUser("UserTest1");
		iDAO.deleteUser("UserTest1");
		//System.out.println("Icon " + userLoaded.getIcon()); //What is going on here??
		assertEquals("UserTest1", userLoaded.getNickname());
		//assertEquals("23", userLoaded.getIcon()); //What is going on here??
		//assertEquals("test@opentest.test", userLoaded.getEmail());
		//assertEquals("321", userLoaded.getPassword());
		logger.debug("Save Load User tested");

	}
	
	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void testSaveLoadActor() {
		iDAO = new EasyFilminJDO();
		Actor actorLoaded1=null;
		Actor actorLoaded2=null;
				iDAO.saveActor(a); 
				actorLoaded1 =iDAO.loadActor("ActorTest0");
				iDAO.deleteActor("ActorTest0");
				iDAO.deleteActor("ActorTest1"); //from previous tests
				actorLoaded2 =iDAO.loadActor("ActorTest2");
				assertEquals("ActorTest0", actorLoaded1.getName());
				assertFalse("ActorTest2",actorLoaded2.getName() !=null);
				logger.debug("Save Load Actor tested");
	}
	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void testSaveLoadDirector() {
		iDAO = new EasyFilminJDO();
		Director directorLoaded1=null;
		Director directorLoaded2=null;
				iDAO.saveDirector(d); 
				directorLoaded1 =iDAO.loadDirector("DirectorTest1");
				iDAO.deleteDirector("DirectorTest1");
				directorLoaded2 =iDAO.loadDirector("DirectorTest2");
				assertEquals("ActorTest1", directorLoaded1.getName());
				assertFalse("ActorTest2",directorLoaded2.getName() !=null);
				logger.debug("Save Load Director tested");
	}
	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void testSaveLoadFilm() {
		iDAO = new EasyFilminJDO();
		Film prueba= new Film();
		prueba.setTitle("PRUBAPELICULA");
		Film fLoaded1=null;
		Film fLoaded2=null;
				iDAO.saveFilm(prueba); 
				fLoaded1 =iDAO.loadFilm("PRUEBAPELICULA");
				iDAO.deleteDirector("PRUEBAPELICULA");
				fLoaded2 =iDAO.loadFilm("FilmTest2");
				assertEquals("PRUEBAPELICULA", fLoaded1.getTitle());
				assertFalse("FilmTest2",fLoaded2.getTitle() !=null);
				logger.debug("Save Load Film tested");
	}
	
}
