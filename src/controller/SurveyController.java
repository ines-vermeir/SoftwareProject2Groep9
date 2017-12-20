package controller;

import java.net.URL;
import java.util.ResourceBundle;
import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import logic.Survey;
import logic.SurveyPredefined;

public class SurveyController implements Initializable {

	@FXML private TreeTableView<logic.SurveyPredefined> list;
	
	@FXML private Button newsurvey;
	@FXML private Button b_checkResults;
	
	@FXML private Button b_newpresurvey;
	@FXML private Button b_addprtotraining;
	
	@FXML private TableView<Survey> allSurveyTable;
	@FXML private TableColumn <Survey, Integer> surveyIDCol;
	@FXML private TableColumn <Survey, Integer> trainingIDCol;
	@FXML private TableColumn <Survey, String> titleCol;
	@FXML private TableColumn <Survey, String> descriptionCol;
	
	@FXML private TableView<SurveyPredefined> allPredefinedSurveyTable;
	@FXML private TableColumn <SurveyPredefined, Integer> prsurveyIDCol;
	@FXML private TableColumn <SurveyPredefined, String> prtitleCol;
	@FXML private TableColumn <SurveyPredefined, String> prdescriptionCol;
	
	public static Survey survey;
	
	@FXML private TextField t_checkresults;
	
	
	
	@FXML //functie voor button "new survey"
	protected void toNewSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewNewSurvey);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML //functie voor button "new predefined survey"
	protected void toNewPrSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewNewPrSurvey);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	@FXML //functie voor button "check results"
	protected void toCheckResults(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewCheckResults);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML //functie voor button "add a predefined survey to a training"
	protected void toAddPrToTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewAddPrtoTraining);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}

	@Override
	public void initialize (URL arg0, ResourceBundle arg1) {
			
	}
	
}



