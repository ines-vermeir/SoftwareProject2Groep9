package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.Answer;
import logic.AnswerPredefined;
import logic.Question;
import logic.Survey;
import logic.SurveyPredefined;
import logic.QuestionPredefined;

public class SurveyPredefinedDB extends BaseDAO{


		private SessionFactory myFactory= null;
//		private SessionFactory sessionFactory = null;
		
		
		public SurveyPredefinedDB()throws SQLException{

			super();
	      myFactory = SingletonHibernate.getSessionFactory();
		
			// TODO Auto-generated constructor stub
		}
		
		
		public  void  addSurvey(SurveyPredefined mySurvey) {
			
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
		
		

		public ArrayList <SurveyPredefined> getAllSurveys() throws SQLException, Exception{ 
		Statement stm = null; 
		ResultSet r = null; 
		String sql = "SELECT * FROM Predefined_surveys";
		ArrayList<SurveyPredefined> myListSurveys = new ArrayList<SurveyPredefined>();
		
		SurveyPredefined survey = null;

		try{
			if(getConnection().isClosed()){
				 throw new Exception("error");
			}
			stm = getConnection().createStatement(); 
			r = stm.executeQuery(sql);
		
			while(r.next()){
			
			try {
				survey = new SurveyPredefined(r.getInt(1), r.getString(2),r.getString(3));
				
				List <QuestionPredefined> questions = new ArrayList<QuestionPredefined>();
				 questions = getAllQuestionsByid(r.getInt(1));
				
				 survey.setMyListSurveysQuestions(questions);
				
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
		
		public SurveyPredefined getSurveyByID(int surveyID) throws SQLException, Exception{ 
			SurveyPredefined s = new SurveyPredefined();
			s.setSurveyPrID(surveyID);
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				if(getConnection().isClosed()){
				throw new Exception("error");
			}
			ps = getConnection().prepareStatement("select * from Predefined_surveys where surveyPrID=?");
			ps.setInt(1, surveyID);
			
			rs = ps.executeQuery();		
			rs.next();	
				
			s.setSurveyPrID(rs.getInt(1));
			s.setTitle(rs.getString(2));
			s.setDescription(rs.getString(3));
			
			
			
			List <QuestionPredefined> questions = new ArrayList<QuestionPredefined>();
			 questions = getAllQuestionsByid(surveyID);
			
			 s.setMyListSurveysQuestions(questions);
			
			return s;

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
		
		
		
		
		public ArrayList<QuestionPredefined> getAllQuestionsByid(int surveyID) throws SQLException, Exception{	
			QuestionPredefined question = null;
			PreparedStatement p = null;
			ResultSet r = null;

			String sql= "SELECT questionID, question FROM Predefined_questions WHERE SurveyPrID= ?";
			ArrayList<QuestionPredefined> questions = new ArrayList<QuestionPredefined>();

			try {
				if (getConnection().isClosed()) {
					throw new Exception ("error");
			}
			p = getConnection().prepareStatement(sql);
			p.setInt(1,surveyID);
			r = p.executeQuery();

			while(r.next()) {
				question = new QuestionPredefined (r.getInt(1),r.getString("question"),null);
				question.setAntwoorden(getAllAnswersByid(question.getQuestionId()));
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
			
		
		
		
		public List<AnswerPredefined> getAllAnswersByid(int questionID) throws SQLException, Exception{	
			List<AnswerPredefined> answers= new ArrayList<AnswerPredefined>();
			PreparedStatement p = null;
			ResultSet r = null;

			String sql= "SELECT answer FROM Predefined_answers WHERE questionID= ?";
	

			try {
				if (getConnection().isClosed()) {
					throw new Exception ("error");
			}
			p = getConnection().prepareStatement(sql);
			p.setInt(1,questionID);
			r = p.executeQuery();

			while(r.next()) {
				AnswerPredefined answer = new AnswerPredefined (r.getString("answer"));
				answers.add(answer);
			}
			return answers;
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
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////

		
// delete survey
		
		
		public boolean deleteSurveyByID(int SurveyPrID) throws SQLException, Exception {
			 //deleteSurveyQuestionsbyID(SurveyPrID);
		
			boolean successvol = false;
			PreparedStatement p = null; 
			
			deleteSurveyQuestionsbyID(SurveyPrID);
			
			String sql= "DELETE FROM Predefined_surveys WHERE SurveyPrID=?"; 
			
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
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
		
		
		public boolean deleteSurveyQuestionsbyID(int SurveyPrID) throws SQLException, Exception{
			boolean successvol = false;
			PreparedStatement p = null; 
			
			
			
			//deleteSurveyAnwersbyID(int questionID);
			
			String sql= "DELETE FROM Predefined_questions WHERE SurveyPrID=?"; 
			
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
				}
			p = getConnection().prepareStatement(sql);
			
			p.setInt(1, SurveyPrID);
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
		
		
		
		public boolean deleteSurveyAnwersbyID(int questionID) throws SQLException, Exception{
			
			boolean successvol = false;
			PreparedStatement p = null; 
			
			String sql= "DELETE FROM Predefined_answers WHERE questionID=?"; 
			
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
				}
			p = getConnection().prepareStatement(sql);
			
			p.setInt(1, questionID);
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
		
		
		
		
		
		
		
		
		
public boolean updateSurveyByID(int surveyID) throws SQLException, Exception{ 
			
			boolean successvol = false;
			PreparedStatement p = null; 
			
			String sql= "UPDATE Predefined_surveys SET title =?, description=? where SurveyPrID=?"; 
			// "UPDATE Surveys SET surveyID = ?, trainingID = ?, title =?, description=? where surveyID=?"; 
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
				}
				p= getConnection().prepareStatement(sql); 
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
		
		
		
		
		
		
		
		
		
		public boolean updateSurveyByID(int surveyID,SurveyPredefined updatesur) throws SQLException, Exception{ 
			
			boolean successvol = false;
			PreparedStatement p = null; 
			
			String sql= "UPDATE Predefined_surveys SET title =?, description=? where SurveyPrID=?"; 
			// "UPDATE Surveys SET surveyID = ?, trainingID = ?, title =?, description=? where surveyID=?"; 
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
				}
				p= getConnection().prepareStatement(sql); 
			//	p.setInt(1,  updatesur.getSurveyID());
			//	p.setInt(2,  updatesur.getTrainingsID());
				p.setString(1, updatesur.getTitle());
				p.setString(2, updatesur.getDescription());
				p.setInt(3, surveyID);
				
				
				// delete
	
				 deleteSurveyQuestionsbyID(updatesur.getSurveyPrID(),updatesur.getMyListSurveysQuestions());
				
				// update
			//	insertPredefined_Questions(updatesur.getSurveyID(),updatesur.getMyListSurveysQuestions());
				
				// insert
			//	insertPredefined_Questions(updatesur.getSurveyID(),updatesur.getMyListSurveysQuestions());
				
				if (p.executeUpdate() == 0){
					successvol = true;
				//	deleteSurveyQuestionsbyID(updatesur.getSurveyID(),updatesur.getMyListSurveysQuestions());
				//	insertPredefined_Questions(updatesur.getSurveyID(),updatesur.getMyListSurveysQuestions());	
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
//			
		public boolean deleteSurveyQuestionsbyID(int SurveyPrID, List<QuestionPredefined> predefinedQuestions) throws SQLException, Exception{
			boolean successvol = false;
			PreparedStatement p = null; 
			
			
			
			for(int i = 0; i < predefinedQuestions.size(); i++) {
				deleteSurveyAnwersbyID(predefinedQuestions.get(i).getQuestionId());
	
			}
			
			
			String sql= "DELETE FROM Predefined_questions WHERE SurveyPrID=?"; 
			
			try{
				if(getConnection().isClosed() ){
					throw new Exception("fout"); 
				}
			p = getConnection().prepareStatement(sql);
			
			p.setInt(1, SurveyPrID);
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
		
//		public boolean deleteSurveyAnwersbyID(int questionID) throws SQLException, Exception{
//			
//			boolean successvol = false;
//			PreparedStatement p = null; 
//			
//			String sql= "DELETE FROM Predefined_answers WHERE questionID=?"; 
//			
//			try{
//				if(getConnection().isClosed() ){
//					throw new Exception("fout"); 
//				}
//			p = getConnection().prepareStatement(sql);
//			
//			p.setInt(1, questionID);
//			if (p.executeUpdate() == 0){
//				successvol = true;
//			} 
//			return successvol;
//			
//			}finally{
//				try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//					}
//			}	
//		}
//		
//		
//		public boolean insertPredefined_answers(int questionID,List<String> answers)  throws SQLException, Exception{
//			PreparedStatement p = null; 
//			boolean successvol = false;
//			
//			String sql= "INSERT INTO Predefined_answers(questionID,answer) VALUES (?,?)";
//			try{
//				if(getConnection().isClosed() ){
//					throw new Exception("fout"); 
//				}
//				p = getConnection().prepareStatement(sql);
//			
//			for(int i = 0; i < answers.size();i++) {
//				p.setInt(1, questionID);
//				p.setString(2, answers.get(i));
//				p.executeUpdate();
//				
//			}
//				if (p.executeUpdate() == 0){
//					successvol = true;
//				}
//					return successvol;
//			}finally{
//				try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//					}
//			}	
//		}
//		
//		public boolean insertPredefined_Questions(int SurveyPrID,List<QuestionPredefined> predefinedQuestions)  throws SQLException, Exception{
//	
//			PreparedStatement p = null; 
//			boolean successvol = false;
//			
//			String sql= "INSERT INTO Predefined_questions(question,SurveyPrID) VALUES (?,?)";
//			try{
//				if(getConnection().isClosed() ){
//					throw new Exception("fout"); 
//				}
//				p = getConnection().prepareStatement(sql);
//			
//
//			for(int i = 0; i < predefinedQuestions.size();i++) {
//				p.setString(1, predefinedQuestions.get(i).getQuestion());
//				p.setInt(2, SurveyPrID);
//				p.executeUpdate();
//				insertPredefined_answers(predefinedQuestions.get(i).getQuestionId(),predefinedQuestions.get(i).getAntwoorden());	
//			}
//				if (p.executeUpdate() == 0){
//					successvol = true;
//				}
//					return successvol;
//			}finally{
//				try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//					}
//			}	
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

