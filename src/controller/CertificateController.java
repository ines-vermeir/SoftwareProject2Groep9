package controller;
//https://www.youtube.com/watch?v=hNz8Xf4tMI4

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import db.Certificate_uploadDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.Certificate_upload;

public class CertificateController implements Initializable {

	@FXML private Button b_search;
	@FXML private ListView<String> l_list;
	@FXML private Label t_label;
	@FXML private TextField t_empID;
	@FXML private Button b_save;
	
	File selectedFile;
	
	@FXML void saveFile(ActionEvent e)
	{
		t_label.setText("");
		String tid;
		int empID;
		byte[] bFile = null;
		boolean check = true;
		if ((t_empID.getText()!= null && !t_empID.getText().isEmpty())) {
			tid = t_empID.getText();
			try {
				empID = Integer.parseInt(tid);
			 }catch( NumberFormatException numberex) {
				 t_label.setText(t_label.getText() + "\nEmployee ID is not a number!");
				 check = false;
			 }
		}  else {
		 t_label.setText(t_label.getText() + "\nEmployee ID is empty!");
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
				cu.setEmployeeID(123);
				cu.setFile(bFile);		
				Certificate_uploadDB db = new Certificate_uploadDB();
				if (db.insertCertificate_upload(cu) == true)
				{
					t_label.setText("\nFile uploaded succesfully!");
					t_empID.clear();
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
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
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
		
	}

}
