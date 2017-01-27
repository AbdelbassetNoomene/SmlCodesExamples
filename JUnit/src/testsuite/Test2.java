package testsuite;

import static org.junit.Assert.assertEquals;
import org.junit.Test; 

public class Test2 {
	@Test
	  public void addTest() {
	    Calculator calculator = new Calculator();
	    int sum = calculator.sum(8,2);	    
	    assertEquals("8+2=10 Passed",10, sum);
	  }
}
