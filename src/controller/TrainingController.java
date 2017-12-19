package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.Navigator;

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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import logic.Session;
import logic.Training;
import db.SessionDB;
import db.TrainingDB;

public class TrainingController implements Initializable {

	@FXML private Button allBtn;
	@FXML private Button addBtn;

	@FXML private TextField searchBar;

	@FXML private TableView<Training> allTrainingTable;
	@FXML private TableColumn <Training, Integer> idTableCol;
	@FXML private TableColumn <Training, String> titleTableCol;
	@FXML private TableColumn <Training, String> subjectTableCol;
	@FXML private TableColumn <Training, String> langTableCol;
	@FXML private TableColumn <Training, String> teacherTableCol;
	@FXML private TableColumn <Training, Integer> idSessionTableCol;
	@FXML private TableColumn <Training, String> idTrainingTableCol;
	@FXML private TableColumn <Training, String> titleTrainingTableCol;
	@FXML private TableColumn <Training, String> dateTableCol;



	public static Training trainingRow;


	@FXML
	protected void toAll(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML
	protected void zoekFunct(ActionEvent e) {

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
			SortedList<Training> training = new SortedList<>(filteredTraining);
			training.comparatorProperty().bind(allTrainingTable.comparatorProperty());								
			allTrainingTable.setItems(training);
		}


		FilteredList<Training> filteredData = new FilteredList<>(FXCollections.observableArrayList(tdb.getActiveTrainings()), p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Training -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name field in your object with filter.
				String lowerCaseFilter = newValue.toLowerCase();

				if (String.valueOf(Training.getTitle()).toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches first name.

				} else if (String.valueOf(Training.getSubject()).toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else		
					if (String.valueOf(Training.getLanguage()).toLowerCase().contains(lowerCaseFilter)) {
						return true; // Filter matches last name.
					} else		
						if (String.valueOf(Training.getResponsible()).toLowerCase().contains(lowerCaseFilter)) {
							return true; // Filter matches last name.
						} else		
							if (String.valueOf(Training.getTrainingID()).toLowerCase().contains(lowerCaseFilter)) {
								return true; // Filter matches last name.
							} 

				return false; // Does not match.
			});
		});

		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Training> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(allTrainingTable.comparatorProperty());
		// 5. Add sorted (and filtered) data to the table.
		allTrainingTable.setItems(sortedData);

		
		allTrainingTable.setRowFactory( trainingClick -> {
		    TableRow<Training> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            trainingRow = row.getItem();
		            
		            Navigator.loadVista(Navigator.TrainingDetailsView);
		    		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
		        }
		    });
		    return row ;
		});
	}

}

























