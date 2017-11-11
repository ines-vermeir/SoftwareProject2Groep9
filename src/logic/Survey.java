package logic;

import java.util.ArrayList;
import java.util.Arrays;


public class Survey {

	// datamembers
	private int surveyID;
	private int trainingsID;
	private ArrayList<String> myListSurveysQuestions;
	
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
	
	public ArrayList<String> getMyListSurveysQuestions() {
		return myListSurveysQuestions;
	}
	public void setMyListSurveysQuestions(ArrayList<String> myListSurveysQuestions) {
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	
	// constructor
	public Survey() {
		
	}
	
	public Survey(int surveyID, int trainingsID, ArrayList<String> myListSurveysQuestions) {
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
	
	
	public void Addquestion(String question) {
		myListSurveysQuestions.add(question);
	}
	
	@Override
public String toString() {
	return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", myListSurveysQuestions="
			+ myListSurveysQuestions + "]";
}
	
 
		
		}



