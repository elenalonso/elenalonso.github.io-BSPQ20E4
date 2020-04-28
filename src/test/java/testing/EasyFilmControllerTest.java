package testing;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class EasyFilmControllerTest {
	
	private int num1 = 2;
	private int num2 = 0;
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(EasyFilmControllerTest.class);
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
