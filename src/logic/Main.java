package logic;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import db.BookDAO;

public class Main {

	/*
	 * LOGIN 
	 * 
	 */
	
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
	
	/*
	 * Trainig  methodes
	 * MENU training --> bepaald wat je kan zien (adhv privileges)
	 * 
	 * 
	 */
	
	/*
	 * Certificate
	 * MENU certificate
	 * 
	 */
	
	/*
	 * Book
	 * 
	 */
	
	/*
	 * Employee
	 * 
	 */
	
	public static void main(String[] args) throws SQLException, Exception {
/*		// TODO Auto-generated method stub
	    
		

//		Book b1 = new Book("9781328994967","Timothy Ferriss","Tribe of mentors",new GregorianCalendar(2017,11,21));
//		Book b2 = new Book("9781501178139","Isabel Allende","In the midst of winter",new GregorianCalendar(2017,10,31));
//		Book b3 = new Book("9780062820754","Marc Sumerak","The Art of Harry Potter",new GregorianCalendar(2017,11,21));
//	Book b4 = new Book("test","test","testen",new GregorianCalendar(2017,8,16));
//		
		Book b5 = new Book("test5","test5","testen",new GregorianCalendar(2017,8,16));
		BookDAO dao = new BookDAO();
		
//		
//		dao.insertBook(b1);
//		dao.insertBook(b2);
//		dao.insertBook(b3);
//		dao.insertBook(b4);
		dao.insertBook(b5);
		//dao.deleteBook("test");
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
//
//	}
	*/
}
}



