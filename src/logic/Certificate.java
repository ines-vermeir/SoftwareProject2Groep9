/**
 * 
 */
package logic;

import java.util.Date;
//
///**
// * @author Charles
// * import logic.Training		// --> to be activated when class Training is ready, and change of code?  27/10/2017
// */
public class Certificate {

	int ID;
	Date issueDate;			// should this be a string as in the diagram?
	Date expirationDate;
	int trainingID;
//	/**
//	 * @param args
//	 */
	Certificate(int ID, Date issueDate, Date expirationDate, int trainingID){
		this.ID = ID;
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.trainingID = trainingID;
	}
	
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
