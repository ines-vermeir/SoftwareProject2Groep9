package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Navigator;
import db.SurveyDB;
import db.SurveyPredefinedDB;
import db.TrainingDB;
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
import logic.AnswerPredefined;
import logic.Question;
import logic.QuestionPredefined;
import logic.Survey;
import logic.SurveyPredefined;
import logic.Training;

public class SurveyAddPrSurveyToTraining implements Initializable {

	@FXML private TableView<SurveyPredefined> allPredefinedSurveyTable;
	@FXML private TableColumn <SurveyPredefined, Integer> prsurveyIDCol;
	@FXML private TableColumn <SurveyPredefined, String> prtitleCol;
	@FXML private TableColumn <SurveyPredefined, String> prdescriptionCol;
	
	@FXML private TableView<Training> allTrainingTable;
	@FXML private TableColumn <Training, Integer> idTableCol;
	@FXML private TableColumn <Training, String> titleTableCol;
	@FXML private TableColumn <Training, String> subjectTableCol;
	@FXML private TableColumn <Training, String> langTableCol;
	@FXML private TableColumn <Training, String> teacherTableCol;
	
	@FXML private Button back;
	
	@FXML private TextField t_surveyID;
	@FXML private TextField t_trainingID;
	@FXML private Button add;
	
	@FXML private Label errorMsg;
	
	@FXML
	protected void addToTraining(ActionEvent e)
	{
		SurveyPredefinedDB db = new SurveyPredefinedDB();
		ArrayList<SurveyPredefined> allPreSurveys = db.getAllSurveys();
		TrainingDB dbt = new TrainingDB();
		ArrayList<Training> allTraining = dbt.getAllTrainings();
		String tid;
		int trainingID = -1, surveyID = -1;
		boolean check = true, check2 = false;
		errorMsg.setText("");
		//checken of trainingID ingevuld is en een nummer is
		if ((t_trainingID.getText()!= null && !t_trainingID.getText().isEmpty())) {
			tid = t_trainingID.getText();
			try {
				 trainingID = Integer.parseInt(tid);
				 for (Training t: allTraining) {
					 if (t.getTrainingID() == trainingID)
					 {
						 check2 = true;
					 }
				 }
				 if (check2 == false)
				 {
					 errorMsg.setText(errorMsg.getText() + "\nThis Training ID does not exist!");
					 check = false;
				 }
			 }catch( NumberFormatException numberex) {
				 errorMsg.setText(errorMsg.getText() + "\nTraining ID is not a number!");
				 check = false;
			 }
		}  else {
		 errorMsg.setText(errorMsg.getText() + "\nTraining ID is empty!");
		 check = false;
		}
		//checken of surveyID ingevuld is en een nummer is
		if ((t_surveyID.getText()!= null && !t_surveyID.getText().isEmpty())) {
			tid = t_surveyID.getText();
			try {
				 surveyID = Integer.parseInt(tid);
				 for (SurveyPredefined sp: allPreSurveys) {
					 if (sp.getSurveyPrID() == surveyID)
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
		}  else {
		 errorMsg.setText(errorMsg.getText() + "\nSurvey ID is empty!");
		 check = false;
		}
		
		if (check == true)
		{
			Question q;
			Answer a;
			Survey s = new Survey();
			SurveyPredefined sp = db.getSurvey(surveyID);
			if ( sp != null)
			{
				s.setTitle(sp.getTitle());
		        s.setTrainingsID(trainingID);
		        s.setDescription(sp.getDescription());
		        s.setArchive(0);
		        s.setAantalIngevuld(0);
		        for (QuestionPredefined qu: sp.getMyListSurveysQuestions())
		        {
		        	q = new Question();
		        	q.setSurvey(s);
		        	q.setQuestion(qu.getQuestion());
		        	for (AnswerPredefined ap: qu.getAntwoorden())
		        	{
		        		a = new Answer();
		        		a.setAantal(0);
		        		a.setAnswer(ap.getAnswer());
		        		a.setQuestion(q);
		        		q.getAntwoorden().add(a);
		        	}
		        	s.getMyListSurveysQuestions().add(q);
		        }
			}
			SurveyDB surveydb = new SurveyDB();
			try {
			surveydb.addSurvey(s);
			 errorMsg.setText(errorMsg.getText() + "\nSurvey has been saved!");
			} catch (Exception exc)
			{
				errorMsg.setText(errorMsg.getText() + "\nOops, something went wrong!");
			}
		}
		
	}
	
	
	@FXML //functie voor button "new survey"
	protected void backToSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyView);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//opvullen predefined surveys tabel (toont alle predefined surveys)
				SurveyPredefinedDB prdb = new SurveyPredefinedDB();
				if (prdb.getAllSurveys() != null) {
					ObservableList<SurveyPredefined> prsurveys = FXCollections.observableArrayList(prdb.getAllSurveys());
				prsurveyIDCol.setCellValueFactory(new PropertyValueFactory<SurveyPredefined, Integer>("surveyPrID"));
				prtitleCol.setCellValueFactory(new PropertyValueFactory<SurveyPredefined, String>("title"));
				prdescriptionCol.setCellValueFactory(new PropertyValueFactory<SurveyPredefined, String>("description"));
				FilteredList<SurveyPredefined> filteredprSurvey = new FilteredList<>(prsurveys, p -> true);

				SortedList<SurveyPredefined> sortedprSurvey = new SortedList<>(filteredprSurvey);		
				sortedprSurvey.comparatorProperty().bind(allPredefinedSurveyTable.comparatorProperty());										
				allPredefinedSurveyTable.setItems(sortedprSurvey);
				}
				
				TrainingDB tdb = new TrainingDB();
				if (tdb.getActiveTrainings() != null) {
					ObservableList<Training> trainings = FXCollections.observableArrayList(tdb.getActiveTrainings());
				idTableCol.setCellValueFactory(new PropertyValueFactory<Training, Integer>("trainingID"));
				titleTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("title"));
				subjectTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("subject"));
				langTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("language"));
				teacherTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("responsible"));
				FilteredList<Training> filteredTraining = new FilteredList<>(trainings, p -> true);
				
				SortedList<Training> sortedTraining = new SortedList<>(filteredTraining);				
				sortedTraining.comparatorProperty().bind(allTrainingTable.comparatorProperty());							
				allTrainingTable.setItems(sortedTraining);
		
	}
	}

}