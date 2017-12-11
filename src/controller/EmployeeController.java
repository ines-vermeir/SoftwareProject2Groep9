package controller;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import db.TestJackson;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;
import logic.Employee;

public class EmployeeController implements Initializable{
	
	@FXML
	private TreeTableView<logic.Employee> table;
	
	@FXML
	private JFXTextField input;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	//	Field[] fields = logic.Employee.class.getDeclaredFields();
		ArrayList<logic.Employee> EmployeeOdata = null;
		try {
			EmployeeOdata = (ArrayList<logic.Employee>) TestJackson.getEmployees();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*
		for(int i= 0; i < fields.length; i++) {
			   
			JFXTreeTableColumn<Field,String> item = new JFXTreeTableColumn(fields.toString());
			item.setPrefWidth(100);
		
			item.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Field, String>, ObservableValue<String>>() {
		          
				@Override
	           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Field, String> param) {
					SimpleStringProperty column = new SimpleStringProperty();
					column.setValue(param.getValue().getValue().getName());
					return column;
	           }
	       });
			
			table.getColumns().set(i, item)
		}
		*/
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
///////////////////////////////////////////
		
	
		for(logic.Employee emp : EmployeeOdata) {
			
			Employees.add(emp);
		}
		/*
		Employee.add(new Employee("Gill Steens","20","Halle"));
		Employee.add(new Employee("Eva Bouton","20","Brussel"));
		Employee.add(new Employee("Charles White","18","Gent"));
		Employee.add(new Employee("Sebastian Garcia Martinez","21","Spanje"));
		Employee.add(new Employee("Ines Vermeire","21","Antwerpen"));
		Employee.add(new Employee("Michiel Roelants","31","Antwerpen"));
		*/
	/*	RecursiveTreeObject<Employee> r = new RecursiveTreeObject<Employee>();
		r.setChildren(Employees);*/
		//final TreeItem<logic.Employee> root = new RecursiveTreeItem<logic.Employee>(Employees, RecursiveTreeObject::getChildren);
		final TreeItem<logic.Employee> root = new TreeItem<logic.Employee>();
		
		for(Employee  e:  Employees) {
			TreeItem<Employee> item = new TreeItem<>(e);
			root.getChildren().add(item);
			
		}
		table.getColumns().setAll(id, fName,lName,city,title, birthday,address);
		table.setRoot(root);
		table.setShowRoot(false);
/*		
 * 
 * 
		input.textProperty().addListener(new ChangeListener<String>() {


			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				table.setPressed(new Predicate<TreeItem<Employee>>() {
					@Override
					public boolean test(TreeItem<Employee> employee) {
						Boolean flag = employee.getValue().getFirstName().toLowerCase().contains(newValue.toLowerCase());
						return flag;
					}
				});
				
			}
			
			
		});
		
		*/
	
	}
/*
	class Employee extends RecursiveTreeObject<Employee>{
		StringProperty name;
		StringProperty age;
		StringProperty address;
		
		public Employee(String name,String age,String address)
		{
			this.name = new SimpleStringProperty(name);
			this.age  = new SimpleStringProperty(age);
			this.address = new SimpleStringProperty(address);
			
		}
		
		
	}
	*/
}