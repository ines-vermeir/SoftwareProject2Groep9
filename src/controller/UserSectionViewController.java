package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class UserSectionViewController implements Initializable {

	
	@FXML	private Label user_label;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		user_label.setText(LoginController.userLogin.getUsername());
	}

}
