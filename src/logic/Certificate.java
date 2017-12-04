/**
 * 
 */
package logic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//
///**
// * @author Charles
// * import logic.Training		// --> to be activated when class Training is ready, and change of code?  27/10/2017
									// hou het maar zo, de informatie van training kan dan opgevraagd worden via getTraining (Eva)
// */

@Entity

@Table(name="Certificates")

public class Certificate {

	@Id @Column(name="ID") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name="issueDate")
	private Date issueDate;			// should this be a string as in the diagram?
	@Column(name="expirationDate")
	private Date expirationDate;
	@Column(name="trainingID")
	private int trainingID;
	@Column(name="archive")
	private int archive;
	
//	/**
//	 * @param args
//	 */
	Certificate(int ID, Date issueDate, Date expirationDate, int trainingID){
		this.ID = ID;
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.trainingID = trainingID;
		this.archive = 0;
	}
	
	public int getArchive() {
		return archive;
	}
	
	public void setArchive(int archive) {
		this.archive = archive;
	}
	
	public Certificate() {
		super();
	}
	
	@Override
	public String toString() {
		return "Certificate ID: " + this.ID + ", Issue Date: " 
				+ this.issueDate + ", Valid until: " + this.expirationDate 
				+ ", Training Information: " + this.trainingID;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}

}
