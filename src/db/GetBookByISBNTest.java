package db;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetBookByISBNTest {

	private TestJackson books;
	@BeforeEach
	void setUp() throws Exception {
		books = new TestJackson(); 
	}


	@Test
	public void testGeenInputGeeftNull() {
		
		assertNull(books.getBookByISBN(""));
	}
    
	
	@Test
	public void testGetBooksByISBNNotNull() throws MalformedURLException {
		
		
		assertNotNull(books.getBookByISBN("9780321185792"));
		
	}
		
	@Test
	public void testNietGevondenBoekGeefNull() {
		
		assertNull(books.getBookByISBN("lkeljekjkhdjb"));
	}
    
	
	
}
