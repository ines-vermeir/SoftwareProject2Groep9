package db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.Book;

public class SessionDB {

//	private SessionFactory myFactory= null;
////	private SessionFactory sessionFactory = null;
//	public BookDB() {
//
//		super();
//       myFactory = HibernateFactory.getSessionFactory();
//		// TODO Auto-generated constructor stub
//	}
//
//	public  void  insertBook(Book myBook) {
//		
//		
//		Session session = myFactory.openSession();
//		Transaction t = null; 
//		try {
//			t = session.beginTransaction();
//			session.save(myBook);
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
//	
//	}
//	
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

	
}