package db;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import logic.BookApi;
import logic.BookGoogleAPI;
import logic.Employee;
import logic.MetadataOdata;


public class TestJackson {

	private static MetadataOdata metadata = null; 

	private static ObjectMapper mapper = null;
	public static List<Employee> getEmployees() throws MalformedURLException{
		
		URL jsonUrl = new URL(
				"http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
		ArrayList<Employee> list = new ArrayList<Employee>();
	
		mapper = new ObjectMapper(); 
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			
			
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
	

		
		public static ArrayList<BookGoogleAPI> getBooksByContent(String topic) throws IOException {
		//BookApi b = new BookApi();
		URL jsonUrl = new URL(
			//"https://www.googleapis.com/books/v1/volumes?q=" + topic);
			//	"https://www.googleapis.com/books/v1/volumes?q=" + topic+"&maxResults=40&filter=full");
		"https://www.googleapis.com/books/v1/volumes?q=" + topic+"&maxResults=40");
		mapper = new ObjectMapper(); 
		ArrayList<BookGoogleAPI> list = new ArrayList<BookGoogleAPI>();
		BookGoogleAPI myBook =null;
	  JsonNode root = mapper.readTree(jsonUrl);
	  //	  JsonNode item = root.path("items");
	  JsonNode arrayItem = root.get("items");
	
//	  JsonNode identifier = volumeInfo.get("industryIdentifiers");
//	  JsonNode author = volumeInfo.get("authors");
//	  JsonNode saleInfo = arrayItem.get("saleInfo");
	//  JsonNode isbn = volumeInfo.path("industryIdentifiers").get(1).path("identifier");
	  if(!root.path("error").isMissingNode()) {
		  //Dat wil zeggen dat de user wss geen input heeft ingevuld waardoor de json een error teruggeeft
		  return  null;
	  }
	  
	  if(arrayItem.isArray()) {
		  ArrayList<String> listAuthors=new ArrayList<String>();
		//  Iterator<JsonNode> items = item.elements();
		  for(JsonNode node: arrayItem) {
			  listAuthors=new ArrayList<String>();
			  myBook =new BookGoogleAPI();
			 myBook.setTitle(node.get("volumeInfo").get("title").asText());
			 
			  myBook.setPublishedDate(node.get("volumeInfo").path("publishedDate").asText());
			  myBook.setDescription(node.get("volumeInfo").path("description").asText());
		/*	  if(node.get("volumeInfo").path("authors").isNull()) {
				  //omdat het boek geen auteurs heeft
				  listAuthors= new ArrayList<String>();
				  listAuthors.add("Unknown authors");
				
			  }
			  
			  
		*/
			  for(JsonNode author :node.get("volumeInfo").path("authors")) {
				 
				  listAuthors.add(author.asText());
			  }
			  myBook.setAuthors(listAuthors);
			  //myBook.setIndustryIdentifiers(node.get("volumeInfo").get("industryIdentifiers").get(1).get("identifier").asText());
			 
			 if(node.get("volumeInfo").get("industryIdentifiers").isNull()) {
				//Indien er geen unieke identifier bestaat 
					 myBook.setIndustryIdentifiers("unknown");
			 
		 }else {
			// indien er een andere identifier bestaat 
			 myBook.setIndustryIdentifiers(node.path("volumeInfo").path("industryIdentifiers").get(0).path("identifier").asText());
		 }
			 
			
			 
			//  myBook.setIndustryIdentifiers("test");
//Als er geen retailPrice is in de Json wil dat zeggen dat het boek niet te koop is
			  if(node.path("saleInfo").path("retailPrice").isNull()) {
				  myBook.setPrice(0.0);
				
			  }else {
				  myBook.setPrice(node.path("saleInfo").path("retailPrice").path("amount").asDouble());
			  }
		
			  //myBook.setPrice(0.0);
			  list.add(myBook);
		  }
		 
	  }
	  
	  return list;
	  
	  
		
		
		

		
		
			
		
	}
	
	
	
}
