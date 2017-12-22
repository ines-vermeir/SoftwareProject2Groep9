package test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import db.TestJackson;

public class GetBooksByContentTest {

	private TestJackson books;
	@Before
	public void setUp() throws Exception {
		books = new TestJackson(); 
	}


	@Test
	public void testGeenInputGeeftNull() {
		
		assertNull(books.getBooksByContent(""));
	}
    /*
	//Max result is 40 volgens Google Books documentatie
	@Test
	public void  testMaxResult() {
		
		assertEquals(40,books.getBooksByContent("cook").size());
	}
	*/
	@Test
	public void testGetBooksByContentNotNull() throws MalformedURLException {
		
		
		assertNotNull(books.getBooksByContent("php"));
		
	}
	@Test
	public void testGetBooksByContentNotEmpty() throws MalformedURLException {
		
		assertFalse(books.getBooksByContent("php").isEmpty());
	}
	
}
