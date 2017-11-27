package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

	private static Singleton instance;
	private Connection connection;
	
	private Singleton(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Singleton getSingleton(){
		if( instance == null)
			instance = new Singleton();
			return instance;
		
		
	}
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}

	public Connection getConnection(boolean autoCommit) throws SQLException {
		if (connection == null || connection.isClosed()) {

			try {
				connection = DriverManager.getConnection(
					//	"jdbc:mysql://dtsl.ehb.be/"+Credentials.USERNAME,
						"jdbc:mysql://dtprojecten.ehb.be/"+Credentials.USERNAME,
						
						Credentials.USERNAME,
						Credentials.PASSWORD);

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return connection;
	}

}
