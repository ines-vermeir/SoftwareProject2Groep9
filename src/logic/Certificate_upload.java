package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="Certificates_upload")
@Table(name="Certificates_upload")
public class Certificate_upload {
	
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="certificateID")
	    private int certificateID;
	 
	    @Column(name="employeeID")
	    private int employeeID;
	 
	    @Column(name="title")
	    private String title;
	    
	    @Column(name="file")
	    private byte[] file;

	    public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	    
		public Certificate_upload(int certificateID, int employeeID, byte[] file) {
			super();
			this.certificateID = certificateID;
			this.employeeID = employeeID;
			this.file = file;
		}
		
		public Certificate_upload(int employeeID, String title, byte[] file) {
			super();
			this.employeeID = employeeID;
			this.title = title;
			this.file = file;
		}
		
		public Certificate_upload() {
			super();
		}

		public int getCertificateID() {
			return certificateID;
		}

		public void setCertificateID(int certificateID) {
			this.certificateID = certificateID;
		}

		public int getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}

		public byte[] getFile() {
			return file;
		}

		public void setFile(byte[] file) {
			this.file = file;
		}
	
}

//code om pdf in database te saven

//File file = new File("C:\\Users\\evabo\\OneDrive\\Documenten\\test_certificaat.pdf");
//byte[] bFile = new byte[(int) file.length()];
//
//try {
//  FileInputStream fileInputStream = new FileInputStream(file);
//  fileInputStream.read(bFile);
//  fileInputStream.close();
//} catch (Exception e) {
//  e.printStackTrace();
//}
//
//Certificate_upload cu = new Certificate_upload();
//cu.setEmployeeID(123);
//cu.setFile(bFile);
//
//Certificate_uploadDB db = new Certificate_uploadDB();
//db.insertCertificate_upload(cu);
//
	
	
	//code om pdf uit database te halen
	
//	Certificate_uploadDB db = new Certificate_uploadDB();
//	Certificate_upload cu = db.getCertificate_upload(1);   
//
//try{
//  FileOutputStream fos = new FileOutputStream("C:\\Users\\evabo\\OneDrive\\Documenten\\test_certificaat2.pdf");
//  fos.write(cu.getFile());
//  fos.close();
//}catch(Exception e){
//  e.printStackTrace();
//}
