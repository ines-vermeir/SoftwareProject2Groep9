package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//@Entity(name="logic.Session_teachers")
@Entity
//Deze annotation wordt gebruikt samen met een aparte klasse voor een composite key
//@IdClass(Teacher.class)
@Table(name="Session_teachers")
public class Session_teachers implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="sessionID",referencedColumnName="sessionID", nullable=false)
private Session Session;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sessionID;
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}
	
	public Session getSession() {
		return Session;
	}
	public void setSession(Session session) {
		this.Session = session;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session_teachers other = (Session_teachers) obj;
		if (sessionID != other.sessionID)
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
	public Session_teachers() {
		// TODO Auto-generated constructor stub
	}
	
	//private TeacherID id;/	
	@Id
	@Column(name="SessionID")
	private int sessionID; 
	@Id
	@Column(name="Teacher")
	private String teacher;
	
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	/*
	@EmbeddedId
	public TeacherID getId() {
		return id;
	}
	public void setId(TeacherID id) {
		this.id = id;
	}
	*/
	public Session_teachers(int sessionID, String teacher) {
		super();
		this.sessionID = sessionID;
		this.teacher = teacher;
	}
	
	public Session_teachers(String teacher) {
		super();
		this.teacher = teacher;
	}
	

}
/*
@Embeddable
class TeacherID implements Serializable{
	@Column(name="SessionID")
	private int SessionID; 
	
	@Column(name="Teacher")
	private String Teacher;
	
	
	public int getSessionID() {
		return SessionID;
	}
	public void setSessionID(int sessionID) {
		this.SessionID = sessionID;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		this.Teacher = teacher;
	}
	@Override
	public String toString() {
		return "Session_teachers [sessionID=" + SessionID + ", teacher=" + Teacher + "]";
	}
}
*/