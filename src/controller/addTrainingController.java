package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Navigator;
import db.TrainingDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import logic.Training;
import logic.Training.Language;

public class addTrainingController  implements Initializable {

	@FXML private Button save;
	@FXML private Button back;
	@FXML private Button addSession;

	@FXML private TextField addTitle;
	@FXML private TextField addSubject;
	@FXML private TextField addSeq;
	@FXML private TextField addTeacher;
	@FXML private TextField part;
	
	@FXML private DatePicker addDate;
	
	@FXML private ChoiceBox<String> addLanguage;
	@FXML private ChoiceBox<String> addStartHour;
	@FXML private ChoiceBox<String> addStartMin;
	@FXML private ChoiceBox<String> addEndHour;
	@FXML private ChoiceBox<String> addEndMin;
	
	@FXML private Label errorMsg;
	
	@FXML protected void toAllTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	@FXML protected void toAddTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.AddTrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	@FXML protected void toAddSession() {
		Navigator.loadVista(Navigator.AddSessionView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML protected void saveSession(ActionEvent e) {
	
	}
	
	@FXML protected void saveTraining(ActionEvent e) {
		errorMsg.setText("");
		TrainingDB tdb = new TrainingDB();
		String title = null,subject= null,teacher=null,ses=null;
		int sessions = 1;
		boolean check = true;

		 if ((addTitle.getText()!= null && !addTitle.getText().isEmpty())) {
			 title = addTitle.getText();
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nTitle is empty!");
			 check = false;
		 }
		 if ((addSubject.getText() != null && !addSubject.getText().isEmpty())) {
			 subject = addSubject.getText();
		 } else {
			 errorMsg.setText(errorMsg.getText() + "\nSubject is empty!");
			 check = false;
		 }
		 if ((addSeq.getText() != null && !addSeq.getText().isEmpty() )) {
			 ses = addSeq.getText();
			 try {
				 sessions = Integer.parseInt(ses);
			 }catch( NumberFormatException numberex) {
				 errorMsg.setText(errorMsg.getText() + "\nSession is not a number!");
				 check = false;
			 }
		 }  else {
			 errorMsg.setText(errorMsg.getText() + "\nSequentility is empty!");
			 check = false;
		 }
		 //check if seq number 
		 if ((addTeacher.getText() != null && !addTeacher.getText().isEmpty() )) {
			 teacher = addTeacher.getText();
		 }else {
			 errorMsg.setText(errorMsg.getText() + "\nTeacher is empty!");
			 check = false;
		 }

		 if (check == true ) {Training t = new Training (title, subject, Language.valueOf(addLanguage.getValue()) , teacher, sessions, 0);
		 tdb.insertTraining(t);
		 toAddSession();
		 Navigator.loadVista(Navigator.AddSessionView);
		 Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
		 }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		addLanguage.setItems(FXCollections.observableArrayList("Chinese","English", "Spanish", "Arabic", "Russian", "Portuguese" , "French","Japanese","German","Italien", "Dutch"));
		addLanguage.setValue("English");
		}
	}

