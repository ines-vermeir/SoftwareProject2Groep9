package db;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import com.mysql.jdbc.PreparedStatement;

import logic.Book;


//Deze klasse gebruikt Hibernate voor de connectie met de database en de CRUD operations

public class BookDB {
	
	
	private Session session = null;
//	private SessionFactory sessionFactory = null;
	public BookDB() {

		super();
		
		 session = SingletonHibernate.getSessionFactory().openSession();
		// TODO Auto-generated constructor stub
	}

	public  void  insertBook(Book myBook) {
		
		

		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		
	
		
	
	}
	
	public void  updateBook(Book myBook) {

		
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.update(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
	
	}
	
	public void deleteBook(Book myBook) {
       

		
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.delete(myBook);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	public Book getBook(String isbn) {
         Book b = null;
	
		Transaction t = null; 
		try {
			t = session.beginTransaction();
	
			//get by PRIMARY KEY met setParameter om SQL injection te voorkomen - similar to Prepared Statements 
			@SuppressWarnings("rawtypes")
			Query query =session.createNativeQuery("Select * from Books WHERE isbn = :isbn", Book.class).setParameter("isbn", isbn);
		
			b = (Book) query.getSingleResult();
			
			
			// b = (Book) session.get(Book.class,isbn);
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		return b;
		
				
	

		
	}
	
	public ArrayList<Book> getAllBooks(){
		
		   ArrayList<Book> list = null;
		 
			Transaction t = null; 
			try {
				t = session.beginTransaction();
				
			    list = (ArrayList<Book>) session.createCriteria(Book.class).list();
				t.commit();
				
			}catch(HibernateException e) {
				if(t!= null ) t.rollback();
				e.printStackTrace();
			}
			return list;
			
		   
	
		    
			
		  
			
		 
			 
		
	}

}

