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
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.ColorPicker;
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
import javafx.util.Callback;
import logic.Employee;
import logic.Location;
import logic.Session;
import logic.Survey;
import logic.Training;
import logic.Training.Language;
import javafx.scene.paint.*;

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

	@FXML private TableView<logic.Session> sessionTable;
	@FXML private TableColumn <logic.Session, Integer> sesionIdCol;
	@FXML private TableColumn <logic.Session, String> dateCol;
	@FXML private TableColumn <logic.Session, String> starttimeCol;
	@FXML private TableColumn <logic.Training, String> endtimeCol;
	@FXML private TableColumn <logic.Training, String> partCol;


	@FXML protected void toAllTraining() {
		Navigator.loadVista(Navigator.TrainingView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML protected void addNewSesFunct() {
		TrainingDB tdb = new TrainingDB();
		SessionDB sdb = new SessionDB();
		Training t = tdb.getTraining(Integer.parseInt(trainingId.getText()));
		t.setSessions(t.getSessions()+1);
		tdb.updateTraining(t);
		addTrainingController.id = Integer.parseInt(trainingId.getText());
		List<logic.Session> sesions = sdb.getAllSessionsOfTrainingID(addTrainingController.id);
		controller.AddSessionController.deel = sesions.size();

		Navigator.loadVista(Navigator.AddSessionView);
		Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
	}

	@FXML protected void deleteSes() {
		errorMsg.setVisible(false);
		try {
			logic.Session s = sessionTable.getSelectionModel().getSelectedItem();
			int part = s.getPart();
			SessionDB sdb = new SessionDB();
			TrainingDB tdb = new TrainingDB();
			Training t = tdb.getTraining(s.getTrainingID());
			List<logic.Session> sessions = sdb.getAllSessionsOfTrainingID(Integer.parseInt(trainingId.getText()));
			System.err.println(sessions.size());
			if (sessions.size() > 1) {
				for (int i = part; i < sessions.size(); i++) {
					System.out.println("Dit is " + i);
					System.out.println("hahahaah" + sessions.size());
					System.out.println(sessions.get(i).getSessionID());
					sessions.get(i).setPart(i);
					sdb.updateSession(sessions.get(i));
				}
			t.setSessions(t.getSessions()-1);
			tdb.updateTraining(t);
			logic.Session ses = sdb.getSessionByID(s.getSessionID());
			//sdb.updateSession(s);
			sdb.archiveSession(ses);
			Navigator.loadVista(Navigator.TrainingDetailsView);
			Navigator.loadMenuVista(Navigator.MenuTrainingActiveView);
			}else {
				System.err.println(sessions.size());
				errorMsg.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "There must be at least one session.\n");
			}
		}
		catch(Exception ex) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "No session is deleted!\n");
		}
	}

	@FXML protected void deleteFunct() {
		try {
			TrainingDB tdb = new TrainingDB();
			
			System.err.println("voor delete");
			
			tdb.deleteTraining(tdb.getTraining(Integer.parseInt(trainingId.getText())));
			
			System.err.println("na delete");
			toAllTraining();
		}
		catch(Exception ex) {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Training is not deleted!\n");

		}
	}

	private String idLocString;
	boolean check = true;
	boolean checkLoc = true;
	db.SessionDB sdb = new SessionDB();
	String startTime = null,endTime= null;
	LocalDate date;
	LocalDate dateNow = LocalDate.now();
	Calendar cal = null;
	int lid = 1;
	@FXML protected void saveSession() {

		if ((addDate.getValue()!= null)) { 
			if (addDate.getValue().isAfter(dateNow)){
				date = addDate.getValue();

				cal = Calendar.getInstance();
				cal.set(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
			} else {
				errorPane.setVisible(true);
				errorMsg.setText(errorMsg.getText() + "Date is not valid!\n");
				check = false;
			}
		} else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Date is not valid!\n");
			check = false;
		}



		boolean checkhours = false;

		if (AmPmStart.getValue() == AmPmEnd.getValue()) {		
			if (Integer.parseInt(addStartHour.getValue()) < Integer.parseInt(addEndHour.getValue())) {
				checkhours = true;
				System.err.println("start:"+ AmPmStart.getValue());
				System.err.println("end:" + AmPmEnd.getValue());
				System.err.println("starHt:" + addStartHour.getValue());
				System.err.println("endH:"+ addEndHour.getValue());
			}
		} 

		else if ( AmPmStart.getValue() == "AM" && AmPmEnd.getValue() == "PM") {
			checkhours = true;
			System.err.println("start:"+ AmPmStart.getValue());
			System.err.println("end: " + AmPmEnd.getValue());
			System.err.println("starHt:" + addStartHour.getValue());
			System.err.println("endH:"+ addEndHour.getValue());
		}
		else {
			checkhours = false;
		}

		if (checkhours == true) {
			startTime =  (addStartHour.getValue() + ":" + addStartMin.getValue() + AmPmStart.getValue());
			endTime =  (addEndHour.getValue() + ":" + addEndMin.getValue() + AmPmEnd.getValue());
		}else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Hours are not valid!\n");
			check = false;
		}

		logic.Session newSes = new Session();
		newSes = sdb.getSessionByID(Integer.parseInt(sessionId.getText()));
		LocationDB ldb = new LocationDB();
		checkLocation();
		if ( checkLoc == true ) {
			//Location newLoc = new Location(Streetname.getText(), Number.getText(), PostalCode.getText(),City.getText(),Country.getText(), nameLoc.getText(), ExtraInfo.getText(),0);
			Location newLoc = ldb.getLocationById(newSes.getLocationID());
			lid = newLoc.getID();
			newLoc.setStreetName(Streetname.getText());
			newLoc.setNumber( Number.getText());
			newLoc.setPostalCode(PostalCode.getText());
			newLoc.setCity(City.getText());
			newLoc.setCountry(Country.getText());
			newLoc.setName(nameLoc.getText());
			newLoc.setInfo(ExtraInfo.getText());
			ldb.updateLocation(newLoc);
		} else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Adres is not valid!\n");
			check = false;
		}

	}


	public void checkLocation() {
		if (Streetname.getText()!= null && !Streetname.getText().isEmpty()) {
		}	 else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Streetname is empty!\n");
			checkLoc = false;
		}
		if ((City.getText() != null && !City.getText().isEmpty())) {
		} else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "City is empty!\n");
			checkLoc = false;
		}
		if ((Number.getText() != null && !Number.getText().isEmpty() )) {
		}  else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Number is empty!\n");
			checkLoc = false;
		}
		if ((PostalCode.getText() != null && !PostalCode.getText().isEmpty() )) {
		}else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Postal Code is empty!\n");
			checkLoc = false;
		}
		if ((Country.getText() != null && !Country.getText().isEmpty() )) {
		}else {
			errorPane.setVisible(true);
			errorMsg.setText(errorMsg.getText() + "Country is empty!\n");
			checkLoc = false;
		}
	}
	@FXML protected Training saveTraining() {

		TrainingDB tdb = new TrainingDB();
		String title = null,subject= null,teacher=null;

		if ((titleTraining.getText()!= null && !titleTraining.getText().isEmpty())) {
			title = titleTraining.getText();
		}	 else {
			errorMsg.setText(errorMsg.getText() + "Title is empty!\n");
			check = false;
		}
		if ((subjectTraining.getText() != null && !subjectTraining.getText().isEmpty())) {
			subject = subjectTraining.getText();
		} else {
			errorMsg.setText(errorMsg.getText() + "Subject is empty!\n");
			check = false;
		}
		if ((teacherTraining.getText() != null && !teacherTraining.getText().isEmpty() )) {
			teacher = teacherTraining.getText();
		}else {
			errorMsg.setText(errorMsg.getText() + "Teacher is empty!\n");
			check = false;
		}

		Training newtr = new Training();
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
		return newtr;
	}

	public void updateFunct() {
		check = true;
		errorMsg.setText("");
		db.SessionDB sdb = new SessionDB();
		TrainingDB tdb = new TrainingDB();
		Training saveTr = saveTraining();
		saveSession();
		System.err.println("0");
		try {
			if (check == true) {
				System.err.println("1");
				if (trainingId.getText() != null && !trainingId.getText().isEmpty()) {
					System.err.println("2");
					tdb.updateTraining(saveTr);
					System.err.println(saveTr.toString());
					System.err.println("3");
				}
				if (sessionId.getText() != null && !sessionId.getText().isEmpty()) {
					logic.Session saveSes = sdb.getSessionByID(Integer.parseInt(sessionId.getText()));
					System.err.println("4");
					System.err.println(saveSes.getLocationID());
					saveSes.setDate(cal);
					saveSes.setEndTime(endTime);
					saveSes.setStartTime(startTime);
					saveSes.setLocationID(lid);
					System.err.println(saveSes.getLocationID());
					saveSes.setArchive(0);
					System.err.println(saveSes.toString());
					sdb.updateSession(saveSes);
					System.err.println("5");
				}
				System.err.println("6");
				errorMsg.setVisible(true);
				errorMsg.setTextFill(javafx.scene.paint.Color.BLACK);
				errorMsg.setText(errorMsg.getText() + "Update succesfull!\n");
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
		db.SessionDB sdb = new SessionDB();
		LocationDB ldb = new LocationDB();
		locationField.setVisible(false);

		List<logic.Session> s  = sdb.getAllSessionsOfTrainingID(t.getTrainingID());

		errorMsg.setTextFill(javafx.scene.paint.Color.RED);
		SessionPane.setVisible(false);

		trainingId.setText(Integer.toString(t.getTrainingID()));
		titleTraining.setText(t.getTitle());
		LanguageTraining.setItems(FXCollections.observableArrayList("Chinese","English", "Spanish", "Arabic", "Russian", "Portuguese" , "French","Japanese","German","Italien", "Dutch"));
		LanguageTraining.setValue(t.getLanguage().toString());
		teacherTraining.setText(t.getResponsible());
		subjectTraining.setText(t.getSubject());

		if (s != null) {
			ObservableList<logic.Session> sessions = FXCollections.observableArrayList(s);


			sesionIdCol.setCellValueFactory(new PropertyValueFactory<logic.Session, Integer>("sessionID"));
			//dateCol.setCellValueFactory(new PropertyValueFactory<Session, LocalDate>("date"));
			dateCol.setCellValueFactory(new Callback<CellDataFeatures<logic.Session, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(CellDataFeatures<logic.Session, String> data) {
					Calendar cal = data.getValue().getDate();
					LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
					return new SimpleStringProperty(ld.toString());
				}
			});
			starttimeCol.setCellValueFactory(new PropertyValueFactory<logic.Session, String>("startTime"));
			endtimeCol.setCellValueFactory(new PropertyValueFactory<Training, String>("endTime"));
			partCol.setCellValueFactory(new PropertyValueFactory<Training, String>("part"));



			FilteredList<logic.Session> filteredSession= new FilteredList<>(sessions, p -> true);
			SortedList<logic.Session> ses = new SortedList<>(filteredSession);
			ses.comparatorProperty().bind(sessionTable.comparatorProperty());								
			sessionTable.setItems(ses);
		}

		sessionTable.setRowFactory( sessionClick -> {
			TableRow<logic.Session> row = new TableRow<logic.Session>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
					try {
						logic.Session sessionRow = row.getItem();
						logic.Session sesShow = sdb.getSessionByID(sessionRow.getSessionID());
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

						locationField.setVisible(true);
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
								errorMsg.setVisible(true);
								errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
							}
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
						errorMsg.setVisible(true);
						errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
					}
				}
			});
			return row;
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

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		existLoc.setVisible(false);
		Training t = TrainingController.trainingRow;
		fillAll(t);

		LocationDB ldb = new LocationDB();
		existLoc.valueProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue ov, Object oldLoc, Object newLoc) {
				try {
					if(!newLoc.toString().equals("Existing Location")) {
						int first = newLoc.toString().indexOf("ID=");
						int last = newLoc.toString().indexOf(",");

						String idLocString = newLoc.toString().substring(first+3, last);
						Location place = ldb.getLocationById(Integer.parseInt(idLocString));

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
							errorMsg.setVisible(true);
							errorMsg.setText(errorMsg.getText() + "Oops, something went wrong!\n");
						}
					}
				}
				catch (NullPointerException ex) {
					//System.out.println("error locatie weergeven");
				}

			}

		});


	}
}


