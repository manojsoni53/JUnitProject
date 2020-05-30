package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {

	@BeforeAll			  //Initialize once before any of the method or all method, even before @BeforeEach
	static void beforeAll() {
		System.out.println("Initialize connection");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Clossing connection");
	}
	
	@BeforeEach		//Initialize before every method in class event run for single method
	void beforeEach(TestInfo info) {		//parameter is optional, in junit there was no parameter
		System.out.println("Initialize test data for "+info.getDisplayName());
	}
	
	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("data clean up for "+info.getDisplayName());
	}
	
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
	
	@Test
	void split_basic() {
		String arr= "abc def ghi";
		String[] actualResult=arr.split(" ");
		String[] result=new String[] {"abc", "def" , "ghi"};
		
		assertArrayEquals(result, actualResult);
	}

}
