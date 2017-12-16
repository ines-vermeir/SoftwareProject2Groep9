package db;
//Singleton voor sessionFactory 
//genomen uit www.onlinetutorialspoint.com/hibernate/singleton-hibernate-sessionfactory-example.html. Raadpleging op 14 november 2017.
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonHibernate {

	private static SessionFactory sessionFactory = null;
	
	
	private SingletonHibernate(){
		
		
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null || sessionFactory.isClosed()) {
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		
		}
		
		
		return sessionFactory;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}
	
	public static void closeSessionFactory() {

		if(sessionFactory != null || !sessionFactory.isClosed()) {
			sessionFactory.close();
		
		}
		
	}
	

}
