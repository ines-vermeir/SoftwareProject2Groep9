package db;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

import javax.persistence.Query;

import logic.Location;
import logic.Students_enrolled_in_session;
import logic.Training;

public class SessionDB {

	private Session session= null;
	
	public SessionDB()
	{
		super();
		 session = SingletonHibernate.getSessionFactory().openSession();
	}

	
	public boolean insertSession (logic.Session mySession)
	{
		boolean succes = false;
		
		Transaction t = null;
		try 
		{
			t = session.beginTransaction();
			session.save(mySession);
			t.commit();
			succes = true;
		} catch(HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
			succes = false;
		} 
		return succes;
	}
	
	
	
	public boolean updateSession (logic.Session mySession)
	{
		boolean succes = false;
		
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(mySession);
			t.commit();
			succes = true;
		} catch(HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
			succes = false;
		}
		
		return succes;
	}
	
	
	public boolean archiveSession (logic.Session mySession)
	{
		mySession.setArchive(1);
	
		boolean succes = false;
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(mySession);
			t.commit();
			succes = true;
		}
		catch (HibernateException e)
		{
			if ( t != null) t.rollback();
			e.printStackTrace();
			succes = false;
		}
		
		return succes;
	}
	

	
	public logic.Session getSessionByID (int sessionID)
	{
		logic.Session s = null;
	
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			s = (logic.Session) session.get(logic.Session.class, sessionID);
			t.commit();
		} catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		} 
		return s;
	}
	
	
	public ArrayList<logic.Session> getAllSessions() 
	{
		ArrayList<logic.Session> list = null;
	
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			list = (ArrayList<logic.Session>) session.createCriteria(logic.Session.class).list();
			
			t.commit();
		} catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<logic.Session> getAllSessionsOfTrainingID(int tid) 
	{
		 List<logic.Session> list = new ArrayList<logic.Session>(); 
		  for (Object oneObject : session.createQuery("FROM Sessions where trainingID =  " + tid).getResultList()) {
			  list.add((logic.Session)oneObject);
		    }
	
		  return list;
	}
	
	//Added by Sebastian 
	
  public List<Students_enrolled_in_session> getAllEmployeesInSession(){

		 List<Students_enrolled_in_session> list = new ArrayList<Students_enrolled_in_session>(); 
		  for (Object oneObject : session.createQuery("FROM Students_enrolled_in_session").getResultList()) {
			  list.add((Students_enrolled_in_session)oneObject);
		    }
	
		  return list;
	}
	
	public List<Students_enrolled_in_session> getAllEmployeesInSession(int tid){

		 List<Students_enrolled_in_session> list = new ArrayList<Students_enrolled_in_session>(); 
		  for (Object oneObject : session.createQuery("FROM Session where archive =0 AND trainingID =  " + tid).getResultList()) {
			  list.add((logic.Session)oneObject);
		    }
		  //session.close();
		  return list;
	}
	
	
	public int  linkEmployee(int sessionID, int employeeIDenrolled) {
		
		int result = 0;
		Transaction t = null; 
		try {
			
			t = session.beginTransaction();
				@SuppressWarnings("rawtypes")
			Query query =session.createNativeQuery("INSERT INTO Students_enrolled_in_session VALUES(:sessionID, :employeeIDenrolled)");
				query.setParameter("sessionID", sessionID);
				query.setParameter("employeeIDenrolled",employeeIDenrolled ); 
				
		       result= query.executeUpdate();
			
			t.commit();
			
			return result;
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
}


// Code SessionDAO:

//package db;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import logic.Employee;
//import logic.Session;
//import logic.Location;
//
//public class SessionDAO extends BaseDAO {
//
//	public SessionDAO() throws SQLException {
//		super();
//	}
//
//	//deze functie update de locatie, datum en tijd van een sessie
//	// eventueel nog toe te voegen: update van teachers, studentsEnrolled, studentsPresent
//	public boolean updateSession (Session s) throws SQLException, Exception { 
//		boolean successvol = false;
//		PreparedStatement p = null;
//		String sql = "UPDATE Sessions SET locationID = ?, date = ?, startTime = ?, endTime = ? WHERE sessionID= ?";
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try{
//			if(getConnection().isClosed() ){
//				throw new Exception("fout"); 
//			}
//			p= getConnection().prepareStatement(sql);
//			p.setInt(1, s.getLocation().getID());
//			p.setTimestamp(2,new Timestamp( s.getDate().getTime().getTime()));
//			p.setString(3, s.getStartTime());
//			p.setString (4, s.getEndTime());
//			p.setInt(4, s.getSessionID());
//			if (p.executeUpdate() == 0){
//				successvol = true;
//			} 
//			return successvol;
//		
//		}finally{
//			try{
//			if( p != null){
//				p.close();
//			}
//			}catch(SQLException e){
//				System.out.println(e.getMessage());
//				throw new RuntimeException("error");
//			}
//		}
//			
//	}
//	
//	public boolean insertSession(Session s) throws SQLException, Exception { 
//		boolean successvol = false; 
//		PreparedStatement p = null; 
//		String sql = "INSERT INTO Sessions VALUES (NULL,?,?,?,?,?)";
//		
//		//SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
//		
//		try{
//			if(getConnection().isClosed() ){
//				throw new Exception("fout"); 
//			}
//			p= getConnection().prepareStatement(sql);
//			p.setInt(1, s.getTrainingID());
//			p.setInt(2, s.getLocation().getID());
//			p.setTimestamp (3, new Timestamp( s.getDate().getTime().getTime()));
//			p.setString(4,  s.getStartTime());
//			p.setString(5,  s.getEndTime());
//			if (p.executeUpdate() == 0)
//			{
//				successvol = true;
//			}			
//			Statement stmt = getConnection().createStatement();
//			ResultSet r = stmt.executeQuery("SELECT LAST_INSERT_ID();");
//			s.setSessionID(r.getInt("sessionID"));
//				
//			if (s.getTeachers() != null)
//			{
//				insertTeachers(s.getTeachers(), s.getSessionID());
//			}
//			if (s.getStudentsEnrolled() != null)
//			{
//				insertStudentsEnrolled(s.getStudentsEnrolled(), s.getSessionID());
//			}
//			if (s.getStudentsPresent() != null)
//			{
//				insertStudentsPresent(s.getStudentsEnrolled(), s.getSessionID());
//			}
//			if (s.getLocation() != null)
//			{
//				//insertLocation(s.getLocation());
//			}
//			return successvol;
//	}finally{
//		try{
//		if( p != null){
//			p.close();
//		}
//		}catch(SQLException e){
//			System.out.println(e.getMessage());
//			throw new RuntimeException("error");
//		}
//	}
//		
//	}
//	
//	//onderstaande functie heeft getLocation functie van LocationDAO nodig, kan daarna uit commentaar gehaald worden
////	public ArrayList<Session> getAllSessions() throws SQLException, Exception {
////		Statement stm = null;
////		ResultSet r = null;
////		String sql = "SELECT * FROM Sessions";
////		ArrayList<Session> sessions = new ArrayList<Session>();
////		ArrayList<String> teachers = null;
////		ArrayList<Integer> studentsenrolled = null;
////		ArrayList<Integer> studentspresent = null;
////		Session s = null;
////		Location l = null;
////		LocationDAO ld = new LocationDAO();
////		try {
////			if (getConnection().isClosed()) {
////				throw new Exception("error");
////			}
////			stm = getConnection().createStatement();
////			r = stm.executeQuery(sql);
////			while (r.next())
////			{
////				long milliseconds = r.getTimestamp("date").getTime() + (r.getTimestamp("date").getNanos() / 1000000);
////				Calendar c = GregorianCalendar.getInstance();
////				c.setTimeInMillis(milliseconds);
////				l = new Location(ld.getLocation(r.getInt("locationID")));	
////				teachers = new ArrayList<String>(getAllTeachers(r.getInt("SessionID")));
////				studentsenrolled = new ArrayList<Integer>(getAllStudentsEnrolled(r.getInt("SessionID")));
////				studentspresent  = new ArrayList<Integer>(getAllStudentsPresent(r.getInt("SessionID")));
////				s = new Session(r.getInt("SessionID"), r.getInt("TrainingID"), c, r.getString("startTime"), r.getString("endTime"), l, teachers, studentsenrolled, studentspresent);
////				sessions.add(s);
////			}
////			return sessions;
////		}finally{
////			try{
////				if(stm != null){
////					stm.close();
////				}
////				if(r != null){
////					r.close();
////				}
////				
////			}catch(SQLException e){
////				System.out.println(e.getMessage());
////				throw new RuntimeException("fout");
////			}
////		}
////	}
//	
//	//onderstaande functie heeft getLocation functie van LocationDAO nodig, kan daarna uit commentaar gehaald worden
////	public Session getSession (int sID) throws Exception
////	{
////		PreparedStatement p = null;
////		ResultSet r = null;
////		String sql = "SELECT * FROM Sessions WHERE SesssionID = ?";
////		ArrayList<Session> sessions = new ArrayList<Session>();
////		ArrayList<String> teachers = null;
////		ArrayList<Integer> studentsenrolled = null;
////		ArrayList<Integer> studentspresent = null;
////		Session s = null;
////		Location l = null;
////		LocationDAO ld = new LocationDAO();
////				try{
////					if(getConnection().isClosed() ){
////						throw new Exception("fout"); 
////					}
////					p= getConnection().prepareStatement(sql);
////					p.setInt(1, sID);
////					r = p.executeQuery();
////					long milliseconds = r.getTimestamp("date").getTime() + (r.getTimestamp("date").getNanos() / 1000000);
////					Calendar c = GregorianCalendar.getInstance();
////					c.setTimeInMillis(milliseconds);
////					l = new Location(ld.getLocation(r.getInt("locationID")));	
////					teachers = new ArrayList<String>(getAllTeachers(r.getInt("SessionID")));
////					studentsenrolled = new ArrayList<Integer>(getAllStudentsEnrolled(r.getInt("SessionID")));
////					studentspresent  = new ArrayList<Integer>(getAllStudentsPresent(r.getInt("SessionID")));
////					s = new Session(r.getInt("SessionID"), r.getInt("TrainingID"), c, r.getString("startTime"), r.getString("endTime"), l, teachers, studentsenrolled, studentspresent);
////					return s;
////				}finally{
////					try{
////						if( p != null){
////							p.close();
////						}
////						}catch(SQLException e){
////							System.out.println(e.getMessage());
////							throw new RuntimeException("error");
////						}
////					}
////						
////				}
//	
//	public boolean insertTeachers (ArrayList<String> t, int sID) throws SQLException, Exception  // wordt gebruikt in insertSession()
//	{
//		boolean successvol = false;
//		PreparedStatement p = null; 
//		String sql = "INSERT INTO Session_teachers VALUES (?,?)";
//		try{
//			if(getConnection().isClosed() ){
//				throw new Exception("fout"); 
//			}
//			for (String s : t)
//			{
//				p= getConnection().prepareStatement(sql);
//				p.setInt(1, sID);
//				p.setString(2, s);
//				if (p.executeUpdate() == 0)
//				{
//					successvol = true;
//				}
//			}
//			return successvol;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}		
//	}
//	}
//	
//	public boolean insertStudentsPresent (ArrayList<Integer> sp, int sID) throws SQLException, Exception // wordt gebruikt in insertSession()
//	{
//		boolean successvol = false;
//		PreparedStatement p = null; 
//		String sql = "INSERT INTO Students_present_in_session VALUES (?,?)";
//		try{
//			if(getConnection().isClosed() ){
//				throw new Exception("fout"); 
//			}
//			for (int i : sp)
//			{
//				p= getConnection().prepareStatement(sql);
//				p.setInt(1, sID);
//				p.setInt(2, i);
//				if (p.executeUpdate() == 0)
//				{
//					successvol = true;
//				}
//			}
//			return successvol;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}		
//		}
//	}
//	
//	public boolean insertStudentsEnrolled (ArrayList<Integer> se, int sID) throws SQLException, Exception // wordt gebruikt in insertSession()
//	{
//		boolean successvol = false;
//		PreparedStatement p = null; 
//		String sql = "INSERT INTO Students_enrolled_in_session VALUES (?,?)";
//		try{
//			if(getConnection().isClosed() ){
//				throw new Exception("fout"); 
//			}
//			for (int i : se)
//			{
//				p= getConnection().prepareStatement(sql);
//				p.setInt(1, sID);
//				p.setInt(2, i);
//				if (p.executeUpdate() == 0)
//				{
//					successvol = true;
//				}
//			}
//			return successvol;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}		
//		}
//	}
//
//	
//	public ArrayList<String> getAllTeachers(int sID) throws SQLException, Exception // wordt gebruikt in getAllSessions() en getSession()
//	{
//		String teacher = null;
//		PreparedStatement p = null;
//		ResultSet r = null;
//		String sql = "SELECT Teacher FROM Session_Teachers WHERE SessionID = ? ";
//		ArrayList<String> teachers = new ArrayList<String>();
//		
//		try {
//			if (getConnection().isClosed()) {
//				throw new Exception ("error");
//			}
//			p= getConnection().prepareStatement(sql); 
//			p.setInt(1, sID);
//			r = p.executeQuery();
//			
//			while (r.next()) {
//				teacher = new String(r.getString("Teacher"));
//				teachers.add(teacher);
//			}
//			return teachers;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}
//			}	
//	}
//	
//	public ArrayList<Integer> getAllStudentsEnrolled(int sID) throws SQLException, Exception // wordt gebruikt in getAllSessions() en getSession()
//	{
//		int emplID;
//		PreparedStatement p = null;
//		ResultSet r = null;
//		String sql = "SELECT employeeID FROM Students_enrolled_in_session WHERE SessionID = ? ";
//		ArrayList<Integer> studentsEnrolled = new ArrayList<Integer>();
//		
//		try {
//			if (getConnection().isClosed()) {
//				throw new Exception ("error");
//			}
//			p= getConnection().prepareStatement(sql); 
//			p.setInt(1, sID);
//			r = p.executeQuery();
//			
//			while (r.next()) {
//				emplID = r.getInt("employeeID");
//				studentsEnrolled.add(emplID);
//			}
//			return studentsEnrolled;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}
//			}	
//	}
//	
//	public ArrayList<Integer> getAllStudentsPresent(int sID) throws SQLException, Exception // wordt gebruikt in getAllSessions() en getSession()
//	{
//		int emplID;
//		PreparedStatement p = null;
//		ResultSet r = null;
//		String sql = "SELECT employeeID FROM Students_present_in_session WHERE SessionID = ? ";
//		ArrayList<Integer> studentsPresent = new ArrayList<Integer>();
//		
//		try {
//			if (getConnection().isClosed()) {
//				throw new Exception ("error");
//			}
//			p= getConnection().prepareStatement(sql); 
//			p.setInt(1, sID);
//			r = p.executeQuery();
//			
//			while (r.next()) {
//				emplID = r.getInt("employeeID");
//				studentsPresent.add(emplID);
//			}
//			return studentsPresent;
//		}finally{
//			try{
//				if( p != null){
//					p.close();
//				}
//				}catch(SQLException e){
//					System.out.println(e.getMessage());
//					throw new RuntimeException("error");
//				}
//			}	
//	}
//	
//
//	
//
//}