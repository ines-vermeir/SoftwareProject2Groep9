/**
 * 
 */
package logic;
//ERROR --> Error: Could not find or load main class logic.Login 27/10/2017
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 /**
 * @author Charles
 *Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
 *
 */
public class Login {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
		//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
		Scanner input = new Scanner(System.in); // (database verbinding voor input?)
		
		// =====
		try {
			Scanner scan = new Scanner (new File(" "));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String file_username = "John";		//--> Ik heb dit hardcoded want ik weet niet hoe 27/10/2017
		String file_password = "Bonus";
		
		System.out.println("Give your login credentials. ");
		System.out.println("Username: ");
		String input_username = input.next();
		
		System.out.println("Password: ");
		String input_password =input.next();
		
		//users check = new users(username, password);
		
		if(input_username.equals(file_username) && input_password.equals(file_password)) {
			System.out.println("Welcome, " + file_username + "! You are logged in!");
		}else {
			System.out.print("Please, provide the correct credentials.");
		}

	}

}
