package logic;

import javax.persistence.CascadeType;
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
@Table(name="Survey_Answers")
public class Answer {

	
	@Id
	@Column(name = "answerID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int answerID;
	
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "total")
	private int aantal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="questionID",referencedColumnName="questionID")
	private Question question;

	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer(String answer, Question question) {
		super();
		this.answer = answer;
		this.question = question;
		this.aantal=0;
	}
	
	
	
	
	public Answer(String answer, int aantal) {
		super();
		this.answer = answer;
		this.aantal = aantal;
	}

	public Answer(int answerID, String answer, int aantal, Question question) {
		super();
		this.answerID = answerID;
		this.answer = answer;
		this.aantal = aantal;
		this.question = question;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public Answer() {
			
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + "]";
	}




	
	
	
	
	
	
	
	
	
}
