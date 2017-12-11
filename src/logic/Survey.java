package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import db.SurveyDB;
import db.SurveyPredefinedDB;
import db.TrainingDB;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;




@Entity
@Table(name="Survey_Surveys")
public class Survey {

	
	// datamembers
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="surveyID")
	private int surveyID;
	
	@Column(name="trainingID")	
	private int trainingsID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	//@OneToMany(mappedBy="survey", cascade={ CascadeType.ALL, }, orphanRemoval=true)//,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@OneToMany(cascade=CascadeType.ALL,mappedBy="survey",fetch = FetchType.EAGER)
	private List<Question> myListSurveysQuestions = new ArrayList<>();
	
	
	@Column(name="aantalIngevuld")
	private int aantalIngevuld;
	
	@Column(name="archive")
	private int archive;
	
	// getters & setters
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	
	public int getTrainingsID() {
		return trainingsID;
	}
	public void setTrainingsID(int trainingsID) {
		this.trainingsID = trainingsID;
	}
	
	public List<Question> getMyListSurveysQuestions() {
		return myListSurveysQuestions;
	}
	
	public void setMyListSurveysQuestions(List<Question> myListSurveysQuestions) {
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	/*
	public void setMyListSurveysQuestions(ArrayList<Question> myListSurveysQuestions) {
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	*/
	
	/*
	public void Addquestion(Question question) {
		myListSurveysQuestions.add(question);
	}
	*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getArchive() {
		return archive;
	}
	public void setArchive(int archive) {
		this.archive = archive;
	}
	
	public int getAantalIngevuld() {
		return aantalIngevuld;
	}
	public void setAantalIngevuld(int aantalIngevuld) {
		this.aantalIngevuld = aantalIngevuld;
	}
		// constructor
		public Survey() {
			this.archive=0;
			this.aantalIngevuld=0;
		}
		
	public Survey(int trainingsID, String title, String description, List<Question> myListSurveysQuestions,
			int archive) {
		super();
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.myListSurveysQuestions = myListSurveysQuestions;
		this.archive = archive;
		this.aantalIngevuld=0;
	}
	
	public Survey(int surveyID, int trainingsID, String title, String description, int archive) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.archive = archive;
		this.aantalIngevuld=0;
	}
	
	public Survey(int trainingsID, String title, String description) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.archive = 0;
		this.aantalIngevuld=0;
	}
	
	public Survey(int trainingsID, String title, String description, List<Question> myListSurveysQuestions) {
		super();
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.myListSurveysQuestions = myListSurveysQuestions;
		this.archive = 0;
		this.aantalIngevuld=0;
	}
	
	
	public Survey(int surveyID, int trainingsID, String title, String description, int aantalIngevuld, int archive) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.aantalIngevuld = aantalIngevuld;
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", title=" + title + ", description="
				+ description + ", myListSurveysQuestions=" + myListSurveysQuestions + ", archive=" + archive + "]";
	}
	
	
	
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
				
					surveyInvullen(surveyID);
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
				
				
			 }	 
	
			System.out.println("");
		boolean[] gekozenAnswers = new boolean[si1.getMyListSurveysQuestions().get(i).getAntwoorden().size()];
		 Arrays.fill(gekozenAnswers,Boolean.FALSE);
			 System.out.print("Wich answers do you wish to select press -1 to stop");
			 
		 int keuze5;
			 
			 do {
				 
				 keuze5 = scan.nextInt();
				 if(keuze5 > 1) {
				 gekozenAnswers[keuze5 -1] = true;
				 }
					 
			 }while(keuze5 !=-1);
			 
//			 for (int a = 0; a < gekozenAnswers.length;a++) {
//				 if( gekozenAnswers[a] == true) {
//					 si1.getMyListSurveysQuestions().get(i).getAntwoorden().get(j).setAantal((si1.getMyListSurveysQuestions().get(i).getAntwoorden().get(j).getAantal()+1));	 
//				 }		 				 
//			}	
		}
		surveydb.updateSurveyById(SurveyID, si1);
		System.out.println("");
	}
	
	
	
	public void watchResults(){
		SurveyDB 	surveydb = new SurveyDB();
    	
		List<Survey> surveys= new ArrayList<Survey>();
		surveys = surveydb.getAllSurveys();
		
		System.out.println(surveys);
	}
	
	
	
	
	// TO DO
	public void makeNewSurvey(){
		Scanner scan = new Scanner(System.in);
		int keuze;
		System.out.println("1) make a new survey");
		System.out.println("2) use a predifined survey");
		keuze = scan.nextInt();
//		do {
//			keuze = scan.nextInt();
//		}while(keuze > 1 || keuze < 2);
		
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
	}
	
	
	
	

	
	
	
	
		
	
		
	

	
// Testcode:
//
//
//
//List<Question> questionsOBJ = new ArrayList<>();
//
/*
List<String> questionsSTR1 = new ArrayList<String>(); 
questionsSTR1.add("vraag 1 28/11");
questionsSTR1.add("vraag 2 28/11");

List<String> questionsSTR2 = new ArrayList<String>(); 
questionsSTR2.add("vraag 3 28/11");
questionsSTR2.add("vraag 4 28/11");
*/
//Survey s3 = new Survey();
//Survey s1 = new Survey();
//s1.setTrainingsID(23);
//s1.setTitle("title");	
//s1.setDescription("description");	//  ok
//
//Question q1 = new Question();
//q1.setQuestion("vraag 1 28/11");	// 	ok
//q1.getAntwoorden().add("antwoord1");
//q1.getAntwoorden().add("antwoord2");
//q1.getAntwoorden().add("antwoord3");
//
//Question q2 = new Question();
//q2.setQuestion("vraag 2 29/11");// 		ok
//q2.getAntwoorden().add("antwoord4");
//q2.getAntwoorden().add("antwoord5");
//q2.getAntwoorden().add("antwoord6");
//
//s1.getMyListSurveysQuestions().add(q1);
//s1.getMyListSurveysQuestions().add(q2);
//
//q1.setSurvey(s1);
//q2.setSurvey(s1);
//
////	System.out.println(s1.toString());
//SurveyDB surveydb = new SurveyDB();
////	surveydb.addSurvey(s1);					// werkt
////	s3 = surveydb.getSurvey(18);
////	System.out.println(s3.toString());
//
//
//Survey s4 = new Survey();
//s4.setDescription("nieuwe descriptie");
//s4.setTitle("nieuwe titel");
// 	surveydb.updateSurveyByID(18, s4);	werkt




//	List<Question> questions = new ArrayList<Question>(); 
//	questions = surveydb.getAllAnswersByid(1);		werkt

//	questions = surveydb.getAllQuestionsByid(18);
//	s3=	surveydb.getSurveyByID(18);

//	s3 = surveydb.getSurveyByID(18);			// werkt

//	List<Question> questions = new ArrayList<Question>(); 
//	questions = surveydb.getAllQuestionsByid(18);


//	s3 = surveydb.getSurveyByID(18);	// werkt

//	List<String> questions = new ArrayList<String>(); 
//	questions = surveydb.getAllAnswersByid(1);
//	s3 = surveydb.getSurveyByID(18);


// werkt surveydb.archiveSurvey(18);		werkt


//	List<Survey> surveys = new ArrayList<Survey>();
//	surveys = surveydb.getAllSurveys();			werkt

//	List<Survey> activeSurveys = new ArrayList<Survey>(); werkt
//	activeSurveys = surveydb.getAllActiveSurveys();

//		System.out.println(activeSurveys .toString()); werkt

//
//*/
	
	
	
	
	
		
	
	///////////////////////////////////////////////////////////////////////

//SurveyPredefined surveyPredefined = new SurveyPredefined();
//
//surveyPredefined.setDescription("description");
//surveyPredefined.setTitle("title");
//
//QuestionPredefined q1 = new QuestionPredefined();
//q1.setQuestion("question 1");
//q1.setSurvey(surveyPredefined);
//
//AnswerPredefined a1 = new AnswerPredefined();
//a1.setAnswer("answer1");
//a1.setQuestion(q1);
//
//q1.getAntwoorden().add(a1);
//surveyPredefined.getMyListSurveysQuestions().add(q1);
//
//
////System.out.println(surveyPredefined.toString());
//
//SurveyDB sDB = new SurveyDB();
////sDB.addSurvey(surveyPredefined);
//
//Survey s1 = new Survey();
////s1 =sDB.getSurvey(48);
//
////  	List<String> answers = new ArrayList<String>();
//List<Answer> answers= new ArrayList<Answer>();
//answers = sDB.getAllAnswersByid(31);
//
//
//
//Survey s5 = new Survey();
////s5=  sDB.getSurveyByID(48);
//
//
//List<Question> questions= new ArrayList<Question>();
////s1 = sDB.getSurveyByID(48);
//
////sDB.archiveSurvey(48);
//
//List<Survey> surveys= new ArrayList<Survey>();
//surveys = sDB.getAllActiveSurveys();
//System.out.println(	surveys.toString());
//

//
//SurveyPredefined surveyPredefined = new SurveyPredefined();
// surveyPredefined.setTitle("java");
// surveyPredefined.setDescription("java OO");
//// surveyPredefined.setMyListSurveysQuestions(null);
// 
// QuestionPredefined questionPredefined = new QuestionPredefined();
// questionPredefined.setQuestion("hoe was de leerstof");
// questionPredefined.setSurvey(surveyPredefined);
// 
//AnswerPredefined answerPredefined = new AnswerPredefined();
//answerPredefined.setAnswer("1) goed");
//answerPredefined.setQuestion(questionPredefined);
//
//
//AnswerPredefined answerPredefined2 = new AnswerPredefined();
//answerPredefined2 .setAnswer("2) niet goed");
//answerPredefined2.setQuestion(questionPredefined);
//
//
//questionPredefined.getAntwoorden().add(answerPredefined);
//questionPredefined.getAntwoorden().add(answerPredefined2);
//
//
//surveyPredefined.getMyListSurveysQuestions().add(questionPredefined);
//
//
//
//
//
//
//
//SurveyPredefined surveyPredefined2 = new SurveyPredefined();
//surveyPredefined2.setTitle("java2");
//surveyPredefined2.setDescription("java2 OO");
//// surveyPredefined.setMyListSurveysQuestions(null);
//
//


//	Survey s1 = new Survey();
// 	s1.makeNewSurvey();


// 	System.out.println("test");





//System.out.println(surveyPredefined.toString());


//SurveyPredefinedDB 	surveyPredefinedDB = new SurveyPredefinedDB();
////surveyPredefinedDB.addSurvey(surveyPredefined);
//
//List<SurveyPredefined> surveys= new ArrayList<SurveyPredefined>();
////surveys = surveyPredefinedDB.getAllSurveys();
//
//
//SurveyPredefined surveyPredefined1 = new SurveyPredefined();
////surveyPredefined1 = surveyPredefinedDB.getSurveyByID(16);
//
//
////surveyPredefinedDB.updateSurveyByID(16, surveyPredefined2);
//
//
//surveyPredefinedDB.deleteSurveyQuestionsbyID(16, null);
//
//
//surveyPredefinedDB.updateSurveyByID(16, surveyPredefined2);
////surveyPredefinedDB.deleteSurveyAnwersbyID(16);

//System.out.println(surveyPredefined1.toString());


////////////////////
//Survey s1 = new Survey();
//
//s1.setTrainingsID(26);
//s1.setTitle("HQL1");
//s1.setDescription("Hibernate Query Language1");
//
//
//Question q1 = new Question();
//q1.setQuestion("score van leraar1");
//q1.setSurvey(s1);
//
//Answer a1 = new Answer();
//a1.setAnswer("1) slecht1");
//a1.setQuestion(q1);
//a1.setAantal(0);
//
//Answer a2 = new Answer();
//a2.setAnswer("1) slecht1");
//a2.setQuestion(q1);
//a2.setAantal(0);
//
//
//
//Question q2 = new Question();
//q2.setQuestion("score van leraar1");
//q2.setSurvey(s1);
//
//Answer a3 = new Answer();
//a3.setAnswer("1) slecht1");
//a3.setQuestion(q2);
//a3.setAantal(0);
//
//Answer a4 = new Answer();
//a4.setAnswer("1) slecht5");
//a4.setQuestion(q2);
//a4.setAantal(0);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
///*Question q2 = new Question();
//q2.setQuestion("score leerstof");
//q2.setSurvey(s1);
//*/
//
//q1.getAntwoorden().add(a1);
//q1.getAntwoorden().add(a2);
//
//q2.getAntwoorden().add(a3);
//q2.getAntwoorden().add(a4);
//
//s1.getMyListSurveysQuestions().add(q1);
//s1.getMyListSurveysQuestions().add(q2);
////
////
//System.out.println(s1.toString());
////s1.getMyListSurveysQuestions().add(q2);
////
//SurveyDB sDB = new SurveyDB();
//	sDB.addSurvey(s1);



/*
Answer a1 = new Answer();
Answer a2 = new Answer();
Answer a3 = new Answer();

a1.setAnswer("1) slecht");
a1.setQuestion(q1);
a2.setAnswer("2) matig");
a2.setQuestion(q1);
a3.setAnswer("3) goed");
a3.setQuestion(q1);

q1.getAntwoorden().add(a1);
q1.getAntwoorden().add(a2);
q1.getAntwoorden().add(a3);

Question q2 = new Question();
q2.setQuestion("score leerstof");
q2.setSurvey(s1);


Answer a4 = new Answer();
Answer a5 = new Answer();
Answer a6= new Answer();

a4.setAnswer("1) slecht");
a4.setQuestion(q2);
a5.setAnswer("2) matig");
a5.setQuestion(q2);
a6.setAnswer("3) goed");
a6.setQuestion(q2);

q2.getAntwoorden().add(a4);
q2.getAntwoorden().add(a5);
q2.getAntwoorden().add(a6);

s1.getMyListSurveysQuestions().add(q1);
s1.getMyListSurveysQuestions().add(q2);
*/




// 	System.out.println(s1.toString());

//	SurveyDB sDB = new SurveyDB();
//sDB.addSurvey(s1);

	
	
	
	
	
	
	
	
	
	
	
	
	
		



