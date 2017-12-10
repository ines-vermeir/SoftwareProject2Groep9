package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;

import db.TestJackson;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import logic.BookGoogleAPI;

public class BookController implements Initializable{

	
	@FXML
	private TreeTableView<BookGoogleAPI> list;
	
	@FXML
	private TextField input;
	
	@FXML
	private ChoiceBox chosenTraining;
	

		
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
		
		ArrayList<BookGoogleAPI> books = null;
		//Here searchBook implementeren, voorlopig zo om te testen
		books = (ArrayList<BookGoogleAPI>) TestJackson.getBooksByContent("php programming");
		
       for(BookGoogleAPI book : books) {
			
			bookList.add(book);
		}
       final TreeItem<BookGoogleAPI> root = new TreeItem<BookGoogleAPI>();
		
		for(BookGoogleAPI  b:   bookList ) {
			TreeItem<BookGoogleAPI> item = new TreeItem<>(b);
			root.getChildren().add(item);
			
		}
		
	  list.getColumns().setAll(isbn,title,price,author,date,desc);	
	  list.setRoot(root);
	  list.setShowRoot(false);
	}
	
}
