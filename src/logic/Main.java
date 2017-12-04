package logic;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import application.Navigator;
import controller.MainController;
import db.BookDAO;
import db.BookDB;
import db.LocationDB;
/*import db.TestGson;
import db.TestJackson;
import db.UserDB;
import logic.User.Privilege;*/


import java.util.Date;
import db.SessionDB;
import db.UserDB;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.User.Privilege;
import db.TestJackson;
import db.TrainingDB;
import db.SurveyDB;
import java.io.IOException;
import controller.MainController;
import javafx.application.Application;


public class Main extends Application {
	
public static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws Exception {
		 
		mainStage = stage;
		mainStage.setTitle("Human Resource Team 9 Git");
		mainStage.setScene(createScene(loadMainPane()));
		mainStage.setMaximized(true);
		
		mainStage.show();
		
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
	}

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */

    private Pane loadMainPane() throws IOException {
        
		FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MainView));

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);

        Navigator.loadVista(Navigator.LoginView);

        return mainPane;
    }
	

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );
        
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
	
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
		if (user.getPrivilege() == Privilege.HR)
		{
			menuHR(user);
		}
		else if (user.getPrivilege() == Privilege.ADMIN)
		{
			//menuADMIN(user);
		}
		//else if (user.getPrivilege() == Privilege.TEACHER)
		{
			//menuTeacher(user);
		}

	}
	
	
	/*
	 * end LOGIN
	 */


//----------------------------------------------------hoofdmenu (afhankelijk van privilege andere menu laten zien)------------------------------------------------------	

	/* MENU PRIVILEGE 1 (HR)  */
	public static void menuHR (User user) throws IOException {
  //Training menuTraing = new Training();
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
		case 1:// menuTraing.trainingMenu(privilege);
		 		break;
		case 2: /*certificateMenu(privilege)*/
				break;
		case 3: break;	
		default: break;
		}
		return;
	}
	
	
	/*
	 * MENU PRIVILEGE 2(ADMIN)
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

	
	
	public void addNewSession (User u, int  trainingId) throws IOException // nog niet af
, ParseException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SessionDB db = new SessionDB();
		int locationID = 0, part = 0;
		String startTime = null, endTime = null, teacher, input;
		Calendar date = Calendar.getInstance();
		List<String> teachers = null;
		List<Integer> studentsEnrolled = null, studentsPresent = null;
		ArrayList<Session> allSessions;
		boolean check = true;
		System.out.println("date:");
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date.setTime(format.parse(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		System.out.println("Start time: ");
		try {
			startTime = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End time: ");
		try {
			endTime = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		while(check == true)
		{
			System.out.println("Location");
			System.out.println("Overview existing Locations: ");
			// functie getAllLocations aanspreken + alle locaties op scherm tonen
			System.out.println("Give the locationID of an existing location. If you would like to add a new location press '0'.");
			check = false;
			try {
				locationID = Integer.parseInt(br.readLine());
			}catch (IOException e) 
			{
			e.printStackTrace();
			}
			if (locationID == 0) {
				//locationID = addLocation();
				check = false;
			}
			else 
			{
		 		allSessions = db.getAllSessions();
		 		for(Session s: allSessions){
		 			if (s.getLocationID() == locationID){
		 				if (s.getDate() == date) {
		 					check = true;
		 					System.out.println("This location is already in use for the chosen date. Please select another location.");
		 				}
		 			}
		 		}
			}
		}
		check = true;
		while (check == true)
		{
			System.out.println("Name teacher: ");
			try {
				teacher = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			teachers.add(teacher);
			do {
				System.out.println("add another teacher: (Y/N)");
				input = br.readLine();
				if (input == "Y" || input == "y")
					check = true;
				else if (input == "N" || input == "n")
					check = false;
				else {
					System.out.println("Wrong input. Try again: ");
				}
			} while (input != "Y" || input !="y" || input != "N" || input !="n" );
		}
		// employeeID's toevoegen aan session. Hoe doen we dit? Tonen we alle employees eerst?
		// moet er dan voor elke employee automatisch een email naar zijn manager gestuurd worden?
		Session s = new Session (trainingId, date, startTime, endTime, locationID, part, teachers, studentsEnrolled, studentsPresent);
		if (saveUpdate() ==  true) {
			if (db.insertSession(s) == true) {
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
	
	public void deleteSession(int id) {
		SessionDB db = new SessionDB();
		Session s;
		try {
		s = db.getSessionByID(id);
		System.out.println("DELETE: " + s.toString());
		if (saveUpdate() ==  true) {
			try {
				if (db.archiveSession(s) == true) {
					System.out.println("DELETE SUCCESFULL");
				}
				else {
					System.out.println("ERROR: DELETE UNSUCCESFULL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void changeSessionDate (int id) throws SQLException, Exception {
		SessionDB db = new SessionDB();
		Session s = db.getSessionByID(id);
		System.out.println("What is the new date: ");
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
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			Calendar cal  = Calendar.getInstance();
			cal.setTime(df.parse(input));
			s.setDate(cal);
			if (db.updateSession(s) == true) {
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
	
	public void changeSessionStartTime (int id) throws SQLException, Exception {
		SessionDB db = new SessionDB();
		Session s = db.getSessionByID(id);
		System.out.println("What is the new start time: ");
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
			s.setStartTime(input);
			if (db.updateSession(s) == true) {
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
	
	public void changeSessionEndTime (int id) throws SQLException, Exception {
		SessionDB db = new SessionDB();
		Session s = db.getSessionByID(id);
		System.out.println("What is the new end time: ");
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
			s.setStartTime(input);
			if (db.updateSession(s) == true) {
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
	
	public void changeSessionLocation (int id) throws SQLException, Exception {
		SessionDB db = new SessionDB();
		Session s = db.getSessionByID(id);
		System.out.println("What is the id of the new location: ");
		int input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    try {
			input = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(input);
		if (saveUpdate() ==  true) {
			
			s.setLocationID(input);
			if (db.updateSession(s) == true) {
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
	
//INES-------------------------------------	methodes/menu klasse Location------------------------------------------------------------------------	
	/*
	 * Location
	 * 
	 */
	
	/*
	 * CHANGE LOCATION FUNCTIONS
	 */
	
	public void changeStreetName (int id) throws SQLException, Exception {
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setStreetName(input);
			if (db.updateLocation(l) == true) {
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
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setNumber(input);
			if (db.updateLocation(l) == true) {
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
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setPostalCode(input);
			if (db.updateLocation(l) == true) {
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
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setCity(input);
			if (db.updateLocation(l) == true) {
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
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
		//l = new Location(2,"Nijverheidkaai","170","1080","Anderlecht","Belgium","campus Kaai","blok A, audi 1",0);
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
			l.setCountry(input);
			if (db.updateLocation(l) == true) {
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
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setName(input);
			if (db.updateLocation(l) == true) {
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
	public void changeInfo (int id) throws Exception {
		LocationDB db = new LocationDB();
		Location l = db.getLocationById(id);
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
			l.setInfo(input);
			if (db.updateLocation(l) == true) {
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

	public void deleteLocation(int id) {
		LocationDB db = new LocationDB();
		Location l;
		try {
		l = db.getLocationById(id);
		System.out.println("DELETE: " + l.toString());
		if (saveUpdate() ==  true) {
			l.setArchive(1);
			try {
				if (db.updateLocation(l) == true) {
					System.out.println("DELETE SUCCESFULL");
				}
				else {
					System.out.println("ERROR: DELETE UNSUCCESFULL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void addLocation() throws SQLException, Exception {
		String[] questions = new String[]{"What is the streetName: ","What is the number: ", "What is the postal code: ", "What is the city: ", "What is the country: ","What is the name: ","What is the info: " };
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
	    Location l = new Location (input[0], input[1], input[2],input[3],input[4],input[5], input[6],0);
	    LocationDB db = new LocationDB();
		//Location l = new Location("Nijverheidkaai","170","1080","Anderlecht","Belgium","campus Kaai","blok A, audi 1",0);
	    System.out.println(l.toString());
	    if (saveUpdate() ==  true) {
			if ( db.insertLocation(l) == true) {
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
	
	
	/*
	 * end LOCATION
	 * 
	 */
	
	
	
//MICHIEL-------------------------------------	methodes/menu klasses Survey&Question--------------------------------------------------------------
//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	

	
	
//EVA-------------------------------------	methodes/menu klasse User--------------------------------------------------------------	
	//(user meegeven als parameter en afhankelijk daarvan andere opties voorzien)	
	

	public void changePassword (String username) throws SQLException, Exception {
		UserDB db = new UserDB();
		User u = db.getUser(username);
		System.out.println("Give the new password: ");
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
			u.setPassword(input);
			if (db.updateUser(u) == true) {
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
	
	public void deleteUser(String username) {
		UserDB db = new UserDB();
		User u;
		try {
		u = db.getUser(username);
		System.out.println("DELETE: " + u.toString());
		if (saveUpdate() ==  true) {
			try {
				if (db.archiveUser(u) == true) {
					System.out.println("DELETE SUCCESFULL");
				}
				else {
					System.out.println("ERROR: DELETE UNSUCCESFULL");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("CHANGES DELETED");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public void addUser() throws SQLException, Exception {
		String[] questions = new String[]{"What is the username: ","What is the password: ", "What is the privilege: " };
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
	    User u = new User (input[0], input[1], Privilege.valueOf(input[2]));
	    UserDB db = new UserDB();
	    System.out.println(u.toString());
	    if (saveUpdate() ==  true) {
			if ( db.insertUser(u) == true) {
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
	
//--------------------------------------------------------------------	
	/*
	 * SAVE methode
	 * 
	 */
	public boolean saveUpdate() {
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
	
	
	
	/*
	 * end SAVE
	 * 
	 */
	
	

//	public static void main(String[] args) throws SQLException, Exception {		
//		
//		login();
//		
//	}
}






