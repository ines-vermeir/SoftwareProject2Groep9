package db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.Certificate;
import logic.Certificate_upload;
import logic.Survey;
import logic.Training;



public class Certificate_uploadDB {

private SessionFactory myFactory = null;
private Session session = null;

public Certificate_uploadDB(){

	super();
  myFactory = SingletonHibernate.getSessionFactory();
 session= myFactory.openSession();
	// TODO Auto-generated constructor stub
}


//public List<Certificate_upload> getAllCertificatesByID(int empID) {
//	  List<Certificate_upload> certificateList = new ArrayList<Certificate_upload>(); 
//	 
//	  for (Object oneObject : session.createQuery("FROM Certificates_upload where employeeID =" + empID).getResultList()) {
//		  certificateList.add((Certificate_upload)oneObject);
//	    }
//	
//	  return certificateList;
//	}



public  boolean  insertCertificate_upload(Certificate_upload cu) {
	
	boolean check;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.save(cu);
		t.commit();
		check = true;
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
		check = false;
	}finally {
		session.close();
	//	sessionFactory.close();
	}
	return check;
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
	
	//Added by Sebastian 
	public ArrayList<Certificate_upload> getCertificatesByEmployee(int Id) {
		Certificate c = null;
		ArrayList<Certificate_upload> list = new ArrayList<Certificate_upload>();
		
	
		
			
			for (Object oneObject : session.createQuery("FROM Certificates_upload where employeeID = " + Id).getResultList()) {
				list.add((Certificate_upload)oneObject);
			}
			
		
		
		return list;
		
	}
	/*public ArrayList<Certificate_upload> getAllCertificate_uploads()
	{
		ArrayList<Certificate_upload> list = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			
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
	}*/
	public ArrayList<Certificate_upload> getAllCertificate_uploads()
	{
		ArrayList<Certificate_upload> list = new ArrayList<Certificate_upload>();
	
		for (Object oneObject : session.createQuery("FROM Certificates_upload").getResultList()) {
			list.add((Certificate_upload)oneObject);
		}
		
		
		return list;
	}
	
}