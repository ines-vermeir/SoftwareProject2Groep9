package db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;
import logic.Training;

public class TrainingDB {
	
	private SessionFactory myFactory= null;
//	private SessionFactory sessionFactory = null;
	public TrainingDB() {

		super();
      myFactory = SingletonHibernate.getSessionFactory();
	
		// TODO Auto-generated constructor stub
	}
	
public  void  insertTraining(Training myTraining) {
		
		Session session = myFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			session.save(myTraining);
			t.commit();
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		//	sessionFactory.close();
		}
	}


public void  updateTraining(Training myTraining) {

	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.update(myTraining);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}
}


public void archiveTraining(Training myTraining) {
	 
	myTraining.setArchive(1);
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		session.update(myTraining);
		t.commit();
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
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
	}finally {
		session.close();
	//	sessionFactory.close();
	}	
	return tr;
}


public ArrayList<Training> getAllTrainings(){
	
	   ArrayList<Training> list = null;
	   Session session = myFactory.openSession();
		Transaction t = null; 
		try {
			t = session.beginTransaction();
			
		    list = (ArrayList<Training>) session.createCriteria(Training.class).list();
			t.commit();
			
		}catch(HibernateException e) {
			if(t!= null ) t.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		//	sessionFactory.close();
		}	
		return list;
	}

public void updateTrainingById(int traingsID, Training training) {
	
	Training tr = null;
	Session session = myFactory.openSession();
	Transaction t = null; 
	try {
		t = session.beginTransaction();
		//get by PRIMARY KEY 
		
		 tr = (Training) session.get(Training.class,traingsID);
		 
		 tr.setTitle(training.getTitle());
		 tr.setSubject(training.getSubject());
		 tr.setLanguage(training.getLanguage());
		 tr.setResponsible(training.getResponsible());
		 tr.setSequentiality(training.getSequentiality());
		 tr.setArchive(0);
		session.update(tr);
		t.commit();
	
	}catch(HibernateException e) {
		if(t!= null ) t.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	//	sessionFactory.close();
	}	


}
public void archiveTrainingById(int traingsID) {

	Training tr = null;
	Session session = myFactory.openSession();
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
		}finally {
			session.close();
		//	sessionFactory.close();
		}	
	}


public List<Training> getActiveTrainings() {
	  List<Training> TrainingList = new ArrayList<Training>(); 
	  Session session = myFactory.openSession();
	  for (Object oneObject : session.createQuery("FROM Training where archive =0 ").getResultList()) {
		  TrainingList.add((Training)oneObject);
	    }
	  session.close();
	  return TrainingList;
	}

public List<Training> getNonActiveTrainings() {
	  List<Training> TrainingList = new ArrayList<Training>(); 
	  Session session = myFactory.openSession();
	  for (Object oneObject : session.createQuery("FROM Training where archive =1 ").getResultList()) {
		  TrainingList.add((Training)oneObject);
	    }
	  session.close();
	  return TrainingList;
	}







}
