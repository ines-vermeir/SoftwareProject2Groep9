package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.tree.TreeSelectionModel;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import logic.BookGoogleAPI;
import logic.Training;

public class BookController implements Initializable{

	
	@FXML
	private TreeTableView<BookGoogleAPI> list;
	
	@FXML
	private TextField input;
	
	@FXML
	private ComboBox trainingBox;
	
   @FXML
   private Button searchB; 
   
   @FXML
   private Button okB; 
   
   @FXML
   private Button backB; 
   
   @FXML
   private Label feedback;
   @FXML
	protected void toAll(ActionEvent e) {
		Navigator.loadVista(Navigator.BookOverview);
	   Navigator.loadMenuVista(Navigator.MenuBookActiveView);
	}
   private TreeItem<BookGoogleAPI> chosenBook=null;
   private String message = "";  

  public void populateTraining() {
	  ObservableList<Training> trainingList = FXCollections.observableArrayList();
	  
	  
	  TrainingDB db = new TrainingDB(); 
	  
	  
	  for(Training training : db.getAllTrainings()) {
			
			trainingList.add(training);
		}
	  
  }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//LIST BOEKEN
		JFXTreeTableColumn<BookGoogleAPI,String> isbn = new JFXTreeTableColumn("ISBN");
		isbn.setPrefWidth(150);

		isbn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getIndustryIdentifiers());
				return simple;
			}

			
	   });
		
		
		JFXTreeTableColumn<BookGoogleAPI,String> title = new JFXTreeTableColumn("Title");
		title.setPrefWidth(250);

		title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getTitle());
				return simple;
			}

			
	   });
		JFXTreeTableColumn<BookGoogleAPI,String> author = new JFXTreeTableColumn("Author(s)");
		author.setPrefWidth(150);

		author.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				for(String s: param.getValue().getValue().getAuthors()) {
					simple.setValue(s +" ");
				}
				
				return simple;
			}

			
	   });
		
		
		JFXTreeTableColumn<BookGoogleAPI,String> date = new JFXTreeTableColumn("Published date");
		date.setPrefWidth(180);

		date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getPublishedDate());
				return simple;
			}

			
	   });
		
		
		
		JFXTreeTableColumn<BookGoogleAPI,String> desc = new JFXTreeTableColumn("Description");
		desc.setPrefWidth(300);

		desc.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(param.getValue().getValue().getDescription());
				return simple;
			}

			
	   });
		
		
		
		
		JFXTreeTableColumn<BookGoogleAPI,String> price = new JFXTreeTableColumn("Price");
		price.setPrefWidth(100);

		price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookGoogleAPI, String>, ObservableValue<String>>() {
	          
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BookGoogleAPI, String> param) {
				SimpleStringProperty simple = new SimpleStringProperty();
				simple.setValue(Double.toString(param.getValue().getValue().getPrice()));
				return simple;
			}

			
	   });
		

		ObservableList<BookGoogleAPI> bookList = FXCollections.observableArrayList();
		final TreeItem<BookGoogleAPI> root= new TreeItem<BookGoogleAPI>();
		
	
	//Search button handler
	
		searchB.setOnAction(new EventHandler<ActionEvent>() {
           
			@Override
			public void handle(ActionEvent arg0) {
				//list.setRoot(null);
				ArrayList<BookGoogleAPI> books = null;
				for(int i=0; i< root.getChildren().size(); i++) {
					root.getChildren().clear();
				}
				
				bookList.clear();
				
				if ((input.getText() != null && !input.getText().isEmpty())) {
					
					feedback.setText(null);
					String zoek = input.getText();
					books = (ArrayList<BookGoogleAPI>) TestJackson.getBooksByContent(zoek);
					
				       for(BookGoogleAPI book : books) {
							
							bookList.add(book);
						}
				     
						
						for(BookGoogleAPI  b:   bookList ) {
							TreeItem<BookGoogleAPI> item = new TreeItem<>(b);
							root.getChildren().add(item);
							
						}
						
						input.clear();
						zoek = null; 
						input.setText(null);
						
						
						
			        	
		            
		        } else {
		          
		        	feedback.setText("Please type a topic and press search");
		      
		        }
		     }
				
			
			
			
			
			
			
			
		});
		
    		
		
		
		  list.getColumns().setAll(isbn,title,price,author,date,desc);	
		  list.setRoot(root);
		  list.setShowRoot(false);	
		  
		  //Handle treeview selection 
		  
		   
		  list.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				chosenBook = list.getSelectionModel().getSelectedItem();
				
			}
			  
			  
			  
		  });
		 
		  
		  //Choicebox trainingen
		  
		  
		  
		  
		  ObservableList<Training> trainingList = FXCollections.observableArrayList();
		  
		  
		  TrainingDB db = new TrainingDB(); 
		  
		  
		  for(Training training : db.getAllTrainings()) {
				
				trainingList.add(training);
			}
		  
		  
	   //  trainingBox.setValue(null);
		  trainingBox.setItems(trainingList);
		  
		  
		  //Link button okB
		 
		
		  okB.setOnAction(new EventHandler<ActionEvent>() {
			
			 
			@Override
			public void handle(ActionEvent arg0) {
				message="";
				
				boolean valid= true;
				
				feedback.setText("");
		
				if( trainingBox==null || trainingBox.getValue()==null || trainingBox.getSelectionModel().isEmpty() ||trainingBox.getSelectionModel().getSelectedItem()==null ) {
					message+="Please choose a training\n";
					valid = false;
					
				}
				
				if(chosenBook==null || chosenBook.getValue()==null || chosenBook.getValue().getIndustryIdentifiers().isEmpty()) {
					message+="Please search and select a book\n";
					valid =false;
			    }
				
				
			/*
			 
			 				if(trainingBox.getSelectionModel().isEmpty() ||trainingBox.getSelectionModel().getSelectedItem()==null  ||  chosenBook.getValue()==null) {
					message+="Please choose a training\nPlease search and select a book";
				
				
				}
				
				*/
				if(valid==true) {
					
					
					db.linkBook((Training)trainingBox.getValue(), chosenBook.getValue().getIndustryIdentifiers());
					message+="A link has succesfully been made\n";
					list.getRoot().getChildren().clear();
					trainingBox.getSelectionModel().clearSelection();
					chosenBook.setValue(null);
					trainingBox.setValue(null);
					
					
				}

				
				feedback.setText(message);
				
				list.getSelectionModel().clearSelection();
				trainingBox.getSelectionModel().clearSelection();
				
			}
			
			  
			  
			  
			  
			  
			  
		  });
		  
		  
		  
		  
		  
		  
		  
	}
	
}
