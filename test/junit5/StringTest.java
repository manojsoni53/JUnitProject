package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		assertEquals(expectedLength, actualLength);	//int parameter
	}
	
	@Test
	void toUpperCase_basic() {
		 String str = "abcd";
		 String result = str.toUpperCase();
		 assertNotNull(result);
		 //duplicate test
		 assertEquals("ABCD", result);			//String parameter		
	}
	
	@Test
	void contains_basic() {
		String str="abcdefgh";
		boolean result = str.contains("ijk");
		
		//assertEquals(false, result);
		//assertFalse(result);
		assertTrue(!result);
	}

}
