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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Location;
import logic.Session;
import logic.Training;

public class AddSessionController  implements Initializable{

	@FXML private Button save;
	@FXML private Button back;
	@FXML private Button addSession;
	@FXML private Button checkLoc;
	
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
	
	
	@FXML private Label errorMsg;
	@FXML private Label trainingId;
	
	@FXML private ImageView locationField;
	
	
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
	
	TrainingDB tdb = new TrainingDB();
	Training t = tdb.getTraining(addTrainingController.id);
	
	@FXML protected void saveSession(ActionEvent e) {
		
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
				 errorMsg.setText(errorMsg.getText() + "\nDate is not valid!");
				 check = false;
				 }
			 
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nDate is not valid!");
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
		  if (checkhours == false) {
				 errorMsg.setText(errorMsg.getText() + "\nHours are not valid!");
				 check = false;
			 }
		 
		  if ( checkLocation(e) == true ) {
				 Location l = new Location(Streetname.getText(),Number.getText(),PostalCode.getText(),City.getText(),Country.getText(), nameLoc.getText() , ExtraInfo.getText() ,0 );
				 LocationDB ldb = new LocationDB();
				 lid = ldb.insertLocation(l); 
				}
				else {
					check = false;
					errorMsg.setText(errorMsg.getText() + "\nAdress is not valid!");
				}
		 if (check == true ) {
			 try {
			 Session s = new Session (t.getTrainingID(), cal, startTime , endTime, lid, t.getSessions(), teachers, studentsEnrolled, studentsPresent );
			 sdb.insertSession(s);
			 
			 List numberSessions = (List) sdb.getAllSessionsOfTrainingID(t.getTrainingID());
			 if (t.getSessions()-1 < numberSessions.size()) {
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
				errorMsg.setText("Oops, something went wrong.");
			}
		 }
		
	}
	
	
	public boolean checkLocation(ActionEvent e) {
		
		boolean check = true;
		Location place = new Location();
		
		 if (Streetname.getText()!= null && !Streetname.getText().isEmpty()) {
			 place.setStreetName(Streetname.getText());
		 }	 else {
			 errorMsg.setText(errorMsg.getText() + "\nStreetname is empty!");
			 check = false;
		 }
		 if ((City.getText() != null && !City.getText().isEmpty())) {
				place.setCity(City.getText());
		 } else {
			 errorMsg.setText(errorMsg.getText() + "\nCity is empty!");
			 check = false;
		 }
		 if ((Number.getText() != null && !Number.getText().isEmpty() )) {
			 place.setNumber(Number.getText());
		 }  else {
			 errorMsg.setText(errorMsg.getText() + "\nNumber is empty!");
			 check = false;
		 }
		 if ((PostalCode.getText() != null && !PostalCode.getText().isEmpty() )) {
				place.setPostalCode(PostalCode.getText());
		 }else {
			 errorMsg.setText(errorMsg.getText() + "\nPostal Code is empty!");
			 check = false;
		 }
		 if ((Country.getText() != null && !Country.getText().isEmpty() )) {
				place.setCountry(Country.getText());
		 }else {
			 errorMsg.setText(errorMsg.getText() + "\nCountry Code is empty!");
			 check = false;
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
				 errorMsg.setText(errorMsg.getText() + "\nOops, something went wrong!");
			 }
		 }
		 return check;
	}
	
	public void addLocation() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
//		SessionDB sdb = new SessionDB();
//		TrainingDB tdb = new TrainingDB();
//		Training t = tdb.getTraining(addTrainingController.id);
//		int partsnr = t.getSessions(); 
		
		
		
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
		
		String tId = Integer.toString(addTrainingController.id);
		trainingId.setText(tId);
		
	}

}
