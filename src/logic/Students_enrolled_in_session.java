package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Students_enrolled_in_session")
@Table(name="Students_enrolled_in_session")
public class Students_enrolled_in_session implements Serializable{
	@Id
	@Column
	private int sessionID; 
	@Id
	@Column
	private int employeeIDenrolled;
	
	
	public Students_enrolled_in_session() {
		// TODO Auto-generated constructor stub
	}


	public int getSessionID() {
		return sessionID;
	}


	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}


	public int getEmployeeIDenrolled() {
		return employeeIDenrolled;
	}


	public void setEmployeeIDenrolled(int employeeIDenrolled) {
		this.employeeIDenrolled = employeeIDenrolled;
	}


	public Students_enrolled_in_session(int sessionID, int employeeIDenrolled) {
		super();
		this.sessionID = sessionID;
		this.employeeIDenrolled = employeeIDenrolled;
	}


	@Override
	public String toString() {
		return "Students_enrolled_in_session [sessionID=" + sessionID + ", employeeIDenrolled=" + employeeIDenrolled
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeIDenrolled;
		result = prime * result + sessionID;
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
		Students_enrolled_in_session other = (Students_enrolled_in_session) obj;
		if (employeeIDenrolled != other.employeeIDenrolled)
			return false;
		if (sessionID != other.sessionID)
			return false;
		return true;
	}
	
	
	
	
	

}
