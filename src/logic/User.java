package logic;

public class User{
	
	public enum Privilege {EMPLOYEE, TEACHER, HR};
	
	

	private int userID;
	private String username;
	private String password;
	private Privilege privilege;
	
	public User(int userID, String username, String password, Privilege privilege){
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.privilege = privilege;
	}
	
	public String toString() {
		return "User ID: " + this.userID + ", Username: " 
				+ this.username + ", Password: " + this.password 
				+ ", Privilege Assigned: " + this.privilege;
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
	
	
	public Privilege getPrivilege() {
		return privilege;
	}
	
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
}
