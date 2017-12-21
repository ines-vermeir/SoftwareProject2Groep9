package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import logic.Training.Language;

import java.util.Scanner;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity


@Table(name="Trainings")
public class Training {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int trainingID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="language")
	@Enumerated(EnumType.STRING) 
	private Language language;
	
	@Column(name="responsible")
	private String responsible;
	
	@Column(name="sessions")
	private int sessions;
	
	@Column(name="archive")
	private int archive;
	
	
	public enum Language {
		Chinese, English, Spanish, Arabic, Russian, Portuguese,French,Japanese,German,Italien, Dutch	
	}
	
	@Transient													// niet meenemen in tabel
	Language[] yourEnums = Language.class.getEnumConstants();
	
	public void printEnumWaarden() {
		for(int i = 0; i < yourEnums.length; i++) {
		System.out.print(i+ 1 + ")" + yourEnums[i] + " ");
		System.out.print("  ");
		}	
	}
	
	
	
	// getters & setters
	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public int getSessions() {
		return sessions;
	}
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public int getArchive() {
		return archive;
	}
	public void setArchive(int archive) {
		this.archive = archive;
	}
	

	// constructors

	public Training() {
		
	}

	public Training(int trainingID, String title, String subject, Language language, String responsible,
			int sessions) {
		super();
		this.trainingID = trainingID;
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sessions = sessions;
		this.archive=0;
	}
	
	public Training(String title, String subject, Language language, String responsible, int sessions) {
		super();
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sessions = sessions;
		this.archive=0;
	}

	public Training(Training addTraining) {
		super();
		this.trainingID = addTraining.trainingID;
		this.title = addTraining.title;
		this.subject = addTraining.subject;
		this.language = addTraining.language;
		this.responsible = addTraining.responsible;
		this.sessions = addTraining.sessions;
		this.archive = addTraining.archive;	
	}
	
	public Training(String title, String subject, Language language, String responsible, int sessions,
			int archive) {
		super();
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sessions = sessions;
		this.archive = archive;
	}
	
	public Training(int trainingID, String title, String subject, Language language, String responsible,
			int sessions, int archive) {
		super();
		this.trainingID = trainingID;
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sessions = sessions;
		this.archive = archive;
	}

	// toString
	/*
	@Override
	public String toString() {
		return "Training [trainingID=" + trainingID + ", title=" + title + ", subject=" + subject + ", language="
				+ language + ", responsible=" + responsible + ", sessions=" + sessions + "]";
	}	
	
	*/
	
	
	// methoden
	
	public void trainingMenu(int privilege) throws IOException{
		
		int option = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		if (privilege == 1) {			// menu employee
		System.out.println("MENU training");
		System.out.println("What do you want to do");	
		System.out.println("1) Watch all trainings");	//	ok
		System.out.println("2) Watch my trainings");	//	ok
		System.out.println("3) send message");			// 	TO DO
		System.out.println("4) survey");				// ok
		System.out.println("5) go back to menu");
	
		
		
		/*
		do {
			option = br.read();
		} while (option < 1 || option > 6);
		*/
		switch (option) {
		case 1: watchAllTrainings(privilege);
		 		break;
		case 2: watchMyTrainings(privilege);
				break;
		case 3: sendMessage();
				break;
		case 4: FillinSurvey(privilege);
				break;
	//case 5: {										// go back to menu
	//	Main main = new Main();
	//	main.menuAdmin(user);					
	//	break;
	//	}	
			}
		}
		
		
		//TO DO
		if (privilege == 2) {						// menu Trainer
			System.out.println("MENU training");
			System.out.println("1) Watch all trainings");	
			System.out.println("3) send message");	
			System.out.println("4) survey");
			System.out.println("5) go back to menu");			
		}
		
		
		if (privilege == 3) {						// menu HR
			System.out.println("MENU training");
			System.out.println("1) Watch all trainings");	//ok
			System.out.println("2) add new training"); 		//ok
			System.out.println("3) survey");				// to do
			System.out.println("4) inschrijven employee aan cursus");
			System.out.println("5) bericht versturen");
			System.out.println("6) history");
			System.out.println("7) go back to menu");
			
			/*
			do {
				option = br.read();
			} while (option < 1 || option > 7);
			*/
		
			switch (option) {
			case 1: watchAllTrainings(privilege);
			 		break;
			case 2: MakeNewTraining(privilege);
					break;
			case 3: surveyMenu(privilege);
					break;
			case 4: registrationEmployee(privilege);
					break;
			case 5: sendMessage();
					break;
			case 6: historyTrainings(privilege);
					break;		
					
			case 7: // {										// go back to menu
				//	Main main = new Main();
				//	main.menuAdmin(user);					
				//	break;
				//	}	
			}
		}
	}
	
 //Note from Sebastian: Ik heb de toString voorlopig aangepast zodat ik Book view enkel id en title krijg op  Book view
	@Override
	public String toString() {
		return "trainingID=" + trainingID + ", title=" + title ;
	}



	public void watchAllTrainings(int privilege) throws IOException{
		
		int option = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Training watchTrainings = new Training();
		List<Training> trainingen = new ArrayList<Training>();
		TrainingDB watchTrainingsDB = new TrainingDB();
		trainingen = watchTrainingsDB.getActiveTrainings();	
		System.out.println(trainingen.toString());
		
		
		
		 if(privilege == 1) {
				System.out.println("Wat wilt u doen?");
				System.out.println("1) request registration"); 
				System.out.println("2) go back to trainingsmenu"); 
				
		
				/*
				do {
					option = br.read();
				} while (option < 1 || option > 2);
				*/

		 switch (option) {
			case 1: requestRegistration(privilege);
			 		break;
			case 2: trainingMenu(privilege);
					break;
		 		}
		 }	 
		 if(privilege == 2) {
			 System.out.println("Wat wilt u doen?");
			 System.out.println("1) session"); 
			 System.out.println("2) go back to trainingsmenu"); 
			
			 /*
				do {
					option = br.read();
				} while (option != 1);
				*/
				
				 switch (option) {
				 case 1:  watchSession(privilege);
			 		break;
					case 2: trainingMenu(privilege);
					 		break;			
		 }
	}
		 
		 if(privilege == 3) {
			 	System.out.println("Wat wilt u doen?");
				System.out.println("1) edit training"); 
				System.out.println("2) archive training"); 
				System.out.println("3) go back to trainingsmenu"); 
				/*
				do {
					option = br.read();
				} while (option != 1);
				*/

				 switch (option) {
					case 1: editTraining(privilege);
					 		break;	
					case 2: archiveTraining(privilege);
							break;
					case 3: trainingMenu(privilege);
			 				break;			
				 }	 
		 }
}	
	
	
	public void requestRegistration(int privilege) throws IOException{
		int option = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TrainingDB registerDB = new TrainingDB();
		Training gettraining = new Training();
		
		System.out.println("REQUEST REGISTRATION"); 
		System.out.println("Give the id of the course you wish to follow");
		
		/*
		do {
			option = br.read();
		} while ();			// controle boolean exists
		*/
		
		System.out.println("watch sessions");	// ga naar sessiemenu
		// ga naar sessie-> trainingsID meegeven
		
		
		// melding naar baas voorgoedkeuring
		
		trainingMenu(privilege);
	
	}
	
	public void watchMyTrainings(int privilege) throws IOException{
		System.out.println("MY TRAININGS"); 
		ArrayList<Integer> mytrainingenID = new ArrayList<Integer>();
		
		// sessie
		// sessieDB hql return list trainingsID
		
		 mytrainingenID = null;// functie van sessieDB
				 
				 
				 
		ArrayList<Training> mytrainingen = new ArrayList<Training>();
		Training tr1 = new Training();
		TrainingDB db1 = new TrainingDB();	
		
		for(int i = 0; i < mytrainingenID.size();i++) {
		tr1 = db1.getTraining(mytrainingenID.get(i));
			mytrainingen.add(tr1);
		}
		
	for(int i = 0; i < mytrainingen.size(); i++) {
		System.out.println(mytrainingen.get(i).toString());
		System.out.println();
	
		}
	System.out.println("What do you want to do?");
	System.out.println("1) deregister for a training"); 
	System.out.println("2) watch sessions"); 
	System.out.println("3) watch books"); 
	System.out.println("4) go back to trainingsmenu"); 
	
	int option = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/*
	do {
		option = br.read();
	} while (option < 1 || option > 3);
	*/
	switch (option) {
	case 1: deregisterTraining(privilege);
	 		break;
	case 2:watchSession(privilege);
		break;
	case 3:watchBooks(privilege);
		break;	
	case 4: trainingMenu(privilege);
			break;
		}
	}
	

public void deregisterTraining( int privilege) throws IOException{
		
		System.out.println("DEREGISTER"); 
		System.out.println("Give the id of the Training you wish to sign out"); 

		int option = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// option = br.read();
		
		/*
		Training tr1 = new Training();
		TrainingDB db1 = new TrainingDB();	
		*/
		
		// uitschrijving voor alle sessies
		// 
		
		watchMyTrainings(privilege);
		 return;
		
	}

public void watchSession(int privilege)  throws IOException{
	System.out.println("WATCH SESSION"); 
	System.out.println("Give the id of the Training you wish to watch the sessions"); 
	
	int option = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// option = br.read();
	// trainingsID exist
	// sessies van training bekijken via id
	
	watchMyTrainings(privilege);
	return;
	
}
	
public void watchBooks(int privilege) throws IOException{
	System.out.println("BOOKS"); 
	System.out.println("Give the id of the Training you wish to see the related books"); 
	
	int option = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// option = br.read();
	// trainingsID exist
	// boeken van training bekijken via id
	
	watchMyTrainings(privilege);
	return;
	
}	


public void sendMessage(){
	// TODO Auto-generated method stub
	
}
	

public void FillinSurvey(int privilege) throws IOException{
	System.out.println("SURVEY"); 
	System.out.println("your surveys");
	
	int option = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// option = br.read();
		// trainingsID exist
		// surveys van training bekijken via id
	
	watchMyTrainings(privilege);
	return;	
}
	
public void editTraining(int privilege) throws IOException{
	int option = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner scan = new Scanner(System.in);
	
	TrainingDB registerDB = new TrainingDB();
	Training uptatetraining = new Training();
	
	System.out.println("REQUEST REGISTRATION"); 
	System.out.println("Give the id of the course you want to change");
	option  = br.read();
	
	
	
	System.out.print("What is the title?");
	String title = scan.nextLine();
	uptatetraining.setTitle(title);
	
	System.out.print("What is the Subject?");
	String subject = scan.nextLine();
	uptatetraining.setSubject(subject);
	
	int language;
	Language keuze;

	System.out.print("What is the language?");
	printEnumWaarden();
	
	do {
		language = scan.nextInt();}
		while(language < 1 || language > yourEnums.length);		
	
		 switch (language) {
			case 1:uptatetraining.setLanguage(Language.Chinese);
					break;
			case 2:uptatetraining.setLanguage(Language.English);
					break;
			case 3:uptatetraining.setLanguage(Language.Spanish);
					break;
			case 4:uptatetraining.setLanguage(Language.Arabic);
					break;
			case 5:uptatetraining.setLanguage(Language.Russian);
					break;
			case 6:uptatetraining.setLanguage(Language.Portuguese);
					break;
			case 7:uptatetraining.setLanguage(Language.French);
					break;
			case 8:uptatetraining.setLanguage(Language.Japanese);
					break;
			case 9:uptatetraining.setLanguage(Language.German);
					break;
			case 10:uptatetraining.setLanguage(Language.Italien);
					break;
			case 11:uptatetraining.setLanguage(Language.Dutch);
					break;
		 }
		
		 System.out.print("Who is the responsible?");
		 String responsible = scan.nextLine();
		 uptatetraining.setResponsible(responsible);
	
		 System.out.print("What is the sessions?");
		 int sessions = scan.nextInt();
		 uptatetraining.setSessions(sessions);
	
		 registerDB.updateTrainingById(option, uptatetraining);
		 trainingMenu(privilege);
				
}

public void archiveTraining(int privilege)throws IOException {
	System.out.print("Give the trainingID of the training you wish to archive");
	Scanner scan = new Scanner(System.in);
	int trainingsid = scan.nextInt();
	
	TrainingDB archiveDB = new TrainingDB();

	archiveDB.archiveTrainingById(trainingsid);	
	trainingMenu(privilege);
	
	}

public void MakeNewTraining(int privilege)throws IOException {
	
	TrainingDB registerDB = new TrainingDB();
	Training newtraining = new Training();
	Scanner scan = new Scanner(System.in);
	
	System.out.print("What is the title?");
	
	String title = scan.nextLine();
	newtraining.setTitle(title);
	
	System.out.print("What is the Subject?");
	String subject = scan.nextLine();
	newtraining.setSubject(subject);
	
	int language;
	Language keuze;

	System.out.print("What is the language?");
	printEnumWaarden();
	
	do {
		language = scan.nextInt();}
		while(language < 1 || language > yourEnums.length);		
	
		 switch (language) {
			case 1:newtraining.setLanguage(Language.Chinese);
					break;
			case 2:newtraining.setLanguage(Language.English);
					break;
			case 3:newtraining.setLanguage(Language.Spanish);
					break;
			case 4:newtraining.setLanguage(Language.Arabic);
					break;
			case 5:newtraining.setLanguage(Language.Russian);
					break;
			case 6:newtraining.setLanguage(Language.Portuguese);
					break;
			case 7:newtraining.setLanguage(Language.French);
					break;
			case 8:newtraining.setLanguage(Language.Japanese);
					break;
			case 9:newtraining.setLanguage(Language.German);
					break;
			case 10:newtraining.setLanguage(Language.Italien);
					break;
			case 11:newtraining.setLanguage(Language.Dutch);
					break;
		 }
		
		 System.out.print("Who is the responsible?");
		 String responsible = scan.nextLine();
		 newtraining.setResponsible(responsible);
	
		 System.out.print("What is the sessions?");
		 int sessions = scan.nextInt();
		 newtraining.setSessions(sessions);
	
		 registerDB.insertTraining(newtraining);
		 trainingMenu(privilege);
	
		}

public void surveyMenu(int privilege) {
	
	System.out.print("to do");
	
	
}



public void registrationEmployee(int privilege){

	// laten inschrijven bij sessies
	
}


public void historyTrainings(int privilege) throws IOException {
//	Training watchTrainings = new Training();
	List<Training> trainingen = new ArrayList<Training>();
	TrainingDB watchTrainingsDB = new TrainingDB();
	trainingen = watchTrainingsDB.getNonActiveTrainings();
	System.out.println(trainingen.toString());
	
	// voorgaande sessies bekijken
	
	
	
	
	 trainingMenu(privilege);
	
	}
}

//Testcode:

///*
//int privilege = 1;
//
//Training t1 = new Training();
//Training t2 = new Training();
//Training t3 = new Training();
//Training t4 = new Training();
//
//t3.setTitle("testHibernate3");
//t3.setSubject("hibernate test poging 3");
//t3.setLanguage(Training.Language.German);
//t3.setResponsible("Michiel");
//t3.setSequentiality(4);
//
//ArrayList<Training> trainingen = new ArrayList<Training>();
//List<Training> TrainingList2 = new ArrayList<Training>(); 
//t1.setTitle("testHibernate3");
//t1.setSubject("hibernate test poging 3");
//t1.setLanguage(Training.Language.Dutch);
//t1.setResponsible("Michiel");
//t1.setSequentiality(4);
//
//TrainingDB db1 = new TrainingDB();		
////db1.insertTraining(t2);						//	 werkt
////db1.updateTraining(t1);						//   gaat niet		niet nodig
////db1.archiveTraining(t1);					//   gaat niet		niet nodig
////t2 = db1.getTraining(23);					//	 werkt
////trainingen = db1.getAllTrainings();			//	 werkt
////db1.updateTrainingById(23, t3);				// 	 werkt
////db1.archiveTrainingById(23);				//	 werkt
////TrainingList2 = db1.getActiveTrainings();	//	 werkt
//
////t4.trainingMenu(privilege);
	



	
	
	

