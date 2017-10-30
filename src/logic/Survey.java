package logic;

import java.util.Arrays;


public class Survey {

	// datamembers
	private int surveyID;
	private int trainingsID;
	private String[] questions;
	private int count = 0;		// aantal elementen in array
	
	
	// getters & setters
	public int getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}
	public String[] getQuestions() {
		return questions;
	}
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}
	public int getTrainingsID() {
		return trainingsID;
	}
	public void setTrainingsID(int trainingsID) {
		this.trainingsID = trainingsID;
	}
	
	// constructors
	public Survey(int surveyID, String[] questions, int trainingsID) {
		super();
	
		this.questions = new String[1]; // vergroten met 1
		this.surveyID = surveyID;
		this.questions = questions;
		this.trainingsID = trainingsID;
	}
	
	public Survey(int surveyID, int trainingsID) {
		super();
	
		this.questions = new String[1]; // vergroten met 1
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
	}
	
	public Survey() {
		super();
		this.questions = new String[1]; // vergroten met 1

	}
	
	// method
	public void Addquestion(String question) {
		if(count <questions.length) {
			questions[count] = question;
		}
		else {
			
	String[] temp = new String[questions.length +1];		// vergroten met 1 bij te klein
	for (int i = 0; i < questions.length; i++){
	      temp[i] = questions[i];
	}
	questions= temp;
	questions[count] = question;	
		}
		count++;
	}
	
	 
	
	@Override
	public String toString() {
		return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", questions="
				+ Arrays.toString(questions) + "]";
	}
	
	
// testing + main

	 
		public static void main(String[] args) {
		Survey survey1 = new Survey(1,1);
		Survey survey2 = new Survey(2,2);
		Survey survey3 = new Survey(3,3);
		Survey survey4 = new Survey();
		
		
		survey1.Addquestion("Wat was de duurtijd1?");
		survey1.Addquestion("Wat was de duurtijd2?");
		survey1.Addquestion("Wat was de duurtijd3?");
		survey1.Addquestion("Wat was de duurtijd4?");
		survey1.Addquestion("Wat was de duurtijd5?");
		survey1.Addquestion("Wat was de duurtijd6?");
		survey1.Addquestion("Wat was de duurtijd7?");
		survey1.Addquestion("Wat was de duurtijd8?");
		survey1.Addquestion("Wat was de duurtijd9?");
		survey1.Addquestion("Wat was de duurtijd10?");
		survey1.Addquestion("Wat was de duurtijd11?");
		
	
		
		System.out.println(survey1.toString());
		
		}
}


