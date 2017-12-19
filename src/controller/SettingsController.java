package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class SettingsController implements Initializable {

	@FXML private Button backup;
	@FXML private Button colors;
	@FXML private Button passw;
	@FXML private Button adduser;
	
	@FXML //functie voor button "new survey"
	protected void toAddUser(ActionEvent e) {
	//	Navigator.loadVista(Navigator.SettingsAddUserView);
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
