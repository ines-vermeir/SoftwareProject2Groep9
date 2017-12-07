package logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="Survey_Questions")
public class Question {
	@Id
	@Column(name="questionID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionId;
	
	
	@Column(name = "question")
	private String question;
		
	//
	//@ElementCollection(targetClass=String.class)
	//@ElementCollection
	//@CollectionTable(name="answers", joinColumns=@JoinColumn(name="questionID"))
	
	
	
	
	//@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	@Column(name="answer")
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "question")
//	@OneToMany(mappedBy="question", cascade={ CascadeType.ALL, }, orphanRemoval=true)
	
	private List <Answer> antwoorden = new ArrayList<Answer>();
	
	
	
	
	//@ManyToOne(fetch = FetchType.EAGER, 
     //       cascade = { CascadeType.ALL, CascadeType. }
	@ManyToOne
	@JoinColumn(name="surveyID",referencedColumnName="surveyID")
	private Survey survey;
	
	
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Integer getQuestionId() {
			return questionId;
	}

	public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
	}

	public String getQuestion() {
			return question;
	}

	public void setQuestion(String question) {
			this.question = question;
		}
		
public List<Answer> getAntwoorden() {
		return antwoorden;
	}

	public void setAntwoorden(List<Answer> antwoorden) {
		this.antwoorden = antwoorden;
	}
	
	

public Question(Integer questionId, String question, List<Answer> antwoorden, Survey survey) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.antwoorden = antwoorden;
		this.survey = survey;
	}

public Question(Integer questionId, String question, List<Answer> antwoorden) {
	super();
	this.questionId = questionId;
	this.question = question;
	this.antwoorden = antwoorden;
}




public Question() {
	super();
}

@Override
public String toString() {
	return "Question [question=" + question + ", antwoorden=" + antwoorden + "]";
}





//		public List<String> getAntwoorden() {
//			return antwoorden;
//		}
		
//		public void setAntwoorden(List<String> antwoorden) {
//			this.antwoorden = antwoorden;
//		}
/*
		public void setAntwoorden(ArrayList<String> antwoorden) {
			this.antwoorden = antwoorden;
		}
		
	*///	public void  addAnswer(String antwoord) {
		//	antwoorden.add(antwoord);
	//	}

		
		
		
//		public Question(Integer questionId, String question, ArrayList<String> antwoorden, ArrayList<Boolean> gekozenAntwoord) {
//			super();
//			this.questionId = questionId;
//			this.question = question;
//			//this.antwoorden = antwoorden;
////			this.gekozenAntwoord = gekozenAntwoord;
//		}
//		
//		public Question(String question) {
//			super();
//			this.question = question;
//		//	antwoorden = null;
//		}
//
//		public Question(String question, ArrayList<String> antwoorden) {
//			super();
//			this.question = question;
//		//	this.antwoorden = antwoorden;
//			}
//
//		public Question(int questionId,String question) {
//			this.questionId = questionId;
//			this.question = question;
//			this.antwoorden = null;
//		}
		
		
	
		/*
		@Override
		public String toString() {
			return "Question [questionId=" + questionId + ", question=" + question + ", antwoorden=" + antwoorden + "]";
		}
		*/
	

}




