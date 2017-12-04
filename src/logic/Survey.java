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
import db.TrainingDB;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;




@Entity
@Table(name="Surveys")
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
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="survey")
	private List<Question> myListSurveysQuestions = new ArrayList<>();
	
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
	
	// constructor
		public Survey() {
			
		}
		
	public Survey(int trainingsID, String title, String description, List<Question> myListSurveysQuestions,
			int archive) {
		super();
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.myListSurveysQuestions = myListSurveysQuestions;
		this.archive = archive;
	}
	
	public Survey(int surveyID, int trainingsID, String title, String description, int archive) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
		this.title = title;
		this.description = description;
		this.archive = archive;
	}
	@Override
	public String toString() {
		return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", title=" + title + ", description="
				+ description + ", myListSurveysQuestions=" + myListSurveysQuestions + ", archive=" + archive + "]";
	}
	
	
	
	void menuSurvey(int privilege) throws SQLException, Exception {
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
					System.out.println("Voor welke training wilt u de survey invullen");
					int surveyID = scan.nextInt();
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
			System.out.println("4) back to Employee menu");
			
			int user_input_number = scan.nextInt();
			
			switch (user_input_number) {
			case 1: watchResults();
					break;
			case 2:makeNewSurvey();
					break;
			case 3:// beherenvoorafGedefinieerdeSurveys();
					break;
			default: System.out.println("U heeft foutieve invoer ingegeven");
			menuSurvey(privilege);
			break;
			}
		}
	}
		

	
	public void surveyInvullen(int surveyID)  throws SQLException, Exception{
		Scanner scan = new Scanner(System.in);
		
		SurveyDB surveydb = new SurveyDB();
		Survey  si1 = new Survey();
		si1 = surveydb.getSurveyByID(surveyID);
		
		System.out.println("TITLE");
		System.out.println(si1.getTitle());
		System.out.println("");
		
		System.out.println("DESCRIPTION");
		System.out.println(si1.getDescription());
		System.out.println("");
		
		// herwerken optellen score !
		int score = 1;
		
		for(int i = 0; i < si1.myListSurveysQuestions.size();i++) {
			System.out.println("QUESTION");
			System.out.println(si1.myListSurveysQuestions.get(i));
			
			for(int j = 0;  j < myListSurveysQuestions.get(j).getAntwoorden().size();i++) {
				System.out.println("Answer " + j+1 + ") ");
				System.out.print(myListSurveysQuestions.get(j).getAntwoorden().get(j));

				System.out.print("pick your answers press 0 to stop");
				
				
				do {
					score = scan.nextInt();
				}while(score !=0);
				
				// toevoegen van score
			}
			System.out.println("Survey filled in, thank you");
		
		}
	}
	
	
	
	private void watchResults() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void makeNewSurvey() throws Exception {
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
			
			System.out.println("Give question, press 0 to stop");
			List<Question> allQuestions = new ArrayList<Question>();
			Question questionnew = new Question();
			String question ="1";
			String answer = "1";
			
			List<String> allAnswers = new ArrayList<String>();
			
			do {
				question = scan.nextLine();
				questionnew.setQuestion(question);
				
				do {
					System.out.println("Give Answers, press 0 to stop");
					answer = scan.nextLine();
					allAnswers.add(answer);
				
				}while(answer != "0");
				questionnew.setAntwoorden(allAnswers);
				allQuestions.add(questionnew);
				
				
			}while(question != "0");
			sur1.setMyListSurveysQuestions(allQuestions);
			
			
			
			
			System.out.println("Wilt u deze survey aanmaken? 1) yes   2) no");
			sur1.toString();
			
			int keuzeAanmaken = scan.nextInt();
			
			
			if( keuzeAanmaken == 1) {
				SurveyDB surveydb = new SurveyDB();
				surveydb.addSurvey(sur1);
			}
			menuSurvey(3);
						
		}
		
		
		if (keuze == 1) {
			
			
			
			
			
		}
		
		
		
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
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		



