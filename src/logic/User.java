/**
 * 
 */
package logic;

/**
 * @author Charles
 *new attempt to commit 03/11/2017
 */
import java.util.Arrays;
import java.util.EnumSet;
import logic.Privilege;
//https://stackoverflow.com/questions/3396424/how-can-i-better-represent-user-permissions
// https://stackoverflow.com/questions/28120496/how-do-i-resolve-this-error-message-to-create-an-enum-project-myfunproject-i
public class User{
	int userID;
	String username;
	String password;
	private EnumSet<Privilege>privilege;
	
	public User(int userID, String username, String password, Privilege privilege){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.privilege = EnumSet.copyOf(Arrays.asList(privilege));
	}
	
	public String toString() {
		return "User ID: " + this.userID + ", Username: " 
				+ this.username + ", Password: " + this.password 
				+ ", Privilege Assigned: " + this.privilege;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public EnumSet<Privilege> getPrivilege() {
		return privilege;
	}
	
	public void setPrivilege(EnumSet<Privilege> privilege) {
		this.privilege = privilege;
	}
}
