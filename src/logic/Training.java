package logic;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import java.util.Scanner;

@Entity


@Table(name="Training")
public class Training {
	@Id	
	private int trainingID;
	private String title;
	private String subject;
	private String language;
	private String responsible;
	private int sequentiality;
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
			int sequentiality, ArrayList<Book> books,
			ArrayList<Employee> studentsEnrolled) {
		super();
		this.trainingID = trainingID;
		this.title = title;
		this.subject = subject;
		this.language = language;
		this.responsible = responsible;
		this.sequentiality = sequentiality;
		this.books = books;
		this.studentsEnrolled = studentsEnrolled;
	}
	
	public Training() {
		
	}
// toString
	@Override
	public String toString() {
		return "Training [trainingID=" + trainingID + ", title=" + title + ", subject=" + subject + ", language="
				+ language + ", responsible=" + responsible + ", sequentiality=" + sequentiality + ", books=" + books + ", studentsEnrolled=" + studentsEnrolled + "]";
	}
	
	// methoden
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addStudent(Employee employee) {
		studentsEnrolled.add(employee);
	}

	
	
	public void menuTraining(){
		
		System.out.println("MENU training");
		System.out.println("Wat wilt u doen?");
		System.out.println("1) trainingen bekijken");
		System.out.println("2) training aanmaken");
		
		Scanner scan = new Scanner(System.in);
		int user_input_number = scan.nextInt();
	
	
	
		switch (user_input_number) {
		case 1: trainingBekijken();
				break;
		case 2: trainingAanmaken();
				break;
		default: System.out.println("U heeft foutieve invoer ingegeven");
				menuTraining();
				break;

		}
	}
		

	

public  void trainingBekijken() {
	// get limited info	(id subject #students enrolled )
	
	
	
	

	
	
	}

public  void trainingAanmaken() {
	
/*	
	String title, String subject, String language, String responsible,
	int sequentiality, ArrayList<Book> books,
	ArrayList<Employee> studentsEnrolled) 
	
	*/
	// int user_input_number = scan.nextInt(); int 
	
	
Scanner scan = new Scanner(System.in);

System.out.print("What is the title?");
String title = scan.nextLine();

System.out.print("What is the Subject?");
String subject = scan.nextLine();

System.out.print("What is the language?");
String language = scan.next();

System.out.print("Who is the responsible?");
String responsible = scan.nextLine();  

System.out.print("What is the sequentiality?");
int sequentiality = scan.nextInt();

	// select alle employees welke wilt u toeveogen?
	
	
	
	
	
	
	
	
	
	
}


}
	
	
	
	
	
	
	
	
	
	

