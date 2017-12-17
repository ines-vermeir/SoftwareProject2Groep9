package db;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.Certificate_upload;
import logic.Survey;



public class Certificate_uploadDB {

private SessionFactory myFactory = null;

public Certificate_uploadDB(){

	super();
  myFactory = SingletonHibernate.getSessionFactory();

	// TODO Auto-generated constructor stub
}


public  void  insertCertificate_upload(Certificate_upload cu) {
	
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.save(cu);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}
}

//	public Certificate_uploadDB ()
//	{
//		super();
//		myFactory = SingletonHibernate.getSessionFactory();
//	}
//	
//	public boolean insertCertificate_uploadDB(Certificate_upload cu)
//	{
//		boolean succes = false;
//		Session session = myFactory.openSession();
//		Transaction t = null;
//		try
//		{
//			t = session.beginTransaction();
//			session.save(cu);
//			t.commit();
//			succes = true;
//		} catch (HibernateException e)
//		{
//			if (t != null) t.rollback();
//			e.printStackTrace();
//			succes = false;
//		} finally
//		{
//			session.close();
//		}
//		return succes;
//	}
	
	public boolean updateCertificate_upload (Certificate_upload cu)
	{
		boolean succes = false;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(cu);
			t.commit();
			succes = true;
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
			succes = false;
		}
		finally
		{
			session.close();
		}
		return succes;
	}
	
	public Certificate_upload getCertificate_upload (int id)
	{
		Certificate_upload cu = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			cu = (Certificate_upload) session.get(Certificate_upload.class, id);
			t.commit();
		} catch (HibernateException e)
		{
			if ( t != null) t.rollback();
			e.printStackTrace();
		} 
		finally
		{
			session.close();
		}
		return cu;
	}

	public ArrayList<Certificate_upload> getAllCertificate_uploads()
	{
		ArrayList<Certificate_upload> list = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			list = (ArrayList<Certificate_upload>) session.createCriteria(Certificate_upload.class).list();
			t.commit();
		} catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return list;
	}

	
}