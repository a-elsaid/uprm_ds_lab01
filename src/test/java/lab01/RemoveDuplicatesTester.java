//import static org.junit.Assert.assertEquals;
package lab01;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class RemoveDuplicatesTester {

	private RemoveDuplicates.Bag<String> B1 = null;


	@Before
	public void setUp() throws Exception {
		B1 = new RemoveDuplicates.ArrayBag<String>(10);
		B1.add("Ken");
		B1.add("Ron");
		B1.add("Joe");
		B1.add("Amy");
		B1.add("Xi");
		// B1 = {Ken, Ron, Joe, Amy, Xi}

	}

	
	@Test
	public void testEmptySet() {
		B1.clear();
		assertEquals("On B1 = {}, removeDuplicates(B1) fails to return 0 when bag is empty", 0, RemoveDuplicates.removeDuplicates(B1));
	}	


	@Test
	public void testCase1() {
		int getFrequencyOf = RemoveDuplicates.removeDuplicates(B1);
		assertEquals("On B1 = {Ken, Ron, Joe, Amy, Xi}, removeDuplicates(B1) fails to return 0", 0, getFrequencyOf);
	}
	@Test
	public void testCase2() {
		B1.add("Ron");
		int getFrequencyOf = RemoveDuplicates.removeDuplicates(B1);
		assertEquals("On B1 = {Ken, Ron, Joe, Amy, Xi, Ron}, removeDuplicates(B1) fails to return 1 and erase one copy of Ron", true , 
				getFrequencyOf==1 && B1.getFrequencyOf("Ron") == 1);
	}
	@Test
	public void testCase3() {
		B1.add("Ron");
		B1.add("Ron");
		int getFrequencyOf = RemoveDuplicates.removeDuplicates(B1);
		assertEquals("On B1 = {Ken, Ron, Joe, Amy, Xi, Ron, Ron}, removeDuplicates(B1) fails to return 2 and erase two copies of Ron", true , 
				getFrequencyOf==2 && B1.getFrequencyOf("Ron") == 1 && B1.size() == 5);
	}
	@Test
	public void testCase4() {
		B1.add("Ron");
		B1.add("Ken");
		int getFrequencyOf = RemoveDuplicates.removeDuplicates(B1);
		assertEquals("On B1 = {Ken, Ron, Joe, Amy, Xi, Ron, Ken}, removeDuplicates(B1) fails to return 2 and erase one copy of Ron and one copy of Ken", true , 
				getFrequencyOf==2 && B1.getFrequencyOf("Ron") == 1 && B1.getFrequencyOf("Ken") == 1);
	}
	@Test
	public void testCase5() {
		B1.add("Ron");
		B1.add("Ken");
		B1.add("Xi");

		int getFrequencyOf = RemoveDuplicates.removeDuplicates(B1);
		assertEquals("On B1 = {Ken, Ron, Joe, Amy, Xi, Ron}, removeDuplicates(B1) fails to return 3 and erase one copy of Ron, one copy of Ken, and one copy of Xi", true , 
				getFrequencyOf==3 && B1.getFrequencyOf("Ron") == 1 && B1.getFrequencyOf("Ken") == 1 && B1.getFrequencyOf("Xi") == 1);
	}	
}
