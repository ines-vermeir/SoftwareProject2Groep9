package db;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetBooksByContentTest {
	private TestJackson books;
	@BeforeEach
	void setUp() throws Exception {
		books = new TestJackson(); 
	}


	@Test
	public void testGeenInputGeeftNull() {
		
		assertNull(books.getBooksByContent(""));
	}
    
	//Max result is 40 volgens Google Books documentatie
	@Test
	public void  testMaxResult() {
		
		assertEquals(40,books.getBooksByContent("php").size());
	}
	
	@Test
	public void testGetBooksByContentNotNull() throws MalformedURLException {
		
		
		assertNotNull(books.getBooksByContent("php"));
		
	}
	@Test
	public void testGetBooksByContentNotEmpty() throws MalformedURLException {
		
		assertFalse(books.getBooksByContent("php").isEmpty());
	}
	
	
}
