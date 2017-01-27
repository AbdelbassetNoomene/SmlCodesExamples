package basic;

import org.junit.Test;
import static org.junit.Assert.*;
public class OperationsTest {
	
	@Test
	public void checkNotNull(int x, int y){		
		 assertNotNull("checkNotNull:X is Null",x);
		 assertNotNull("checkNotNull:Y is Null",y);
			
	}
	
	@Test
	public void checkSub(int x, int y){		
		
		assertTrue("checkSub :X always > Y", x>y);
	}
	
	@Test
	public void checkMul(int x, int y){		
		assertTrue("checkMul:X  > 0", x>0);
		assertTrue("checkMul:Y  > 0", y>0);
		
	}
	@Test
	public void checkDiv(int x, int y){		
		assertFalse("checkDiv : Y!=0",y!=0);		
	}
	
}
