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
    
    
    @FXML
    private TextField userField; 
    
    @FXML 
    private TextField passwordField;
    
    @FXML
    private Label lblStatus;
    
    
    private static User userLogin;
    
    @SuppressWarnings("unused")
    @FXML protected void doLogin(ActionEvent e) {        
        
        boolean login = true;
        boolean usernameGevonden = true;
        String password = passwordField.getText();            
        userLogin = null;
        UserDB userDB = new UserDB(); 
        
        try {
        	userLogin = userDB.getUser(userField.getText());
        } catch (Exception exc)
        {
        	lblStatus.setText("Oops, something went wrong.");
        }       
        if (userLogin == null) {
            usernameGevonden = false;
            lblStatus.setText("user not found");
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
        

        
        
    }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
            
        }
}