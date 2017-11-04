package db;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Employee;
import logic.MetadataOdata;


public class TestJackson {

	private static MetadataOdata metadata = null; 
	
	public static List<Employee> getEmployees() throws MalformedURLException{
		
		URL jsonUrl = new URL(
				"http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
		ArrayList<Employee> list = new ArrayList<Employee>();
		//List<Employee> list= null; 
		//Employee e = null; 
		
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			
			//list = mapper.readValue(jsonUrl, new TypeReference<List<Employee>>() {});
		metadata=	mapper.readValue(jsonUrl, MetadataOdata.class);
		
		  list = (ArrayList<Employee>) metadata.getValue();
			
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
