package logic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {
	
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
