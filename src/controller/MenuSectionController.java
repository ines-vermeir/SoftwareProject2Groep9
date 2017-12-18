package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuSectionController implements Initializable {
	
	@FXML
	private Button homeBtn;
	
	@FXML
	private Button employeeBtn;
	
	@FXML
	private Button trainingBtn;
	
	@FXML
	private Button bookBtn;
	
	@FXML
	private Button surveyBtn;
	
	@FXML
	private Button certificateBtn;
	
	@FXML
	private Button settingsBtn;
	
	
	

	@FXML
	protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
		Navigator.loadMenuVista(Navigator.MenuHomeActiveView);
	}
	
	@FXML
	protected void toEmployees(ActionEvent e) {
		Navigator.loadVista(Navigator.EmployeeView);		
		Navigator.loadMenuVista(Navigator.MenuEmployeeActiveView);
	}
	
    @FXML
	protected void toTrainings(ActionEvent e) {
    		
		Navigator.loadVista(Navigator.TrainingView);		
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
    
    @FXML
	protected void toBooks(ActionEvent e) {
    	 
		Navigator.loadVista(Navigator.BookOverview);	
		Navigator.loadMenuVista(Navigator.MenuBookActiveView);
		
	}
    
    @FXML
	protected void toCertificates(ActionEvent e) {
		Navigator.loadVista(Navigator.CertificateView);	
		Navigator.loadMenuVista(Navigator.MenuCertificateActiveView);
	}
    
    @FXML
	protected void toSurveys(ActionEvent e) {
		Navigator.loadVista(Navigator.SurveyView);
		Navigator.loadMenuVista(Navigator.MenuSurveyActiveView);
	}
	
	@FXML
	protected void toSettings(ActionEvent e) {
		Navigator.loadVista(Navigator.SettingsView);	
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
    @FXML
	protected void doLogout(ActionEvent e) { 	
		Navigator.loadVista(Navigator.LoginView);
		Navigator.loadUserVista(Navigator.EmptyView);
		Navigator.loadMenuVista(Navigator.EmptyView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
