package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.sun.prism.paint.Color;

import application.Navigator;
import db.LocationDB;
import db.SessionDB;
import db.SurveyDB;
import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import logic.Employee;
import logic.Location;
import logic.Session;
import logic.Survey;
import logic.Training;
import logic.Training.Language;

public class TrainingDetailsController  implements Initializable{

	@FXML private Button back;
	@FXML private Button update;
	@FXML private Button addNewSes;
	@FXML private Button deleteSession;
	@FXML private Button delete;


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

	@SuppressWarnings("rawtypes")
	@FXML private ComboBox existLoc;

	@FXML private Label sessionId;
	@FXML private Label errorMsg;
	@FXML private Label trainingId;
	@FXML private Label partSes;

	@FXML private ImageView locationField;

	@FXML private ScrollPane errorPane;

	@FXML private GridPane SessionPane;

	@FXML private TableView<Session> sessionTable;
	@FXML private TableColumn <Session, Integer> sesionIdCol;
	@FXML private TableColumn <Session, String> dateCol;
	@FXML private TableColumn <Session, String> starttimeCol;
	@FXML private TableColumn <Training, String> endtimeCol;
	@FXML private TableColumn <Training, String> partCol;


	@FXML protected void toAllTraining() {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML protected void addNewSesFunct() {
		SessionDB sdb = new SessionDB();
		System.err.println(trainingId.getText());
		addTrainingController.id = Integer.parseInt(trainingId.getText());
		System.err.println(addTrainingController.id);
		List<Session> sesions = sdb.getAllSessionsOfTrainingID(addTrainingController.id);
		controller.AddSessionController.deel = sesions.size();

		Navigator.loadVista(Navigator.AddSessionView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML protected void deleteSes() {
		try {
			Session s = sessionTable.getSelectionModel().getSelectedItem();
			int part = s.getPart();
			SessionDB sdb = new SessionDB();
			TrainingDB tdb = new TrainingDB();
			Training t = tdb.getTraining(s.getTrainingID());
			List<Session> sessions = sdb.getAllSessionsOfTrainingID(Integer.parseInt(trainingId.getText()));
			for (int i = part; i < sessions.size(); i++) {
				sessions.get(i).setPart(i);
				sdb.updateSession(sessions.get(i));
			}
			t.setSessions(t.getSessions()-1);
			tdb.updateTrainingById(t.getTrainingID(), t);
			s.setArchive(1);
			sdb.updateSession(s);
			Navigator.loadVista(Navigator.TrainingDetailsView);
			Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
		}
		catch(Exception ex) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "No session is deleted!\n");

		}
	}

	@FXML protected void deleteFunct() {
		try {
			TrainingDB t = new TrainingDB();
			t.archiveTrainingById(Integer.parseInt(trainingId.getText()));
			toAllTraining();
		}
		catch(Exception ex) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Training is not deleted!\n");

		}
	}

	private String idLocString;

	@FXML protected Session saveSession() {

		errorPane.setVisible(false);
		errorMsg.setText("");

		SessionDB sdb = new SessionDB();
		String startTime = null,endTime= null;
		LocalDate date;
		LocalDate dateNow = LocalDate.now();
		Calendar cal = null;
		int lid = 11;
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
		else {
			checkhours = false;
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

//		if ( checkLocation() == true ) {
//			if(existLoc.getValue().equals("Existing Location")) {
//				Location l = new Location(Streetname.getText(),Number.getText(),PostalCode.getText(),City.getText(),Country.getText(), nameLoc.getText() , ExtraInfo.getText() ,0 );
//				LocationDB ldb = new LocationDB();
//				lid = ldb.insertLocation(l); 
//			}
//			else {
//				lid = Integer.parseInt(idLocString);
//			}
//		} else {
//			errorPane.setVisible(true);
//			errorMsg.setText(errorMsg.getText() + "Adres is not valid!\n");
//			check = false;
//		}

		Session newSes = new Session();
		if (check == true ) {
			newSes = sdb.getSessionByID(Integer.parseInt(sessionId.getText()));
			newSes.setDate(cal);
			newSes.setEndTime(endTime);
			newSes.setStartTime(startTime);
			newSes.setLocationID(lid);
			newSes.setArchive(0);
			return newSes;
		}
		else {
			check = false;
		}
		return newSes;
	}


//	public int checkLocation() {
//
//		LocationDB ldb = new LocationDB();
//		boolean check = true;
//		Location place = new Location();
//
//		if (existLoc.getValue().equals("Existing Location")) {
//			if (Streetname.getText()!= null && !Streetname.getText().isEmpty()) {
//				place.setStreetName(Streetname.getText());
//			}	 else {
//				errorPane.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "Streetname is empty!\n");
//				check = false;
//			}
//			if ((City.getText() != null && !City.getText().isEmpty())) {
//				place.setCity(City.getText());
//			} else {
//				errorPane.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "City is empty!\n");
//				check = false;
//			}
//			if ((Number.getText() != null && !Number.getText().isEmpty() )) {
//				place.setNumber(Number.getText());
//			}  else {
//				errorPane.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "Number is empty!\n");
//				check = false;
//			}
//			if ((PostalCode.getText() != null && !PostalCode.getText().isEmpty() )) {
//				place.setPostalCode(PostalCode.getText());
//			}else {
//				errorPane.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "Postal Code is empty!\n");
//				check = false;
//			}
//			if ((Country.getText() != null && !Country.getText().isEmpty() )) {
//				place.setCountry(Country.getText());
//			}else {
//				errorPane.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "Country is empty!\n");
//				check = false;
//			}
//		}
//		else {
//			int first = existLoc.getValue().toString().indexOf("ID=");
//			int last = existLoc.getValue().toString().indexOf(",");
//
//			idLocString = existLoc.getValue().toString().substring(first+3, last);
//			place = ldb.getLocationById(Integer.parseInt(idLocString));
//
//			Streetname.setText(place.getStreetName());
//			Number.setText(place.getNumber());
//			PostalCode.setText(place.getPostalCode());
//			City.setText(place.getCity());
//			Country.setText(place.getCountry());
//			ExtraInfo.setText(place.getInfo());
//			nameLoc.setText(place.getName());
//
//			return 2;
//		}
//		if (check == true ) {
//			try {
//				String parsedAddress = place.getStreetName().replaceAll("\\s+","+") + "+" + place.getNumber() + "," + place.getPostalCode() + "," + place.getCity() + "," + place.getCountry();
//
//				int width =(int) locationField.getFitWidth();
//				int height =(int) locationField.getFitHeight();
//
//				Image map = new Image("https://maps.googleapis.com/maps/api/staticmap?zoom=14"
//						+ "&center=" + parsedAddress
//						+ "&size=" + width + "x" + height
//						+ "&markers=color:red%7Clabel:A%7C" + parsedAddress
//						+ "&key=AIzaSyBNGYCltDm0bAbk0OWAkD1Mi7VXbat_vIc");
//
//				locationField.setImage(map);
//			}
//			catch (Exception e1) {
//				errorMsg.setVisible(true);
//				errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
//			}
//		}
//		//return check;
//	}
	@FXML protected Training saveTraining() {
		errorMsg.setText("");
		TrainingDB tdb = new TrainingDB();
		String title = null,subject= null,teacher=null;
		boolean check = true;

		if ((titleTraining.getText()!= null && !titleTraining.getText().isEmpty())) {
			title = titleTraining.getText();
		}	 else {
			errorMsg.setText(errorMsg.getText() + "\nTitle is empty!");
			check = false;
		}
		if ((subjectTraining.getText() != null && !subjectTraining.getText().isEmpty())) {
			subject = subjectTraining.getText();
		} else {
			errorMsg.setText(errorMsg.getText() + "\nSubject is empty!");
			check = false;
		}
		if ((teacherTraining.getText() != null && !teacherTraining.getText().isEmpty() )) {
			teacher = teacherTraining.getText();
		}else {
			errorMsg.setText(errorMsg.getText() + "\nTeacher is empty!");
			check = false;
		}

		Training newtr = new Training();
		if (check == true ) {
			try {
				newtr = tdb.getTraining(Integer.parseInt(trainingId.getText()));
				newtr.setLanguage(Language.valueOf(LanguageTraining.getValue()));
				newtr.setResponsible(teacher);
				newtr.setSubject(subject);
				newtr.setTitle(title);
				newtr.setArchive(0);
				return newtr;
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
		}
		return newtr;
	}

	public void updateFunct() {
		SessionDB sdb = new SessionDB();
		TrainingDB tdb = new TrainingDB();
		boolean checkTr = false;
		boolean checkSes = false;
		Training saveTr = saveTraining();
		try {
			if (trainingId.getText() != null && !trainingId.getText().isEmpty()) {
				if(!saveTr.getTitle().equals("")) {
					tdb.updateTraining(saveTr);
					checkTr = true;				
				}
			}
			if (sessionId.getText() != null && !sessionId.getText().isEmpty()) {
				Session saveSes = saveSession();
				if (!saveSes.getEndTime().equals("")) {
					sdb.updateSession(saveSes);
					checkSes = true;
				}
			}
			if (checkTr == true && checkSes == true) {
				fillAll(saveTr);
			}
			else {
				errorMsg.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Nothing was updated!\n");
			}
		}
		catch (Exception ex) {
			errorMsg.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
		}
	}

	
	@SuppressWarnings("unchecked")
	public void fillAll (Training t) {
		SessionDB sdb = new SessionDB();
		LocationDB ldb = new LocationDB();

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
			//dateCol.setCellValueFactory(new PropertyValueFactory<Session, LocalDate>("date"));
			dateCol.setCellValueFactory(new Callback<CellDataFeatures<Session, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<Session, String> data) {
					Calendar cal = data.getValue().getDate();
					LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
					return new SimpleStringProperty(ld.toString());
				}
			});
			starttimeCol.setCellValueFactory(new PropertyValueFactory<Session, String>("startTime"));
			endtimeCol.setCellValueFactory(new PropertyValueFactory<Training, String>("endTime"));
			partCol.setCellValueFactory(new PropertyValueFactory<Training, String>("part"));



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

					partSes.setText(Integer.toString(sesShow.getPart()));

					Calendar cal = sesShow.getDate();
					LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
					addDate.setValue(ld);

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

		//fill combobox with locations
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



	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Training t = TrainingController.trainingRow;
		fillAll(t);
	}
}


