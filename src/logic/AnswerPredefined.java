package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Predefined_answers")
public class AnswerPredefined {
	@Id
	@Column(name="answerID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int answerID;
	
	@Column(name = "answer")
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="questionID",referencedColumnName="questionID")
	private QuestionPredefined question;


	public AnswerPredefined(int answerID, String answer, QuestionPredefined question) {
		super();
		this.answerID = answerID;
		this.answer = answer;
		this.question = question;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionPredefined getQuestion() {
		return question;
	}

	public void setQuestion(QuestionPredefined question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnswerPredefined [answer=" + answer + "]";
	}

	public AnswerPredefined(String answer, QuestionPredefined question) {
		super();
		this.answer = answer;
		this.question = question;
	}

	public AnswerPredefined() {
		super();
	}
	
	public AnswerPredefined(String answer) {
		super();
		this.answer=answer;
	}
	
	
	
	
	
}
