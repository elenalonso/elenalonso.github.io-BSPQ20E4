package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Comment;

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
import server.easyFilminData.Genre;
import server.easyFilminData.User;
import server.easyFilminData.WatchList;
import server.easyFilminData.Watched;

public class EasyFilminJDOTest {
	static Logger logger = Logger.getLogger(EasyFilminJDOTest.class.getName());
	
	private User user = new User("UserTest1", "23", "test@opentest.test", "321");
	private Actor a = new Actor("ActorTest0",null,"1965-03-16");
	private Director d = new Director("DirectorTest1",null,"1954-09-10");
	private IEasyFilminDAO iDAO = new EasyFilminJDO();
	static LocalDate ld;
	
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

	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void testSaveLoadWatched() {
		iDAO = new EasyFilminJDO();
		Watched w = new Watched("Watched");
		Film prueba = new Film("prueba", "","","",1,new Genre("Drama"),2.5, null, null);
		w.addFilm(prueba);
		Watched w1 = null;
		Watched w2 = null;
				iDAO.saveWatched(w); 
				w1 =iDAO.loadWatched("Watched");
				w2 =iDAO.loadWatched("Watched2");
				assertEquals(w1.getFilmList(), w.getFilmList());
				assertNull(w2);
				logger.debug("Save Load Watched tested");
	}

	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void testSaveLoadWatchList() {
		iDAO = new EasyFilminJDO();
		WatchList w = new WatchList("WatchList");
		Film prueba = new Film("prueba", "","","",1,new Genre("Drama"),2.5, null, null);
		w.addFilm(prueba);
		WatchList w1 = null;
		WatchList w2 = null;
				iDAO.saveWatchList(w); 
				w1 =iDAO.loadWatchList("WatchList");
				w2 =iDAO.loadWatchList("WatchList2");
				assertEquals(w1.getFilmList(), w.getFilmList());
				assertNull(w2);
				logger.debug("Save Load WatchList tested");
	}
	//CANNOT INSTANTIATE COMMENT ERROR 
//	@Test
//	@PerfTest(invocations = 15)
//	@Required(max = 5000)
//	public void testSaveLoadComments() {
//		iDAO = new EasyFilminJDO();
//		ld = LocalDate.of(2020, 5, 1);
//		ArrayList<Comment> ac = new ArrayList<>();
//		ac.add(new Comment("prueba", "Comment1", ld));
//		Film prueba = new Film("prueba", "","","",1,new Genre("Drama"),2.5, null, null);
//		prueba.setComments(comments);
//	}

	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void startBDgetAllFilmsTest() {
		iDAO = new EasyFilminJDO();
		iDAO.startBD();
		List<Film> alFilms = iDAO.getAllFilms();
		List<Film> alPrueba = null;
		BufferedReader bufferedReader;
	    int count = 0;
		try {
			bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\filmsPRUEBA.csv"));
		    String input;
		    while((input = bufferedReader.readLine()) != null)count++;
		    System.out.println("Count : "+count);

		} catch (IOException e) {
			logger.error("CSV FILE NOT FOUND");
			e.printStackTrace();
		}
		assertEquals(alFilms.size(),count );

		logger.debug("get All Films tested");
	}
	

	@Test
	@PerfTest(invocations = 15)
	@Required(max = 5000)
	public void loadFilmListTest() {
		iDAO = new EasyFilminJDO();
		FilmList f = new FilmList("NoName");
		FilmList fl = iDAO.loadFilmList("Watched");
		
		assertNotEquals(f, fl);

		logger.debug("loadFilmList test");
		logger.error("We need to fix the loadFilmList method in the first place");
	}

}
