package db;
//code gebruikt als voorbeeld om csv write te schrijven: https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.Book;
import logic.Certificate;
import logic.Location;
import logic.Session;
import logic.User;



public class BackupCsv {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static String FILE_HEADER;
	

	public void backupEverything() throws IOException
	{
		//answersCSV(); - maken als klasse(s) voor survey volledig af is
		booksCSV();
		//certificatesCSV(); - klasse Certificate moet nagekeken worden
		//locationsCSV(); - in order als getAllLocations functie aangemaakt is
		//predefinedAnswersCSV(); - maken als klasse(s) voor survey volledig af is
		//predefinedQuestionsCSV(); - maken als klasse(s) voor survey volledig af is
		//predefinedSurveysCSV(); - maken als klasse(s) voor survey volledig af is
		//requestsCSV();
		sessionsCSV();
		sessionTeachersCSV();
		sessionStudentsEnrolledCSV();
		sessionStudentsPresentCSV();
		//surveyCSV(); - maken als klasse(s) voor survey volledig af is
		//surveyQuestionsCSV(); - maken als klasse(s) voor survey volledig af is
		//TrainingsCSV();
		//Training_booksCSV(); - implementatie in welke klasse?
		usersCSV();
		
		
		System.out.println("Backup is gemaakt");
	}
	

	
	public void usersCSV() throws IOException
	{
		FILE_HEADER = "userID, username, password, privilege, archive";
		UserDB db = new UserDB();
		ArrayList<User> users = db.getAllUsers();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Users-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (User u: users)		{
			fileWriter.append(String.valueOf(u.getUserID()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(u.getUsername());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(u.getPassword());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(u.getPrivilege()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(u.getArchive()));
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
		System.out.println("CVS file of Users was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}	
		
	}

	public void booksCSV() throws IOException
	{
		FILE_HEADER = "ISBN, author, title, releaseDate";
		BookDB db = new BookDB();
		ArrayList<Book> books = db.getAllBooks();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Books-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (Book b: books)
		{
			fileWriter.append(String.valueOf(b.getIsbn()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(b.getAuthor());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(b.getTitle());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(b.getReleaseDate()));
			//fileWriter.append(COMMA_DELIMITER);
			//fileWriter.append(String.valueOf(b.getArchive()));
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
		System.out.println("CVS file of Books was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}	
		
	}
	
	public void sessionsCSV() throws IOException
	{
		FILE_HEADER = "sessionID, trainingID, locationID, part, date, startTime, endTime, archive";
		SessionDB db = new SessionDB();
		ArrayList<Session> sessions = db.getAllSessions();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Sessions-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (Session s: sessions)
		{
			fileWriter.append(String.valueOf(s.getSessionID()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(s.getTrainingID()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(s.getLocationID()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(s.getPart()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(s.getDate()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(s.getStartTime());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(s.getEndTime());
			fileWriter.append(String.valueOf(s.getArchive()));
			fileWriter.append(NEW_LINE_SEPARATOR);
		}
		System.out.println("CVS file of Sessions was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}	
	}
	
	public void sessionTeachersCSV() throws IOException
	{
		FILE_HEADER = "sessionID, teacher";
		SessionDB db = new SessionDB();
		ArrayList<Session> sessions = db.getAllSessions();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Sessions_teachers-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (Session s: sessions)
		{			
			for (String st: s.getTeachers())
			{
				fileWriter.append(String.valueOf(s.getSessionID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(st);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		}
		System.out.println("CVS file of Sessions_teachers was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}
	}
	
	public void sessionStudentsEnrolledCSV() throws IOException
	{
		FILE_HEADER = "sessionID, employeeID";
		SessionDB db = new SessionDB();
		ArrayList<Session> sessions = db.getAllSessions();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Students_enrolled_in_session-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (Session s: sessions)
		{			
			for (int i: s.getStudentsEnrolled())
			{
				fileWriter.append(String.valueOf(s.getSessionID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(i));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}	
		}
		System.out.println("CVS file of Students_enrolled_in_session was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}
	}
	
	public void sessionStudentsPresentCSV() throws IOException
	{
		FILE_HEADER = "sessionID, employeeID";
		SessionDB db = new SessionDB();
		ArrayList<Session> sessions = db.getAllSessions();
		FileWriter fileWriter = null;
		try {
		fileWriter = new FileWriter ("Students_enrolled_in_session-backup");
		fileWriter.append(FILE_HEADER.toString());
		fileWriter.append(NEW_LINE_SEPARATOR);
		for (Session s: sessions)
		{			
			for (int i: s.getStudentsPresent())
			{
				fileWriter.append(String.valueOf(s.getSessionID()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(i));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		}
		System.out.println("CVS file of Students_enrolled_in_session was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter");
				e.printStackTrace();
			}
		}
	}
	
//	public void locationsCSV() //functie getAllLocations nodig
//	{
//		FILE_HEADER = "LocationID, streetName, number, postalCode, city, country, name, addInfo, archive";
//		LocationDB db = new LocationDB();
//		ArrayList<Location> locations = db.getAllLocations();
//		FileWriter fileWriter = null;
//		try {
//		fileWriter = new FileWriter ("Locations-backup");
//		fileWriter.append(FILE_HEADER.toString());
//		fileWriter.append(NEW_LINE_SEPARATOR);
//		for (Location l: locations)		{
//			fileWriter.append(String.valueOf(l.getID()));
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getStreetName());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getNumber());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getPostalCode());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getCity());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getCountry());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getName());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(l.getInfo());
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(String.valueOf(l.getArchive()));
//			fileWriter.append(NEW_LINE_SEPARATOR);
//		}
//		System.out.println("CVS file of Locations was created succesfully");
//		} catch (Exception e)
//		{
//			System.out.println("Error in CsvFileWriter");
//			e.printStackTrace();
//		} finally 
//		{
//			try {
//				fileWriter.flush();
//				fileWriter.close();
//			} catch (IOException e) {
//				System.out.println("Error while flushing/closing fileWriter");
//				e.printStackTrace();
//			}
//		}	
//		
//	}
	
//	public void certificatesCSV() throws IOException // klasse klopt niet met database - employeeID ontbreekt?
//	{
//		FILE_HEADER = "trainingID, issueDate, expirationDate, employeeID, archive";
//		CertificateDB db = new CertificateDB();
//		ArrayList<Certificate> certificates = db.getAllCertificates();
//		FileWriter fileWriter = null;
//		try {
//		fileWriter = new FileWriter ("Certificates-backup");
//		fileWriter.append(FILE_HEADER.toString());
//		fileWriter.append(NEW_LINE_SEPARATOR);
//		for (Certificate c: certificates)		{
//			fileWriter.append(String.valueOf(c.getTrainingID()));
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(String.valueOf(c.getIssueDate()));
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(String.valueOf(c.getExpirationDate()));
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(String.valueOf(c.getEmployeeId())); //waar is deze functie??
//			fileWriter.append(COMMA_DELIMITER);
//			fileWriter.append(String.valueOf(c.getArchive()));
//			fileWriter.append(NEW_LINE_SEPARATOR);
//		}
//		System.out.println("CVS file of Certificates was created succesfully");
//		} catch (Exception e)
//		{
//			System.out.println("Error in CsvFileWriter");
//			e.printStackTrace();
//		} finally 
//		{
//			try {
//				fileWriter.flush();
//				fileWriter.close();
//			} catch (IOException e) {
//				System.out.println("Error while flushing/closing fileWriter");
//				e.printStackTrace();
//			}
//		}		
//	}

}

//testcode:
//BackupCsv backup = new BackupCsv();
//try {
//	backup.usersCSV();
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}