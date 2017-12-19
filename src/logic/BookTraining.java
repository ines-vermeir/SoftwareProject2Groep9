package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Training_books")
@Table(name="Training_books")
public class BookTraining implements Serializable{

	public BookTraining() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="trainingID")
	private int trainingID; 
	@Id
	@Column(name="isbn")
	private String isbn;
    
	@Column(name="titleTraining")
	private String titleTraining;

	@Column(name="titleBook")
	private String titleBook;


	public String getTitleTraining() {
		return titleTraining;
	}

	public void setTitleTraining(String titleTraining) {
		this.titleTraining = titleTraining;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public BookTraining(int trainingID, String isbn, String titleTraining, String titleBook) {
		super();
		this.trainingID = trainingID;
		this.isbn = isbn;
		this.titleTraining = titleTraining;
		this.titleBook = titleBook;
	}

	@Override
	public String toString() {
		return "BookTraining [trainingID=" + trainingID + ", isbn=" + isbn + ", titleTraining=" + titleTraining
				+ ", titleBook=" + titleBook + "]";
	}

	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	

}
