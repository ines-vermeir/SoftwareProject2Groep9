package logic;

import java.util.ArrayList;
import java.util.Calendar;

public class Session {
	int SessionID;
	int TrainingID;
	private  Calendar date;
	private String startTime;
	private String endTime;
	private Location location; 
	private ArrayList<String> teachers;
	private ArrayList<String> studentsEnrolled; // moet type Employee zijn ipv String (aanpassing na implementatie klasse employee)
	private ArrayList<String> studentsPresent; // moet type Employee zijn ipv String (aanpassing na implementatie klasse employee)
	
	
	
	public Session(int sessionID, int trainingID, Calendar date, String startTime, String endTime, Location location,
			ArrayList<String> teachers, ArrayList<String> studentsEnrolled, ArrayList<String> studentsPresent) {
		super();
		SessionID = sessionID;
		TrainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
	}

	public int getSessionID() {
		return SessionID;
	}

	public void setSessionID(int sessionID) {
		SessionID = sessionID;
	}

	public int getTrainingID() {
		return TrainingID;
	}

	public void setTrainingID(int trainingID) {
		TrainingID = trainingID;
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

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public ArrayList<String> getTeachers() {
		return teachers;
	}
	public void setTeachers(ArrayList<String> teachers) {
		this.teachers = teachers;
	}
	public ArrayList<String> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(ArrayList<String> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	public ArrayList<String> getStudentsPresent() {
		return studentsPresent;
	}
	public void setStudentsPresent(ArrayList<String> studentsPresent) {
		this.studentsPresent = studentsPresent;
	}

	@Override
	public String toString() {
		return "Session [SessionID=" + SessionID + ", TrainingID=" + TrainingID + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", location=" + location + ", teachers=" + teachers
				+ ", studentsEnrolled=" + studentsEnrolled + ", studentsPresent=" + studentsPresent + "]";
	}

	
	
	
}
