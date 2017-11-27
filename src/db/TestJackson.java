package db;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
// Log initialiseren 
	final static Logger logger = LogManager.getLogger(TestJackson.class);
	private static MetadataOdata metadata = null; 

	private static ObjectMapper mapper = null;
	public static List<Employee> getEmployees() throws MalformedURLException{
		logger.info("Beginnen consumen Employee Odata methode getEmployees()");
		URL jsonUrl = new URL(
				"http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json");
		ArrayList<Employee> list = new ArrayList<Employee>();
	
		mapper = new ObjectMapper(); 
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		
		try {
			
		
		metadata=	mapper.readValue(jsonUrl, MetadataOdata.class);
		
		  list = (ArrayList<Employee>) metadata.getValue();
			
		} catch (JsonParseException e1) {
			logger.error("Error bij parsen odata employee"+ e1.getMessage());
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			logger.error("Error bij mappen odata employee"+ e1.getMessage());
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		logger.info("Methode heeft een list teruggegeven");
		return list ;
		
		
	}
	

		
	/*	public static ArrayList<BookGoogleAPI> getBooksByContent(String topic)  {
		//BookApi b = new BookApi();
			logger.info("Beginnen getBooksByContent methode om Boeken te zoeken ");
			String	newTopic = topic.replaceAll(" ", "+");
		URL jsonUrl=null;
		try {
			jsonUrl = new URL(
				
				//"https://www.googleapis.com/books/v1/volumes?q=" + topic);
					//"https://www.googleapis.com/books/v1/volumes?q=" + topic+"&maxResults=40&filter=full");
"https://www.googleapis.com/books/v1/volumes?q=" + newTopic+"&maxResults=40");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error bij lezen van URL "+ e.getMessage());
		}
		mapper = new ObjectMapper(); 
		ArrayList<BookGoogleAPI> list = new ArrayList<BookGoogleAPI>();
		BookGoogleAPI myBook =null;
	  JsonNode root=null;
	try {
		root = mapper.readTree(jsonUrl);
	} catch (IOException e) {
		logger.error("Error bij mappen van de Json rootnode  "+ e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
			  
			  
		
			  for(JsonNode author :node.get("volumeInfo").path("authors")) {
				 
				  listAuthors.add(author.asText());
			  }
			  myBook.setAuthors(listAuthors);
			 // myBook.setIndustryIdentifiers(node.get("volumeInfo").get("industryIdentifiers").get(0).get("identifier").asText());
			 
			 if(node.get("volumeInfo").path("industryIdentifiers").isNull()) {
				//Indien er geen unieke identifier bestaat 
					 myBook.setIndustryIdentifiers("unknown");
			 
		 }else {
			// indien er een andere identifier bestaat 
			// myBook.setIndustryIdentifiers(node.path("volumeInfo").get("industryIdentifiers").get(0).get("identifier").asText());
			  myBook.setIndustryIdentifiers(node.path("volumeInfo").path("industryIdentifiers").path(0).path("identifier").asText());
			//  myBook.setIndustryIdentifiers("test");
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
	  
	  logger.info("Er wordt een list teruggegeven ");
	  return list;
	  		
		
	}
	*/

		public static ArrayList<BookGoogleAPI> getBooksByContent(String topic)  {
		//BookApi b = new BookApi();
			logger.info("Beginnen getBooksByContent methode om Boeken te zoeken ");
			String	newTopic = topic.replaceAll(" ", "+");
		URL jsonUrl=null;
		try {
			jsonUrl = new URL(
				
				//"https://www.googleapis.com/books/v1/volumes?q=" + topic);
					//"https://www.googleapis.com/books/v1/volumes?q=" + topic+"&maxResults=40&filter=full");
"https://www.googleapis.com/books/v1/volumes?q=" + newTopic+"&maxResults=40");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error bij lezen van URL "+ e.getMessage());
		}
		mapper = new ObjectMapper(); 
		ArrayList<BookGoogleAPI> list = new ArrayList<BookGoogleAPI>();
		BookGoogleAPI myBook =null;
	  JsonNode root=null;
	try {
		root = mapper.readTree(jsonUrl);
	} catch (IOException e) {
		logger.error("Error bij mappen van de Json rootnode  "+ e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
		//  ArrayList<String> listAuthors=new ArrayList<String>();
		//  Iterator<JsonNode> items = item.elements();
		  for(JsonNode node: arrayItem) {
			
			  list.add(fillBook(node));
		  }
		 
	  }
	  
	  logger.info("Er wordt een list teruggegeven ");
	  return list;
	  		
		
	}
    private static BookGoogleAPI fillBook(JsonNode node) {
    	BookGoogleAPI  myBook = null;
  	  ArrayList<String> listAuthors=null;
  	
    	if(node != null) {
    
    	listAuthors=new ArrayList<String>();
		 myBook =new BookGoogleAPI();
		 myBook.setTitle(node.get("volumeInfo").get("title").asText());
		 
		  myBook.setPublishedDate(node.get("volumeInfo").path("publishedDate").asText());
		  myBook.setDescription(node.get("volumeInfo").path("description").asText());

		  for(JsonNode author :node.get("volumeInfo").path("authors")) {
			 
			  listAuthors.add(author.asText());
		  }
		  myBook.setAuthors(listAuthors);
		
		 
		 if(node.get("volumeInfo").path("industryIdentifiers").isNull()) {
			//Indien er geen unieke identifier bestaat 
				 myBook.setIndustryIdentifiers("unknown");
		 
	 }else {
		// indien er een andere identifier bestaat 
		
		  myBook.setIndustryIdentifiers(node.path("volumeInfo").path("industryIdentifiers").path(0).path("identifier").asText());
		
	 }
		 
		
		 
		
//Als er geen retailPrice is in de Json wil dat zeggen dat het boek niet te koop is
		  if(node.path("saleInfo").path("retailPrice").isNull()) {
			  myBook.setPrice(0.0);
			
		  }else {
			  myBook.setPrice(node.path("saleInfo").path("retailPrice").path("amount").asDouble());
		  }
    	}
    	
        return myBook;     	
    
	
    }
		
	public static BookGoogleAPI getBookByISBN(String isbn) {
		
		//BookApi b = new BookApi();
		logger.info("Beginnen getBooksByISBN methode");
		String	newIsbn = isbn.replaceAll(" ", "+");
	URL jsonUrl=null;
	try {
		jsonUrl = new URL(
			
"https://www.googleapis.com/books/v1/volumes?q=isbn:" + newIsbn);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.error("Error bij lezen van URL "+ e.getMessage());
	}
	mapper = new ObjectMapper(); 
	
	BookGoogleAPI myBook =null;
  JsonNode root=null;
try {
	root = mapper.readTree(jsonUrl);
} catch (IOException e) {
	logger.error("Error bij mappen van de Json rootnode  "+ e.getMessage());
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  //	  JsonNode item = root.path("items");
  JsonNode arrayItem = root.get("items");

//  JsonNode identifier = volumeInfo.get("industryIdentifiers");
//  JsonNode author = volumeInfo.get("authors");
//  JsonNode saleInfo = arrayItem.get("saleInfo");
//  JsonNode isbn = volumeInfo.path("industryIdentifiers").get(1).path("identifier");
  if(!root.path("error").isMissingNode()) {
	  //Dat wil zeggen dat de user wss geen input heeft ingevuld waardoor de json een error teruggeeft
	  return  null;
  }
  
  if(arrayItem.isArray()) {
	
	myBook= fillBook(arrayItem.get(0));
	 
  }
  
  logger.info("Er wordt een BookGoogleAPI object teruggegeven ");
  return myBook;
		
	}
	
	
}
