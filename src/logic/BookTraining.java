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

	@Override
	public String toString() {
		return "BookTraining [trainingID=" + trainingID + ", isbn=" + isbn + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + trainingID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookTraining other = (BookTraining) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (trainingID != other.trainingID)
			return false;
		return true;
	}

	public BookTraining(int trainingID, String isbn) {
		super();
		this.trainingID = trainingID;
		this.isbn = isbn;
	}
	
	

}
