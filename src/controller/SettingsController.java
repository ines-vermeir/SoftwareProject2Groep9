package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import db.HibernateCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SettingsController implements Initializable {

	@FXML private Button backup;
	@FXML private Button colors;
	@FXML private Button passw;
	@FXML private Button adduser;
	
	@FXML //functie voor button "new user"
	protected void toAddUser(ActionEvent e) {
		Navigator.loadVista(Navigator.SettingsAddUserView);
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
	@FXML private Label LabelStatus;
	@FXML private TextField txtPath;
	@FXML private Label lblpath;
	
	@FXML //functie voor button "new survey"
	protected void backup(ActionEvent e) throws IOException {
		LabelStatus.setVisible(true);
		
		String inputPath = txtPath.getText()+"\\";
		
		System.out.println(inputPath);
		
		
		boolean backupGelukt = false;
		
		HibernateCSV hibernateCSV = new HibernateCSV();
		
		// TO DO CONTROLE IS GELUKT !!!
		
		
   // 	String pathGevonden = "C:\\hibernateoef\\";
		
//		if(txtPath.toString().contains("\\") == false){
//			System.out.println("error");
//			LabelStatus.setText("backup failed");
//			LabelStatus.setVisible(true);	
		
		
		
//		else {
			
//			LabelStatus.setText("processing");
//			LabelStatus.setVisible(true);	
		
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
		
		if (backupGelukt) {	
			LabelStatus.setText("backup succeeded");
			LabelStatus.setVisible(true);	

		}
		
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
