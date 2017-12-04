package db;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import logic.Certificate;
//Deze klasse gebruikt Hibernate voor de connectie met de database en de CRUD operations
public class CertificateDB {
	
	private SessionFactory sessionFactory = null;
	public CertificateDB() {
		super();
	 sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	public  void  insertCertificate(Certificate myCertificate) {
		
		
		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public void  updateCertificate(Certificate myCertificate) {

		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.update(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public void deleteCertificate(Certificate myCertificate) {
       

		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.delete(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public Certificate getCertificate(int Id) {
		Certificate c = null;
		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			//get by PRIMARY KEY 
			
			 c = (Certificate) session.get(Certificate.class,Id);
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		return c;
		
	}
	
	public ArrayList<Certificate> getAllCertificates(){
		
		   ArrayList<Certificate> list = null;
		   Session session = sessionFactory.openSession();
			Transaction t = null; 
			try {
				t = session.beginTransaction();
				
			    list = (ArrayList<Certificate>) session.createCriteria(Certificate.class).list();
				t.commit();
				
			}catch(HibernateException e) {
				if(t!= null ) t.rollback();
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();
			}
			
			return list;
	}

}