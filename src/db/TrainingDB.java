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
	
public  void  insertTraining(Training myTraining) {
		
	
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myTraining);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}
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
  /////////////////////////////////////////////// 
public void  linkBook(Training myTraining, String isbn) {
	
	
	Transaction t = null; 
	try {
		
		t = session.beginTransaction();
			@SuppressWarnings("rawtypes")
		Query query =session.createNativeQuery("INSERT INTO Training_books VALUES (:isbn, :trainingID)");
			query.setParameter("isbn", isbn);
			query.setParameter("trainingID",myTraining.getTrainingID() ); 
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

}
