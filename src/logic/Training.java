package logic;
import java.util.ArrayList;



public class Training {

	private int trainingID;
	private String title;
	private String subject;
	private String language;
	private String responsible;
	private int sequentiality;
	private int certificateID;
	private ArrayList<Book> books;
	private ArrayList<Employee> studentsEnrolled;
	
	// getters & setters
	public int getTrainingID() {
		return trainingID;
	}
	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public int getSequentiality() {
		return sequentiality;
	}
	public void setSequentiality(int sequentiality) {
		this.sequentiality = sequentiality;
	}
	public int getCertificate() {
		return certificateID;
	}
	public void setCertificate(int certificate) {
		this.certificateID = certificate;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public ArrayList<Employee> getStudentsEnrolled() {
		return studentsEnrolled;
	}
	public void setStudentsEnrolled(ArrayList<Employee> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	
	// constructors
	public Training(int trainingID, String title, String subject, String language, String responsible,
			int sequentiality, int certificate, ArrayList<Book> books,
			ArrayList<Employee> studentsEnrolled) {
		super();
		this.trainingID = trainingID;
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sequentiality = sequentiality;
		this.certificateID = certificate;
		this.books = books;
		this.studentsEnrolled = studentsEnrolled;
	}
	
	public Training() {
		
	}
// toString
	@Override
	public String toString() {
		return "Training [trainingID=" + trainingID + ", title=" + title + ", subject=" + subject + ", language="
				+ language + ", responsible=" + responsible + ", sequentiality=" + sequentiality + ", certificate="
				+ certificateID + ", books=" + books + ", studentsEnrolled=" + studentsEnrolled + "]";
	}
	
	// methoden
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addStudent(Employee employee) {
		studentsEnrolled.add(employee);
	}
/*	
	// send email to do
	public void sendEmail(String message, username) {
		System.Out.Println("verzender: ");
		System.Out.println("ontvanger: ");
		System.Out.println("onderwerp: ");
		
	
	
		
		
	
	public void Training aanmaken() {
	
		
		
		
		
		
		
		
		
		}
		*/
		
	}
	

	

	
	
	
	
	
	
	
	
	
	

