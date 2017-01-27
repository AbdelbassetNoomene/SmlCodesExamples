package ignoretest;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class IgnoreTestMethodLevel {
	StringUtil util = new StringUtil("a", "b");
	String res = "";

	@Ignore
	@Test
	public void testAddStrings() {
		System.out.println("Inside testAddStrings()");
		res = "ab";
		assertEquals(res, util.addStrings());
	}

	@Test
	public void testUpperCase() {
		System.out.println("Inside testUpperCase()");
		res = "AB";
		assertEquals(res, util.upperCase());
	}
}
