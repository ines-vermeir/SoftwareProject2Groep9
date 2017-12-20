package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import application.Navigator;
import db.UserDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.User;
import logic.User.Privilege;

public class SettingsAddUserController implements Initializable {

	@FXML private Button back;
	@FXML private TextField t_username;
	@FXML private Button saveuser;
	@FXML private ChoiceBox<String> c_privilege;
	@FXML private Label errorMsg;
	@FXML private PasswordField passField;
	
	@FXML
	protected void backToSettings(ActionEvent e) {
		Navigator.loadVista(Navigator.SettingsView);
		Navigator.loadMenuVista(Navigator.MenuSettingsActiveView);
	}
	
	@FXML
	protected void saveUser (ActionEvent e)
	{
		errorMsg.setText("");
		UserDB udb = new UserDB();
		String username = null,password= null;
		User test;
		boolean check = true;

		 if ((t_username.getText()!= null && !t_username.getText().isEmpty())) {
			 username = t_username.getText();
			 test = udb.getUser(username);
			 if ((test != null && test.getUsername().equals(username)))
			 {
				 errorMsg.setText(errorMsg.getText() + "\nThis username is already in use!");
				 check = false;
			 }
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nUsername is empty!");
			 check = false;
		 }
		 if ((passField.getText() != null && !passField.getText().isEmpty())) {
			 password = passField.getText();
			 password = BCrypt.hashpw(passField.getText(), BCrypt.gensalt());
		 } else {
			 errorMsg.setText(errorMsg.getText() + "\nPassword is empty!");
			 check = false;
		 }		 
		 if (check == true ) 
		 {
			 User u = new User (username, password, Privilege.valueOf(c_privilege.getValue()));
			 udb.insertUser(u);
			 errorMsg.setText("User has been saved!");
		 }
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		c_privilege.setItems(FXCollections.observableArrayList("HR","ADMIN"));
		c_privilege.setValue("HR");
		
	}

}