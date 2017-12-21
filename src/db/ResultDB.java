package db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import logic.Result;


public class ResultDB {

		
		private  SessionFactory myFactory= null;
		private Session session = null;

		public ResultDB() {
		super();
	     myFactory = SingletonHibernate.getSessionFactory();
		 session = myFactory.openSession();
		}
		
		public Result getResult (int id)
		{
			Result r = null;
			Transaction t = null;
			try {
				t = session.beginTransaction();
				r = (Result) session.get(Result.class,id);
				t.commit();
			} catch (HibernateException e)
			{
				if(t!= null ) t.rollback();
				e.printStackTrace();
			}
			return r;
		}

		
		public ArrayList<Result> getAllResults() {
			ArrayList<Result> list = null;
			Transaction t = null;
			try 
			{
				t = session.beginTransaction();
				list = (ArrayList<Result>) session.createCriteria(Result.class).list();
				t.commit();
			} catch (HibernateException e) {
				if ( t!= null) t.rollback();
				e.printStackTrace();
			}
			return list;
		}
		
		public List<Result> getAllResultBySurveyId(int id) 
		{
			 List<Result> list = new ArrayList<Result>(); 
			  for (Object oneObject : session.createQuery("FROM Results where survey_id =  " + id).getResultList()) {
				  list.add((Result)oneObject);
			    }
			  return list;
		}

	
}
