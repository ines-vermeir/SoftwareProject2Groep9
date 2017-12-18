package controller;

import java.net.URL;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import logic.BookGoogleAPI;
import logic.BookTraining;

public class BookOverviewController implements Initializable{

	
	
	
	@FXML
	private Button linkB; 
	
	@FXML
	private TableView listBooks;
	private TrainingDB trainingDB = new TrainingDB();
	private TestJackson bookDB = new TestJackson();
	
	@FXML
	protected void toNewLink(ActionEvent e) {
		Navigator.loadVista(Navigator.BookView);
	   Navigator.loadMenuVista(Navigator.MenuBookActiveView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		/*
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
						simple.setValue(trainingDB.getTraining(param.getValue().getValue().getTrainingID()).getTitle().toString());
						return simple;
					}

					
			   });
				JFXTreeTableColumn<BookTraining,String> author = new JFXTreeTableColumn("Author(s)");
				author.setPrefWidth(150);

				author.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						
						List<String> list= bookDB.getBookByISBN(param.getValue().getValue().getIsbn()).getAuthors();
						
						for(String s: list) {
							simple.setValue(s +" ");
						}
						
						return simple;
					}

					
			   });
				
				
				JFXTreeTableColumn<BookTraining,String> date = new JFXTreeTableColumn("Published date");
				date.setPrefWidth(180);

				date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(bookDB.getBookByISBN(param.getValue().getValue().getIsbn()).getPublishedDate());
						return simple;
					}

					
			   });
				JFXTreeTableColumn<BookTraining,String> title = new JFXTreeTableColumn("Title Book");
				title.setPrefWidth(180);

				title.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(bookDB.getBookByISBN(param.getValue().getValue().getIsbn()).getTitle());
						return simple;
					}

					
			   });
				
				
				
				
				
				JFXTreeTableColumn<BookTraining,String> price = new JFXTreeTableColumn("Price");
				price.setPrefWidth(100);

				price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BookTraining, String>, ObservableValue<String>>() {
			          
					
					@Override
					public ObservableValue<String> call(CellDataFeatures<BookTraining, String> param) {
						SimpleStringProperty simple = new SimpleStringProperty();
						simple.setValue(Double.toString(bookDB.getBookByISBN(param.getValue().getValue().getIsbn()).getPrice()));
						return simple;
					}

					
			   });
				
				*/
				ObservableList<BookTraining> bookList = FXCollections.observableArrayList();
				final TreeItem<BookTraining> root= new TreeItem<BookTraining>();
				
				
				//listBooks.getColumns().setAll(isbn,trainingID,trainingTitle,title,price,author,date);	
		/*		listBooks.setRoot(root);
				listBooks.setShowRoot(false);	
		*/
		
	}

}
