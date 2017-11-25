package db;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class SessionDB {

	private SessionFactory myFactory = null;
	
	public SessionDB()
	{
		super();
		myFactory = SingletonHibernate.getSessionFactory();
	}
	
	public void insertSession (logic.Session mySession)
	{
		Session session = myFactory.openSession();
		Transaction t = null;
		try 
		{
			t = session.beginTransaction();
		
			session.save(mySession);
			t.commit();
		} catch(HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
	}
	
	public void updateSession (logic.Session mySession)
	{
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(mySession);
			t.commit();
		} catch(HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public void archiveSession (logic.Session mySession)
	{
		mySession.setArchive(1);
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(mySession);
			t.commit();
		}
		catch (HibernateException e)
		{
			if ( t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public logic.Session getSessionByID (int sessionID)
	{
		logic.Session s = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			s = (logic.Session) session.get(logic.Session.class, sessionID);
			t.commit();
		} catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return s;
	}
	
	
	public ArrayList<logic.Session> getAllSessions() 
	{
		ArrayList<logic.Session> list = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			list = (ArrayList<logic.Session>) session.createCriteria(logic.Session.class).list();
			
			
			t.commit();
		} catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return list;
	}
}

