package controller;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

import db.SessionDB;
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
import logic.Session;
import logic.Students_enrolled_in_session;
import logic.Training;

public class EmployeeController implements Initializable{
	
	@FXML
	private TreeTableView<logic.Employee> table;
	
	@FXML
	private JFXTextField input;
	
	
	@FXML
	private Label authoText;
	
     @FXML
    private Button okB; 
   
     @FXML
     private Label feedback;
     
     @FXML
     private Label trainingText;
      
     private Employee chosenEmp=null; 
     
     private String message = "";  
   
     private TrainingDB db = new TrainingDB();
     //chosen training by employee on applications
     private int chosenTraining;
    
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
				
				ArrayList<Application> listAppl = (ArrayList<Application>) db.getApplications();
				message="";
				feedback.setText(message);
				// TODO Auto-generated method stub
				int userid= 0;
				   String status="";
				
				

				//First= check if employee has done an application or not
			   boolean contains = false;
			   
				for(Application a: listAppl) {
					if(table.getSelectionModel().getSelectedItem()!=null) {
						if(a.getUser_id()==table.getSelectionModel().getSelectedItem().getValue().getEmployeeID()) {
							contains = true;
							userid =a.getUser_id();
							status = a.getStatus();
							chosenTraining= a.getTraining_id();
							chosenEmp = table.getSelectionModel().getSelectedItem().getValue();
							break;
						}
						
						
					}else {
						message="Please select a valid employee\n";
						trainingText.setText("");
						authoText.setText("");
						feedback.setText(message);
						table.getSelectionModel().clearSelection();
						chosenEmp=null;
					}
					
				}
				if(contains==false) {
					message="This employee has not made an application yet\n";
					trainingText.setText("");
					authoText.setText("");
					feedback.setText(message);
					table.getSelectionModel().clearSelection();
					chosenEmp=null;
				}
				if(contains == true) {
					trainingText.setText(""+chosenTraining);
					authoText.setText(status);
					
				if(status.equals("deny")) {
					
							message = "This employee is not allowed to follow this training\n";
						
							feedback.setText(message);
							table.getSelectionModel().clearSelection();
							chosenEmp=null;
				}	
					
				}
				
				
		
				
			}
			  
			
			  
			  
		  });
		 
		
			  
			  
	    //Handle button to link employee to training 
			//Link button okB
				 
		
		ArrayList<Training> activeTrainings = (ArrayList<Training>) db.getActiveTrainings();
				
			  okB.setOnAction(new EventHandler<ActionEvent>() {
				
				 
				@Override
				public void handle(ActionEvent arg0) {
					
					System.out.println(""+chosenTraining);
					message="";
					
					 boolean valid= true;
					
				     
					
					boolean contain = false;
					feedback.setText("");
			
					
					if(chosenEmp==null) {
						
						message="Please select a valid employee\n";
						valid = false;
						feedback.setText(message);
					}else {
					
						//Second= Find out if training is active or not
						//genomen uit https://stackoverflow.com/questions/23336169/condition-to-check-if-a-value-exists-in-list-containing-objects/23336285				
										
										for(Training t: activeTrainings) {
											if(t.getTrainingID()==chosenTraining) {
												
												contain = true; 
												break;
											}
										}
										
										if(contain==false) {
											message+="The employee is allowed but the selected training is yet to be made\n";
											valid=false;
											feedback.setText(message);
										}
											
										
					}
					
						
						
						if(valid==true) {
							
							
							
							SessionDB sessiondb = new SessionDB();
							
							ArrayList<Students_enrolled_in_session> listStudents = (ArrayList<Students_enrolled_in_session>) sessiondb.getAllEmployeesInSession();
							
							//Third= Find out id sessions of this training
							
							
							ArrayList<logic.Session> listSessions =(ArrayList<Session>) sessiondb.getAllSessionsOfTrainingID(chosenTraining);
							
							
							Students_enrolled_in_session st=null;
						    System.out.println(listStudents.size());
						        
							   if(!listStudents.isEmpty()) {
								   System.out.println(listStudents.size());
								   for(int i=0; i < listSessions.size(); i++) {
								    st = new Students_enrolled_in_session(listSessions.get(i).getSessionID(), chosenEmp.getEmployeeID());
								    
									  
								   if(listStudents.contains(st)) {
										message="The employee is already enrolled in this training\n";
										
										 feedback.setText(message);	
									}else{
										
										   sessiondb.linkEmployee(listSessions.get(i).getSessionID(), chosenEmp.getEmployeeID());
											message="The selected employee has successfully been added to the chosen training";
											
											 feedback.setText(message);	
									}
								   
								   }
							   }else {
								   System.out.println(listStudents.size());
								   for(int i=0; i < listSessions.size(); i++) {
								   sessiondb.linkEmployee(listSessions.get(i).getSessionID(), chosenEmp.getEmployeeID());
									message="The selected employee has successfully been added to the chosen training";
									
								   }
							   }
								
								
							}
						    
							
						
						//Finally add employee to the training by adding him/her to table Students_enrolled_in_session
							
							
						
						//Clear and showing confirmation
					
						table.getSelectionModel().clearSelection();
						feedback.setText(message);
						
						
						//chosenEmp=null;
						
						//Eventueel application verwijderen van database of  archiveren 
						
					}

					
					//feedback.setText(message);
					//table.getSelectionModel().clearSelection();
					//chosenEmp=null;
					//trainingBox.getSelectionModel().clearSelection();
					
				});
				
				  
				  
				  
				  
				  
		
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
	
	}

}