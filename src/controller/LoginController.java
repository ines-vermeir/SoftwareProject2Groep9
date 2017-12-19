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
    
    
    
    
    @SuppressWarnings("unused")
    @FXML protected void doLogin(ActionEvent e) {
        
        
        
        boolean login = false;
        boolean usernameGevonden = true;
         
        User user = null;
        UserDB userDB = new UserDB();
        
        user = userDB.getUser(userField.getText());
        
        if (user == null) {
            usernameGevonden = false;
            lblStatus.setText("user not found");
            lblStatus.setVisible(true);    
            userField.setStyle("-fx-background-color: red;");
        }
        
        String password = passwordField.getText();
        
        // 
        if(userField.getText().equals(user.getUsername()) && BCrypt.checkpw(password,user.getPassword())) {
            login = true;
            System.out.println("welcome");
            userField.setStyle("-fx-background-color: green;");
        }
        
        if(login == true) {
            Navigator.loadVista(Navigator.HomeView);
            Navigator.loadUserVista(Navigator.UserSectionView);
            Navigator.loadMenuVista(Navigator.MenuHomeActiveView);        
        }
        
        if (usernameGevonden == true) {
            lblStatus.setText("wrong password");
            lblStatus.setVisible(true);    
            userField.setStyle("-fx-background-color: orange;");
        }
    }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            // TODO Auto-generated method stub
            
        }
}