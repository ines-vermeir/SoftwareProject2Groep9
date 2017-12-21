package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import db.HibernateCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsController implements Initializable {

	@FXML private Button backup;
	@FXML private Button colors;
	@FXML private Button passw;
	@FXML private Button adduser;
	@FXML private Label LabelStatus;
	@FXML private TextField txtPath;
	@FXML private Label lblpath;
	
	@FXML //functie voor button "new user"
	protected void toAddUser(ActionEvent e) {
		Navigator.loadVista(Navigator.SettingsAddUserView);
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
	@FXML //functie voor button "change password"
	protected void gotochangePassword(ActionEvent e) {
		Navigator.loadVista(Navigator.SettingsChangePassword);
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
	
	
	@FXML
	protected void backup(ActionEvent e) throws IOException {
		LabelStatus.setVisible(true);				
		boolean backupGelukt = false;
		
		if (txtPath.getText() != null && !txtPath.getText().isEmpty())
		{
			try
			{
				String inputPath =  txtPath.getText()+"\\";
				System.out.println(inputPath);		
				HibernateCSV hibernateCSV = new HibernateCSV();
				hibernateCSV.hibernateCSVAnswer(inputPath);
				hibernateCSV.hibernateCSVBooks(inputPath);
				hibernateCSV.hibernateCSVCertificate(inputPath);
				hibernateCSV.hibernateCSVLocation(inputPath);
				hibernateCSV.hibernateCSVPredefinedAnswers(inputPath);
				hibernateCSV.hibernateCSVPredefinedQuestions(inputPath);
				hibernateCSV.hibernateCSVPredefinedSurveys(inputPath);
				hibernateCSV.hibernateCSVQuestion(inputPath);
				hibernateCSV.hibernateCSVSessions(inputPath);
				hibernateCSV.hibernateCSVSurvey(inputPath);
				hibernateCSV.hibernateCSVTraining(inputPath);
				hibernateCSV.hibernateCSVUser(inputPath);
				hibernateCSV.sessionStudentsEnrolledCSV(inputPath);
				hibernateCSV.sessionStudentsPresentCSV(inputPath);
				backupGelukt = true;
			} catch (Exception exc)
			{
				LabelStatus.setText("Oops, something went wrong...");
				backupGelukt = false;
			}
		} else
		{
			LabelStatus.setText("You need to choose a file path!");
			backupGelukt = false;
		}
		
		
		if (backupGelukt) {	
			LabelStatus.setText("backup succeeded");
			LabelStatus.setVisible(true);	

		}
	}	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
