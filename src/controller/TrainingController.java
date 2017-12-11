package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.Navigator;
import controller.EmployeeController.Employee;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import logic.Training;
import db.TrainingDB;

public class TrainingController implements Initializable {

	@FXML private Button allBtn;
	@FXML private Button passedBtn;
	@FXML private Button futureBtn;
	@FXML private Button nowBtn;
	@FXML private Button addBtn;

	@FXML private TextField searchBar;
	
	@FXML private TableView<Training> allTrainingTable;
	@FXML private TableView<Training> passedTrainingTable;
	@FXML private TableView<Training> futureTrainingTable;
	@FXML private TableView<Training> nowTrainingTable;
	@FXML private TableColumn <Training, Integer> idTableCol;
	@FXML private TableColumn <Training, String> titleTableCol;
	@FXML private TableColumn <Training, String> subjectTableCol;
	@FXML private TableColumn <Training, String> langTableCol;
	@FXML private TableColumn <Training, String> teacherTableCol;
	

	
	public static Training training;
	
	@FXML
	protected void toAll(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML
	protected void toPassed(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML
	protected void toFuture(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML
	protected void toNow(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML
	protected void addTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.AddTrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		TrainingDB tdb = new TrainingDB();
		if (tdb.getActiveTrainings() != null) {
			ObservableList<Training> trainings = FXCollections.observableArrayList(tdb.getActiveTrainings());
		
		
		idTableCol.setCellValueFactory(new PropertyValueFactory<Training, Integer>("trainingID"));
		titleTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("title"));
		subjectTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("subject"));
		langTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("language"));
		teacherTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("responsible"));
		FilteredList<Training> filteredTraining = new FilteredList<>(trainings, p -> true);
//		
//				searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
//					filteredTraining.setPredicate(training -> {
//						
//						// If filter text is empty, display all persons.
//						if (newValue == null || newValue.isEmpty()) {
//							return true;
//						}
//								
//						if (training.getTrainingID() != -1) {
//							return true; // Filter matches start time.
//						} 
//						
//						return false; // Does not match.
//					});
//				});
							SortedList<Training> sortedTraining = new SortedList<>(filteredTraining);
		
							sortedTraining.comparatorProperty().bind(allTrainingTable.comparatorProperty());
											
							allTrainingTable.setItems(sortedTraining);
			}

		
	}

}

























