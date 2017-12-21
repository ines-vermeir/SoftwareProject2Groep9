package logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import db.SessionDB;
@Entity(name="Sessions")

//@Entity(name="logic.Session")

@Table(name="Sessions")
/*
@SecondaryTables( {
	@SecondaryTable(name="Session_teachers", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")}),
	@SecondaryTable(name="Students_enrolled_in_session", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")}),
	@SecondaryTable(name="Students_present_in_session", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="sessionID", referencedColumnName="sessionID")})
})
*/
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
	@Column(name="part")
	private int part;
	@Column(name="archive")
	private int archive;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection @CollectionTable(name="Session_teachers", joinColumns= @JoinColumn(name="sessionID")) @Column(name="Teacher")
	private List<String> teachers = new ArrayList<String>();
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection @CollectionTable(name="Students_enrolled_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDenrolled")
	private List<Integer> studentsEnrolled = new ArrayList<Integer>();
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection @CollectionTable(name="Students_present_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDpresent")
	private List<Integer> studentsPresent = new ArrayList<Integer>();
	
	
	//constructor voor Hibernate
		public Session ()
		{
			super();
		}
		
	
	public Session(int sessionID, int trainingID, Calendar date, String startTime, String endTime, int locationID, int part, 
			ArrayList<String> teachers, ArrayList<Integer> studentsEnrolled, ArrayList<Integer> studentsPresent) {
		super();
		this.sessionID = sessionID;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationID = locationID;
		this.part = part;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
		this.archive = 0;
	}
	
	
	public Session(int trainingID, Calendar date, String startTime, String endTime, int locationID, int part, 
			List<String> teachers, List<Integer> studentsEnrolled, List<Integer> studentsPresent) {
		super();
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationID = locationID;
		this.part = part;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
		this.archive = 0;
	}
	
	//-------------------------------------------
//	public Session(int trainingID, Calendar date, String startTime, String endTime, int locationID,
//			List<Session_teachers> teachers, List<Student_enrolled_session> studentsEnrolled, List<Student_present> studentsPresent) {
//		super();
//		this.trainingID = trainingID;
//		this.date = date;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.locationID = locationID;
//		this.teachers = teachers;
//		this.studentsEnrolled = studentsEnrolled;
//		this.studentsPresent = studentsPresent;
//		this.archive = 0;
//	}
//	
//	public Session(int SessionID, int trainingID, Calendar date, String startTime, String endTime, int locationID,
//			List<Session_teachers> teachers, List<Student_enrolled_session> studentsEnrolled, List<Student_present> studentsPresent) {
//		super();
//		this.sessionID = sessionID;
//		this.trainingID = trainingID;
//		this.date = date;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.locationID = locationID;
//		this.teachers = teachers;
//		this.studentsEnrolled = studentsEnrolled;
//		this.studentsPresent = studentsPresent;
//		this.archive = 0;
//	}
	
	
	//---------------------------------------
	
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

	public int getPart() {
		return part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	public List<Integer> getStudentsPresent() {
		return studentsPresent;
	}

	public void setStudentsPresent(List<Integer> studentsPresent) {
		this.studentsPresent = studentsPresent;
	}

	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}

	public void setStudentsEnrolled(List<Integer> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	

	public List<String> getTeachers() {
		return teachers;
	}

	public List<Integer> getStudentsEnrolled() {
		return studentsEnrolled;
	}


	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", trainingID=" + trainingID + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", locationID=" + locationID + ", part=" + part + ", archive="
				+ archive + ", teachers=" + teachers + ", studentsEnrolled=" + studentsEnrolled + ", studentsPresent="
				+ studentsPresent + "]";
	}


	
}
	

// testcode
//Session_teachers st1 = new Session_teachers("teacher57");
//Session_teachers st2 = new Session_teachers("teacher58");
//ArrayList<Session_teachers> teachers = new ArrayList<Session_teachers>();
//teachers.add(st1);
//teachers.add(st2);
//ArrayList<Student_enrolled_session> studentsEnrolled = new ArrayList<Student_enrolled_session>();
//Student_enrolled_session se1 = new Student_enrolled_session(4545);
//Student_enrolled_session se2 = new Student_enrolled_session(4545);
//studentsEnrolled.add(se1);
//studentsEnrolled.add(se2);
//ArrayList<Student_present> studentsPresent = new ArrayList<Student_present>();
//Student_present sp1 = new Student_present(4545);
//Student_present sp2 = new Student_present(4546);
//studentsPresent.add(sp1);
//studentsPresent.add(sp2);
//ArrayList<String> teachers = new ArrayList<String>();
//teachers.add("Teacher123");
//teachers.add("Teacher456");
//ArrayList<Integer> studentsEnrolled = new ArrayList<Integer>();
//studentsEnrolled.add(1111);
//studentsEnrolled.add(2222);
//ArrayList<Integer> studentsPresent = new ArrayList<Integer>();
//studentsPresent.add(1111);
//studentsPresent.add(2222);
//Calendar myCal =  new GregorianCalendar();		
//myCal.set(GregorianCalendar.YEAR, 2017);
//myCal.set(GregorianCalendar.MONTH,12);
//myCal.set(GregorianCalendar.DATE,22);

//Session s1 = new Session(1, myCal, "10:00", "12:00", 1, teachers, studentsEnrolled, studentsPresent);

//SessionDB db = new SessionDB();
//Session s1 = db.getSessionByID(45);
//System.out.println(s1.toString());
//db.insertSession(s1);
//ArrayList<Session> s1 = db.getAllSessions();
//for (Session s: s1)
//{
//	System.out.println(s.getSessionID() + "  " + s.getTeachers().size());
//	//System.out.println(s.getSessionID() + "  " + s.getTeachers().size());
//	for (s1. t: s.getTeachers()) {
//		System.out.println("----Teachers-----");
//		System.out.println(t.getTeacher());
//	}
//	for (Student_enrolled_session st: s.getStudentsEnrolled()) {
//		System.out.println("-----Student enrolled session-----");
//		System.out.println( "ID employee= "+ st.getEmployeeIDenrolled());
//	}/*for (Session_teachers t: s.getTeachers()) {
//		System.out.println("----Students enrolled in training-----");
//		System.out.println(t.getTeacher());
//	}
//}

// Andere manier om het via Hibernate te laten werken:
//-----------------------------------------------------------------------------------------------------
//@LazyCollection(LazyCollectionOption.FALSE)
//@OneToMany(mappedBy="Session",cascade = CascadeType.ALL)
////@JoinTable(name="Session_teachers")
////@Fetch(value = FetchMode.SUBSELECT)
////@ElementCollection @CollectionTable(name="Session_teachers", joinColumns= @JoinColumn(name="sessionID")) @Column(name="Teacher")
//
//private List<Session_teachers> teachers = new ArrayList<Session_teachers>();
//@LazyCollection(LazyCollectionOption.FALSE)
//@OneToMany(  mappedBy="Session",cascade = CascadeType.ALL)
////@JoinTable(name="Students_enrolled_in_session", joinColumns=@JoinColumn(name="sessionID"), inverseJoinColums=(name=""))
////@Fetch(value = FetchMode.SUBSELECT)
////@ElementCollection @CollectionTable(name="Students_enrolled_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDenrolled")
//private List<Student_enrolled_session> studentsEnrolled = new ArrayList<Student_enrolled_session>();
//@LazyCollection(LazyCollectionOption.FALSE)
//@OneToMany(  mappedBy="Session",cascade = CascadeType.ALL)
////@JoinTable(name="Students_present_in_session")
////@Fetch(value = FetchMode.SUBSELECT)
////@ElementCollection @CollectionTable(name="Students_present_in_session", joinColumns= @JoinColumn(name="sessionID")) @Column(name="employeeIDpresent")
//private List<Student_present> studentsPresent = new ArrayList<Student_present>();
//
//-------------------------------------------------------------------------------------------------------
