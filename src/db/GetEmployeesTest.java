package db;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

class GetEmployeesTest {
    
	private TestJackson employees = new TestJackson(); 
	
	@Test
	public void testGetEmployeesNotNull() throws MalformedURLException {
		
		
		assertNotNull(employees.getEmployees());
		
	}
	@Test
	public void testGetEmployeesNotEmpty() throws MalformedURLException {
		
		assertFalse(employees.getEmployees().isEmpty());
	}
	
	@Test 
	public void testGetEmployeesBevatAlleEmployees() throws MalformedURLException {
		//Aantal employees op huidige oData is gelijk aan 9
		assertEquals(9,employees.getEmployees().size());
	}

}
