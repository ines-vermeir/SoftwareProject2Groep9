package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable{
	
		//btnLogin Action
		@FXML protected void doLogin(ActionEvent e) {
			Navigator.loadVista(Navigator.HomeView);
			Navigator.loadUserVista(Navigator.UserSectionView);
			Navigator.loadMenuVista(Navigator.MenuHomeActiveView);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
}