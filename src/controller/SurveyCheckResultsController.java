package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Navigator;
import db.ResultDB;
import db.SurveyDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.Answer;
import logic.Question;
import logic.Result;
import logic.Survey;

public class SurveyCheckResultsController implements Initializable {
	
	@FXML private TableView<Survey> allSurveyTable;
	@FXML private TableColumn <Survey, Integer> surveyIDCol1;
	@FXML private TableColumn <Survey, Integer> trainingIDCol1;
	@FXML private TableColumn <Survey, String> titleCol1;
	@FXML private TableColumn <Survey, String> descriptionCol1;
	@FXML private Button back;
	@FXML private Label errorMsg;
	@FXML private Label output;
	@FXML private TextField t_checkresults;
	@FXML private Button b_checkResults;
	
	@FXML //functie voor button "new survey"
	protected void backToSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyView);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	

	@FXML
	protected void checkResult (ActionEvent e)
	{
		errorMsg.setText("");
		output.setText("");
		String tid;
		int surveyID = -1;
		SurveyDB db = new SurveyDB();
		ArrayList<Survey> allSurveys = db.getAllSurveys();
		boolean check = true, check2 = false;
		
		if ((t_checkresults.getText()!= null && !t_checkresults.getText().isEmpty())) {
			tid = t_checkresults.getText();
			try {
				 surveyID = Integer.parseInt(tid);
				 for (Survey sp: allSurveys) {
					 if (sp.getSurveyID() == surveyID)
					 {
						 check2 = true;
					 }
				 }
				 if (check2 == false)
				 {
					 errorMsg.setText(errorMsg.getText() + "\nThis Survey ID does not exist!");
					 check = false;
				 }
			 }catch( NumberFormatException numberex) {
				 errorMsg.setText(errorMsg.getText() + "\nSurvey ID is not a number!");
				 check = false;
			 }
		}  else 
		{
		 errorMsg.setText(errorMsg.getText() + "\nSurvey ID is empty!");
		 check = false;
		}		
		if (check == true)
		{
			SurveyDB surveydb = new SurveyDB();
			ResultDB resultdb = new ResultDB();
			Question question = null;		
			List<Result> results = resultdb.getAllResultBySurveyId(surveyID);
//			Survey survey = surveydb.getSurvey(r.getSurvey_id());
//			int answer0 = 0, answer1 = 0, answer2 = 0;
			
//			for (Result r : results)
//			{					
//				for (Question qtest : survey.getMyListSurveysQuestions())
//				{
//					
//					if (qtest.getQuestionId() == r.getQuestion_id());
//					question = qtest;
//					if (question.getAntwoorden().get(0).getAnswer() == r.getAnswer())
//					{
//						answer0++;
//					}
//					if (question.getAntwoorden().get(1).getAnswer() == r.getAnswer())
//					{
//						answer1++;
//					}
//					if (question.getAntwoorden().get(2).getAnswer() == r.getAnswer())
//					{
//						answer2++;
//					}
//					output.setText("\nquestion: " + question.getQuestion());
//					output.setText("\nAnswer: " + question.getAntwoorden().get(0).getAnswer() + " - " + answer0 + " times choosen");
//					output.setText("\nAnswer: " + question.getAntwoorden().get(1).getAnswer() + " - " + answer1 + " times choosen");
//					output.setText("\nAnswer: " + question.getAntwoorden().get(2).getAnswer() + " - " + answer2 + " times choosen");
//				}
//			}
			output.setText("Results for survey met id: " + surveyID);
			for (Result r : results)
			{		
				Survey survey = surveydb.getSurvey(r.getSurvey_id());
						
				for (Question qtest : survey.getMyListSurveysQuestions())
				{
					if (qtest.getQuestionId() == r.getQuestion_id());
					question = qtest;
				}
				output.setText(output.getText() + "\nquestion: " + question.getQuestion());
				output.setText(output.getText() + " - answer: " + r.getAnswer());
			}
		}	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
				SurveyDB sdb2 = new SurveyDB();
				List<Survey> surveys2 = sdb2.getAllSurveys(); 
				if (surveys2 != null) {
					ObservableList<Survey> surveys = FXCollections.observableArrayList(surveys2);
				surveyIDCol1.setCellValueFactory(new PropertyValueFactory<Survey, Integer>("surveyID"));
				trainingIDCol1.setCellValueFactory(new PropertyValueFactory<Survey, Integer>("trainingsID"));
				titleCol1.setCellValueFactory(new PropertyValueFactory<Survey, String>("title"));
				descriptionCol1.setCellValueFactory(new PropertyValueFactory<Survey, String>("description"));
				FilteredList<Survey> filteredSurvey = new FilteredList<>(surveys, p -> true);

				SortedList<Survey> sortedSurvey = new SortedList<>(filteredSurvey);		
				sortedSurvey.comparatorProperty().bind(allSurveyTable.comparatorProperty());										
				allSurveyTable.setItems(sortedSurvey);
				}
				
				for (Survey s: surveys2)
				{
					System.out.println(s.getSurveyID());
				}
	}

}