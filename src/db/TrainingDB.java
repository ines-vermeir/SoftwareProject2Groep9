package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;

import logic.Application;
import logic.BookTraining;
import logic.Training;

public class TrainingDB {
	
	private  SessionFactory myFactory= null;
	private Session session = null;

	public TrainingDB() {

		super();
     myFactory = SingletonHibernate.getSessionFactory();
	 session = myFactory.openSession();

		// TODO Auto-generated constructor stub
	}
	
public  int  insertTraining(Training myTraining) {
		int id= 0;
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myTraining);
			id = myTraining.getTrainingID();
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		return id;
	}


public void  updateTraining(Training myTraining) {

	
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.update(myTraining);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
}

public void  deleteTraining(Training myTraining) {

	
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.delete(myTraining);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
}

public void archiveTraining(Training myTraining) {
	 
	myTraining.setArchive(1);
	
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.update(myTraining);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
}


public Training getTraining(int trainingID) {
	Training tr = null;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		 tr = (Training) session.get(Training.class,trainingID);
		t.commit();
		
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
	return tr;
}


public  ArrayList<Training> getAllTrainings(){
	
	   ArrayList<Training> list = null;
	  
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			
		    list = (ArrayList<Training>) session.createCriteria(Training.class).list();
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
		return list;
	}

public void updateTrainingById(int traingsID, Training training) {
	
	Training tr = null;
	
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		 tr = (Training) session.get(Training.class,traingsID);
		 
		 tr.setTitle(training.getTitle());
		 tr.setSubject(training.getSubject());
		 tr.setLanguage(training.getLanguage());
		 tr.setResponsible(training.getResponsible());
		 tr.setSessions(training.getSessions());
		 tr.setArchive(0);
		session.update(tr);
		t.commit();
	
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}


}
public  void archiveTrainingById(int traingsID) {

	Training tr = null;

	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		 tr = (Training) session.get(Training.class,traingsID);
		 tr.setArchive(1);

		 session.update(tr);
			t.commit();
		
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
	}


public List<Training> getActiveTrainings() {
	  List<Training> TrainingList = new ArrayList<Training>(); 
	 
	  for (Object oneObject : session.createQuery("FROM Training where archive =0 ").getResultList()) {
		  TrainingList.add((Training)oneObject);
	    }
	
	  return TrainingList;
	}

public  List<Training> getNonActiveTrainings() {
	  List<Training> TrainingList = new ArrayList<Training>(); 
	
	  for (Object oneObject : session.createQuery("FROM Training where archive =1 ").getResultList()) {
		  TrainingList.add((Training)oneObject);
	    }
	 
	  return TrainingList;
	}
  /////////////////////////////////////////////// Added by Sebastian 
public void  linkBook(Training myTraining, String isbn) {
	
	TestJackson j= new TestJackson();
	Transaction t = null; 
	try {
		
		t = session.beginTransaction();
			@SuppressWarnings("rawtypes")
		Query query =session.createNativeQuery("INSERT INTO Training_books VALUES (:isbn, :trainingID, :titleTraining, :titleBook)");
			query.setParameter("isbn", isbn);
			query.setParameter("trainingID",myTraining.getTrainingID() ); 
			query.setParameter("titleTraining",myTraining.getTitle()); 
			query.setParameter("titleBook", j.getBookByISBN(isbn).getTitle());
	        query.executeUpdate();
		
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
}



public List<BookTraining> getBooksTrainings() {
	List<BookTraining> list= null;
	Transaction t = null; 
	try {
		
		t = session.beginTransaction();
	
	
	

	   list = (List<BookTraining>) session.createQuery("FROM Training_books").list();
	 

	 

		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
	
	return list; 

}

public List<Application> getApplications() {
	List<Application> list= null;
	Transaction t = null; 
	try {
		
		t = session.beginTransaction();
	
	
	

	   list = (List<Application>) session.createQuery("FROM applications").list();
	 

	 

		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
	
	return list; 

}

}
/*
public void  linkBook(Training myTraining, String isbn) {
	
	TestJackson j= new TestJackson();
	Transaction t = null; 
	try {
		
		t = session.beginTransaction();
			@SuppressWarnings("rawtypes")
		Query query =session.createNativeQuery("INSERT INTO Training_books VALUES (:isbn, :trainingID, :titleTraining, :titleBook)");
			query.setParameter("isbn", isbn);
			query.setParameter("trainingID",myTraining.getTrainingID() ); 
			query.setParameter("titleTraining",myTraining.getTitle()); 
			query.setParameter("titleBook", j.getBookByISBN(isbn).getTitle());
	        query.executeUpdate();
		
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}
}

*/

