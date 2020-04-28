package testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import server.easyFilminDAO.EasyFilminJDO;
import server.easyFilminDAO.IEasyFilminDAO;
import server.easyFilminData.Film;
import server.easyFilminData.FilmList;
import server.easyFilminData.User;

public class EasyFilminJDOTest {
	
	private User user = new User("UserTest1", "23", "test@opentest.test", "321");
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

	}

}
