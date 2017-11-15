package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity(name="logic.Students_enrolled_in_session")
@Entity
@Table(name="Students_enrolled_in_session")

public class Student_enrolled_session implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="sessionID",referencedColumnName="sessionID", nullable=false)
	private Session Session;
	
	public Session getSession() {
		return Session;
	}
	public void setSession(Session session) {
		this.Session = session;
	}
	@Override
	public String toString() {
		return "Test [sessionID=" + sessionID + ", employeeIDenrolled=" + employeeIDenrolled + "]";
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
		Student_enrolled_session other = (Student_enrolled_session) obj;
		if (employeeIDenrolled != other.employeeIDenrolled)
			return false;
		if (sessionID != other.sessionID)
			return false;
		return true;
	}
	@Id
	@Column(name="sessionID")
	private int sessionID; 
	@Id
	@Column(name="employeeIDenrolled")
	private int employeeIDenrolled;
	public Student_enrolled_session(int sessionID, int employeeIDenrolled) {
		super();
		this.sessionID = sessionID;
		this.employeeIDenrolled = employeeIDenrolled;
	}
	public Student_enrolled_session() {
		super();
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
	public void setEmployeeIDenrolled(int emploteeIDenrolled) {
		this.employeeIDenrolled = emploteeIDenrolled;
	}
	
	
}
