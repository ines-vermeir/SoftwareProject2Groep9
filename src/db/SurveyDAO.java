package db;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Survey;

public class SurveyDAO extends BaseDAO{

	public SurveyDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean addSurvey(Survey survey) throws SQLException, Exception{
		boolean succesvol1 = false; 
		PreparedStatement p = null; 
		String sql= "INSERT INTO Surveys VALUES(?,?)"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1,survey.getSurveyID());
			p.setInt(2,survey.getTrainingsID());
	
			if (p.executeUpdate() == 0){
				succesvol1 = true;
			} 
			
			boolean succesvol2 = addSurveyQuestions(survey);
			
				if (succesvol1 && succesvol2 == true)
					return true;
				else
					return false;
		
		}finally{
			try{
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
			}
		}
	}
	

	public boolean addSurveyQuestions(Survey survey) throws SQLException, Exception{
		boolean successvol = false;
		PreparedStatement p = null; 
		String sql= "INSERT INTO Survey_questions VALUES(?,?)";
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			
			for(int i = 0; i < survey.getMyListSurveysQuestions().size();i++) {	
				p= getConnection().prepareStatement(sql); 
				p.setInt(1,survey.getSurveyID());
				//p.setString(2,survey.getMyListSurveysQuestions().get(i));
			}
			
			if (p.executeUpdate() == 0){
				successvol = true;
			} 
				return successvol;
		}finally{
			try{
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
			}
		}	
	}
	
	public boolean deleteSurvey(int surveyID) throws SQLException, Exception{
		boolean succesvol1 = false; 
		PreparedStatement p = null; 
		String sql= "DELETE FROM Surveys where surveyID=?"; 
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1, surveyID);
		
			
			if (p.executeUpdate() == 0){
				succesvol1 = true;
			} 
			
			boolean succesvol2 = deleteSurveyQuestions( surveyID);
			
			if (succesvol1 && succesvol2 == true)
				return true;
			else
				return false;
				
		}finally{
			try{
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
				}
			}
		}
	
	
	public boolean deleteSurveyQuestions(int surveyID) throws SQLException, Exception{
		boolean successvol1 = false; 
		PreparedStatement p = null; 
		String sql= "DELETE FROM Survey_questions where surveyID=?"; 
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1, surveyID);
				
			if (p.executeUpdate() == 0){
				successvol1 = true;
			} 
			
			return successvol1;
			
		}finally{
			try{
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
				}
			}
		}
	
	
	public Survey getSurveyByID(int surveyID) throws SQLException, Exception{ 
		Survey s = new Survey();
		s.setSurveyID(surveyID);
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			if(getConnection().isClosed()){
			throw new Exception("error");
		}
		ps = getConnection().prepareStatement("select * from Surveys where surveyID=?");
		ps.setInt(1, surveyID);
		
		rs = ps.executeQuery();		
		rs.next();	
			
		s.setSurveyID(rs.getInt(1));
		s.setTrainingsID(rs.getInt(2));
		
		
		ArrayList<String> questions = new ArrayList<String>();
		questions = getAllQuestions( surveyID);
		
		Survey s_compleet = new Survey(s.getSurveyID(),s.getTrainingsID(),questions);
		
		return s_compleet;
	
		}finally{
			try{
			if( ps != null){
				ps.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
				}
			}
		}
	
	
	
	public ArrayList<String> getAllQuestions(int surveyID) throws SQLException, Exception{	
	String question = null;
	PreparedStatement p = null;
	ResultSet r = null;
	
	String sql= "SELECT question FROM Survey_questions WHERE surveyID = ?";
	ArrayList<String> questions = new ArrayList<String>();
	
	try {
		if (getConnection().isClosed()) {
			throw new Exception ("error");
	}
	p = getConnection().prepareStatement(sql);
	p.setInt(1,surveyID);
	r = p.executeQuery();
	
	while(r.next()) {
		question = new String (r.getString("question"));
		questions.add(question);
	}
	return questions;
	} finally {
		try {
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
			}
		}	

	}
	

	public ArrayList<Survey> getAllSurveys() throws SQLException, Exception{
		Statement stm = null; 
		ResultSet r = null; 
		String sql = "SELECT * FROM Surveys";
		ArrayList<Survey> myListSurveys = new ArrayList<Survey>();
		ArrayList<String> questions = new ArrayList<String>();
		ArrayList<Survey> myListSurveysComplete = new ArrayList<Survey>();
		
		Survey survey = null;
		
		try{
			if(getConnection().isClosed()){
				 throw new Exception("error");
			}
			stm = getConnection().createStatement(); 
			r = stm.executeQuery(sql);
			
			while(r.next()){
				
				
				try {
				survey = new Survey(r.getInt(1), r.getInt(2));
				}catch(Exception e){
					System.out.println("fout");
				}
				myListSurveys.add(survey);
				
				 questions =getAllQuestions(survey.getSurveyID());
				 Survey s_compleet = new Survey(survey.getSurveyID(),survey.getTrainingsID(),questions);
				 myListSurveysComplete.add(s_compleet);	
			}
		return myListSurveysComplete;
		
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(r != null){
					r.close();
				}
				
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("fout");
			}
		}
}
	
	
	// werkt nog niet
	public ArrayList<Survey> getAllSurveysbytrainingID(int trainingID) throws SQLException, Exception{
		Statement stm = null; 
		ResultSet r = null; 
		String sql = "SELECT * FROM Surveys WHERE trainingID=?";
		ArrayList<Survey> myListSurveys = new ArrayList<Survey>();
		Survey survey = null;
	
		try{
			if(getConnection().isClosed()){
				 throw new Exception("error");
			}
	
			stm = getConnection().createStatement(); 
			r = stm.executeQuery(sql);
					
			while(r.next()){
				try {
				survey = new Survey(r.getInt(1), r.getInt(2));
				}catch(Exception e){
					System.out.println("fout");
				}
				myListSurveys.add(survey);
			}
		return myListSurveys;
		
		}finally{
			try{
				if(stm != null){
					stm.close();
				}
				if(r != null){
					r.close();
				}	
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("fout");
			}
		}
	}
	
	// PAS OOK (nog) SURVEYQUESTIONS AAN !!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public boolean update(Survey s)	throws SQLException, Exception{
		boolean successvol = false;
		PreparedStatement p = null; 
		
		String sql= "UPDATE Surveys SET surveyID = ?, trainingID = ?"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1, s.getSurveyID());
			p.setInt(2, s.getTrainingsID());
		
			if (p.executeUpdate() == 0){
				successvol = true;
			} 
			return successvol;
		
		}finally{
			try{
			if( p != null){
				p.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("error");
			}
		}	
	}
	
	
	/*
	public boolean updateQuestions(Survey s) throws SQLException, Exception{
	boolean successvol = false;
	PreparedStatement p = null;
	
	String sql= "UPDATE Survey_questions SET surveyID = ?, question = ?"; 
	try{
		if(getConnection().isClosed() ){
			throw new Exception("fout"); 
		}
		p= getConnection().prepareStatement(sql); 
		
		
	}
	*/
	
	
	public boolean deleteQuestionBySID(int surveyID,String question) throws SQLException, Exception{
		boolean successvol = false;
		PreparedStatement p = null;
		String sql= "DELETE FROM Survey_questions where surveyID=? AND question=?"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
		p= getConnection().prepareStatement(sql); 
		p.setInt(1, surveyID);
		p.setString(2, question);
			
		if (p.executeUpdate() == 0){
			successvol = true;
		} 
		return successvol;
		
	}finally{
		try{
		if( p != null){
			p.close();
		}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			throw new RuntimeException("error");
				}
			}
		}
	}
		
