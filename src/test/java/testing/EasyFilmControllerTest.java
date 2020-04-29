package testing;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import client.controller.EasyFilmController;
import client.main.EasyFilmin;
import junit.framework.JUnit4TestAdapter;
import server.JettyServer;
import server.easyFilminData.User;

public class EasyFilmControllerTest {
	
	private String[] arg = {"127.0.0.1", "8080"};
	private static Thread jettyServerThread = null;
		
	private int num1 = 2;
	private int num2 = 0;
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(EasyFilmControllerTest.class);
		}
	
	@BeforeClass static public void setUp() throws Exception {
		//Launch the jetty server
//		JettyServer jettyServer = new JettyServer();
//		jettyServer.start();
//		}
//	
//	
//	@Test public void testConnection() {
//		String url = "http://localhost:8090/status";
//		HttpClient client = HttpClientBuilder.create().build();
//		HttpGet request = new HttpGet(url);
//		 
//		HttpResponse response = client.execute(request);
//		  
//		assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);	
	}
	
	@Test
	@PerfTest(invocations = 100)
	@Required(throughput = 10)
	public void test123() {
		num2 = 0;
		num2 = num2 + 2;
		assertEquals(num1, num2);
	}

}
