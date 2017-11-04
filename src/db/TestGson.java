package db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import logic.Employee;
import logic.MetadataOdata;

public class TestGson {

	private static Gson gson = null;
	private static MetadataOdata metadata = null; 
	private static ArrayList<Employee> list = null;
	public static String readUrl(String urlString) {
		BufferedReader r = null;
		try {
			// User agent code overgenomen van Esailija op Stack Overflow
			// (http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser)
			URLConnection connection = new URL(urlString).openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();

			r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = r.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} catch (FileNotFoundException e) {
			return "";
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			return "";
		} finally {
			if (r != null)
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static  ArrayList<Employee> getEmployees() throws IOException{
		
	    
		URL jsonUrl;
		try {
		jsonUrl = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");

//			HttpURLConnection request = (HttpURLConnection) jsonUrl.openConnection();
//			request.connect();
			
			URLConnection conn =jsonUrl.openConnection();
//			Type listType = new TypeToken<ArrayList<Employee>>(){}.getType();
			
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			
			//String testReader = readUrl("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
	//		 list = gson.fromJson(reader, listType);

			metadata = gson.fromJson(reader,MetadataOdata.class);
			 list = (ArrayList<Employee>) metadata.getValue();
			// return (ArrayList<Employee>) metadata.getValue();
			 return list; 
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
		    return list; 
		    
		    
	}
	

	 
	
}
