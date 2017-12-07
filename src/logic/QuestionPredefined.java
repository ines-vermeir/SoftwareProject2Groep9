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


@Entity
@Table(name="Predefined_questions")
public class QuestionPredefined {

		@Id
		@Column(name="questionID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer questionId;
		
		
		@Column(name = "question")
		private String question;
			
		
		//@ElementCollection(targetClass=String.class)
	//	@ElementCollection
	//	@CollectionTable(name="Predefined_answers", joinColumns=@JoinColumn(name="questionID"))
		@Column(name="answer")
		@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "question")
		private List <AnswerPredefined> antwoorden = new ArrayList<AnswerPredefined>();
		
		@ManyToOne
		@JoinColumn(name="surveyPrID",referencedColumnName="surveyPrID")
		private SurveyPredefined survey;

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

		public List<AnswerPredefined> getAntwoorden() {
			return antwoorden;
		}

		public void setAntwoorden(List<AnswerPredefined> antwoorden) {
			this.antwoorden = antwoorden;
		}

		public SurveyPredefined getSurvey() {
			return survey;
		}

		public void setSurvey(SurveyPredefined survey) {
			this.survey = survey;
		}

		@Override
		public String toString() {
			return "QuestionPredefined [questionId=" + questionId + ", question=" + question + ", antwoorden="
					+ antwoorden + "]";
		}

		public QuestionPredefined(Integer questionId, String question, List<AnswerPredefined> antwoorden,
				SurveyPredefined survey) {
			super();
			this.questionId = questionId;
			this.question = question;
			this.antwoorden = antwoorden;
			this.survey = survey;
		}

		public QuestionPredefined(String question, List<AnswerPredefined> antwoorden, SurveyPredefined survey) {
			super();
			this.question = question;
			this.antwoorden = antwoorden;
			this.survey = survey;
		}
		
		
		public QuestionPredefined() {
			
		}

		public QuestionPredefined(Integer questionId, String question, List<AnswerPredefined> antwoorden) {
			super();
			this.questionId = questionId;
			this.question = question;
			this.antwoorden = antwoorden;
		}
		
		
		
			
	/*
			public void setAntwoorden(ArrayList<String> antwoorden) {
				this.antwoorden = antwoorden;
			}
			
		*///	public void  addAnswer(String antwoord) {
			//	antwoorden.add(antwoord);
		//	}

			


			
			
			
		

	
}
