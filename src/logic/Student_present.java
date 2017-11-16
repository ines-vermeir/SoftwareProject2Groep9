package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//@Entity(name="logic.Students_present_in_session")
@Entity
@Table(name="Students_present_in_session")
public class Student_present implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="sessionID" ,referencedColumnName="sessionID",nullable=false)
	private Session Session;
	
	public Session getSession() {
		return Session;
	}
	public void setSession(Session session) {
		this.Session = session;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeIDpresent;
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
		Student_present other = (Student_present) obj;
		if (employeeIDpresent != other.employeeIDpresent)
			return false;
		if (sessionID != other.sessionID)
			return false;
		return true;
	}
	@Id
	@Column(name="sessionID")
	private int sessionID; 
	@Id
	@Column(name="employeeIDpresent")
	private int employeeIDpresent;
	
	public Student_present(int sessionID, int employeeIDpresent) {
		super();
		this.sessionID = sessionID;
		this.employeeIDpresent = employeeIDpresent;
	}
	
	public Student_present(int employeeIDpresent) {
		super();
		this.employeeIDpresent = employeeIDpresent;
	}
	
	@Override
	public String toString() {
		return "Student_present [sessionID=" + sessionID + ", employeeIDpresent=" + employeeIDpresent + "]";
	}
	public Student_present() {
		// TODO Auto-generated constructor stub
	}

	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public int getEmployeeIDpresent() {
		return employeeIDpresent;
	}
	public void setEmployeeIDpresent(int employeeIDpresent) {
		this.employeeIDpresent = employeeIDpresent;
	}
	
	
	
}
