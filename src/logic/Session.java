package logic;

import java.util.ArrayList;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Session {
	@Id
	private int sessionID;
	private int trainingID;
	private  Calendar date;
	private String startTime;
	private String endTime;
	private Location location; 
	private ArrayList<String> teachers;
	private ArrayList<Integer> studentsEnrolled ; 
	private ArrayList<Integer> studentsPresent;
	
	
	public Session(int sessionID, int trainingID, Calendar date, String startTime, String endTime, Location location,
			ArrayList<String> teachers, ArrayList<Integer> studentsEnrolled, ArrayList<Integer> studentsPresent) {
		super();
		this.sessionID = sessionID;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
	}
	
	public Session(int sessionID, int trainingID, Calendar date, String startTime, String endTime, Location location) {
		super();
		this.sessionID = sessionID;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
	}
	
	public Session(int trainingID, Calendar date, String startTime, String endTime, Location location) {
		super();
		this.sessionID = -1;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
	}
	
	public Session(int trainingID, Calendar date, String startTime, String endTime, Location location,
			ArrayList<String> teachers, ArrayList<Integer> studentsEnrolled, ArrayList<Integer> studentsPresent) {
		super();
		this.sessionID = -1;
		this.trainingID = trainingID;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
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
	public ArrayList<Integer> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(ArrayList<Integer> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	public ArrayList<Integer> getStudentsPresent() {
		return studentsPresent;
	}
	public void setStudentsPresent(ArrayList<Integer> studentsPresent) {
		this.studentsPresent = studentsPresent;
	}

	@Override
	public String toString() {
		return "Session [SessionID=" + sessionID + ", TrainingID=" + trainingID + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", location=" + location + ", teachers=" + teachers
				+ ", studentsEnrolled=" + studentsEnrolled + ", studentsPresent=" + studentsPresent + "]";
	}
	
}
