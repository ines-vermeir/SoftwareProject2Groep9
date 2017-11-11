package db;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import logic.Book;
//Deze klasse gebruikt Hibernate voor de connectie met de database en de CRUD operations

public class BookDB {
	
	private SessionFactory sessionFactory = null;
	public BookDB() {
	super();
	 sessionFactory = new Configuration().configure().buildSessionFactory();
		// TODO Auto-generated constructor stub
	}

	public  void  insertBook(Book myBook) {
		
		
		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}		
	}
	
	public void  updateBook(Book myBook) {

		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.update(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
	
	}
	
	public void deleteBook(Book myBook) {
       

		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.delete(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		
		
	}
	
	public Book getBook(String isbn) {
        Book b = null;
		Session session = sessionFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			//get by PRIMARY KEY 
			
			 b = (Book) session.get(Book.class,isbn);
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
		return b;
		
				
	

		
	}
	
	public ArrayList<Book> getAllBooks(){
		
		   ArrayList<Book> list = null;
		   Session session = sessionFactory.openSession();
			Transaction t = null; 
			try {
				t = session.beginTransaction();
				
			    list = (ArrayList<Book>) session.createCriteria(Book.class).list();
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
