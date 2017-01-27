package testsuite;

import static org.junit.Assert.assertEquals;
import org.junit.Test; 

public class Test1 {
	@Test
	  public void squareTest() {
	    Calculator calculator = new Calculator();
	    int sqr = calculator.square(2);	    
	    assertEquals("2*2=4 Passed",4, sqr);
	  }
}
