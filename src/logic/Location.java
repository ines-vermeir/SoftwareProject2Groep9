package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
@Entity

@Table(name="Locations")

public class Location  {
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		public int ID;
		@Column(name="streetName")
		public String streetName;
		@Column(name="number")
		public String number;
		@Column(name="postalCode")
		public String postalCode;
		@Column(name="city")
		public String city;
		@Column(name="country")
		public String country;
		@Column(name="name")
		public String name;
		@Column(name="addInfo")
		public String info;
		@Column(name="archive")
		public int archive;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + archive;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((info == null) ? 0 : info.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((number == null) ? 0 : number.hashCode());
			result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
			result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
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
			Location other = (Location) obj;
			if (archive != other.archive)
				return false;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			if (info == null) {
				if (other.info != null)
					return false;
			} else if (!info.equals(other.info))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (number == null) {
				if (other.number != null)
					return false;
			} else if (!number.equals(other.number))
				return false;
			if (postalCode == null) {
				if (other.postalCode != null)
					return false;
			} else if (!postalCode.equals(other.postalCode))
				return false;
			if (streetName == null) {
				if (other.streetName != null)
					return false;
			} else if (!streetName.equals(other.streetName))
				return false;
			return true;
		}



		public Location(int ID, String streetName, String number, String postalCode, String city, String country, String name, String info, int archive) {
			super();
			this.ID = ID;
			this.streetName = streetName;
			this.number = number;
			this.postalCode = postalCode;
			this.city = city;
			this.country = country;
			this.name = name;
			this.info = info;
			this.archive = archive;
		}
		
		
		
		public Location(String streetName, String number, String postalCode, String city, String country, String name,
				String info, int archive) {
			super();
			this.streetName = streetName;
			this.number = number;
			this.postalCode = postalCode;
			this.city = city;
			this.country = country;
			this.name = name;
			this.info = info;
			this.archive = archive;
		}



		public Location() {
			super();
		}


		public Location(Location addLocation) {
			super();
			ID = addLocation.ID;
			streetName = addLocation.streetName;
			number = addLocation.number;
			postalCode = addLocation.postalCode;
			city = addLocation.city;
			country = addLocation.country;
			name = addLocation.name;
			info = addLocation.info;
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
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
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
		public String getInfo() {
			return info;
		}
		public void setInfo(String addInfo) {
			this.info = addInfo;
		}
		
		public int getArchive() {
			return archive;
		}

		public void setArchive(int archive) {
			this.archive = archive;
		}


		@Override
		public String toString() {
			return "Location [ID=" + ID + ", streetName=" + streetName + ", number=" + number + ", postalCode=" + postalCode
					+ ", city=" + city + ", country=" + country + ", name=" + name + ", addInfo=" + info
					+ "]";
		}

		/*public void changeStreetName () {
			System.out.println("What is the new streetName: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				streetName = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getStreetName());
			saveUpdate();
		}
		public void changeNumber () { 
			System.out.println("What is the new number: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				number = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getNumber());
			saveUpdate();
		}
		public void changePostalCode () { 
			System.out.println("What is the new postal code: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				postalCode = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getPostalCode());
			saveUpdate();
		}
		public void changeCity () {
			System.out.println("What is the new city: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				city = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getCity());
			saveUpdate();
		}
		public void changeCountry () {
			System.out.println("What is the new country: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				country = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getCountry());
			saveUpdate();
		}
		public void changeName () {
			System.out.println("What is the new name: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				name = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getName());
			saveUpdate();
		}
		public void changeInfo () {
			System.out.println("What is the new info: ");
			String input;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		    try {
				input = br.readLine();
				info = input;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			System.out.println(getInfo());
			saveUpdate();
		}
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
	
		public void deleteLocation() {
			// locatie verwijderen vanuit sessie klasse en locationDAO
		}
		
		public Location addLocation() {
			String[] questions = new String[]{"What is the streetName: ","What is the number: ", "What is the new postal code: ", "What is the city: ", "What is the country: ","What is the name: ","What is the info: " };
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
		    Location l = new Location (, input[0], input[1], input[2],input[3],input[4],input[5], input[6]);
		    l.toString();
		    // addLocation in db 
		    return l;
		}
*/
}
		
		/*public static void main (String args[]) {
			/*Location l = new Location (	1, "Plankenveld", "23", "1703", "Schepdaal", "België", "Huis", "0");*/
			/* test change functies
			 
		 	System.out.println(l.toString());
			l.changeStreetName();
			l.changeNumber();
			l.changePostalCode();
			l.changeCity();
			l.changeCountry();
			l.changeName();
			l.changeInfo();*/
			
			/*test add functie
			Location l2 = new Location (l.addLocation());
			System.out.println(l.toString());
			System.out.println(l2.toString());*/


	

