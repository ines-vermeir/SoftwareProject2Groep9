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
import java.util.Arrays;
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
import db.SurveyPredefinedDB;
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

    public static void main(String[] args)   {
    	
    	
    	
    	
  	
    	
    	
     launch(args);
    }
	
//----------------------------------------------------login functie----------------------------------------------------------------------------	
	/*
	 * LOGIN 
	 * 
	 */
	
	public static void login () throws IOException 
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

	
	void menuSurvey(int privilege){
		Scanner scan = new Scanner(System.in);
		if(privilege == 1) {
			System.out.println("MENU Survey");
			System.out.println("Wat wilt u doen?");
			System.out.println("1) fill in survey");
			System.out.println("2) back to Employee menu");
			
			int user_input_number = scan.nextInt();
			
			switch (user_input_number) {
			case 1: 
				// print al zijn trainingen waarvoor hij een survey kan maken
				// gebeurt via web
				
					surveyInvullen(50);
					break;
			case 2: // back to employeemenu
					return;
			default: System.out.println("U heeft foutieve invoer ingegeven");
			menuSurvey(privilege);
					break;	
				}
			}
		
		if(privilege == 2) {
			// trainer heeft geen survey nodig!
			System.out.println("terugkeren");
			return;
		}
		
		
		if(privilege == 3) {
			System.out.println("MENU Survey");
			System.out.println("Wat wilt u doen?");
			System.out.println("1) watch results");
			System.out.println("2) make new survey");
			System.out.println("3) predefined surveys");
			System.out.println("4) archive Survey");
			System.out.println("5) back to Employee menu");
			
			int user_input_number = scan.nextInt();
			
			switch (user_input_number) {
			case 1: watchResults();
					break;
			case 2:makeNewSurvey();
					break;
			case 3: beherenvoorafGedefinieerdeSurveys();
					break;
					
			case 4: archiveSurvey();		
					break;
			case 5:// back to employeeMenu		
					break;
			default: System.out.println("U heeft foutieve invoer ingegeven");
			menuSurvey(privilege);
			break;
			}
		}
	}
		
	// TO DO 
	public void surveyInvullen(int SurveyID){
		Scanner scan = new Scanner(System.in);
		
		SurveyDB surveydb = new SurveyDB();
		Survey  si1 = new Survey();
		
		si1 = surveydb.getSurvey(SurveyID);
		
		System.out.println("TITLE");
		System.out.println(si1.getTitle());
		System.out.println("");
		
	
		System.out.println("DESCRIPTION");
		System.out.println(si1.getDescription());
		System.out.println("");
		
		// herwerken optellen score !
		
		for(int i = 0; i < si1.getMyListSurveysQuestions().size();i++) {
			System.out.println(si1.getMyListSurveysQuestions().get(i).getQuestion());
			
			for(int j = 0; j < si1.getMyListSurveysQuestions().get(i).getAntwoorden().size();j++) {
				System.out.print(j +1 +") ");
				System.out.print(si1.getMyListSurveysQuestions().get(i).getAntwoorden().get(j) + "         ");
				
				 boolean[] gekozenAnswers = new boolean[si1.getMyListSurveysQuestions().get(i).getAntwoorden().size()];
				 Arrays.fill(gekozenAnswers,Boolean.FALSE);
				 System.out.print("Wich answers do you wish to select press -1 to stop");
				 
				 int keuze5;
				 
				 do {
					 
					 keuze5 = scan.nextInt();
					 gekozenAnswers[keuze5 -1] = true;
						 
				 }while(keuze5 !=-1);
				 
				 for (int a = 0; a < gekozenAnswers.length;a++) {
					 if( gekozenAnswers[a] == true) {
						 si1.getMyListSurveysQuestions().get(i).getAntwoorden().get(j).setAantal((si1.getMyListSurveysQuestions().get(i).getAntwoorden().get(j).getAantal()+1));	 
					 }		 				 
				 }	 
			}	
		}
		surveydb.updateSurveyById(SurveyID, si1);
	}
	
	
	
	public void watchResults(){
		SurveyDB 	surveydb = new SurveyDB();
    	
		List<Survey> surveys= new ArrayList<Survey>();
		surveys = surveydb.getAllSurveys();
		
		System.out.println(surveys);
	}
	
	
	
	
	
	public void makeNewSurvey(){
		Scanner scan = new Scanner(System.in);
		int keuze;
		System.out.println("1) make a new survey");
		System.out.println("2) use a predifined survey");
		 
		do {
			keuze = scan.nextInt();
		}while(keuze > 1 || keuze < 2);
		
		if(keuze == 1) {
			
			System.out.println("Wat is the trainingsID");
			
			TrainingDB trainingdb = new TrainingDB();
			List<Training> allTrainings = new ArrayList<>();
			
			allTrainings = trainingdb.getActiveTrainings();
			
			Survey  sur1= new Survey();
			System.out.println(allTrainings);
			int trainingIDn = scan.nextInt();
			sur1.setTrainingsID(trainingIDn);
			
			System.out.println("what is the title");
			String titlen = scan.nextLine();
			sur1.setTitle(titlen);
			
			System.out.println("what is the description");
			String description = scan.nextLine();
			sur1.setDescription(description);
			
			System.out.println("Give questions, press 0 to stop");
			
			
			
			String question = "1";
			String answer = "1";
		
			sur1.setArchive(0);
			sur1.setAantalIngevuld(0);
			
			do {
				Question Question = new Question();
				question = scan.nextLine();
				Question.setSurvey(sur1);
				Question.setQuestion(question);
			
				do {
					Answer Answer = new Answer();
					answer = scan.nextLine();
					Answer.setAantal(0);
					Answer.setAnswer(answer);
					Answer.setQuestion(Question);
					
					Question.getAntwoorden().add(Answer);
					
				}while(answer != "0");
				sur1.getMyListSurveysQuestions().add(Question);
						
			} while(question !="0");


			System.out.println("Wilt u deze survey aanmaken? 1) yes   2) no");
			sur1.toString();
			
			int keuzeAanmaken = scan.nextInt();
			
			
			if( keuzeAanmaken == 1) {
				SurveyDB surveydb = new SurveyDB();
				surveydb.addSurvey(sur1);
			}
			menuSurvey(3);				
		}
		
		if(keuze == 2) {
			System.out.println("predefined Surveys");
		
			SurveyPredefinedDB surveydb = new SurveyPredefinedDB();
			SurveyPredefined surveypr = new SurveyPredefined();
			Survey survey2 = new Survey();
			
			List <SurveyPredefined> listsurveyPredefined = new ArrayList <SurveyPredefined>();
			listsurveyPredefined = surveydb.getAllSurveys();
			System.out.println(	listsurveyPredefined.toString());
			
			
			
			System.out.println("Wich predefined survey you want to use, give the id");
			
			int idPresur = scan.nextInt();
			surveypr = surveydb.getSurvey(idPresur);
			
			survey2.setTitle(surveypr.getTitle());
			survey2.setDescription(surveypr.getDescription());
			survey2.setArchive(0);
			survey2.setAantalIngevuld(0);
			
			
			
			System.out.println("What training you want to link, give the id");
			TrainingDB trainingdb = new TrainingDB();
			trainingdb.getActiveTrainings();
			
			int idtrain = scan.nextInt();
			survey2.setTrainingsID(idtrain);
			survey2.setAantalIngevuld(0);
			survey2.setArchive(0);
			
			
			survey2.setDescription(surveypr.getDescription());
			survey2.setTitle(surveypr.getDescription());
			
			
			for (int i = 0; i < surveypr.getMyListSurveysQuestions().size();i++) {
				survey2.getMyListSurveysQuestions().get(i).setQuestion(surveypr.getMyListSurveysQuestions().get(i).getQuestion());
				survey2.getMyListSurveysQuestions().get(i).setSurvey(survey2);
	
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		//	List<Question> questions= new ArrayList<Question>();
		//	List<QuestionPredefined> predefinedQuestions = new ArrayList<QuestionPredefined>();
			

//			for(int i = 0; i < surveypr.getMyListSurveysQuestions().size();i++) {
//				Question q1 = new Question();
//				q1.setQuestion(surveypr.getMyListSurveysQuestions().get(i).getQuestion());
//				q1.setSurvey(survey2);
//				List<Answer> answers = new ArrayList<Answer>();
//				for(int j = 0; j < surveypr.getMyListSurveysQuestions().get(i).getAntwoorden().size();j++) {
//				
//					Answer a1 = new Answer();
//					a1.setAantal(0);
//					a1.setAnswer(surveypr.getMyListSurveysQuestions().get(i).getAntwoorden().get(j).getAnswer());
//					a1.setQuestion(q1);
//					answers.add(a1);
//						
//				}
//				q1.setAntwoorden(answers);
//				questions.add(q1);		
//			}
//	
//			survey2.setMyListSurveysQuestions(questions);

			System.out.println("Wilt u deze survey aanmaken? 1) yes   2) no");
			survey2.toString();
			
			int keuzeAanmaken = scan.nextInt();
			
			
			if( keuzeAanmaken == 1) {
				SurveyDB surveydb2 = new SurveyDB();
				surveydb2.addSurvey(survey2);
			}
			menuSurvey(3);	
	}
	
	}
	

	private void beherenvoorafGedefinieerdeSurveys(){
		Scanner scan = new Scanner(System.in);
		int keuze;
		System.out.println("MENU SURVEYPREDEFINED");
		System.out.println("1) watch predefined Surveys");
		System.out.println("2) add predefined Survey");
		System.out.println("3) modify predefined Survey");
		System.out.println("4) delete predefined Survey");
		System.out.println("5) return");
		
		
		do {
			keuze = scan.nextInt();
		}while(keuze > 1 || keuze < 5);
		
		
		switch(keuze) {
		case 1:{
			
			SurveyPredefinedDB surveydb = new SurveyPredefinedDB();
			SurveyPredefined surveypr = new SurveyPredefined();
			Survey survey2 = new Survey();
			
			
			surveydb.getAllSurveys();
			
			menuSurvey(3);
		}
			
		case 2: {
		
			SurveyPredefined surveyPredefined = new SurveyPredefined();
			
			
			System.out.println("What is the title");
			String title = scan.nextLine();
			surveyPredefined.setTitle(title );
			
			
			System.out.println("What is the description");
			String description = scan.nextLine();
			surveyPredefined.setTitle(description);
			
			System.out.println("Give question, press 0 to stop");
			
			String question ="1";
			String answer = "1";		
			
			do {
				QuestionPredefined questionPredefined = new QuestionPredefined();
				question = scan.nextLine();
				questionPredefined.setSurvey(surveyPredefined);
				questionPredefined.setQuestion(question);
				
				
				do {
					AnswerPredefined anserpredefined = new AnswerPredefined();
					answer= scan.nextLine(); 
					anserpredefined.setAnswer(answer);
					anserpredefined.setQuestion(questionPredefined);
					
					
					questionPredefined.getAntwoorden().add(anserpredefined);
					
				} while(answer != "0");
				surveyPredefined.getMyListSurveysQuestions().add(questionPredefined);
				
			} while (question != "0");
			
			
			System.out.println("Wilt u deze survey aanmaken? 1) yes   2) no");
			surveyPredefined.toString();
			
			int keuzeAanmaken = scan.nextInt();
			
			do {
				keuzeAanmaken = scan.nextInt();
			}while(keuzeAanmaken> 1 || keuzeAanmaken < 2);
			
			
			
			
			if( keuzeAanmaken == 1) {
				SurveyPredefinedDB surveydb = new SurveyPredefinedDB();
				surveydb.addSurvey(surveyPredefined);
			
			menuSurvey(3);
			}
		}
		
		case 3: {
			
			SurveyPredefinedDB surveydb = new SurveyPredefinedDB();
			List <SurveyPredefined> listsurveyPredefined = new ArrayList <SurveyPredefined>();
			listsurveyPredefined = surveydb.getAllSurveys();
			System.out.println(	listsurveyPredefined.toString());
			
			System.out.println("give the  id of the predefined survey you wish to modify");
			Scanner scan2 = new Scanner(System.in);
			int keuze2;
			
			keuze2 = scan.nextInt();
			
			
			
			
SurveyPredefined surveyPredefined = new SurveyPredefined();
			
			
			System.out.println("What is the title");
			String title = scan.nextLine();
			surveyPredefined.setTitle(title );
			
			
			System.out.println("What is the description");
			String description = scan.nextLine();
			surveyPredefined.setTitle(description);
			
			System.out.println("Give question, press 0 to stop");
			
			String question ="1";
			String answer = "1";		
			
			do {
				QuestionPredefined questionPredefined = new QuestionPredefined();
				question = scan.nextLine();
				questionPredefined.setSurvey(surveyPredefined);
				questionPredefined.setQuestion(question);
				
				
				do {
					AnswerPredefined anserpredefined = new AnswerPredefined();
					answer= scan.nextLine(); 
					anserpredefined.setAnswer(answer);
					anserpredefined.setQuestion(questionPredefined);
					
					questionPredefined.getAntwoorden().add(anserpredefined);
					
				} while(answer != "0");
				surveyPredefined.getMyListSurveysQuestions().add(questionPredefined);
				
			} while (question != "0");
			
			
			System.out.println("Wilt u deze survey veranderen? 1) yes   2) no");
			surveyPredefined.toString();
			
			int keuzeAanmaken = scan.nextInt();
			
			do {
				keuzeAanmaken = scan.nextInt();
			}while(keuzeAanmaken> 1 || keuzeAanmaken < 2);
			
			if( keuzeAanmaken == 1) {
			
				surveydb.updatePredefinedSurvey(keuze2, surveyPredefined);
			}
		}
		case 4: 
		SurveyPredefinedDB surveydb = new SurveyPredefinedDB();

		List <SurveyPredefined> listsurveyPredefined = new ArrayList <SurveyPredefined>();
		listsurveyPredefined = surveydb.getAllSurveys();
		System.out.println(	listsurveyPredefined.toString());
		
		System.out.println("give the  id of the predefined survey you wish to delete");
		
		Scanner scan2 = new Scanner(System.in);
		int keuze2;
		
		keuze2 = scan.nextInt();
		surveydb.deletePredefinedSurvey(keuze2);
		menuSurvey(3);
			
		case 5: menuSurvey(3);
		}
	
	}
	
	
	private void archiveSurvey(){
		
		SurveyDB surveyDB = new SurveyDB();
		List<Survey> surveys = new ArrayList<Survey>();
		surveys = surveyDB.getAllSurveys();
	     	System.out.println(surveys);
		
	     	
	     	System.out.println("Which Survey you want to archive?");
	     	Scanner scan = new Scanner(System.in);
			int keuze;
			
			keuze = scan.nextInt();
	     	
			surveyDB.archiveSurvey(keuze);
			
		}
	
	
	
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
	
	
}






