package logic;


import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import db.BookDAO;
import db.BookDB;
import db.TestGson;
import db.TestJackson;
import java.util.Date;
import db.SessionDAO;
import db.SurveyDAO;

public class Source {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		

//		Book b1 = new Book("9781328994967","Timothy Ferriss","Tribe of mentors",new GregorianCalendar(2017,11,21));
//		Book b2 = new Book("9781501178139","Isabel Allende","In the midst of winter",new GregorianCalendar(2017,10,31));
//		Book b3 = new Book("9780062820754","Marc Sumerak","The Art of Harry Potter",new GregorianCalendar(2017,11,21));
//	Book b4 = new Book("test","test","testen",new GregorianCalendar(2017,8,16));
////		
//
//		Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
//		BookDAO dao = new BookDAO();
		
		// testing Michiel
		// DAO Survey
		
//		Survey survey1 = new Survey(1,20);
//		Survey survey2 = new Survey(3,17);
//		Survey survey3 = new Survey(4,15);
//		Survey survey4 = new Survey(4,15);
//		Survey survey5 = new Survey(4,80);
//		
//		SurveyDAO sdao = new SurveyDAO();
//		
//		sdao.addSurvey(survey1);
//		sdao.addSurvey(survey2);
//		sdao.addSurvey(survey3);
//		sdao.addSurvey(survey4);
//		sdao.addSurvey(survey5);
//		
//		sdao.getSurveyByID(1);
//		
//		sdao.deleteSurvey(3);
//		
//		sdao.getAllSurveys();
//		
//		sdao.getAllSurveyByTraining(15);
//		
//		sdao.update(survey4);
//		 
//		Book b1 = new Book("9781328994967","Timothy Ferriss","Tribe of mentors",new GregorianCalendar(2017,11,21));
//		Book b2 = new Book("9781501178139","Isabel Allende","In the midst of winter",new GregorianCalendar(2017,10,31));
//		Book b3 = new Book("9780062820754","Marc Sumerak","The Art of Harry Potter",new GregorianCalendar(2017,11,21));
//	Book b4 = new Book("test","test","testen",new GregorianCalendar(2017,8,16));
//		

//		Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
		//BookDAO dao = new BookDAO();
		

//		dao.insertBook(b1);
//		dao.insertBook(b2);
//		dao.insertBook(b3);
//		dao.insertBook(b4);
//		dao.insertBook(b5);
		
		//dao.archiveBook("test1");
		//dao.deleteBook("test");
		
//		ArrayList<Book> lijst = dao.getAllBooks();
//		
//		for(Book b: lijst) {
//			System.out.println(b.toString());
//		}
		//ArrayList<Book> lijst = dao.getAllBooks();
		//System.out.println(lijst.toString());
		
		//System.out.println("---- GET BOOK by ISBN------------");
		
//		
//		
//		
//		if(dao.getBook("9780062820754") == null) {
//			
//			System.out.println("Sorry het boek dat jij zoekt bestaat niet");
//		}else {
//			System.out.println(dao.getBook("9780062820754").toString());
//		}
//		
//		
		
		/*
		System.out.println("---- UPDATE BOOK------------");
		Book b6 = dao.getBook("test");
	b6.setAuthor("testUpdated");
		b6.setTitle("New title");
		dao.updateBook(b6);
		System.out.println(dao.getBook("test").toString());  */
		
		
//------------ Volgende code is om de connectie met de database met Hibernate te testen (By Sebastian G)  ----------
//		Calendar myCal =  new GregorianCalendar();
//		
//		myCal.set(GregorianCalendar.YEAR, 2015);
//		myCal.set(GregorianCalendar.MONTH,8);
//		myCal.set(GregorianCalendar.DATE,23);
//	   Book myBook = new Book("test5","Last Title","Last Author", myCal);
//		
//		
		BookDB db = new BookDB();
		


//		Book myBook = new Book("testH","testH","testH",new GregorianCalendar(2017,9,22));
//		
//		db.insertBook(myBook);
		
//	 Book newBook = db.getBook("testH");

		//System.out.println(dao.getBook("test").toString());
		
/*	 Book newBook = db.getBook("Last Book");
branch 'SebastianG' of https://github.com/ines-vermeir/SoftwareProject2Groep9.git
		
	 if(newBook != null) {
		 
		 System.out.println(newBook.toString());
	 }else {
		 System.out.println("Sorry, het boek bestaat niet");
		 
	 }
	 
	 
	
	
		newBook.setTitle("Last Book Hier");
	db.updateBook(newBook);
		
	System.out.println("-----UPDATE-------");		
		System.out.println(newBook.toString());
		*/
		
	//	db.deleteBook(myBook);
		
	/*	ArrayList<Book> books = db.getAllBooks();
		
	for(int i=0; i< books.size(); i++) {
			System.out.println(books.get(i).toString());
		}*/
		
		
		
		//--------------- Odata lezen ---------------------------
		//ArrayList<Employee> employees= (ArrayList<Employee>) TestJackson.getEmployees();
	//	ArrayList<Value> employees=  TestGson.getEmployees();
		
	//	System.out.println(TestGson.readUrl("http://services.odata.org/V3/Northwind/Northwind.svc/Employees?$format=json"));
		
//		for(int i=0; i< employees.size(); i++) {
//			System.out.println(employees.get(i).toString());
//			System.out.println("\n");
//			}
//		
//	}
		
		//Odata google Books Api 
		
		ArrayList books = TestJackson.getBooksByContent("php");
		
		for(int i=0; i< books.size(); i++) {
						System.out.println(books.get(i).toString());
		}
			System.out.println("\n");
			}
		
		
		
		
//tot hier code van Sebastian G--------------------------------------------------------------------------------------------------------------------------

		//Testcode sessieDAO:
		//int trainingID, Calendar date, String startTime, String endTime, Location location
		//int ID, String streetName, String number, String postalCode, String city, String country, String name, String info
		//Location l = new Location (5, "teststraat", "testnummer", "testpostalcode", "testcity", "testcountry", "testname", "testinfo");		
		//Session s = new Session(10, new GregorianCalendar(2017,8,16), "09:00", "12:00", l);
		//SessionDAO dao = new SessionDAO();
		//dao.insertSession(s);
		
	}

	
	
	
	
	
	
	
	
	
	//hieronder: code afkomstig uit klasse login (Charles)
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
//		//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
//		Scanner input = new Scanner(System.in); // (database verbinding voor input?)
//		
//		// =====
//		try {
//			Scanner scan = new Scanner (new File(" "));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String file_username = "John";		//--> Ik heb dit hardcoded want ik weet niet hoe 27/10/2017
//		String file_password = "Bonus";
//		
//		System.out.println("Give your login credentials. ");
//		System.out.println("Username: ");
//		String input_username = input.next();
//		
//		System.out.println("Password: ");
//		String input_password =input.next();
//		
//		//users check = new users(username, password);
//		
//		if(input_username.equals(file_username) && input_password.equals(file_password)) {
//			System.out.println("Welcome, " + file_username + "! You are logged in!");
//		}else {
//			System.out.print("Please, provide the correct credentials.");
//		}
//	}
//}
//}


