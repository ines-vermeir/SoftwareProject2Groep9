package logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity(name="logic.Session")
@Table(name="Sessions")

@SecondaryTables( {
	@SecondaryTable(name="Session_teachers", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")}),
	@SecondaryTable(name="Students_enrolled_in_session", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")}),
	@SecondaryTable(name="Students_present_in_session", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")})
})


public class Session {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="sessionID")
	private int sessionID;
	@Column(name="trainingID")
	private int trainingID;
	@Column(name="date")
	private Calendar date;
	@Column(name="startTime")
	private String startTime;
	@Column(name="endTime")
	private String endTime;
	@Column(name="locationID")
	private int locationID;
	@Column(name="archive")
	private int archive;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="logic.Session", cascade = CascadeType.ALL) 
	@ElementCollection @CollectionTable(name="Session_teachers", joinColumns= @JoinColumn(name="sessionID")) @Column(name="Teacher") 
	private List<String> teachers;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="logic.Session", cascade = CascadeType.ALL) 
	@ElementCollection @CollectionTable(name="Students_enrolled_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDenrolled")
	private List<Integer> studentsEnrolled; 
	@OneToMany(fetch = FetchType.EAGER, mappedBy="logic.Session", cascade = CascadeType.ALL) 
	@ElementCollection @CollectionTable(name="Students_present_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDpresent")
	private List<Integer> studentsPresent;
	
	//constructor voor Hibernate
		public Session ()
		{
			super();
		}
		
	
	public Session(int sessionID, int trainingID, Calendar date, String startTime, String endTime, int locationID,
			ArrayList<String> teachers, ArrayList<Integer> studentsEnrolled, ArrayList<Integer> studentsPresent) {
		super();
		this.sessionID = sessionID;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationID = locationID;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
		this.archive = 0;
	}
	
	
	public Session(int trainingID, Calendar date, String startTime, String endTime, int locationID,
			List<String> teachers, List<Integer> studentsEnrolled, List<Integer> studentsPresent) {
		super();
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationID = locationID;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
		this.archive = 0;
	}
	
	public int getArchive() {
		return archive;
	}


	public void setArchive(int archive) {
		this.archive = archive;
	}


	public Session (int sessionID)
	{
		this.sessionID = sessionID;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public int getTrainingID() {
		return trainingID;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getLocationID() {
		return locationID;
	}
	
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	
	public List<String> getTeachers() {
		return teachers;
	}
	public void setTeachers(ArrayList<String> teachers) {
		this.teachers = teachers;
	}
	public List<Integer> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(ArrayList<Integer> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	public List<Integer> getStudentsPresent() {
		return studentsPresent;
	}
	public void setStudentsPresent(ArrayList<Integer> studentsPresent) {
		this.studentsPresent = studentsPresent;
	}

	@Override
	public String toString() {
		return "Session [SessionID=" + sessionID + ", TrainingID=" + trainingID + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", locationID=" + locationID + ", teachers=" + teachers
				+ ", studentsEnrolled=" + studentsEnrolled + ", studentsPresent=" + studentsPresent + "]";
	}
	
}
