package controller;
import java.net.URL;
import java.util.ResourceBundle;

import db.CertificateDB;
import db.Certificate_uploadDB;
import db.SessionDB;
import db.TrainingDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import logic.Certificate;
import logic.Certificate_upload;
import logic.Session;
import logic.Students_enrolled_in_session;
import logic.Training;

public class ChartController implements Initializable {
	 @FXML
	    private BarChart<?, ?> chart;

	    @FXML
	    private NumberAxis  y;

	    @FXML
	    private CategoryAxis x;
        
	    @FXML
	    private PieChart piechart;
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			XYChart.Series series = new XYChart.Series<>();
			Certificate_uploadDB db = new Certificate_uploadDB(); 
			
			
			
			for(Certificate_upload c: db.getAllCertificate_uploads()) {
				
					series.getData().add(new XYChart.Data(Integer.toString(c.getEmployeeID()), db.getCertificatesByEmployee(c.getEmployeeID()).size()));
				
				
				
			}
			
			chart.getData().addAll(series);
			
		/*	
			//Pie chart 
			
			ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
					);
			
			SessionDB session = new SessionDB();
			TrainingDB training = new TrainingDB();

			
			for(Session s : session.getAllSessions()) {
			
			for(Students_enrolled_in_session st: session.getAllEmployeesInSession()) {
				 
				if(st.getSessionID() == s.getSessionID()) {
						pieData.add(new PieChart.Data(Integer.toString(s.getTrainingID()),session.getAllSessionsByEmployeeId(st.getEmployeeIDenrolled()).size()));
						
					
			
				   
					
				
				}
				}
				
				
			
			
			piechart.setData(pieData);
			
		}
	*/
}}
