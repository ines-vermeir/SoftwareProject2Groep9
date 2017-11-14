package db;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.User;

//functies zijn getest en werken
public class UserDB {

	private SessionFactory myFactory = null;
	
	public UserDB()
	{
		super();
		myFactory = SingletonHibernate.getSessionFactory();
	}
	
	public void insertUser (User myUser)
	{
		Session session = myFactory.openSession();
		Transaction t = null;
		try 
		{
			t = session.beginTransaction();
			session.save(myUser);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
	}
	
	public void updateUser (User myUser) {
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(myUser);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	//zelfde als update, maar eerst wordt de archive datamember aangepast waardoor die in de database op 1 komt te staan
	public void archiveUser (User myUser) {
		myUser.setArchive(1);
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(myUser);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

	public User getUser (int userID)
	{
		User u = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			// get by PRIMARY KEY
			u = (User) session.get(User.class, userID);
			t.commit();
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return u;
	}
	
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> list = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			list = (ArrayList<User>) session.createCriteria(User.class).list();
			t.commit();
		}
		catch (HibernateException e)
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

//	beter om archiveUser te gebruiken	
//	public void deleteUser (User myUser)
//	{
//		Session session = myFactory.openSession();
//		Transaction t = null;
//		try
//		{
//			t = session.beginTransaction();
//			session.delete(myUser);
//			t.commit();
//		}
//		catch (HibernateException e)
//		{
//			if (t != null) t.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
	
}


// Testcode
//User u = new User (1, "Testnaam", "Testpasw" , Privilege.TEACHER);
//UserDB db = new UserDB();
//db.insertUser(u);
//db.archiveUser(u);
//User u = db.getUser(1);
//System.out.println(u.toString());