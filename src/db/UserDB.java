package db;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import logic.Location;
import logic.User;

//functies zijn getest en werken

//nog toe te voegen functies:
//getAllUserNames   (om bij aanmaak van nieuwe user te kijken of de username reeds in gebruik is + bij inloggen checken of de user bestaat)
//getUserByUsername (om user op te halen op basis van username en zo wachtwoordcheck te doen)

public class UserDB {

	private SessionFactory myFactory = null;
	
	public UserDB()
	{
		super();
		myFactory = SingletonHibernate.getSessionFactory();
	}
	
	public boolean insertUser (User myUser)
	{
		boolean succes = false;
		Session session = myFactory.openSession();
		Transaction t = null;
		try 
		{
			t = session.beginTransaction();
			session.save(myUser);
			t.commit();
			succes = true;
		}
		catch (HibernateException e)
		{
			if (t != null) t.rollback();
			e.printStackTrace();
			succes = false;
		} finally
		{
			session.close();
		}
		return succes;
	}
	
	public boolean updateUser (User myUser) {
		boolean succes = false;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(myUser);
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
	
	
	
	//zelfde als update, maar eerst wordt de archive datamember aangepast waardoor die in de database op 1 komt te staan
	public boolean archiveUser (User myUser) {
		boolean succes = false;
		myUser.setArchive(1);
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			session.update(myUser);
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

	public User getUser (String username)
	{
		User u = null;
		Session session = myFactory.openSession();
		Transaction t = null;
		try
		{
			t = session.beginTransaction();
			// get by PRIMARY KEY
			u = (User) session.get(User.class, username);
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
	
//	public User getUserByUsername (String username)
//	{
//		User u = new User();
//		Session session = myFactory.openSession();
//		Transaction t = null;
//		try
//		{
//			
//			t = session.beginTransaction();
//			u = session.createCriteria(User.class).add(eq("username", username)).uniqueResult();
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
//		return u;
//	}
	
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

//System.out.println("Welkom");
//Main m = new Main();
//m.login();

//User u = new User ("TestUser5", "pass", Privilege.HR);
//UserDB db = new UserDB();
//User u = db.getUser("TestU");
//if (u == null)
//{
//	System.out.println("geen data gevonden");
//}
//System.out.println(u.toString());
//ArrayList<User> list = db.getAllUsers();
//for (User u1 : list)
//{
//	System.out.println(u1.toString());
//}