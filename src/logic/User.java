
package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.mindrot.jbcrypt.BCrypt;

@Entity

@Table(name="Users")

public class User{
	
	public enum Privilege {HR, ADMIN};
	
	@Column(name ="userID") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	@Id 
	@Column(name="username") 
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="privilege") @Enumerated(EnumType.STRING)
	private Privilege privilege;
	@Column(name="archive")
	private int archive;

	public User(int userID, String username, String password, Privilege privilege){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.privilege = privilege;
		this.archive = 0;
	}
	
	public User(String username, String password, Privilege privilege){
		this.username = username;
		this.password = password;
		this.privilege = privilege;
		this.archive = 0;
	}
	
	public int getArchive() {
		return archive;
	}

	public void setArchive(int archive) {
		this.archive = archive;
	}

	
	
	//constructor voor Hibernate
	public User ()
	{
		super();
	}
	
	public String toString() {
		return "User ID: " + this.userID + ", Username: " 
				+ this.username + ", Privilege Assigned: " + this.privilege;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	public int getUserID() {
		return userID;
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
//		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = password;
	}
	
	
	public Privilege getPrivilege() {
		return privilege;
	}
	
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	
	
	//tot hier code van Sebastian G--------------------------------------------------------------------------------------------------------------------------
	
		//hieronder: code afkomstig uit klasse login (Charles)
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
//			//Source: https://stackoverflow.com/questions/16627910/how-to-code-a-very-simple-login-system-with-java
//			Scanner input = new Scanner(System.in); // (database verbinding voor input?)
//			
//			// =====
//			try {
//				Scanner scan = new Scanner (new File(" "));
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			String file_username = "John";		//--> Ik heb dit hardcoded want ik weet niet hoe 27/10/2017
//			String file_password = "Bonus";
//			
//			System.out.println("Give your login credentials. ");
//			System.out.println("Username: ");
//			String input_username = input.next();
//			
//			System.out.println("Password: ");
//			String input_password =input.next();
//			
//			//users check = new users(username, password);
//			
//			if(input_username.equals(file_username) && input_password.equals(file_password)) {
//				System.out.println("Welcome, " + file_username + "! You are logged in!");
//			}else {
//				System.out.print("Please, provide the correct credentials.");
//			}
	
}
