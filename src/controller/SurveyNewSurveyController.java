package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.SurveyDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Answer;
import logic.Question;
import logic.Survey;
import javafx.event.ActionEvent;

public class SurveyNewSurveyController implements Initializable {

	Survey s;
	Alert alert = null;
	SurveyDB db = new SurveyDB();
	int trainingID;
	String desc;
	String title;
	Question q = null;
	List<Question> questions;
	
	@FXML
	private TextField t_trainingID;
	
	@FXML
	private TextField t_title;
	
	@FXML
	private TextArea description;
	
	@FXML
	private TextField t_question1;
	@FXML
	private TextField t_question2;
	
	
	@FXML
	private TextField t_answer1a;
	@FXML
	private TextField t_answer2a;
	
	
	@FXML
	private TextField t_answer1b;
	@FXML
	private TextField t_answer2b;
	
	
	@FXML
	private TextField t_answer1c;
	@FXML
	private TextField t_answer2c;	
	@FXML
	private Button b_savesurvey;
	
	
	@FXML //functie voor button "save survey"
	protected void toSaveSurvey(ActionEvent e) {
		trainingID = Integer.parseInt(t_trainingID.getText());
		desc = description.getText();
		title = t_title.getText();
		
		q = new Question (t_question1.getText());
		q.getAntwoorden().add(new Answer(t_answer1a.getText(), q));
		q.getAntwoorden().add(new Answer(t_answer1b.getText(), q));
		q.getAntwoorden().add(new Answer(t_answer1c.getText(), q));
		questions.add(q);
		q = new Question (t_question2.getText());
		q.getAntwoorden().add(new Answer(t_answer2a.getText(), q));
		q.getAntwoorden().add(new Answer(t_answer2b.getText(), q));
		q.getAntwoorden().add(new Answer(t_answer2c.getText(), q));
		questions.add(q);
		s= new Survey(trainingID, title, desc, questions);
		db.addSurvey(s);
	}
	
//	@FXML
//	protected void savetrainingId (ActionEvent e)
//	{
//		trainingID = Integer.parseInt(t_trainingID.getText());
//	}
	
//	@FXML
//	protected void savedesc (ActionEvent e)
//	{
//		desc = description.getText();
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		

//		String desc = description.getText();
//		String ttle = t_title.getText();
//		s = new Survey(trainingID, ttle, desc);
//		String question = t_question.getText();
//		Question q = new Question(question);
//		Answer answ1 = new Answer(t_answer1.getText(), q);
//		Answer answ2 = new Answer(t_answer2.getText(), q);
//		Answer answ3 = new Answer(t_answer3.getText(), q);
//		q.getAntwoorden().add(answ1);
//		q.getAntwoorden().add(answ2);
//		q.getAntwoorden().add(answ3);
		
	}

}
