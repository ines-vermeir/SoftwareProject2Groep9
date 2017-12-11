package controller;

import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import application.Navigator;
import db.SessionDB;
import db.TrainingDB;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.Session;
import logic.Training;

public class PassedTrainingController implements Initializable {

	@FXML private Button allBtn;
	@FXML private Button passedBtn;
	@FXML private Button futureBtn;
	@FXML private Button nowBtn;
	@FXML private Button addBtn;

	@FXML private TextField searchBar;
	
	@FXML private TableView<Training> allTrainingTable;
	@FXML private TableView<Session> passedTrainingTable;
	@FXML private TableView<Training> futureTrainingTable;
	@FXML private TableView<Training> nowTrainingTable;
	@FXML private TableColumn <Session, Integer> idSessionTableCol;
	@FXML private TableColumn <Session, Integer> idTrainingTableCol;
	@FXML private TableColumn <Training, String> titleTrainingTableCol;
	@FXML private TableColumn <Session, Date> dateTableCol;
	
	@FXML
	protected void toAll(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	
	@FXML
	protected void toPassed(ActionEvent e) {
		Navigator.loadVista(Navigator.PassedTrainingView);
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
			SessionDB sdb = new SessionDB();
			if (tdb.getActiveTrainings() != null && sdb.getAllSessions() != null) {
				ObservableList<Session> sessions = FXCollections.observableArrayList(sdb.getAllSessions());
				
				idSessionTableCol.setCellValueFactory(new PropertyValueFactory<Session, Integer>("sessionID"));
				idTrainingTableCol.setCellValueFactory(new PropertyValueFactory<Session, Integer>("trainingID"));
				//titleTrainingTableCol.setCellValueFactory(new PropertyValueFactory<Training, String>("title"));
				dateTableCol.setCellValueFactory(new PropertyValueFactory<Session, Date>("date"));
				
				FilteredList<Session> session = new FilteredList<>(sessions, p -> true);
				SortedList<Session> sessionn = new SortedList<>(session);
				sessionn.comparatorProperty().bind(passedTrainingTable.comparatorProperty());								
				passedTrainingTable.setItems(sessionn);
			}
		}
}
