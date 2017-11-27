package logic;

import java.util.ArrayList;
import java.util.Arrays;


public class Survey {

	// datamembers
	private int surveyID;
	private int trainingsID;
	private String title;
	private String description;
	private ArrayList<Question> myListSurveysQuestions;
	
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
	
	public ArrayList<Question> getMyListSurveysQuestions() {
		return myListSurveysQuestions;
	}
	public void setMyListSurveysQuestions(ArrayList<Question> myListSurveysQuestions) {
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	
	// constructor
	public Survey() {
		
	}
	public Survey(int surveyID, int trainingsID, ArrayList<Question> myListSurveysQuestions) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	
	public Survey(int surveyID, int trainingsID) {
		super();
		this.surveyID = surveyID;
		this.trainingsID = trainingsID;
	}
	
	/*
	// constructors
	public Survey(int surveyID, String[] questions, int trainingsID) {
		super();
	
		this.questions = new String[1]; // vergroten met 1
		this.surveyID = surveyID;
		this.questions = questions;
		this.trainingsID = trainingsID;
	}
	*/

	/*
	public Survey() {
		super();
		this.questions = new String[1]; // vergroten met 1

	}
	*/
	public void Addquestion(Question question) {
		myListSurveysQuestions.add(question);
	}
	
	@Override
public String toString() {
	return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", myListSurveysQuestions="
			+ myListSurveysQuestions + "]";
}
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
	
 
		
		}



