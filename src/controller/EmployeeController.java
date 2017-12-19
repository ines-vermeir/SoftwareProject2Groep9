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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;
import logic.Application;
import logic.Employee;
import logic.Training;

public class EmployeeController implements Initializable{
	
	@FXML
	private TreeTableView<logic.Employee> table;
	
	@FXML
	private JFXTextField input;
	
	
	@FXML
	private ComboBox trainingBox;
	
     @FXML
    private Button okB; 
   
     @FXML
     private Label feedback;
     
     @FXML
     private Label trainingLabel;
      
     private Employee chosenEmp=null; 
     
     private String message = "";  
   
     private TrainingDB db = new TrainingDB();
     private int chosenTraining=0;
     
     
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		ArrayList<logic.Employee> EmployeeOdata = null;
		try {
			EmployeeOdata = (ArrayList<logic.Employee>) TestJackson.getEmployees();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		JFXTreeTableColumn<logic.Employee,String> id = new JFXTreeTableColumn("EmployeeID");
		id.setPrefWidth(150);
	
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
       
		
		//handle selected Employee
		
		
		table.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				chosenEmp = table.getSelectionModel().getSelectedItem().getValue();
				

				//First= check if employee has done an application or not
			   
				
				
				for(Application a: db.getApplications()) {
					if((chosenEmp.getEmployeeID() == a.getUser_id())) {
						
						chosenTraining= a.getTraining_id();
						trainingLabel.setText("This employee wishes to follow training with ID=" + a.getTraining_id());
						
					}else {
						trainingLabel.setText("This employee has not made an application yet");
						chosenEmp=null;
						chosenTraining=0;
					}
				}
				
			}
			  
			  
			  
		  });
		 
		
		
		
		
		
		
		
		
		//Populate combobox and handle selection
		
		
		
			  ObservableList<Training> trainingList = FXCollections.observableArrayList();
			  
			  
			  TrainingDB db = new TrainingDB(); 
			  
			  
			  for(Training training : db.getAllTrainings()) {
					
					trainingList.add(training);
				}
			  
		  
			  trainingBox.setItems(trainingList);
			  
			  
	    //Handle button to link employee to training 
			//Link button okB
				 
				
			  okB.setOnAction(new EventHandler<ActionEvent>() {
				
				 
				@Override
				public void handle(ActionEvent arg0) {
					message="";
					
					boolean valid= true;
					
					feedback.setText("");
			
					if( trainingBox==null || trainingBox.getValue()==null || trainingBox.getSelectionModel().isEmpty() ||trainingBox.getSelectionModel().getSelectedItem()==null  ) {
						message+="Please choose the training the employee wishes to follow\n";
						valid = false;
						
					}
					
					if(chosenEmp==null) {
						
						message+="Please select the employee that wishes to follow a training\n";
						valid = false;
						}
					
			
						//First= check if employee has done an application to follow a training and he/she is allowed to follow that training
					   
						
						Training chosenTraining = (Training)trainingBox.getValue();
						for(Application a: db.getApplications()) {
							if((chosenEmp.getEmployeeID() == a.getUser_id() && a.getStatus().equals("allow") && a.getTraining_id() == chosenTraining.getTrainingID() )) {
								message+="The employee is not allowed to follow this training\n";
								valid=false;
							}else {
								
							}
						}
						
						
						if(valid==true) {
							
						
						//Second= Find the trainingid of the 
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						//Clear and showing confirmation
						message+="The selected employee has successfully been added\nto the chosen training";
						table.getSelectionModel().clearSelection();
						trainingBox.getSelectionModel().clearSelection();
						
						
						chosenEmp=null;
						trainingBox.setValue(null);
						
						
					}

					
					feedback.setText(message);
					//table.getSelectionModel().clearSelection();
					//chosenEmp=null;
					//trainingBox.getSelectionModel().clearSelection();
					
				}
				
				  
				  
				  
				  
				  
				  
			  });
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
	
	}

}