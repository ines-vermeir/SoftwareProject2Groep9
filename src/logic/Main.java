package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import db.BookDAO;
import db.BookDB;
import db.TestGson;
import db.TestJackson;
import db.UserDB;
import logic.User.Privilege;

import java.util.Date;
import db.SessionDAO;
import db.SurveyDAO;

public class Main {

	
//----------------------------------------------------login functie----------------------------------------------------------------------------	
	/*
	 * LOGIN 
	 * 
	 */

//----------------------------------------------------hoofdmenu (afhankelijk van privilege andere menu laten zien)------------------------------------------------------	
	
	/* MENU PRIVILEGE 1 (EMPLOYEE)  */
	public void menuEmployee (int privilege, String naam) throws IOException {
		System.out.println("Welkom" + naam);
		System.out.println("1. training");
		System.out.println("2. Certificate");
		System.out.println("3. Log Out");
		
		int input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			input = br.read();
		} while (input < 1 || input > 3);
		
		switch (input) {
		case 1: /*trainingMenu(privilege);*/
		 		break;
		case 2: /*certificateMenu(privilege)*/
				break;
		case 3: return;	
		default: break;
			
		}
	}
	
	
	/*
	 * MENU PRIVILEGE 2(docent)
	 * 
	 */
	
	/*
	 * MENU PRIVILEGE 3 (HR)
	 * 
	 */

	
//MICHIEL-------------------------------------methodes/menu klasse Training -------------------------------------------------------------------
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)
	
	/*
	 * Trainig  methodes
	 * MENU training --> bepaald wat je kan zien (adhv privileges)
	 * 
	 * 
	 */

//CHARLES-------------------------------------methodes/menu klasse Certificate------------------------------------------------------------------
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	
	
	
	/*
	 * Certificate
	 * MENU certificate
	 * 
	 */

//SEBASTIAN-------------------------------------methodes/menu klasse Book----------------------------------------------------------------------	
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	
	
	/*
	 * Book
	 * 
	 */

//SEBASTIAN-------------------------------------methodes/menu klasse Employee-------------------------------------------------------------------------	
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)
	
	/*
	 * Employee
	 * 
	 */

//EVA-------------------------------------	methodes/menu klasse Session-------------------------------------------------------------------------	
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)

	
	
	
	
//INES-------------------------------------	methodes/menu klasse Location------------------------------------------------------------------------	
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)

	
	
	
	
//MICHIEL-------------------------------------	methodes/menu klasses Survey&Question--------------------------------------------------------------
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	

	
	
//EVA-------------------------------------	methodes/menu klasse User--------------------------------------------------------------	
	//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	
	
	
	
	public static void main(String[] args) throws SQLException, Exception {
		
		System.out.println("Welkom");

		
		
		

//---------------------------------------------------Testcode Eva---------------------------------------------------------------------------------		
		
//---------------------------------------------------Testcode Inès---------------------------------------------------------------------------------			

//---------------------------------------------------Testcode Gill---------------------------------------------------------------------------------			

//---------------------------------------------------Testcode Charles---------------------------------------------------------------------------------			

//---------------------------------------------------Testcode Michiel---------------------------------------------------------------------------------			
		
// 		DAO Survey				
//		Survey survey1 = new Survey(1,20);
//		Survey survey2 = new Survey(3,17);
//		Survey survey3 = new Survey(4,15);
//		Survey survey4 = new Survey(4,15);
//		Survey survey5 = new Survey(4,80);		
//		SurveyDAO sdao = new SurveyDAO();				
//		sdao.addSurvey(survey1);
//		sdao.addSurvey(survey2);
//		sdao.addSurvey(survey3);
//		sdao.addSurvey(survey4);
//		sdao.addSurvey(survey5);				
//		sdao.getSurveyByID(1);				
//		sdao.deleteSurvey(3);			
//		sdao.getAllSurveys();			
//		sdao.getAllSurveyByTraining(15);				
//		sdao.update(survey4);
		
//---------------------------------------------------Testcode Sebastian---------------------------------------------------------------------------------			
		
//		Book b1 = new Book("9781328994967","Timothy Ferriss","Tribe of mentors",new GregorianCalendar(2017,11,21));
//		Book b2 = new Book("9781501178139","Isabel Allende","In the midst of winter",new GregorianCalendar(2017,10,31));
//		Book b3 = new Book("9780062820754","Marc Sumerak","The Art of Harry Potter",new GregorianCalendar(2017,11,21));
//		Book b4 = new Book("test","test","testen",new GregorianCalendar(2017,8,16));	
//		Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
//		BookDAO dao = new BookDAO();
//		Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
//		BookDAO dao = new BookDAO();
//		dao.insertBook(b1);
//		dao.insertBook(b2);
//		dao.insertBook(b3);
//		dao.insertBook(b4);
//		dao.insertBook(b5);		

//		ArrayList<Book> lijst = dao.getAllBooks();
//		
//		for(Book b: lijst) {
//			System.out.println(b.toString());
//		}
		//ArrayList<Book> lijst = dao.getAllBooks();
		//System.out.println(lijst.toString());
		
		//System.out.println("---- GET BOOK by ISBN------------");	
//		if(dao.getBook("9780062820754") == null) {
//			
//			System.out.println("Sorry het boek dat jij zoekt bestaat niet");
//		}else {
//			System.out.println(dao.getBook("9780062820754").toString());
//		}	
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
//	   Book myBook = new Book("test6","Last Title","Last Author", myCal);
//		
//		
//		BookDB db1 = new BookDB();
		


//		Book myBook = new Book("testH","testH","testH",new GregorianCalendar(2017,9,22));
//		
//		db1.insertBook(myBook);
		
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
		
//		ArrayList books = TestJackson.getBooksByContent("php");
//		
//		for(int i=0; i< books.size(); i++) {
//						System.out.println(books.get(i).toString());
//		}
//			System.out.println("\n");
//			}
//		
		
		
		

	}

}

