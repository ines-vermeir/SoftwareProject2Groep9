package db;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Employee;

public class TestJackson {

	
	
	public static List<Employee> getEmployees() throws MalformedURLException{
		
		URL jsonUrl = new URL(
				"http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
		
		List<Employee> list= null; 
		Employee e = null; 
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		try {
			list = new ArrayList<Employee>();
			list = mapper.readValue(jsonUrl, new TypeReference<List<Employee>>() {});
			
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return list ;
		
		
	}
}
