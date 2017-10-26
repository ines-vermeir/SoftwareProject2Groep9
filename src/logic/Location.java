package logic;

import java.util.Arrays;

public class Location {
	
	public int ID;
	public String streetName;
	public int number;
	public String postalCode;
	public String city;
	public String country;
	public String name;
	public String[] addInfo;
	
	public Location(int iD, String streetName, int number, String postalCode, String city, String country, String name,
			String[] addInfo) {
		super();
		ID = iD;
		this.streetName = streetName;
		this.number = number;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.name = name;
		this.addInfo = addInfo;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(String[] addInfo) {
		this.addInfo = addInfo;
	}
	@Override
	public String toString() {
		return "Location [ID=" + ID + ", streetName=" + streetName + ", number=" + number + ", postalCode=" + postalCode
				+ ", city=" + city + ", country=" + country + ", name=" + name + ", addInfo=" + Arrays.toString(addInfo)
				+ "]";
	}

	
}
