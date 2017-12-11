package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Predefined_surveys")
public class SurveyPredefined {
	
	@Id	 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="surveyPrID")
	private int surveyPrID;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="survey",fetch = FetchType.EAGER,orphanRemoval=true)
//	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN,
//        org.hibernate.annotations.CascadeType.PERSIST,
//        org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Fetch(FetchMode.SELECT)
	private List<QuestionPredefined> myListSurveysQuestions = new ArrayList<>();

	public int getSurveyPrID() {
		return surveyPrID;
	}

	public void setSurveyPrID(int surveyPrID) {
		this.surveyPrID = surveyPrID;
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

	public List<QuestionPredefined> getMyListSurveysQuestions() {
		return myListSurveysQuestions;
	}

	public void setMyListSurveysQuestions(List<QuestionPredefined> myListSurveysQuestions) {
		this.myListSurveysQuestions = myListSurveysQuestions;
	}

	@Override
	public String toString() {
		return "SurveyPredefined [surveyPrID=" + surveyPrID + ", title=" + title + ", description=" + description
				+ ", myListSurveysQuestions=" + myListSurveysQuestions + "]";
	}

	public SurveyPredefined() {
		super();
	}

	public SurveyPredefined(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public SurveyPredefined(int surveyPrID, String title, String description) {
		super();
		this.surveyPrID = surveyPrID;
		this.title = title;
		this.description = description;
	}

	public SurveyPredefined(int surveyPrID, String title, String description,
			List<QuestionPredefined> myListSurveysQuestions) {
		super();
		this.surveyPrID = surveyPrID;
		this.title = title;
		this.description = description;
		this.myListSurveysQuestions = myListSurveysQuestions;
	}

	public SurveyPredefined(String title, String description, List<QuestionPredefined> myListSurveysQuestions) {
		super();
		this.title = title;
		this.description = description;
		this.myListSurveysQuestions = myListSurveysQuestions;
	}
	

	
	
	

	
}
