package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;

import application.Navigator;
import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import logic.BookGoogleAPI;
import logic.BookTraining;
import logic.Training;

public class BookOverviewController implements Initializable{

	
	
	
	@FXML
	private Button linkB; 
	
	@FXML
	private TreeTableView<BookTraining> list;
	
	
	@FXML
	protected void toNewLink(ActionEvent e) {
		Navigator.loadVista(Navigator.BookView);
	   Navigator.loadMenuVista(Navigator.MenuBookActiveView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
				JFXTreeTableColumn<BookTraining,String> isbn = new JFXTreeTableColumn("ISBN");
				isbn.setPrefWidth(150);

				isbn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(param.getValue().getValue().getIsbn());
						return simple;
					}

					
			   });
				
				
				JFXTreeTableColumn<BookTraining,String> trainingID = new JFXTreeTableColumn("Training ID");
				trainingID.setPrefWidth(250);

				trainingID.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(Integer.toString(param.getValue().getValue().getTrainingID()));
						return simple;
					}

					
			   });
				
				JFXTreeTableColumn<BookTraining,String> trainingTitle = new JFXTreeTableColumn("Training title");
				trainingTitle.setPrefWidth(250);

				trainingTitle.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(param.getValue().getValue().getTitleTraining());
						return simple;
					}

					
			   });
				
				
				
				
				JFXTreeTableColumn<BookTraining,String> title = new JFXTreeTableColumn("Title Book");
				title.setPrefWidth(180);

				title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(param.getValue().getValue().getTitleBook());
						return simple;
					}

					
			   });
				
				

				list.getColumns().setAll(isbn,trainingID,trainingTitle,title);	
			
				
				
			
				
				TrainingDB trainingDB = new TrainingDB();
				TestJackson bookDB = new TestJackson();
				
				ObservableList<BookTraining> tList = FXCollections.observableArrayList();
			    final TreeItem<BookTraining> root= new TreeItem<BookTraining>();
				
			    ArrayList<BookTraining> bookTrainings = (ArrayList<BookTraining>) trainingDB.getBooksTrainings();
			     
			    for (BookTraining b:bookTrainings ) {
			    	tList.add(b);
			    }
			    
			    for(BookTraining b : tList) {
			    	TreeItem<BookTraining> item = new TreeItem<>(b);
			    	
			    	root.getChildren().add(item);
				}
			    
			    
				
				
			    list.setRoot(root);
			     list.setShowRoot(false);	
		
				
				
			
				
		
	}

}
