package logic;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="Survey_Questions_test")
public class Question {
	@Id
	@Column(name="questionID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionId;
	
	
	@Column(name = "question")
	private String question;
		
	
	//@ElementCollection(targetClass=String.class)
	@ElementCollection
	@CollectionTable(name="answers", joinColumns=@JoinColumn(name="questionID"))
	@Column(name="answer")
	
	private List <String> antwoorden = new ArrayList<String>();
	
	@ManyToOne
	@JoinColumn(name="surveyID")
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

		public List<String> getAntwoorden() {
			return antwoorden;
		}
		
		public void setAntwoorden(List<String> antwoorden) {
			this.antwoorden = antwoorden;
		}
/*
		public void setAntwoorden(ArrayList<String> antwoorden) {
			this.antwoorden = antwoorden;
		}
		
	*///	public void  addAnswer(String antwoord) {
		//	antwoorden.add(antwoord);
	//	}

		public Question(Integer questionId, String question, ArrayList<String> antwoorden, ArrayList<Boolean> gekozenAntwoord) {
			super();
			this.questionId = questionId;
			this.question = question;
			this.antwoorden = antwoorden;
//			this.gekozenAntwoord = gekozenAntwoord;
		}
		
		public Question(String question) {
			super();
			this.question = question;
		//	antwoorden = null;
		}

		public Question(String question, ArrayList<String> antwoorden) {
			super();
			this.question = question;
		//	this.antwoorden = antwoorden;
			}

		public Question() {
		
		}
		
		@Override
		public String toString() {
			return "Question [questionId=" + questionId + ", question=" + question + ", antwoorden=" + antwoorden + "]";
		}
		
	

}




