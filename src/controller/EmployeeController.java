package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Callback;

public class EmployeeController implements Initializable{
	
	@FXML
	private JFXTreeTableView<Employee> table;
	
	@FXML
	private JFXTextField input;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		JFXTreeTableColumn<Employee,String> name = new JFXTreeTableColumn("Name");
		name.setPrefWidth(100);
	
		name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
               return param.getValue().getValue().name;
           }
       });
		
		JFXTreeTableColumn<Employee,String> age = new JFXTreeTableColumn("Age");
		age.setPrefWidth(100);
	
		age.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
               return param.getValue().getValue().age;
           }
       });
		
		JFXTreeTableColumn<Employee,String> address = new JFXTreeTableColumn("Address");
		address.setPrefWidth(100);
	
		address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
	          
			@Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
               return param.getValue().getValue().address;
           }
       });
		
		
		ObservableList<Employee> Employee = FXCollections.observableArrayList();
		Employee.add(new Employee("Gill Steens","20","Halle"));
		Employee.add(new Employee("Eva Bouton","20","Brussel"));
		Employee.add(new Employee("Charles White","18","Gent"));
		Employee.add(new Employee("Sebastian Garcia Martinez","21","Spanje"));
		Employee.add(new Employee("Ines Vermeire","21","Antwerpen"));
		Employee.add(new Employee("Michiel Roelants","31","Antwerpen"));
		
		final TreeItem<Employee> root = new RecursiveTreeItem<Employee>(Employee, RecursiveTreeObject::getChildren);
		table.getColumns().setAll(name,age,address);
		table.setRoot(root);
		table.setShowRoot(false);
		
		input.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				table.setPredicate(new Predicate<TreeItem<Employee>>() {
					@Override
					public boolean test(TreeItem<Employee> employee) {
						Boolean flag = employee.getValue().name.getValue().toLowerCase().contains(newValue.toLowerCase());
						return flag;
					}
				});
				
			}
			
		});
		
		
	
	}

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
	
}