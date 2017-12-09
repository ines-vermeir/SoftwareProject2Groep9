package logic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

//Om te testen heb ik de klasse Employee moeten aanpassen met de parameters van de Odata - Sebastian G
//@JsonIgnoreProperties(ignoreUnknown = true)


public class Employee {
	  public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
//	public String toString() {
//		return "Employee [employeeID=" + employeeID + ", lastName=" + lastName + ", firstName=" + firstName + ", title="
//				+ title + ", titleOfCourtesy=" + titleOfCourtesy + ", birthDate=" + birthDate + ", hireDate=" + hireDate
//				+ ", address=" + address + ", city=" + city + ", region=" + region + ", postalCode=" + postalCode
//				+ ", country=" + country + ", homePhone=" + homePhone + ", extension=" + extension + ", photo=" + photo
//				+ ", notes=" + notes + ", reportsTo=" + reportsTo + ", photoPath=" + photoPath + "]";
//	}

	
	  public String toString() {
			return "Employee [employeeID=" + employeeID + ", lastName=" + lastName + ", firstName=" + firstName + ", title="
					+ title + ", titleOfCourtesy=" + titleOfCourtesy + ", birthDate=" + birthDate + ", hireDate=" + hireDate
					+ ", address=" + address +"]";
		}
		
	
	private int employeeID; 
	  private String lastName; 
	  private String firstName; 
	  private String title; 
	  private String titleOfCourtesy; 
	  private String birthDate; 
	  private String hireDate; 
	  private String address; 
	  private String city; 
	  private String region; 
	  private String postalCode; 
	  private String country; 
	  private String homePhone; 
	  private String extension; 
	  private String photo; 
	  private String notes; 
	  private int reportsTo; 
	  private String photoPath; 

	  public int getEmployeeID(){
	  	return employeeID; 
	  }
	  public void setEmployeeID(int input){
	  	 this.employeeID = input;
	  }
	  public String getLastName(){
	  	return lastName; 
	  }
	  public void setLastName(String input){
	  	 this.lastName = input;
	  }
	  public String getFirstName(){
	  	return firstName; 
	  }
	  public void setFirstName(String input){
	  	 this.firstName = input;
	  }
	  public String getTitle(){
	  	return title; 
	  }
	  public void setTitle(String input){
	  	 this.title = input;
	  }
	  public String getTitleOfCourtesy(){
	  	return titleOfCourtesy; 
	  }
	  public void setTitleOfCourtesy(String input){
	  	 this.titleOfCourtesy = input;
	  }
	  public String getBirthDate(){
	  	return birthDate; 
	  }
	  public void setBirthDate(String input){
	  	 this.birthDate = input;
	  }
	  public String getHireDate(){
	  	return hireDate; 
	  }
	  public void setHireDate(String input){
	  	 this.hireDate = input;
	  }
	  public String getAddress(){
	  	return address; 
	  }
	  public void setAddress(String input){
	  	 this.address = input;
	  }
	  public String getCity(){
	  	return city; 
	  }
	  public void setCity(String input){
	  	 this.city = input;
	  }
	  public String getRegion(){
	  	return region; 
	  }
	  public void setRegion(String input){
	  	 this.region = input;
	  }
	  public String getPostalCode(){
	  	return postalCode; 
	  }
	  public void setPostalCode(String input){
	  	 this.postalCode = input;
	  }
	  public String getCountry(){
	  	return country; 
	  }
	  public void setCountry(String input){
	  	 this.country = input;
	  }
	  public String getHomePhone(){
	  	return homePhone; 
	  }
	  public void setHomePhone(String input){
	  	 this.homePhone = input;
	  }
	  public String getExtension(){
	  	return extension; 
	  }
	  public void setExtension(String input){
	  	 this.extension = input;
	  }
	  public String getPhoto(){
	  	return photo; 
	  }
	  public void setPhoto(String input){
	  	 this.photo = input;
	  }
	  public String getNotes(){
	  	return notes; 
	  }
	  public void setNotes(String input){
	  	 this.notes = input;
	  }
	  public int getReportsTo(){
	  	return reportsTo; 
	  }
	  public void setReportsTo(int input){
	  	 this.reportsTo = input;
	  }
	  public String getPhotoPath(){
	  	return photoPath; 
	  }
	  public void setPhotoPath(String input){
	  	 this.photoPath = input;
	  }
	  
	  
	  
	  
	  
	public Employee(int employeeID, String lastName, String firstName, String title, String titleOfCourtesy,
			String birthDate, String hireDate, String address, String city, String region, String postalCode,
			String country, String homePhone, String extension, String photo, String notes, int reportsTo,
			String photoPath) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.homePhone = homePhone;
		this.extension = extension;
		this.photo = photo;
		this.notes = notes;
		this.reportsTo = reportsTo;
		this.photoPath = photoPath;
	}
	  
	  
	  
	 
	  
	  


}
  


	
	/*
	
	private String firstName;
	private String lastName;
	private String emails;
	private String addressInfo;
	private String gender;
	private String concurrency;
	
//	public static void main(String[] args) {
//		Employee Gill = new Employee("Gill", "Steens", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
//		Employee Gill2 = new Employee("Eva", "Bouten", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
//		Employee Gill3 = new Employee("Charles", "White", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
//		Employee Gill4 = new Employee("Ines", "Vermeire", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
//
//		System.out.println(Gill);
//		System.out.println(Gill2);
//		System.out.println(Gill3);
//		System.out.println(Gill4);
//	}
	
	@Override
	public String toString() {
		return "Employee: \n" + "firstName = " + firstName + "\n" + "lastName = " + lastName + "\n" + "emails = " + emails + "\n" + "addressInfo = "
				+ addressInfo + "\n" + "gender = " + gender + "\n" + "concurrency = " + concurrency + "\n";
	}
	public Employee(String firstName, String lastName, String emails, String addressInfo, String gender,
			String concurrency) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emails = emails;
		this.addressInfo = addressInfo;
		this.gender = gender;
		this.concurrency = concurrency;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public String getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getConcurrency() {
		return concurrency;
	}
	public void setConcurrency(String concurrency) {
		this.concurrency = concurrency;
	}
	
	}
	
	*/
	


