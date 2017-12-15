package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;

import application.Navigator;
import db.SurveyDB;
import db.SurveyPredefinedDB;
import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import logic.Answer;
import logic.Question;
import logic.Survey;
import logic.SurveyPredefined;
import logic.Training;

public class SurveyController implements Initializable {

	@FXML private TreeTableView<logic.SurveyPredefined> list;
	
	@FXML private Button newsurvey;
	@FXML private Button b_checkResults;
	@FXML private static TextField t_checkresults;
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
	
	
	public static String getCheckResultsID()
	{
		String checkr = t_checkresults.getText();
		return checkr;
	}
	
	@FXML //functie voor button "new survey"
	protected void toNewSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewNewSurvey);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML //functie voor button "new pr survey"
	protected void toNewPrSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewNewPrSurvey);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	@FXML //functie voor button "new pr survey"
	protected void toCheckResults(ActionEvent e) {
		getCheckResultsID();
		Navigator.loadVista(Navigator.SurveyViewCheckResults);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML //functie voor button "new pr survey"
	protected void toAddPrToTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewAddPrtoTraining);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}

	@Override
	public void initialize (URL arg0, ResourceBundle arg1) {
		
		//opvullen tabel voor search survey (toont alle surveys)
		SurveyDB sdb = new SurveyDB();
		if (sdb.getAllSurveys() != null) {
			ObservableList<Survey> surveys = FXCollections.observableArrayList(sdb.getAllSurveys());
		surveyIDCol.setCellValueFactory(new PropertyValueFactory<Survey, Integer>("surveyID"));
		trainingIDCol.setCellValueFactory(new PropertyValueFactory<Survey, Integer>("trainingsID"));
		titleCol.setCellValueFactory(new PropertyValueFactory<Survey, String>("title"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Survey, String>("description"));
		FilteredList<Survey> filteredSurvey = new FilteredList<>(surveys, p -> true);

		SortedList<Survey> sortedSurvey = new SortedList<>(filteredSurvey);		
		sortedSurvey.comparatorProperty().bind(allSurveyTable.comparatorProperty());										
		allSurveyTable.setItems(sortedSurvey);
		}

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

		
	}
	
}



//JFXTreeTableColumn<logic.SurveyPredefined,String> surveyPrID = new JFXTreeTableColumn("surveyID");
//surveyPrID.setPrefWidth(100);
//
//surveyPrID.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined, String>, ObservableValue<String>>() {
//      
//	@Override
//   public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.SurveyPredefined, String> param) {
//		SimpleStringProperty simple = new SimpleStringProperty();
//		simple.setValue(new Integer(param.getValue().getValue().getSurveyPrID()).toString());
//		return simple;
//   }
//});
//
//JFXTreeTableColumn<logic.SurveyPredefined,String> title = new JFXTreeTableColumn("Title");
//title.setPrefWidth(150);
//
//title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined,String>, ObservableValue<String>>() {
//
//
//@Override
//public ObservableValue<String> call(CellDataFeatures<logic.SurveyPredefined, String> param) {
//	SimpleStringProperty simple = new SimpleStringProperty();
//	simple.setValue(param.getValue().getValue().getTitle());
//	return simple;
//}
//});
//
//JFXTreeTableColumn<logic.SurveyPredefined,String> description = new JFXTreeTableColumn("Description");
//title.setPrefWidth(400);
//
//description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined,String>, ObservableValue<String>>() {
//
//
//@Override
//public ObservableValue<String> call(CellDataFeatures<logic.SurveyPredefined, String> param) {
//	SimpleStringProperty simple = new SimpleStringProperty();
//	simple.setValue(param.getValue().getValue().getDescription());
//	return simple;
//}
//});
//
//ObservableList<logic.SurveyPredefined> surveyPrList = FXCollections.observableArrayList();
//ArrayList<logic.SurveyPredefined> surveyPr = null;
//SurveyPredefinedDB db = new SurveyPredefinedDB();
//surveyPr = db.getAllSurveys();
//
//for (SurveyPredefined sp: surveyPr)
//{
//	surveyPrList.add(sp);
//}
//final TreeItem<SurveyPredefined> root = new TreeItem<SurveyPredefined>();
//for (SurveyPredefined sp: surveyPrList)
//{
//	TreeItem<SurveyPredefined> item = new TreeItem<>(sp);
//	root.getChildren().add(item);
//}
//list.getColumns().setAll(surveyPrID, title, description);
//list.setRoot(root);
//list.setShowRoot(false);
