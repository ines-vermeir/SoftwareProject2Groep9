package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="Results")
@Table(name="Results")

public class Result {
	
	@Id
	@Column(name ="id")
	int id;
	
	@Column(name ="question_id")
	int question_id;
	
	@Column(name ="survey_id")
	int survey_id;
	
	@Column(name ="answer")
	String answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getSurvey_id() {
		return survey_id;
	}
	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Result(int id, int question_id, int survey_id, String answer) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.survey_id = survey_id;
		this.answer = answer;
	}
	
	public Result()
	{
		
	}
	
}
