package controller;
//https://www.youtube.com/watch?v=hNz8Xf4tMI4

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.Certificate_uploadDB;
import db.TestJackson;
import db.TrainingDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.Certificate_upload;
import logic.Employee;
import logic.Training;

public class CertificateController implements Initializable {

	@FXML private Button b_search;
	@FXML private ListView<String> l_list;
	@FXML private Label t_label;
	@FXML private Button b_save;
	@FXML private TextField t_title;
	@FXML private ComboBox c_empid;
	
	
	File selectedFile;
	
	@FXML void saveFile(ActionEvent e)
	{
		t_label.setText("");
		String tid, title = null;
		int empID = -1;
		byte[] bFile = null;
		boolean check = true;
		if ((t_title.getText()!= null && !t_title.getText().isEmpty())) {
			title = t_title.getText();
		}  else {
		 t_label.setText(t_label.getText() + "\ntitle is empty!");
		 check = false;
		}
		if (selectedFile != null)
		{
			bFile = new byte[(int) selectedFile.length()];			
			try {
			  FileInputStream fileInputStream = new FileInputStream(selectedFile);
			  fileInputStream.read(bFile);
			  fileInputStream.close();
			} catch (Exception ex) {
			  ex.printStackTrace();
			  t_label.setText(t_label.getText() + "\nFile can not be uploaded!");
			  check = false;
			}	
		}
		else
		{
			t_label.setText(t_label.getText() + "\nFile input is empty!");
			check = false;
		}
		
		
		//File file = new File("C:\\Users\\evabo\\OneDrive\\Documenten\\test_certificaat.pdf");
		
		if (check == true)
		{
			if (bFile != null)
			{
				Certificate_upload cu = new Certificate_upload();
				Employee emp = (Employee)c_empid.getValue();
				int i = emp.getEmployeeID();
				cu.setEmployeeID(i);
				cu.setTitle(title);
				cu.setFile(bFile);		
				Certificate_uploadDB db = new Certificate_uploadDB();
				if (db.insertCertificate_upload(cu) == true)
				{
					t_label.setText("\nFile uploaded succesfully!");
					t_title.clear();
					l_list.getItems().remove(0);
				}
				else
				{
					t_label.setText("\nFile could not be uploaded!");
				}
			}
			else
			{
				t_label.setText("\nFile could not be uploaded!");
			}
		}
		
		
		
	}
	
	@FXML
	public void searchFile(ActionEvent e)
	{
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("PDF Files", "*.pdf"));
		fc.getExtensionFilters().add(new ExtensionFilter ("JPG", "*.jpg"));
		fc.getExtensionFilters().add(new ExtensionFilter ("PNG", "*.png"));
		selectedFile = fc.showOpenDialog(null);
		
		if (selectedFile != null)
		{
			if (l_list.getItems().size() < 1)
			{
				l_list.getItems().add(selectedFile.getName());
			}
			else
			{
				l_list.getItems().remove(0);
				l_list.getItems().add(selectedFile.getName());
			}		
		} 
		else
		{
				t_label.setText("No file has been selected.");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		TestJackson tj = new TestJackson();
//		try {
//			List<Employee> ae = tj.getEmployees();
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		ObservableList<Employee> employeeList = FXCollections.observableArrayList();		  
		  
		  try {
			for(Employee e : tj.getEmployees()) {
					
					employeeList.add(e);
				}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	   //  trainingBox.setValue(null);
		  c_empid.setItems(employeeList);	
	}

}