package db;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import logic.Training;



public class TrainingDB {
	
	private SessionFactory sessionFactory = null;
	public TrainingDB() {
		super();
	 sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	
public  void  insertBook(Training mytraining) {
		
		
		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(mytraining);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
