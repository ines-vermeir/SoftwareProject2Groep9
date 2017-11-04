import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Location  {
		public int ID;
		public String streetName;
		public String number;
		public String postalCode;
		public String city;
		public String country;
		public String name;
		public String info;
		
		public Location(int ID, String streetName, String number, String postalCode, String city, String country, String name, String info) {
			super();
			this.ID = ID;
			this.streetName = streetName;
			this.number = number;
			this.postalCode = postalCode;
			this.city = city;
			this.country = country;
			this.name = name;
			this.info = info;
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
		@Override
		public String toString() {
			return "Location [ID=" + ID + ", streetName=" + streetName + ", number=" + number + ", postalCode=" + postalCode
					+ ", city=" + city + ", country=" + country + ", name=" + name + ", addInfo=" + info
					+ "]";
		}

		public void changeStreetName () {
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
				/* l.updateLocation(l); --> DAO*/
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
			/* locatie verwijderen vanuit sessie klasse en locationDAO*/
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
		    Location l = new Location (1/*id bepaald door db*/, input[0], input[1], input[2],input[3],input[4],input[5], input[6]);
		    l.toString();
		    /* addLocation in db */
		    return l;
		}
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


	

