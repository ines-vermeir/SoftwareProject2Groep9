package db;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.User;

public class UserDB {

	private SessionFactory myFactory = null;
	
	public UserDB()
	{
		super();
		myFactory = HibernateFactory.getSessionFactory();
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
	
}

//	public void  updateBook(Book myBook) {
//
//		Session session = myFactory.openSession();
//		Transaction t = null; 
//		try {
//			t = session.beginTransaction();
//			session.update(myBook);
//			t.commit();
//		}catch(HibernateException e) {
//			if(t!= null ) t.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		//	sessionFactory.close();
//		}
//		
//	
//	}
//	
//	public void deleteBook(Book myBook) {
//       
//
//		Session session = myFactory.openSession();
//		Transaction t = null; 
//		try {
//			t = session.beginTransaction();
//			session.delete(myBook);
//			t.commit();
//		}catch(HibernateException e) {
//			if(t!= null ) t.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		//	sessionFactory.close();
//		}
//		
//		
//		
//	}
//	
//	public Book getBook(String isbn) {
//        Book b = null;
//		Session session = myFactory.openSession();
//		Transaction t = null; 
//		try {
//			t = session.beginTransaction();
//			//get by PRIMARY KEY 
//			
//			 b = (Book) session.get(Book.class,isbn);
//			t.commit();
//			
//		}catch(HibernateException e) {
//			if(t!= null ) t.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		//	sessionFactory.close();
//		}
//		
//		return b;
//		
//				
//	
//
//		
//	}
//	
//	public ArrayList<Book> getAllBooks(){
//		
//		   ArrayList<Book> list = null;
//		   Session session = myFactory.openSession();
//			Transaction t = null; 
//			try {
//				t = session.beginTransaction();
//				
//			    list = (ArrayList<Book>) session.createCriteria(Book.class).list();
//				t.commit();
//				
//			}catch(HibernateException e) {
//				if(t!= null ) t.rollback();
//				e.printStackTrace();
//			}finally {
//				session.close();
//			//	sessionFactory.close();
//			}
//			
//			return list;	 	
//	}
//
//}
