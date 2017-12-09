package db;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;

// import com.mysql.jdbc.Statement;

import logic.Survey;
import logic.Training;
import logic.Question;
import logic.Answer;
import logic.Book;
import db.Singleton;
import db.BaseDAO;




import org.hibernate.SessionFactory;

public class SurveyDB { //extends BaseDAO{


	private SessionFactory myFactory= null;
//	private SessionFactory sessionFactory = null;
	
	
	public SurveyDB(){

		super();
      myFactory = SingletonHibernate.getSessionFactory();
	
		// TODO Auto-generated constructor stub
	}
	
	
public  void  addSurvey(Survey mySurvey) {
		
		Session session = myFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(mySurvey);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		//	sessionFactory.close();
		}
	}


// werkt niet
@SuppressWarnings("deprecation")
public  Survey  getSurvey1(int surveyID) {
	Survey s = null;
	Session session = myFactory.openSession();
	Transaction t = null;
	
	try {
		t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query = session.createNativeQuery("Select * from Survey_Surveys  WHERE surveyID = :surveyID",Survey.class).setParameter("surveyID", surveyID);
		s = (Survey) query.getSingleResult();
		
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}
		return s;
		
	}
	
	
// werkt
public Survey getSurvey(int surveyID) {
	 Survey sur = null;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		sur = (Survey) session.get(Survey.class,surveyID);
		t.commit();
		
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}
	
	return sur;
	
}


// werkt
public  void archiveSurvey(int surveyID) {	
	Survey sur = null;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		sur = (Survey) session.get(Survey.class,surveyID);
		sur.setArchive(1);

		 session.update(sur);
			t.commit();
		
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		//	sessionFactory.close();
		}	
	}


// werkt
public ArrayList<Survey> getAllSurveys(){
	
	   ArrayList<Survey> list = null;
	   Session session = myFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			
		    list = (ArrayList<Survey>) session.createCriteria(Survey.class).list();
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		//	sessionFactory.close();
		}	
		return list;
	}




// werkt niet
public void  updateSurvey(Survey mySurvey) {

	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.update(mySurvey);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}
	

}

//werkt 
public void updateSurveyById(int surveyID, Survey survey) {
	
	Survey  sur = null;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		sur = (Survey) session.get(Survey.class,surveyID);
		 
		int ID = sur.getSurveyID();
		session.delete(sur);
		sur =  survey;
		sur.setSurveyID(surveyID);
		session.save(sur);
		t.commit();
	
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
		}	
	}
}





///////////////////////////////////////////////////////////////////////////////////////////
//// werkt
//public List<Answer> getAllAnswersByid(int questionID) throws SQLException, Exception{	
//	List<Answer> answers= new ArrayList<Answer>();
//	
//PreparedStatement p = null;
//ResultSet r = null;
//
//String sql= "SELECT answer, total FROM Survey_Answers WHERE questionID= ?";
//
//
//try {
//	if (getConnection().isClosed()) {
//		throw new Exception ("error");
//}
//p = getConnection().prepareStatement(sql);
//p.setInt(1,questionID);
//r = p.executeQuery();
//
//while(r.next()) {
//	Answer answer = new Answer (r.getString("answer"),r.getInt("total"));
//	answers.add(answer);
//}
//return answers;
//} finally {
//	try {
//		if( p != null){
//			p.close();
//		}
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("error");
//		}
//	}	
//}
//
//
//
//
//
//
//// werkt  		
//public Survey getSurveyByID(int surveyID) throws SQLException, Exception{ 
//	Survey s = new Survey();
//	s.setSurveyID(surveyID);
//	
//	PreparedStatement ps = null;
//	ResultSet rs = null;
//	
//	try {
//		if(getConnection().isClosed()){
//		throw new Exception("error");
//	}
//	ps = getConnection().prepareStatement("select * from Survey_Surveys where surveyID=?");
//	ps.setInt(1, surveyID);
//	
//	rs = ps.executeQuery();		
//	rs.next();	
//		
//	s.setSurveyID(rs.getInt(1));
//	s.setTrainingsID(rs.getInt(2));
//	s.setTitle(rs.getString(3));
//	s.setDescription(rs.getString(4));
//	s.setAantalIngevuld(rs.getInt(5));
//
//	
//	
//	List <Question> questions = new ArrayList<Question>();
//	 questions = getAllQuestionsByid(surveyID);
//	
//	 s.setMyListSurveysQuestions(questions);
//	
//	return s;
//
//	}finally{
//		try{
//		if( ps != null){
//			ps.close();
//		}
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("error");
//			}
//		}
//	}
////
////
////
////// 
//
////werkt
//
//public ArrayList<Question> getAllQuestionsByid(int surveyID) throws SQLException, Exception{	
//Question question = null;
//PreparedStatement p = null;
//ResultSet r = null;
//
//String sql= "SELECT questionID, question  FROM Survey_Questions WHERE surveyID= ?";
//ArrayList<Question> questions = new ArrayList<Question>();
//
//try {
//	if (getConnection().isClosed()) {
//		throw new Exception ("error");
//}
//p = getConnection().prepareStatement(sql);
//p.setInt(1,surveyID);
//r = p.executeQuery();
//
//
//while(r.next()) {
//	question = new Question (r.getInt(1),r.getString("question"),null);
//	question.setAntwoorden(getAllAnswersByid(question.getQuestionId()));
//	questions.add(question);
//}
//
//return questions;
//} finally {
//	try {
//		if( p != null){
//			p.close();
//		}
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("error");
//		}
//	}	
//}
//
//
////public ArrayList <Survey> getAllSurveys() throws SQLException, Exception{ 
////	Statement stm = null; 
////	ResultSet r = null; 
////	String sql = "SELECT * FROM Survey_Surveys";
////	ArrayList<Survey> myListSurveys = new ArrayList<Survey>();
////	
////	Survey survey = null;
////
////	try{
////		if(getConnection().isClosed()){
////			 throw new Exception("error");
////		}
////		stm = getConnection().createStatement(); 
////		r = stm.executeQuery(sql);
////	
////	
////		while(r.next()){
////		
////		try {
////			survey = new Survey(r.getInt(1), r.getInt(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6));
////			
////			List <Question> questions = new ArrayList<Question>();
////			 questions = getAllQuestionsByid(r.getInt(1));
////			
////			 survey.setMyListSurveysQuestions(questions);
////			
////		}catch(Exception e){
////			System.out.println("fout");
////			}
////		myListSurveys.add(survey);
////	
////	}
////	return myListSurveys;
////	
////	}finally{
////		try{
////			if(stm != null){
////			stm.close();
////			}
////		if(r != null){
////				r.close();
////			}
////			
////		}catch(SQLException e){
////			System.out.println(e.getMessage());
////			throw new RuntimeException("fout");
////			}
////		}
////	}
//
//
//
//
//
//public ArrayList <Survey> getAllActiveSurveys() throws SQLException, Exception{ 
//	Statement stm = null; 
//	ResultSet r = null; 
//	String sql = "SELECT * FROM Survey_Surveys where archive =0";
//	ArrayList<Survey> myListSurveys = new ArrayList<Survey>();
//	
//	Survey survey = null;
//
//	try{
//		if(getConnection().isClosed()){
//			 throw new Exception("error");
//		}
//		stm = getConnection().createStatement(); 
//		r = stm.executeQuery(sql);
//	
//	
//		while(r.next()){
//		
//		try {
//			survey = new Survey(r.getInt(1), r.getInt(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6));
//			
//			List <Question> questions = new ArrayList<Question>();
//			 questions = getAllQuestionsByid(r.getInt(1));
//			
//			 survey.setMyListSurveysQuestions(questions);
//			
//		}catch(Exception e){
//			System.out.println("fout");
//			}
//		myListSurveys.add(survey);
//	
//	}
//	return myListSurveys;
//	
//	}finally{
//		try{
//			if(stm != null){
//			stm.close();
//			}
//		if(r != null){
//				r.close();
//			}
//			
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("fout");
//			}
//		}
//	}
////
//public ArrayList <Survey> getAllNonActiveSurveys() throws SQLException, Exception{ 
//	Statement stm = null; 
//	ResultSet r = null; 
//	String sql = "SELECT * FROM Survey_Surveys where archive =1";
//	ArrayList<Survey> myListSurveys = new ArrayList<Survey>();
//	
//	Survey survey = null;
//
//	try{
//		if(getConnection().isClosed()){
//			 throw new Exception("error");
//		}
//		stm = getConnection().createStatement(); 
//		r = stm.executeQuery(sql);
//
//		while(r.next()){
//		
//		try {
//			survey = new Survey(r.getInt(1), r.getInt(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6));
//			
//			List <Question> questions = new ArrayList<Question>();
//			 questions = getAllQuestionsByid(r.getInt(1));
//			
//			 survey.setMyListSurveysQuestions(questions);
//			
//		}catch(Exception e){
//			System.out.println("fout");
//			}
//		myListSurveys.add(survey);
//	
//	}
//	return myListSurveys;
//	
//	}finally{
//		try{
//			if(stm != null){
//			stm.close();
//			}
//		if(r != null){
//				r.close();
//			}
//			
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("fout");
//			}
//		}
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////
////
////public boolean updateSurveys(Survey s1, int surveyID) throws SQLException, Exception{ 
////	boolean successvol = false;
////	PreparedStatement p = null; 
////
////	String sql= "UPDATE Surveys SET surveyID = ?, trainingID = ?, title =?, description=?"; 
////
////	try{
////		if(getConnection().isClosed() ){
////			throw new Exception("fout"); 
////		}
////		p= getConnection().prepareStatement(sql); 
////		p.setInt(1, s1.getSurveyID());
////		p.setInt(2, s1.getTrainingsID());
////		p.setString(3,s1.getTitle());
////		p.setString(4, s1.getDescription());
////		
////		if (p.executeUpdate() == 0){
////			successvol = true;
////		} 
////		return successvol;
////	}finally{
////		try{
////		if( p != null){
////			p.close();
////		}
////		}catch(SQLException e){
////			System.out.println(e.getMessage());
////			throw new RuntimeException("error");
////			}
////		}
////	}
////
////public boolean updateSurveyByID(int surveyID,Survey updatesur) throws SQLException, Exception{ 
////	
////	boolean successvol = false;
////	PreparedStatement p = null; 
////	
////	String sql= "UPDATE Surveys SET title =?, description=? where surveyID=?"; 
////	// "UPDATE Surveys SET surveyID = ?, trainingID = ?, title =?, description=? where surveyID=?"; 
////	try{
////		if(getConnection().isClosed() ){
////			throw new Exception("fout"); 
////		}
////		p= getConnection().prepareStatement(sql); 
////	//	p.setInt(1,  updatesur.getSurveyID());
////	//	p.setInt(2,  updatesur.getTrainingsID());
////		p.setString(1, updatesur.getTitle());
////		p.setString(2, updatesur.getDescription());
////		p.setInt(3, surveyID);
////		
////		
////		
////		if (p.executeUpdate() == 0){
////			successvol = true;
////		} 
////		return successvol;
////	
////	}finally{
////		try{
////		if( p != null){
////			p.close();
////		}
////		}catch(SQLException e){
////			System.out.println(e.getMessage());
////			throw new RuntimeException("error");
////			}
////		}	
////	}
/////*
////
////public boolean updateSurveyQuestionsID(int surveyID,List<Question> myListQuestions) throws SQLException, Exception{ 
////
////	Statement stm = null; 
////	ResultSet r = null; 
////	
////	boolean successvol = false;
////	PreparedStatement p = null; 
////	String sql= "DELETE * FROM Survey_Questions_test WHERE surveyID=?"; 
////	
////	try{
////		if(getConnection().isClosed() ){
////			throw new Exception("fout"); 
////		}
////		
////		stm = getConnection().createStatement(); 
////		r = sextm.executeQuery(sql);
////		while(r.next()){
////			
////		
////			
////			
////			
////		}
////	
////	return successvol;
////}finally{
////	try{
////	if( p != null){
////		p.close();
////	}
////	}catch(SQLException e){
////		System.out.println(e.getMessage());
////		throw new RuntimeException("error");
////			}
////		}	
////	}
////	
////	*/

