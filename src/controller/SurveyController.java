package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;

import application.Navigator;
import db.SurveyDB;
import db.SurveyPredefinedDB;
import db.TestJackson;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;
import logic.Answer;
import logic.Question;
import logic.Survey;
import logic.SurveyPredefined;

public class SurveyController implements Initializable {
	
	//Survey s = null;
	//Alert alert = null;
	//SurveyDB db = new SurveyDB();

	@FXML
	private TreeTableView<logic.SurveyPredefined> list;
	
	@FXML
	private Button newsurvey;
	

	
	@FXML //functie voor button "new survey"
	protected void toNewSurvey(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyViewNewSurvey);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	

//	@FXML //functie voor button "save survey"
//	protected void toSaveSurvey(ActionEvent e) {
//		db.addSurvey(s);
//	}
	
	@Override
	public void initialize (URL arg0, ResourceBundle arg1) {
		
		JFXTreeTableColumn<logic.SurveyPredefined,String> surveyPrID = new JFXTreeTableColumn("surveyID");
		surveyPrID.setPrefWidth(100);
		
		surveyPrID.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.SurveyPredefined, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(new Integer(param.getValue().getValue().getSurveyPrID()).toString());
				return simple;
           }
       });
	
		JFXTreeTableColumn<logic.SurveyPredefined,String> title = new JFXTreeTableColumn("Title");
		title.setPrefWidth(150);
		
		title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined,String>, ObservableValue<String>>() {
        
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<logic.SurveyPredefined, String> param) {
			SimpleStringProperty simple = new SimpleStringProperty();
			simple.setValue(param.getValue().getValue().getTitle());
			return simple;
		}
		});
		
		JFXTreeTableColumn<logic.SurveyPredefined,String> description = new JFXTreeTableColumn("Description");
		title.setPrefWidth(400);
		
		description.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.SurveyPredefined,String>, ObservableValue<String>>() {
        
		
		@Override
		public ObservableValue<String> call(CellDataFeatures<logic.SurveyPredefined, String> param) {
			SimpleStringProperty simple = new SimpleStringProperty();
			simple.setValue(param.getValue().getValue().getDescription());
			return simple;
		}
		});
		
		ObservableList<logic.SurveyPredefined> surveyPrList = FXCollections.observableArrayList();
		ArrayList<logic.SurveyPredefined> surveyPr = null;
		SurveyPredefinedDB db = new SurveyPredefinedDB();
		surveyPr = db.getAllSurveys();
		
		for (SurveyPredefined sp: surveyPr)
		{
			surveyPrList.add(sp);
		}
		final TreeItem<SurveyPredefined> root = new TreeItem<SurveyPredefined>();
		for (SurveyPredefined sp: surveyPrList)
		{
			TreeItem<SurveyPredefined> item = new TreeItem<>(sp);
			root.getChildren().add(item);
		}
		list.getColumns().setAll(surveyPrID, title, description);
		list.setRoot(root);
		list.setShowRoot(false);
		
		
//		int trainingID = Integer.parseInt(t_trainingID.getText());
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
