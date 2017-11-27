package db;


/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/


import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import logic.Location;


public class LocationDB {
	private SessionFactory myFactory =  null;
	
	public LocationDB() {
		super();
		  myFactory =  SingletonHibernate.getSessionFactory();
	}
	
	public boolean insertLocation(Location l)  {
		boolean succes = false;
		Session session = myFactory.openSession();
		Transaction t = null; 
		
		try {
			t = session.beginTransaction();
			session.save(l);
			t.commit();
			succes = true;
		}
		catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
			succes = false;
		}
		finally{
			session.close();
		}
		return succes;
		}

	public boolean updateLocation(Location l) {
		boolean succes = false;
		Session session = myFactory.openSession();
		Transaction t = null; 
		
		try {
			t = session.beginTransaction();
			session.update(l);
			t.commit();
			succes = true;
		}
		catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
			succes = false;
		}
		finally{
			session.close();
		}
		return succes;
		
	}

	public Location getLocationById(int id) {
		Location l = null;
		Session session = myFactory.openSession();
		Transaction t = null; 
		
		try {
			t = session.beginTransaction();
			l = (Location) session.get(Location.class, id);
			t.commit();
		}
		catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return l;
	}
	}
	
	
	
	/*public static Location fill(ResultSet r){
		Location l= null;
		try{
			l = new Location(r.getInt("locationID"),r.getString("streetName"),r.getString("number"),r.getString("postalCode"),r.getString("city"),r.getString("country"),r.getString("name"),r.getString("addInfo"));
			
		}catch(Exception e){
			System.out.println("fout");
		}
		return l;
	}
	
	public static ArrayList<Location> getAllLocations() throws SQLException, Exception{
		
		Statement stm = null; 
		ResultSet r = null; 
		String sql = "SELECT * FROM Locations"; 
		ArrayList<Location> myListLocation = new ArrayList<Location>();
		try{
			if(getConnection().isClosed()){
				 throw new Exception("ERROR");
			}
			stm = getConnection().createStatement(); 
			
			r = stm.executeQuery(sql);
			
			while(r.next()){
				myListLocation.add(fill(r));
			}
			
			return myListLocation;
			
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
				throw new RuntimeException("ERROR");
			}
		}
		}
	public static Location getLocationById(int id) throws SQLException, Exception{
		 
		ResultSet r = null; 
		PreparedStatement p = null; 
		String sql = "SELECT * FROM Locations where id = ?"; 
		Location l;
		try{
			if(getConnection().isClosed()){
				 throw new Exception("ERROR");
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1, id);
			r = p.executeQuery(sql);
			l = fill(r);
			return l;
			
		}finally{
			try{
				if(p != null){
					p.close();
				}
				if(r != null){
					r.close();
				}
				
			}catch(SQLException e){
				System.out.println(e.getMessage());
				throw new RuntimeException("ERROR");
			}
		}
		}
	
	public static boolean deleteLocation(int id) throws SQLException, Exception{
		
		boolean successvol = false; 
		PreparedStatement p = null; 
		String sql= "DELETE FROM Locations where locationID =?"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("ERROR"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setInt(1, id);
			
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

	public static boolean insertLocation(Location l) throws SQLException, Exception{
		
		boolean successvol = false; 
		PreparedStatement p = null; 
		String sql= "INSERT INTO Locations VALUES(NOT NULL,?,?,?,?,?,?,?)"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("ERROR"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setString(1,l.getStreetName());
			p.setString(2, l.getNumber());
			p.setString(3, l.getPostalCode());
			p.setString(4,l.getCity());
			p.setString(5, l.getCountry());
			p.setString(6, l.getName());
			p.setString(7,l.getInfo());
		
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

	public static boolean updateLocation(Location l) throws SQLException, Exception{
		
		boolean successvol = false; 
		PreparedStatement p = null; 
		String sql= "UPDATE Locations SET streetName = ?, number=?, postalCode=?, city=?, country=?, name=?, addInfo=? WHERE locationID=?;";
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("ERROR"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setString(1,l.getStreetName());
			p.setString(2, l.getNumber());
			p.setString(3, l.getPostalCode());
			p.setString(4,l.getCity());
			p.setString(5, l.getCountry());
			p.setString(6, l.getName());
			p.setString(7,l.getInfo());
			p.setInt(8, l.getID());
		
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

	}*/

