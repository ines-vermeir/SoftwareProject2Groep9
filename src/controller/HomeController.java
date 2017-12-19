package controller;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import db.SessionDB;
import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;
import logic.BookGoogleAPI;
import logic.Employee;
import logic.Session;
import logic.Training;

public class HomeController implements Initializable {

	@FXML private TreeTableView<logic.Employee> table;	
	@FXML private JFXTextField input;
	
	@FXML private Button b_trainings;	
	@FXML private Button b_certificates;
	@FXML private Label l_certificate;
	@FXML private Label l_training;
	@FXML private Label errorMsg;
	
	private TreeItem<logic.Employee> chosenEmployee=null;
	private int empID = 0;
	
	@FXML
	protected void showTrainings()
	{
		l_training.setText("");
		SessionDB db = new SessionDB();
		ArrayList<Integer> trainingIDs = new ArrayList<Integer>();
		ArrayList<Training> allTrainings = new ArrayList<Training>();
		int trainingID;
		TrainingDB dbt = new TrainingDB();
		ArrayList<Session> allSessions = db.getAllSessions();
		boolean check = true;
		for (Session s: allSessions)	{
			trainingID = s.getTrainingID();
			for (int i : s.getStudentsEnrolled()) {
				if (i == empID)	{
					for (int j : trainingIDs) {
						if (j == trainingID) {
							check = false;
						}
					}if (check == true)	{
						trainingIDs.add(trainingID);
					}					
				}
			}
		}
		for (int k : trainingIDs){
			allTrainings.add(dbt.getTraining(k));
		}
		for (Training t: allTrainings) {
			l_training.setText(l_training.getText() + "\nID: " + t.getTrainingID() + " - title: " + t.getTitle());
		}		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ArrayList<logic.Employee> EmployeeOdata = null;
		try {
			EmployeeOdata = (ArrayList<logic.Employee>) TestJackson.getEmployees();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		JFXTreeTableColumn<logic.Employee,String> id = new JFXTreeTableColumn("EmployeeID");
		id.setPrefWidth(100);
	
		id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(new Integer(param.getValue().getValue().getEmployeeID()).toString());
				return simple;
           }
       });
		JFXTreeTableColumn<logic.Employee,String> fName = new JFXTreeTableColumn("First Name");
		fName.setPrefWidth(100);
	
		fName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty name = new SimpleStringProperty();
				name.setValue(param.getValue().getValue().getFirstName());
				return name;
           }
       });
		JFXTreeTableColumn<logic.Employee,String> lName = new JFXTreeTableColumn("Last Name");
		lName.setPrefWidth(100);
	
		lName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty name = new SimpleStringProperty();
				name.setValue(param.getValue().getValue().getLastName());
				return name;
           }
       });
		JFXTreeTableColumn<logic.Employee,String> title = new JFXTreeTableColumn("Title");
		title.setPrefWidth(220);
	
		title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getTitle());
				return simple;
           }
       });
		JFXTreeTableColumn<logic.Employee,String> birthday = new JFXTreeTableColumn("Day of Birth");
		birthday.setPrefWidth(100);
	
		birthday.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty birthday = new SimpleStringProperty();
				birthday.setValue(param.getValue().getValue().getBirthDate().substring(0, 10));
				return birthday;
             
           }
       });
		
		JFXTreeTableColumn<logic.Employee,String> address = new JFXTreeTableColumn("Address");
		address.setPrefWidth(260);
	
		address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty address = new SimpleStringProperty();
				address.setValue(param.getValue().getValue().getAddress());
				return address;
              
           }
       });
		JFXTreeTableColumn<logic.Employee,String> city = new JFXTreeTableColumn("City");
		city.setPrefWidth(100);
	
		city.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<logic.Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<logic.Employee, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getCity());
				return simple;
           }
       });
		
		ObservableList<logic.Employee> Employees = FXCollections.observableArrayList();
	
		for(logic.Employee emp : EmployeeOdata) {
			
			Employees.add(emp);
		}
		
		final TreeItem<logic.Employee> root = new TreeItem<logic.Employee>();
		
		for(Employee  e:  Employees) {
			TreeItem<Employee> item = new TreeItem<>(e);
			root.getChildren().add(item);
			
		}
		table.getColumns().setAll(id, fName,lName,city,title, birthday,address);
		table.setRoot(root);
		table.setShowRoot(false);

			
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle (MouseEvent arg0) {
				chosenEmployee = table.getSelectionModel().getSelectedItem();
				Employee e = (Employee) chosenEmployee.getValue();
				empID = e.getEmployeeID();
			}
		});

		
	
	}

}
