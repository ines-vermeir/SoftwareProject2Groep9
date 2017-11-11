package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		
		
		return sessionFactory;
	}
}
