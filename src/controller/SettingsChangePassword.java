package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import db.UserDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
public class SettingsChangePassword implements Initializable {

	@FXML private PasswordField passFieldOld;
	@FXML private PasswordField passFieldNew;
	@FXML private PasswordField passFieldConfirm;
	@FXML private Label errorMsg;
	@FXML private Button save;
	
	@FXML
	protected void changePassword(ActionEvent e) {
	
		controller.LoginController.userLogin.getPassword();
		errorMsg.setText("");
		boolean check = true;
		String passFieldOlds = null, passFieldNews = null, confermedPassws = null, password = null;
		UserDB userdb = new UserDB();
		
		if ((passFieldOld.getText() != null && !passFieldOld.getText().isEmpty()))	{
			passFieldOlds = passFieldOld.getText();
			if(BCrypt.checkpw(passFieldOlds,controller.LoginController.userLogin.getPassword())  == false) {
				check = false;
				errorMsg.setText(errorMsg.getText() + "\nincorrect old password");
			}	
		}
		else 	{
			check = false;
			errorMsg.setText(errorMsg.getText() + "\nfield old password is empty");
		}
		if ((passFieldNew.getText() != null && !passFieldNew.getText().isEmpty()))	{
			passFieldNews = passFieldNew.getText();
		}
		else 	{
			check = false;
			errorMsg.setText(errorMsg.getText() + "\nnew password field is empty");
		}
		if ((passFieldConfirm.getText() != null && !passFieldConfirm.getText().isEmpty()))	{
			confermedPassws = passFieldConfirm.getText();
		}
		else 	{
			check = false;
			errorMsg.setText(errorMsg.getText() + "\nconfirm new password is empty");
		}
		
		if (check == true)	{
			if (!(confermedPassws.equals(passFieldNews))){
				check = false;
				errorMsg.setText(errorMsg.getText() + "\nnew password and confirm new password are not equal");
			}
			else	{
				check = true;
				password = BCrypt.hashpw(passFieldNews, BCrypt.gensalt());
				try {
					userdb.ChangePassword(controller.LoginController.userLogin.getUsername(), password);
					errorMsg.setText(errorMsg.getText() + "\nPassword change has been saved");
				} catch (Exception exc)
				{
					errorMsg.setText(errorMsg.getText() + "\nOops, something went wrong");
				}
			}
		}
	}
		
	
		
		
		
	//-------------------------------------------------------	
		
		
//		boolean allFilledIn = true;	 // needs to be true
//		if((passFieldOlds.trim().isEmpty()==false) && (passFieldNews.trim().isEmpty() == false)  && (confermedPassws.trim().isEmpty()==false)){	//
//			allFilledIn = true;	
//			//statusPassword.setText("correct");	
//		}
//	
//		else{		
//			allFilledIn = false;
//		//	statusPassword.setText("All fiels need to be filled in");
//			LabelS += ("All fiels need to be filled in" + '\n');
//		}
//		
//
//		
//		boolean correctConfermedPassword = true;
//		
//		if(confermedPassws.equals(passFieldNews)) {
//			correctConfermedPassword = true;
//			statusPassword.setVisible(false);
//		//	System.out.println("gelukt");
//			
//		} else {	
//			correctConfermedPassword = false;
//		//	statusPassword.setText("false confirmed PassWord");	
//		//	statusPassword.setVisible(true);
//			LabelS += ("false confirmed PassWord" + '\n');
//			
//			//System.out.println("mislukt");
//		}
//		
//		
//		
//		
//		
//		boolean changedPassWord = true; // needs to be true
//		if (passFieldOlds.equals(passFieldNews)) {
//			
//		//	statusPassword.setText("Password needs to be a new value");	
//			LabelS += ("Password needs to be a new value" + '\n');
//			changedPassWord = false;
//		}
//		
//		else {
//			statusPassword.setVisible(false);
//			changedPassWord = true;
//		}
//		
//		
//		
//		System.out.println(passFieldOlds);
//		System.out.println(passFieldNews);
//		System.out.println(confermedPassws);
//		
//		System.out.println(LabelS);
//		
//		
//		
//		
//		if(correctOldPassword && allFilledIn && correctConfermedPassword && changedPassWord) {
//		
//			
//			userdb.ChangePassword(user.getUsername(), passFieldNews);
//			
//		}
//			
//		else {	
//			statusPassword.setText(LabelS);
//			statusPassword.setVisible(true);
//		}
//			
//	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
