package db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import logic.Employee;

public class TestGson {

	private static Gson gson = null;
	
	private static ArrayList<Employee> list = null;
	
	public static  ArrayList<Employee> getEmployees() throws IOException{
		
	
		URL jsonUrl;
		try {
		jsonUrl = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
			
	
//			HttpURLConnection request = (HttpURLConnection) jsonUrl.openConnection();
//			request.connect();
			
			URLConnection conn =jsonUrl.openConnection();
			Type listType = new TypeToken<ArrayList<Employee>>(){}.getType();
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			 list = gson.fromJson(reader, listType);
	       
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
		    return list; 
		    
		    
	}
	

	 
	
}
