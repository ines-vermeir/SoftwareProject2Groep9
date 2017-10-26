package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import logic.Book;


public class BookDAO extends BaseDAO {
	
	
	public BookDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public boolean deleteBook(String isbn) throws SQLException, Exception{
		
		boolean successvol = false; 
		PreparedStatement p = null; 
		String sql= "DELETE FROM Books where isbn =?"; 
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setString(1, isbn);
			
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

	public boolean insertBook(Book b) throws SQLException, Exception{
		
		boolean successvol = false; 
		PreparedStatement p = null; 
		String sql= "INSERT INTO Books VALUES(?,?,?,?)"; 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			if(getConnection().isClosed() ){
				throw new Exception("fout"); 
			}
			p= getConnection().prepareStatement(sql); 
			p.setString(1, b.getIsbn());
			p.setString(2, b.getAuthor());
			p.setString(3, b.getTitle());
		//	p.setDate(4, new Date( format.parse(b.getReleaseDate().toString()).getTime()));
			p.setTimestamp(4,new Timestamp( b.getReleaseDate().getTime().getTime()));
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
	
	public Book fill(ResultSet r){
		Book b= null;
		try{
			 long milliseconds = r.getTimestamp("releaseDate").getTime() + (r.getTimestamp("releaseDate").getNanos() / 1000000);
			Calendar c = GregorianCalendar.getInstance();
			c.setTimeInMillis(milliseconds);
			
			b = new Book(r.getString("isbn"), r.getString("author"), r.getString("title"), c);
			
		}catch(Exception e){
			System.out.println("fout");
		}
		return b;
	}
	
	
	public ArrayList<Book> getAllBooks() throws SQLException, Exception{
		
		Statement stm = null; 
		ResultSet r = null; 
		String sql = "SELECT * FROM Books"; 
		ArrayList<Book> myListBooks = new ArrayList<Book>();
		try{
			if(getConnection().isClosed()){
				 throw new Exception("error");
			}
			stm = getConnection().createStatement(); 
			
			r = stm.executeQuery(sql);
			
			while(r.next()){
				myListBooks.add(fill(r));
			}
			
			return myListBooks;
			
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
}
