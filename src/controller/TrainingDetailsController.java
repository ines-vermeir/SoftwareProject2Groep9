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
import db.SurveyDB;
import db.TrainingDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import logic.Location;
import logic.Session;
import logic.Survey;
import logic.Training;
import logic.Training.Language;

public class TrainingDetailsController  implements Initializable{

	@FXML private Button back;
	@FXML private Button update;



	@FXML private DatePicker addDate;

	@FXML private ChoiceBox<String> addStartHour;
	@FXML private ChoiceBox<String> addStartMin;
	@FXML private ChoiceBox<String> addEndHour;
	@FXML private ChoiceBox<String> addEndMin;
	@FXML private ChoiceBox<String> AmPmStart;
	@FXML private ChoiceBox<String> AmPmEnd;
	@FXML private ChoiceBox<String> LanguageTraining;
	@FXML private ChoiceBox<Survey> survey;
	
	@FXML private TextField Streetname;
	@FXML private TextField Number;
	@FXML private TextField City;
	@FXML private TextField PostalCode;
	@FXML private TextField Country;
	@FXML private TextField nameLoc;
	@FXML private TextArea ExtraInfo;
	@FXML private TextField titleTraining;
	@FXML private TextField subjectTraining;
	@FXML private TextField teacherTraining;

	@FXML private ComboBox existLoc;
	
	@FXML private Label sessionId;
	@FXML private Label errorMsg;
	@FXML private Label trainingId;

	@FXML private ImageView locationField;

	@FXML private ScrollPane errorPane;

	@FXML private GridPane SessionPane;
	
	@FXML private TableView<Session> sessionTable;
	@FXML private TableColumn <Session, Integer> sesionIdCol;
	@FXML private TableColumn <Session, String> dateCol;
	@FXML private TableColumn <Session, String> starttimeCol;
	@FXML private TableColumn <Training, String> endtimeCol;

	


	@FXML protected void toAllTraining() {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}


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
		if (checkhours == false) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Hours are not valid!\n");
			check = false;
		}

		if ( checkLocation(e) == true ) {
			if(existLoc.getValue().equals("Existing Location")) {
				Location l = new Location(Streetname.getText(),Number.getText(),PostalCode.getText(),City.getText(),Country.getText(), nameLoc.getText() , ExtraInfo.getText() ,0 );
				LocationDB ldb = new LocationDB();
				lid = ldb.insertLocation(l); 
			}
			else {
				lid = Integer.parseInt(idLocString);
			}
		}
		if (check == true ) {
			try {
//				//Session s = new Session (t.getTrainingID(), cal, startTime , endTime, lid, deel, teachers, studentsEnrolled, studentsPresent );
//				sdb.insertSession(s);
//
//				List numberSessions = sdb.getAllSessionsOfTrainingID(t.getTrainingID());
//				if (t.getSessions() > numberSessions.size()) {
//					deel = numberSessions.size();
//					Navigator.loadVista(Navigator.AddSessionView);
////					Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
//				}
//				else {
//					toAllTraining();
//				}
			}

			catch (Exception e1) {

				e1.printStackTrace();
				errorPane.setVisible(true);
				errorMsg.setText("Oops, something went wrong.");
			}

		}
	}


	public boolean checkLocation(ActionEvent e) {

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
		}
		return check;
	}

	public void updateFunct() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		SessionDB sdb = new SessionDB();
		TrainingDB tdb = new TrainingDB();
		LocationDB ldb = new LocationDB();
		Training t = TrainingController.trainingRow;
		List<Session> s  = sdb.getAllSessionsOfTrainingID(t.getTrainingID());
		
		errorPane.setVisible(false);
		SessionPane.setVisible(false);
		
		trainingId.setText(Integer.toString(t.getTrainingID()));
		titleTraining.setText(t.getTitle());
		LanguageTraining.setItems(FXCollections.observableArrayList("Chinese","English", "Spanish", "Arabic", "Russian", "Portuguese" , "French","Japanese","German","Italien", "Dutch"));
		LanguageTraining.setValue(t.getLanguage().toString());
		teacherTraining.setText(t.getResponsible());
		subjectTraining.setText(t.getSubject());
		
		if (s != null) {
			ObservableList<Session> sessions = FXCollections.observableArrayList(s);


			sesionIdCol.setCellValueFactory(new PropertyValueFactory<Session, Integer>("sessionID"));
			dateCol.setCellValueFactory(new PropertyValueFactory<Session, String>("date"));
			starttimeCol.setCellValueFactory(new PropertyValueFactory<Session, String>("startTime"));
			endtimeCol.setCellValueFactory(new PropertyValueFactory<Training, String>("endTime"));

			FilteredList<Session> filteredSession= new FilteredList<>(sessions, p -> true);
			SortedList<Session> ses = new SortedList<>(filteredSession);
			ses.comparatorProperty().bind(sessionTable.comparatorProperty());								
			sessionTable.setItems(ses);
		}
		
		sessionTable.setRowFactory( sessionClick -> {
		    TableRow<Session> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		            Session sessionRow = row.getItem();
		            Session sesShow = sdb.getSessionByID(sessionRow.getSessionID());
		            SessionPane.setVisible(true);
		            
		            sessionId.setText(Integer.toString(sesShow.getSessionID()));
		            addStartHour.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12"));		            
		            int first = sesShow.getStartTime().toString().indexOf("");
					int last = sesShow.getStartTime().toString().indexOf(":");
					String startHours = sesShow.getStartTime().toString().substring(first, last);
		    		addStartHour.setValue(startHours);
		    		
		    		addStartMin.setItems(FXCollections.observableArrayList("00","05","10","15","20","25", "30","35", "40","45","50","55"));
		    		first = sesShow.getStartTime().toString().indexOf(":");
					last = sesShow.getStartTime().toString().indexOf("M");
					String startMin = sesShow.getStartTime().toString().substring(first+1, last-1);
		    		addStartMin.setValue(startMin);
		    		
		    		AmPmStart.setItems(FXCollections.observableArrayList("AM","PM"));
					String ampmstart = sesShow.getStartTime().toString().substring(last-1);
		    		AmPmStart.setValue(ampmstart);

		    		addEndHour.setItems(FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12"));    		 
		    		first = sesShow.getEndTime().toString().indexOf("");
					last = sesShow.getEndTime().toString().indexOf(":");
					String endHours = sesShow.getEndTime().toString().substring(first, last);
		    		addEndHour.setValue(endHours);
		    		
		    		addEndMin.setItems(FXCollections.observableArrayList("00","05","10","15","20","25", "30","35", "40","45","50","55"));
		    		first = sesShow.getEndTime().toString().indexOf(":");
					last = sesShow.getEndTime().toString().indexOf("M");
					String endMin = sesShow.getEndTime().toString().substring(first+1, last-1);
		    		addEndMin.setValue(endMin);
		    		
		    		AmPmEnd.setItems(FXCollections.observableArrayList("AM","PM"));
		    		String ampmend = sesShow.getEndTime().toString().substring(last-1);
		    		AmPmEnd.setValue(ampmend);
		    		
		    		//addDate.setValue(sesShow.getDate()); --> to local date
		    		
		    		Location place = ldb.getLocationById(sesShow.getLocationID());
		    	
		    		if (place != null) {
		    		Streetname.setText(place.getStreetName());
					Number.setText(place.getNumber());
					PostalCode.setText(place.getPostalCode());
					City.setText(place.getCity());
					Country.setText(place.getCountry());
					ExtraInfo.setText(place.getInfo());
					nameLoc.setText(place.getName());
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
		        }
		        }
		    });
		    return row ;
		});


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
		
		SurveyDB surveydb = new SurveyDB();
		survey.setItems(FXCollections.observableArrayList(surveydb.getAllSurveys()));
	}

}
