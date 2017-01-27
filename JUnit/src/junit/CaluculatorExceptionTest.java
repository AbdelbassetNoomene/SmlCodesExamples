package junit;
import static org.junit.Assert.*;
import org.junit.Test;

public class CaluculatorExceptionTest {
	 @Test(expected = ArithmeticException.class)
	  public void divTest() {
	    Calculator calculator = new Calculator();
	    int res = calculator.div(12,0);	//success
	   // int res = calculator.div(12,0);	//error	    
	    assertEquals(4, res);
	}
}
