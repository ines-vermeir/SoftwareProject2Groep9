package controller;
import java.net.URL;
import java.util.ResourceBundle;
import org.mindrot.jbcrypt.BCrypt;
import application.Navigator;
import db.UserDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.User;

public class LoginController implements Initializable{
    
    
    @FXML private TextField userField;     
    @FXML private TextField passwordField;   
    @FXML private Label lblStatus;
    
    public static User userLogin;
    
    @SuppressWarnings("unused")
    @FXML protected void doLogin(ActionEvent e) {  
    	lblStatus.setText("Logging in...");
    	try {
        boolean login = true;
        boolean usernameGevonden = true;
        String password = passwordField.getText();            
        userLogin = null;
        boolean check = false;
        UserDB userDB = null; 
        
        userDB = new UserDB(); 
        	if (userDB != null) {
        		
        		userLogin = userDB.getUser(userField.getText());
        		check = true;
        		}
        	else {
        		login = false;
        		lblStatus.setText("Oops, something went wrong.");
        	}

        
        if (check == true)
        {
        if (userLogin == null) {
            usernameGevonden = false;
            lblStatus.setText("user not found.");
            lblStatus.setVisible(true);    
            userField.setStyle("-fx-background-color: red;");
            login = false;
        }  else {
        	if ((BCrypt.checkpw(password,userLogin.getPassword())) == false) {
        		lblStatus.setText("wrong password");
        		lblStatus.setVisible(true);    
        		userField.setStyle("-fx-background-color: orange;");
        		passwordField.clear();
        		login = false;
        	}
        }
        }
        else
        {
        	lblStatus.setText("Oops, something went wrong.");
        }
        
        if (login == true) {
        if((userField.getText().equals(userLogin.getUsername())) && (BCrypt.checkpw(password,userLogin.getPassword()))) {
            login = true;
            System.out.println("welcome");
            userField.setStyle("-fx-background-color: green;");
            Navigator.loadVista(Navigator.HomeView);
            Navigator.loadUserVista(Navigator.UserSectionView);
            Navigator.loadMenuVista(Navigator.MenuHomeActiveView); 
        }
        else {
        	lblStatus.setText("Oops, something went wrong.");
        }
      }
    	} catch (Exception ex)
    	{
    		lblStatus.setText("Oops, something went wrong.");
    	}   
        
    }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
        	
        }
}