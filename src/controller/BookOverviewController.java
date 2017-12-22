package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;

import application.Navigator;
import db.TestJackson;
import db.TrainingDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import logic.BookGoogleAPI;
import logic.BookTraining;
import logic.Training;

public class BookOverviewController implements Initializable{

	
	
	
	@FXML
	private Button linkB; 
	@FXML
	private Button deleteB; 
	@FXML
    private Label feedback;
	 String message="";
	@FXML
	private TreeTableView<BookTraining> list;
	
	@FXML
	private TreeItem<BookTraining> chosenBook = null;
	
	@FXML
	protected void toNewLink(ActionEvent e) {
		Navigator.loadVista(Navigator.BookView);
	   Navigator.loadMenuVista(Navigator.MenuBookActiveView);
	}
	TrainingDB trainingDB = new TrainingDB();
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
			
				deleteB.setOnAction(new EventHandler<ActionEvent>() {
			           
					
					@Override
					public void handle(ActionEvent arg0) {
						message="";
					      
						if(chosenBook==null) {
							
							message="Please choose the link you wish to delete";
							feedback.setText(message);
						
						}else {
							
						   if(trainingDB.deleteBook(chosenBook.getValue())>0) {
							   message="The link has successfully been deleted";
								feedback.setText(message);
							
						   }
						   Navigator.loadVista(Navigator.BookOverview);
						   Navigator.loadMenuVista(Navigator.MenuBookActiveView);
						
							
						}
								
							
								
								
					}	
					        	
				            
				        });
				
				
				
				  
				  list.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent arg0) {
						// TODO Auto-generated method stub
						chosenBook = list.getSelectionModel().getSelectedItem();
						
					}
					  
					  
					  
				  });
				 
			   
				
				
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
