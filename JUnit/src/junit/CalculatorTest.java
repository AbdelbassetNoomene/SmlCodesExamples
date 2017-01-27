package junit;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	@Test
	  public void squareTest() {
	    Calculator calculator = new Calculator();
	    int sqr = calculator.square(2);
	    //Checking for 2
	    assertEquals("2*2=4 Passed",4, sqr);
	  }
}
