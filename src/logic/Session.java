package logic;

import java.util.ArrayList;

public class Session {
	String location; // moet type Location zijn ipv string (aanpassing na afwerking klasses)
	String date;
	ArrayList<String> teachers;
	ArrayList<String> studentsEnrolled; // moet type Employee zijn ipv String (aanpassing na implementatie klasse employee)
	ArrayList<String> studentsPresent; // moet type Employee zijn ipv String (aanpassing na implementatie klasse employee)
	
	
	public Session(String location, String date, ArrayList<String> teachers, ArrayList<String> studentsEnrolled,
			ArrayList<String> studentsPresent) {
		super();
		this.location = location;
		this.date = date;
		this.teachers = teachers;
		this.studentsEnrolled = studentsEnrolled;
		this.studentsPresent = studentsPresent;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
		return "location=" + location + ", date=" + date + ", teachers=" + teachers + ", studentsEnrolled="
				+ studentsEnrolled + ", studentsPresent=" + studentsPresent;
	}
	
	
}
