/**
 * 
 */
package logic;
// begin addition
import java.util.Calendar;
// end addition
import java.util.Date;
// begin addition
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// end addition
//
///**
// * testing connection
// *
// * @author Charles
// * import logic.Training		// --> to be activated when class Training is ready, and change of code?  27/10/2017
									// hou het maar zo, de informatie van training kan dan opgevraagd worden via getTraining (Eva)
// */
// begin addition
//prosthesi
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;


@Entity

@Table(name="Certificates")
// end addition
// original line: public class Certificate {
public class Certificate implements Serializable {
	
// begin addition
	private static final long serialVersionUID = 5573786716243569738L;
	@Id @Column(name="ID") @GeneratedValue(strategy=GenerationType.IDENTITY) //reactivated18-12--13:45
	private int ID;//reactivated18-12--13:45
	@Id
	@Column(name="trainingID")
	private int trainingID;
	@Column(name="issueDate")
	private Calendar issueDate;			// should this be a string as in the diagram?
	@Column(name="expirationDate")
	private Calendar expirationDate;
	@Id
	@Column(name="employeeID")		// --> to be added to active file
	private String employeeID;			// --> to be added to active file
	@Column(name="archive")
	private int archive;
// end addition
	//original line: int ID;
	//original line:Date issueDate;			// should this be a string as in the diagram?
	//original line:Date expirationDate;
	//original line:int trainingID;
//	/**
//	 * @param args
//	 */
	
	// begin original section --> A
	//Certificate(int ID, Date issueDate, Date expirationDate, int trainingID){
	//	this.ID = ID;
	//	this.issueDate = issueDate;
	//	this.expirationDate = expirationDate;
	//	this.trainingID = trainingID;
	//}
	
	//public String toString() {
	//	return "Certificate ID: " + this.ID + ", Issue Date: " 
	//			+ this.issueDate + ", Valid until: " + this.expirationDate 
	//			+ ", Training Information: " + this.trainingID;
	//}
	// end original section --> A
	// begin new section --> A
	Certificate(int ID, int trainingID, Calendar issueDate, Calendar expirationDate, String employeeID ){
		super();
		this.ID = ID; //reactivated18-12--13:45
		this.trainingID = trainingID;
		this.issueDate = issueDate;
		this.expirationDate = expirationDate;
		this.employeeID = employeeID;
		this.archive = 0;
	}
	Certificate(int trainingID, Calendar issueDate, Calendar expirationDate, String employeeID ){
		this.issueDate = issueDate;
		this.employeeID = employeeID;
		this.expirationDate = expirationDate;
		this.trainingID = trainingID;
		this.archive = 0;
	}
	// end new section --> A
	// begin addition
	/*public Certificate(Certificate addCertificate) {
	super();
	ID = addCertificate.ID;
	trainingID = addCertificate.trainingID;
	issueDate = addCertificate.issueDate;
	expirationDate = addCertificate.expirationDate;
	employeeID = addCertificate.employeeID;
}*/
	// begin addition
	public int getArchive() {
		return archive;
	}
	
	public void setArchive(int archive) {
		this.archive = archive;
	}
	
	public Certificate() {
		super();
	}
	// end addition
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Calendar getIssueDate() { // switched 'Date' to 'Calendar' -->>18-12 13:45h
		return issueDate;
	}

	public void setIssueDate(Calendar issueDate) { // switched 'Date' to 'Calendar' -->>18-12 13:45h
		this.issueDate = issueDate;
	}

	public Calendar getExpirationDate() { // switched 'Date' to 'Calendar' -->>18-12 13:45h
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {  // switched 'Date' to 'Calendar' -->>18-12 13:45h
		this.expirationDate = expirationDate;
	}

	public int getTrainingID() {
		return trainingID;
	}

	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}
// begin addition
	@Override
	public String toString() {
		return "Certificate ID: " /*+ this.ID */+ ", Employee ID: " + this.employeeID + ", Issue Date: " 
				+ this.issueDate + ", Valid until: " + this.expirationDate 
				+ ", Training Information: " + this.trainingID;
	}	
// end addition	
	
	// begin commented additions
	/*
	public void changeIssueDate () {
	System.out.println("What is the new issue date: ");
	Date input;			//String
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	try {
		input = br.next();
		issueDate = input;
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}
	System.out.println(getIssueDate());
	saveUpdate();
	}*/
	/*
	public void changeEmployeeID () { 
	System.out.println("What is the new employee ID: ");
	String input;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	try {
		input = br.readLine();
		number = input;
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}
	System.out.println(getEmployeeID());
	saveUpdate();
	}*/

	/*
	public void changeExpirationDate () { 
	System.out.println("What is the new expiration date: ");
	Date input;		// String
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	try {
		input = br.read();
		expirationDate = input;
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}
	System.out.println(getExpirationDate());
	saveUpdate();
	}*/
		
	/*	
	public void changeTrainingID () {
	System.out.println("What is the new training ID: ");
	int input;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	try {
		input = br.nextInt();
		trainingID = input;
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}
	System.out.println(getTrainingID());
	saveUpdate();
	}*/

		/*
	public void saveUpdate() {
	String input;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	do {
	System.out.println("Save(Y/N): ");
	try {
		input = br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
		return;
	}
	input = input.toUpperCase();
	}while (!input.equals("Y") && !input.equals("N"));

	switch (input) {
	case "Y": 
		System.out.println("SUCCESSFULLY UPDATED");
		break;
	case "N":
		System.out.println("UPDATE DELETED");
		break;
	default:
		System.out.println("ERROR: no update");
		break;
	}
	}
	*/

		/*
	public void deleteCertificate() {

	}
	*/
		
	/*	
	public Certificate addCertificate() {
	String[] questions = new String[]{"What is the employee ID: ","What is the issue date: ", "What is the expiration date: ", "What is the training ID: "};
	String[] input = new String[questions.length];
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	for (int i=0; i < questions.length; i++) {
	try {
		System.out.println(questions[i]);
		input[i] = br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	Certificate c = new Certificate (, input[0], input[1], input[2],input[3],input[4]);
	c.toString();
	// addCertificate in db 
	return c;
	}
	//telos prosthesi


	/*public static void main (String args[]) {
	/*Certificate c = new Certificate (1, "12/05/2012", "15/08/2018", "1703");*/
	/* test change functies
	 
		System.out.println(c.toString());
	c.changeEmployeeID();
	c.changeIssueDate();
	c.changeExpirationDate();
	c.changeTrainingID();
	*/

	/*test add functie
	Certificate c2 = new Certificate (c.addCertificate());
	System.out.println(c.toString());
	System.out.println(c2.toString());*/
	
	// end commented additions
}
