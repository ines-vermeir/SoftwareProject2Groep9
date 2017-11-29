package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Override
	public String toString() {
		return "Survey [surveyID=" + surveyID + ", trainingsID=" + trainingsID + ", myListSurveysQuestions="
				+ myListSurveysQuestions + "]";
	}
		
		}



