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
import logic.Certificate_upload;
//Deze klasse gebruikt Hibernate voor de connectie met de database en de CRUD operations
public class CertificateDB {
	
	private Session session = null;
	public CertificateDB() {
		super();
		 session = SingletonHibernate.getSessionFactory().openSession();
		// TODO Auto-generated constructor stub
	}

	public  void  insertCertificate(Certificate myCertificate) {
		
		
		
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
	}
	
	public void  updateCertificate(Certificate myCertificate) {

		
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.update(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
	}
	
	public void deleteCertificate(Certificate myCertificate) {
       

	
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.delete(myCertificate);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
	}
	
	public Certificate getCertificate(int Id) {
		Certificate c = null;
	
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			//get by PRIMARY KEY 
			
			 c = (Certificate) session.get(Certificate.class,Id);
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	public ArrayList<Certificate> getAllCertificates(){
		
		   ArrayList<Certificate> list = null;
		 
			Transaction t = null; 
			try {
				t = session.beginTransaction();
				
			    list = (ArrayList<Certificate>) session.createCriteria(Certificate.class).list();
				t.commit();
				
			}catch(HibernateException e) {
				if(t!= null ) t.rollback();
				e.printStackTrace();
			}
			
			return list;
	}

}