package logic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Deze annotation is voor uw klasse/tabel op uw database
@Entity
//@Table(name="") wordt gebruikt als de naam van de klasse en de naam van de table op de database anders is
@Table(name="Books")
public class Book {
	//Deze annotation is voor uw primary key
    @Id	
	private String isbn;
	private String title; 
	private String author;
	private  Calendar releaseDate;
	
	public Book(String isbn, String title, String author,Calendar releaseDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}
   
//Voor Hibernate moet je voorzien van een default constructor
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public  Calendar  getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", releaseDate=" +  myFormat.format(releaseDate.getTime()) + "]";
	}
	
	

}
