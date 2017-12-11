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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import logic.Training;
import logic.Training.Language;

public class addTrainingController  implements Initializable {

	@FXML private Button add;
	@FXML private Button back;

	@FXML private TextField addTitle;
	@FXML private TextField addSubject;
	@FXML private TextField addSeq;
	@FXML private TextField addTeacher;
	
	@FXML private ChoiceBox<String> addLanguage;
	
	@FXML private Label errorMsg;
	
	@FXML protected void toAllTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	/*@FXML protected void checkTitle(ActionEvent e) {
		errorAdd.setVisible(true);
		errorAdd.setText("Title is empty!");
		if ((addTitle.getText() != null || !addTitle.getText().isEmpty())) {
            errorAdd.setText("Title is empty!");
	 	}
	 }*/
	
	
	// oplossen dat check uitgevoerd wordt
	// training kan nog niet gesaved worden
	@FXML protected void saveTraining(ActionEvent e) {
		errorMsg.setText("");
		TrainingDB tdb = new TrainingDB();
		String title = null,subject= null,teacher=null,seq=null;
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
			 seq = addSeq.getText();
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

		 if (check == true ) {Training t = new Training (title, subject, Language.valueOf(addLanguage.getValue()) , teacher, 1, 0);
		 tdb.insertTraining(t);
		 Navigator.loadVista(Navigator.TrainingView);
		 Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
		 }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		addLanguage.setItems(FXCollections.observableArrayList("Chinese","English", "Spanish", "Arabic", "Russian", "Portuguese" , "French","Japanese","German","Italien", "Dutch"));
		addLanguage.setValue("English");
		}
	}

