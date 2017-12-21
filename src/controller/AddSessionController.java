package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import application.Navigator;
import db.LocationDB;
import db.SessionDB;
import db.TrainingDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import logic.Location;
import logic.Session;
import logic.Training;

public class AddSessionController  implements Initializable{

	@FXML private Button save;
	@FXML private Button back;
	@FXML private Button addSession;
	@FXML private Button checkLoc;
	@FXML private Button clear;

	@FXML private Label part;

	@FXML private DatePicker addDate;

	@FXML private ChoiceBox<String> addStartHour;
	@FXML private ChoiceBox<String> addStartMin;
	@FXML private ChoiceBox<String> addEndHour;
	@FXML private ChoiceBox<String> addEndMin;
	@FXML private ChoiceBox<String> AmPmStart;
	@FXML private ChoiceBox<String> AmPmEnd;

	@FXML private TextField Streetname;
	@FXML private TextField Number;
	@FXML private TextField City;
	@FXML private TextField PostalCode;
	@FXML private TextField Country;
	@FXML private TextField nameLoc;
	@FXML private TextArea ExtraInfo;

	@FXML private ComboBox existLoc;

	@FXML private Label errorMsg;
	@FXML private Label trainingId;

	@FXML private ImageView locationField;

	@FXML private ScrollPane errorPane;


	static int deel;

	@FXML protected void toAddTraining(ActionEvent e) {
		Navigator.loadVista(Navigator.AddTrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	@FXML protected void toAddSession() {
		Navigator.loadVista(Navigator.AddSessionView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}
	@FXML protected void toAllTraining() {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML protected void clearAll() {
		Navigator.loadVista(Navigator.AddSessionView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	TrainingDB tdb = new TrainingDB();
	Training t = tdb.getTraining(addTrainingController.id);
	private String idLocString;

	@FXML protected void saveSession(ActionEvent e) {

		errorPane.setVisible(false);
		errorMsg.setText("");
		SessionDB sdb = new SessionDB();
		String startTime = null,endTime= null;
		LocalDate date;
		LocalDate dateNow = LocalDate.now();
		Calendar cal = null;
		int lid = 1;
		List<String> teachers = new ArrayList<String>();
		List<Integer> studentsEnrolled = new ArrayList<Integer>();
		List<Integer> studentsPresent = new ArrayList<Integer>();
		boolean check = true;


		if ((addDate.getValue()!= null)) { 
			if (addDate.getValue().isAfter(dateNow)){
				date = addDate.getValue();

				cal = Calendar.getInstance();
				cal.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth());

			}
			else {
				errorPane.setVisible(true);
				errorMsg.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Date is not valid!\n");
				check = false;
			}

		}	 else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Date is not valid!\n");
			check = false;

		}



		boolean checkhours = false;
		if (AmPmStart.getValue() == AmPmEnd.getValue()) {
			if (Integer.parseInt(addStartHour.getValue()) < Integer.parseInt(addEndHour.getValue())) {
				checkhours = true;
			}
		} 
		if ( AmPmStart.getValue() == "AM" && AmPmEnd.getValue() == "PM") {
			checkhours = true;
		} 
		if (checkhours == true) {
			startTime =  (addStartHour.getValue() + ":" + addStartMin.getValue() + AmPmStart.getValue());
			endTime =  (addEndHour.getValue() + ":" + addEndMin.getValue() + AmPmEnd.getValue());
		}
		System.err.println("test1");
		if (checkhours == false) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Hours are not valid!\n");
			System.err.println("test2");
			check = false;
		}

		if ( checkLocation() == true ) {
			if(existLoc.getValue().equals("Existing Location")) {
				Location l = new Location(Streetname.getText(),Number.getText(),PostalCode.getText(),City.getText(),Country.getText(), nameLoc.getText() , ExtraInfo.getText() ,0 );
				LocationDB ldb = new LocationDB();
				lid = ldb.insertLocation(l); 
			}
			else {
				lid = Integer.parseInt(idLocString);
			}
		}
		else {
			check = false;
		}
		if (check == true ) {
			try {
				Session s = new Session (t.getTrainingID(), cal, startTime , endTime, lid, deel+1, teachers, studentsEnrolled, studentsPresent );
				sdb.insertSession(s);

				List numberSessions = sdb.getAllSessionsOfTrainingID(t.getTrainingID());
				if (t.getSessions() > numberSessions.size()) {
					deel = numberSessions.size();
					Navigator.loadVista(Navigator.AddSessionView);
					Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
				}
				else {
					toAllTraining();
				}
			}

			catch (Exception e1) {

				e1.printStackTrace();
				errorPane.setVisible(true);
				errorMsg.setText("Oops, something went wrong.");
			}

		}else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Can not add session.");
		}
	}


	public boolean checkLocation() {

		LocationDB ldb = new LocationDB();
		boolean check = true;
		Location place = new Location();
		if (existLoc.getValue().equals("Existing Location")) {
			if (Streetname.getText()!= null && !Streetname.getText().isEmpty()) {
				place.setStreetName(Streetname.getText());
			}	 else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Streetname is empty!\n");
				check = false;
			}
			if ((City.getText() != null && !City.getText().isEmpty())) {
				place.setCity(City.getText());
			} else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "City is empty!\n");
				check = false;
			}
			if ((Number.getText() != null && !Number.getText().isEmpty() )) {
				place.setNumber(Number.getText());
			}  else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Number is empty!\n");
				check = false;
			}
			if ((PostalCode.getText() != null && !PostalCode.getText().isEmpty() )) {
				place.setPostalCode(PostalCode.getText());
			}else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Postal Code is empty!\n");
				check = false;
			}
			if ((Country.getText() != null && !Country.getText().isEmpty() )) {
				place.setCountry(Country.getText());
			}else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Country is empty!\n");
				check = false;
			}
		}
		else {
			int first = existLoc.getValue().toString().indexOf("ID=");
			int last = existLoc.getValue().toString().indexOf(",");

			idLocString = existLoc.getValue().toString().substring(first+3, last);
			place = ldb.getLocationById(Integer.parseInt(idLocString));

			Streetname.setText(place.getStreetName());
			Number.setText(place.getNumber());
			PostalCode.setText(place.getPostalCode());
			City.setText(place.getCity());
			Country.setText(place.getCountry());
			ExtraInfo.setText(place.getInfo());
			nameLoc.setText(place.getName());

		}
		if (check == true ) {

			try {
				String parsedAddress = place.getStreetName().replaceAll("\\s+","+") + "+" + place.getNumber() + "," + place.getPostalCode() + "," + place.getCity() + "," + place.getCountry();

				int width =(int) locationField.getFitWidth();
				int height =(int) locationField.getFitHeight();

				Image map = new Image("https://maps.googleapis.com/maps/api/staticmap?zoom=14"
						+ "&center=" + parsedAddress
						+ "&size=" + width + "x" + height
						+ "&markers=color:red%7Clabel:A%7C" + parsedAddress
						+ "&key=AIzaSyBNGYCltDm0bAbk0OWAkD1Mi7VXbat_vIc");

				locationField.setImage(map);
			}
			catch (Exception e1) {
				errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
			}
			return true;
		}
		else {
		return false;
		}
	}

	public void addLocation() {

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//		SessionDB sdb = new SessionDB();
		//		TrainingDB tdb = new TrainingDB();
		//		Training t = tdb.getTraining(addTrainingController.id);
		
		errorPane.setVisible(false);
		addStartHour.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12"));
		addStartHour.setValue("12");
		addStartMin.setItems(FXCollections.observableArrayList("00","05","10","15","20","25", "30","35", "40","45","50","55"));
		addStartMin.setValue("00");
		AmPmStart.setItems(FXCollections.observableArrayList("AM","PM"));
		AmPmStart.setValue("AM");

		addEndHour.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12"));
		addEndHour.setValue("12");
		addEndMin.setItems(FXCollections.observableArrayList("00","05","10","15","20","25", "30","35", "40","45","50","55"));
		addEndMin.setValue("00");
		AmPmEnd.setItems(FXCollections.observableArrayList("AM","PM"));
		AmPmEnd.setValue("AM");

		part.setText(Integer.toString(deel+1));
		
		trainingId.setText(Integer.toString(t.getTrainingID()));

		LocationDB ldb = new LocationDB();

		existLoc.setItems(FXCollections.observableArrayList(ldb.getAllLocations()));

		Callback<ListView<Location>, ListCell<Location>> call = lv -> new ListCell<Location>() {
			@Override
			public void updateItem (Location o, boolean empty) {
				super.updateItem(o, empty);
				setText(o== null ? "" : o.toString());
			}
		};

		existLoc.setCellFactory(call);
		existLoc.setButtonCell(call.call(null));
		existLoc.setValue("Existing Location");
		String tId = Integer.toString(addTrainingController.id);
		trainingId.setText(tId);

	}

}
