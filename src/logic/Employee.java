package logic;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String emails;
	private String addressInfo;
	private String gender;
	private String concurrency;
	
	public static void main(String[] args) {
		Employee Gill = new Employee("Gill", "Steens", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
		Employee Gill2 = new Employee("Eva", "Bouten", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
		Employee Gill3 = new Employee("Charles", "White", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );
		Employee Gill4 = new Employee("Ines", "Vermeire", "gillsteens@gmail.com", "Hollestraat 112 1500 Halle", "m", "concurrency" );

		System.out.println(Gill);
		System.out.println(Gill2);
		System.out.println(Gill3);
		System.out.println(Gill4);
	}
	
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
