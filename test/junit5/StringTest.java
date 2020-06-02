package junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {
	
	private String str;

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
	@ValueSource(strings = {"ABCD","ABC","A","DEF"})		//valueSource can be used with (ints,longs,doubles,strings)[array of single value]
	void length_greater_then_0_Parameterize(String str) {
		assertTrue(str.length()>0);
	}
	
	@ParameterizedTest(name = "{0} convert uppercase to {1}")
	@CsvSource(value = {"abcd,ABCD","abc,ABC","'',''","abcdefg,ABCDEFG"})		//for operation on array of more than one value 
	void uppercase(String word, String capitalizedWord) {
		assertEquals(capitalizedWord,word.toUpperCase());		
	}
	
	@ParameterizedTest(name = "{0} length is {1}")					//to make name visible in output
	@CsvSource(value = {"abcd,4","abc,3","'',0","abcdefg,7"})		//for length 
	void length(String word, int expectedLength) {
		assertEquals(expectedLength,word.length());		
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
	@RepeatedTest(10)
	void contains_basic() {
		String str="abcdefgh";
		System.out.println("");
		boolean result = str.contains("ijk");
		assertTrue(!result);
	}
	
	@Test
	@Disabled	//In junit4 it was @ 
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(5), 

			() -> {
				for(int i=0; i<900000;i++) {
					System.out.println("---->"+i);
				}
			}
		);
	}
	
	@Test
	void split_basic() {
		String arr= "abc def ghi";
		String[] actualResult=arr.split(" ");
		String[] result=new String[] {"abc", "def" , "ghi"};
		
		assertArrayEquals(result, actualResult);
	}
	
	@Nested
	@DisplayName("test for empty ")
	class EmptyStringTests{
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		
		@Test
		@DisplayName("test for empty length")
		void lengthIsZero() {
			assertEquals(0, str.length());
		}
		
		@Test
		@DisplayName("test for empty uppercase")
		void upperCaseIsEmpty() {
			assertEquals("", str.toUpperCase());
		}
	}
	
	@Nested
	@DisplayName("sdf")
	class LargeStringTests{
		@BeforeEach
		void setToEmpty() {
			str="ndjkfgkfgkdjfgkdhghdkghdk";
		}
		
		@Test
		@DisplayName("sdf")
		void lengthIsLarge() {
			assertTrue(str.length()>9);
		}

	}

}
