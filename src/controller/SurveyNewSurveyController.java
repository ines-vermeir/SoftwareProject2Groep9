package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import db.SurveyDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.Answer;
import logic.Question;
import logic.Survey;
import javafx.event.ActionEvent;

public class SurveyNewSurveyController implements Initializable {

	
	@FXML private Label errorMsg;
	
	@FXML private TextField t_trainingID;	
	@FXML private TextField t_title;	
	@FXML private TextArea description;
	
	@FXML private TextField t_question1;
	@FXML private TextField t_question2;
	@FXML private TextField t_question3;
	@FXML private TextField t_question4;
	@FXML private TextField t_question5;
	@FXML private TextField t_answer1a;
	@FXML private TextField t_answer2a;
	@FXML private TextField t_answer3a;
	@FXML private TextField t_answer4a;
	@FXML private TextField t_answer5a;
	@FXML private TextField t_answer1b;
	@FXML private TextField t_answer2b;	
	@FXML private TextField t_answer3b;	
	@FXML private TextField t_answer4b;	
	@FXML private TextField t_answer5b;	
	@FXML private TextField t_answer1c;
	@FXML private TextField t_answer2c;	
	@FXML private TextField t_answer3c;	
	@FXML private TextField t_answer4c;	
	@FXML private TextField t_answer5c;	
	@FXML private Button b_savesurvey;
	@FXML private Button back;

	
	@FXML //functie voor button "new survey"
	protected void backToSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyView);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML
	protected void toSaveSurvey(ActionEvent e)
	{
		errorMsg.setText("");
		int trainingID = 0;
		String desc = null, title = null, question1 = null, question2 = null, question3 = null, question4 = null, question5 = null,
				answer1a = null, answer1b = null, answer1c = null, 
				answer2a = null, answer2b = null, answer2c = null,
				answer3a = null, answer3b = null, answer3c = null,
				answer4a = null, answer4b = null, answer4c = null,
				answer5a = null, answer5b = null, answer5c = null,
				tid = null;
		boolean check = true;
		
		if ((t_trainingID.getText()!= null && !t_trainingID.getText().isEmpty())) {
			tid = t_trainingID.getText();
			try {
				 trainingID = Integer.parseInt(tid);
			 }catch( NumberFormatException numberex) {
				 errorMsg.setText(errorMsg.getText() + "\nTraining ID is not a number!");
				 check = false;
			 }
		}  else {
		 errorMsg.setText(errorMsg.getText() + "\nTraining ID is empty!");
		 check = false;
		}
		if ((t_title.getText()!= null && !t_title.getText().isEmpty())) {
			title = t_title.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nTitle is empty!");
			 check = false;
		 }
		if ((description.getText()!= null && !description.getText().isEmpty())) {
			desc = description.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nDescription is empty!");
			 check = false;
		 }
		if ((t_question1.getText()!= null && !t_question1.getText().isEmpty())) {
			question1 = t_question1.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nQuestion 1 is empty!");
			 check = false;
		 }
		if ((t_question2.getText()!= null && !t_question2.getText().isEmpty())) {
			question2 = t_question2.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nQuestion 2 is empty!");
			 check = false;
		 }		
			
			question3 = t_question3.getText();
			question4 = t_question4.getText();
			question5 = t_question5.getText();
		
		if ((t_answer1a.getText()!= null && !t_answer1a.getText().isEmpty())) {
			answer1a = t_answer1a.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 1a is empty!");
			 check = false;
		 }
		if ((t_answer1b.getText()!= null && !t_answer1b.getText().isEmpty())) {
			answer1b = t_answer1b.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 1b is empty!");
			 check = false;
		 }
		if ((t_answer1c.getText()!= null && !t_answer1c.getText().isEmpty())) {
			answer1c = t_answer1c.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 1c is empty!");
			 check = false;
		 }
		if ((t_answer2a.getText()!= null && !t_answer2a.getText().isEmpty())) {
			answer2a = t_answer2a.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 2a is empty!");
			 check = false;
		 }
		if ((t_answer2b.getText()!= null && !t_answer2b.getText().isEmpty())) {
			answer2b = t_answer2b.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 2b is empty!");
			 check = false;
		 }
		if ((t_answer2c.getText()!= null && !t_answer2c.getText().isEmpty())) {
			answer2c = t_answer2c.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 2c is empty!");
			 check = false;
		 }
//--------------------------
		if ((t_question3.getText()!= null && !t_question3.getText().isEmpty()))
		{
		if ((t_answer3a.getText()!= null && !t_answer3a.getText().isEmpty())) {
			answer3a = t_answer3a.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 3a is empty!");
			 check = false;
		 }
		if ((t_answer3b.getText()!= null && !t_answer3b.getText().isEmpty())) {
			answer3b = t_answer3b.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 3b is empty!");
			 check = false;
		 }
		if ((t_answer3c.getText()!= null && !t_answer3c.getText().isEmpty())) {
			answer3c = t_answer3c.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 3c is empty!");
			 check = false;
		 }
		}
		if ((t_question4.getText()!= null && !t_question4.getText().isEmpty())) {
		if ((t_answer4a.getText()!= null && !t_answer4a.getText().isEmpty())) {
			answer4a = t_answer4a.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 4a is empty!");
			 check = false;
		 }
		if ((t_answer4b.getText()!= null && !t_answer4b.getText().isEmpty())) {
			answer4b = t_answer4b.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 4b is empty!");
			 check = false;
		 }
		if ((t_answer4c.getText()!= null && !t_answer4c.getText().isEmpty())) {
			answer4c = t_answer4c.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 4c is empty!");
			 check = false;
		 }
	}
		if ((t_question5.getText()!= null && !t_question5.getText().isEmpty())) {
		if ((t_answer5a.getText()!= null && !t_answer5a.getText().isEmpty())) {
			answer5a = t_answer5a.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 5a is empty!");
			 check = false;
		 }
		if ((t_answer5b.getText()!= null && !t_answer5b.getText().isEmpty())) {
			answer5b = t_answer5b.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 5b is empty!");
			 check = false;
		 }
		if ((t_answer5c.getText()!= null && !t_answer5c.getText().isEmpty())) {
			answer5c = t_answer5c.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nAnswer 5c is empty!");
			 check = false;
		 }
		}

		if (check == true) {
			Survey sur = new Survey();
	        SurveyDB surveyDB = new SurveyDB();
	        
	        sur.setTitle(title);
	        sur.setTrainingsID(trainingID);
	        sur.setDescription(desc);
	        sur.setArchive(0);
	        sur.setAantalIngevuld(0);     
	        Question q1 = new Question();
	        q1.setSurvey(sur);
	        q1.setQuestion(question1);       
	        Answer a1a = new Answer();
	        a1a.setAantal(0);
	        a1a.setAnswer(answer1a);
	        a1a.setQuestion(q1);    
	        Answer a1b = new Answer();
	        a1b.setAantal(0);
	        a1b.setAnswer(answer1b);
	        a1b.setQuestion(q1);
	        Answer a1c = new Answer();
	        a1c.setAantal(0);
	        a1c.setAnswer(answer1c);
	        a1c.setQuestion(q1);   
	        q1.getAntwoorden().add(a1a);
	        q1.getAntwoorden().add(a1b); 
	        q1.getAntwoorden().add(a1c);  
	        Question q2 = new Question();
	        q2.setSurvey(sur);
	        q2.setQuestion(question2);       
	        Answer a2a = new Answer();
	        a2a.setAantal(0);
	        a2a.setAnswer(answer2a);
	        a2a.setQuestion(q2);      
	        Answer a2b = new Answer();
	        a2b.setAantal(0);
	        a2b.setAnswer(answer2b);
	        a2b.setQuestion(q2);  
	        Answer a2c = new Answer();
	        a2c.setAantal(0);
	        a2c.setAnswer(answer2c);
	        a2c.setQuestion(q2);  
	        q2.getAntwoorden().add(a2a);
	        q2.getAntwoorden().add(a2b);  
	        q2.getAntwoorden().add(a2c); 
	        
	        
	        if ((t_question3.getText()!= null && !t_question3.getText().isEmpty())) {
	        Question q3 = new Question();
	        q3.setSurvey(sur);
	        q3.setQuestion(question3);       
	        Answer a3a = new Answer();
	        a3a.setAantal(0);
	        a3a.setAnswer(answer3a);
	        a3a.setQuestion(q3);      
	        Answer a3b = new Answer();
	        a3b.setAantal(0);
	        a3b.setAnswer(answer3b);
	        a3b.setQuestion(q3);  
	        Answer a3c = new Answer();
	        a3c.setAantal(0);
	        a3c.setAnswer(answer3c);
	        a3c.setQuestion(q3);  
	        q3.getAntwoorden().add(a3a);
	        q3.getAntwoorden().add(a3b);  
	        q3.getAntwoorden().add(a3c); 
	        sur.getMyListSurveysQuestions().add(q3);
	        }
	        
	        if ((t_question4.getText()!= null && !t_question4.getText().isEmpty())) {
	        Question q4 = new Question();
	        q4.setSurvey(sur);
	        q4.setQuestion(question4);       
	        Answer a4a = new Answer();
	        a4a.setAantal(0);
	        a4a.setAnswer(answer4a);
	        a4a.setQuestion(q4);      
	        Answer a4b = new Answer();
	        a4b.setAantal(0);
	        a4b.setAnswer(answer4b);
	        a4b.setQuestion(q4);  
	        Answer a4c = new Answer();
	        a4c.setAantal(0);
	        a4c.setAnswer(answer4c);
	        a4c.setQuestion(q4);  
	        q4.getAntwoorden().add(a4a);
	        q4.getAntwoorden().add(a4b);  
	        q4.getAntwoorden().add(a4c);
	        sur.getMyListSurveysQuestions().add(q4);
	        }
	        
	        if ((t_question5.getText()!= null && !t_question5.getText().isEmpty())) {
	        Question q5 = new Question();
	        q5.setSurvey(sur);
	        q5.setQuestion(question5);       
	        Answer a5a = new Answer();
	        a5a.setAantal(0);
	        a5a.setAnswer(answer5a);
	        a5a.setQuestion(q5);      
	        Answer a5b = new Answer();
	        a5b.setAantal(0);
	        a5b.setAnswer(answer5b);
	        a5b.setQuestion(q5);  
	        Answer a5c = new Answer();
	        a5c.setAantal(0);
	        a5c.setAnswer(answer5c);
	        a5c.setQuestion(q5);  
	        q5.getAntwoorden().add(a5a);
	        q5.getAntwoorden().add(a5b);  
	        q5.getAntwoorden().add(a5c);
	        sur.getMyListSurveysQuestions().add(q5);
	        }
	        
	        sur.getMyListSurveysQuestions().add(q1);
	        sur.getMyListSurveysQuestions().add(q2);
	        
	        
	        
	        surveyDB.addSurvey(sur);
	        
	        errorMsg.setText("Survey is saved!");
	        
	        t_trainingID.clear();
	        t_title.clear();
	        description.clear();
	        t_question1.clear();
	        t_question2.clear();
	        t_question3.clear();
	        t_question4.clear();
	        t_question5.clear();
	        t_answer1a.clear();
	        t_answer1b.clear();
	        t_answer1c.clear();
	        t_answer2a.clear();
	        t_answer2b.clear();
	        t_answer2c.clear();
	        t_answer3a.clear();
	        t_answer3b.clear();
	        t_answer3c.clear();
	        t_answer4a.clear();
	        t_answer4b.clear();
	        t_answer4c.clear();
	        t_answer5a.clear();
	        t_answer5b.clear();
	        t_answer5c.clear();
		}

	}

	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}

}