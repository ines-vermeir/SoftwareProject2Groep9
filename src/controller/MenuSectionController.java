package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuSectionController implements Initializable {

	@FXML
	protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
	}
    
    @FXML
	protected void toTrainings(ActionEvent e) {
		Navigator.loadVista(Navigator.CourseView);		
	}
	
	@FXML
	protected void toEmployees(ActionEvent e) {
		Navigator.loadVista(Navigator.StudentView);			
	}
	
	@FXML
	protected void toSettings(ActionEvent e) {
		//Navigator.loadVista(Navigator.GeneralSettingsView);			
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
