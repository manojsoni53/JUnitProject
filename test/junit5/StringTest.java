package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("When String is null, throw an exception")
	void length_exception() {
		
		String str = null;
		assertThrows(NullPointerException.class, 
			() -> {
				str.length();
			}
				
		);
	}
	
	@Test
	void length_greater_then_0() {
		assertTrue("ABCD".length()>0);
		assertTrue("ABC".length()>0);
		assertTrue("A".length()>0);
		assertTrue("DEF".length()>0);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"ABCD","ABC","A","DEF"})			//valueSource can be uised with (ints,longs,doubles,strings)
	void length_greater_then_0_Parameterize(String str) {
		assertTrue(str.length()>0);
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
