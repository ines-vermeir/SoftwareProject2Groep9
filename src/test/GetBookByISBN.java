package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import db.TestJackson;

public class GetBookByISBN {

	private TestJackson books;
	@Before
	public void setUp() throws Exception {
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
