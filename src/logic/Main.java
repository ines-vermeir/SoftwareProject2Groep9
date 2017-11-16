

package logic;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Scanner;

import db.BookDAO;
import db.BookDB;
import db.LocationDAO;
/*import db.TestGson;
import db.TestJackson;
import db.UserDB;
import logic.User.Privilege;*/

import java.util.Date;
import db.SessionDB;
/*import db.SurveyDAO;*/
import db.UserDB;
import logic.User.Privilege;
import db.TestJackson;

public class Main {

	
//----------------------------------------------------login functie----------------------------------------------------------------------------	
	/*
	 * LOGIN 
	 * 
	 */

	
	public static void login () throws IOException //wordt nog verder uitgewerkt (Eva)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		User user = null;
		boolean check = false;
		int attempt = 0;
		UserDB db = new UserDB();
		String username = null;
		String password = null;
		try {			
				System.out.println("Welcome! \nPlease log in \nUsername:");
				username = br.readLine();
				while (check == false)
				{
					user = db.getUser(username);
					if (user == null)
					{
						System.out.println("Username does not exist. Please try again: \nUsername: ");
						username = br.readLine();
					}
					else
					{
						check = true;
					}
				}
				check = false;
				System.out.println("Password: ");
				password = br.readLine();
				System.out.println(password);
				while (check == false && attempt < 3)
				{
					if (user.getPassword().equals(password))
					{
						System.out.println("Login successful");
						check = true;
					}
					else
					{
						attempt++;
						if (attempt < 3)
						{				
							System.out.println(user.getPassword());
							System.out.println("Wrong password. Please try again (" + (3 - attempt) + " attempts remaining): \nPassword:");
							password = br.readLine();
						}
					} 
				} 
		} catch (Exception e)
		{
			System.out.println("ERROR");
		}
		if (user.getPrivilege() == Privilege.EMPLOYEE)
		{
			menuEmployee(user);
		}
		else if (user.getPrivilege() == Privilege.HR)
		{
			//menuHR(user);
		}
		else if (user.getPrivilege() == Privilege.TEACHER)
		{
			//menuTeacher(user);
		}
	}
	
	
	/*
	 * end LOGIN
	 */


//----------------------------------------------------hoofdmenu (afhankelijk van privilege andere menu laten zien)------------------------------------------------------	

	
	/* MENU PRIVILEGE 1 (EMPLOYEE)  */
	public static void menuEmployee (User user) throws IOException {
		System.out.println("Welkom" + user.getUsername());
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
		case 3: break;	
		default: break;
		}
		return;
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
	/*
	 * Location
	 * 
	 */
	
	/*
	 * CHANGE LOCATION FUNCTIONS
	 */
	/*
	public void changeStreetName (int id) throws SQLException, Exception {
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new streetName: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(input);
		if (saveUpdate() ==  true) {
			l.streetName = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changeNumber (int id) throws SQLException, Exception { 
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new number: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(input);
		if (saveUpdate() ==  true) {
			l.number = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changePostalCode (int id) throws SQLException, Exception { 
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new postal code: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(input);
		if (saveUpdate() ==  true) {
			l.postalCode = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changeCity (int id) throws SQLException, Exception {
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new city: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	    System.out.println(input);
		if (saveUpdate() ==  true) {
			l.postalCode = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changeCountry (int id) throws SQLException, Exception {
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new country: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	    System.out.println(input);
		if (saveUpdate() ==  true) {
			l.postalCode = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changeName (int id) throws SQLException, Exception {
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new name: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	    System.out.println(input);
		if (saveUpdate() ==  true) {
			l.postalCode = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}
	public void changeInfo (int id) throws SQLException, Exception {
		Location l = new Location(LocationDAO.getLocationById(id));
		System.out.println("What is the new info: ");
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	    System.out.println(input);
		if (saveUpdate() ==  true) {
			l.postalCode = input;
			if (LocationDAO.updateLocation(l) == true) {
				System.out.println("UPDATE SUCCESFULL");
			}
			else {
				System.out.println("ERROR: UPDATE UNSUCCESFULL");
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		return;
	}

	/* 
	 * end CHANGE LOCATION FUNCTIONS
	 */
/*	public void deleteLocation() {
		/* locatie verwijderen vanuit sessie klasse en locationDAO???*/
//	}
	
/*	public void addLocation() throws SQLException, Exception {
		String[] questions = new String[]{"What is the streetName: ","What is the number: ", "What is the new postal code: ", "What is the city: ", "What is the country: ","What is the name: ","What is the info: " };
		String[] input = new String[questions.length];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		for (int i=0; i < questions.length; i++) {
	    try {
	    	System.out.println(questions[i]);
			input[i] = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	    Location l = new Location (-1, input[0], input[1], input[2],input[3],input[4],input[5], input[6]);
	    System.out.println(l.toString());
	    if (saveUpdate() ==  true) {
			if ( LocationDAO.insertLocation(l) == true) {
				System.out.println("INSERT SUCCESFULL");
			}
			else {
				System.out.println("ERROR: INSERT UNSUCCESFULL");
			}
		}
		else {
			System.out.println("INSERT DELETED");
		}
	    return;
	}
	
	*/
	/*
	 * end LOCATION
	 * 
	 */
	
	
	
	
	
//MICHIEL-------------------------------------	methodes/menu klasses Survey&Question--------------------------------------------------------------
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	

	
	
//EVA-------------------------------------	methodes/menu klasse User--------------------------------------------------------------	
	//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	
	
	
	
	
	
	/*
	 * SAVE methode
	 * 
	 */
/*	public boolean saveUpdate() {
		String input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		do {
		System.out.println("Save(Y/N): ");
	    try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		input = input.toUpperCase();
		}while (!input.equals("Y") && !input.equals("N"));
		
		switch (input) {
		case "Y":  return true;
		case "N": return false;
		default: return false;
		}
	}
	
	
	*/
	/*
	 * end SAVE
	 * 
	 */
	
	
	public static void main(String[] args) throws SQLException, Exception {
		
//		Session_teachers st1 = new Session_teachers("teacher57");
//		Session_teachers st2 = new Session_teachers("teacher58");
//		ArrayList<Session_teachers> teachers = new ArrayList<Session_teachers>();
//		teachers.add(st1);
//		teachers.add(st2);
//		ArrayList<Student_enrolled_session> studentsEnrolled = new ArrayList<Student_enrolled_session>();
//		Student_enrolled_session se1 = new Student_enrolled_session(4545);
//		Student_enrolled_session se2 = new Student_enrolled_session(4545);
//		studentsEnrolled.add(se1);
//		studentsEnrolled.add(se2);
//		ArrayList<Student_present> studentsPresent = new ArrayList<Student_present>();
//		Student_present sp1 = new Student_present(4545);
//		Student_present sp2 = new Student_present(4546);
//		studentsPresent.add(sp1);
//		studentsPresent.add(sp2);
//		ArrayList<String> teachers = new ArrayList<String>();
//		teachers.add("Teacher123");
//		teachers.add("Teacher456");
//		ArrayList<Integer> studentsEnrolled = new ArrayList<Integer>();
//		studentsEnrolled.add(1111);
//		studentsEnrolled.add(2222);
//		ArrayList<Integer> studentsPresent = new ArrayList<Integer>();
//		studentsPresent.add(1111);
//		studentsPresent.add(2222);
//		Calendar myCal =  new GregorianCalendar();		
//		myCal.set(GregorianCalendar.YEAR, 2017);
//		myCal.set(GregorianCalendar.MONTH,12);
//		myCal.set(GregorianCalendar.DATE,22);
		
//		Session s1 = new Session(1, myCal, "10:00", "12:00", 1, teachers, studentsEnrolled, studentsPresent);
		
		SessionDB db = new SessionDB();
		Session s1 = db.getSessionByID(45);
		System.out.println(s1.toString());
//		db.insertSession(s1);
//		ArrayList<Session> s1 = db.getAllSessions();
//		for (Session s: s1)
//		{
//			System.out.println(s.getSessionID() + "  " + s.getTeachers().size());
//			//System.out.println(s.getSessionID() + "  " + s.getTeachers().size());
//			for (s1. t: s.getTeachers()) {
//				System.out.println("----Teachers-----");
//				System.out.println(t.getTeacher());
//			}
//			for (Student_enrolled_session st: s.getStudentsEnrolled()) {
//				System.out.println("-----Student enrolled session-----");
//				System.out.println( "ID employee= "+ st.getEmployeeIDenrolled());
//			}/*for (Session_teachers t: s.getTeachers()) {
//				System.out.println("----Students enrolled in training-----");
//				System.out.println(t.getTeacher());
//			}
//		}
		
		
//		login();
//		System.out.println("Welkom");
//		Main m = new Main();
//		m.login();		


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
	//	BookDB db = new BookDB();
		


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
		
/*		ArrayList<Book> books = db.getAllBooks();
		
	for(int i=0; i< books.size(); i++) {
			System.out.println(books.get(i).toString());
		}
		*/
		
		
//--------------- Odata lezen Employees---------------------------
	/*	ArrayList<Employee> employees= (ArrayList<Employee>) TestJackson.getEmployees();
	
		
		for(int i=0; i< employees.size(); i++) {
			System.out.println(employees.get(i).toString());
		*/    
		//	System.out.println(employees.get(i).getEmployeeID());
			
			
			
		

		
 //Odata google Books Api test-----------------------------------------------------------------
		

/*
	   ArrayList<BookGoogleAPI> books = TestJackson.getBooksByContent("php programming");



			for(BookGoogleAPI book : books) {
						System.out.println(book.toString());
							//System.out.println(book.getTitle());
			}

*/
			
	
			
	
			
			
			
			
			
			


//	   ArrayList<BookGoogleAPI> books = TestJackson.getBooksByContent("php programming");
//
//
//
//			for(BookGoogleAPI book : books) {
//						System.out.println(book.toString());
//							//System.out.println(book.getTitle());
//			}
//	

		

	}
}







