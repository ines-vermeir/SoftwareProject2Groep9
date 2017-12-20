
	
	package db;

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.io.Writer;
	import java.sql.Date;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Iterator;
	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.mindrot.jbcrypt.BCrypt;

	import logic.Answer;
	import logic.Book;
	import logic.Certificate;
	import logic.Certificate_upload;
	import logic.Location;
	import logic.Question;
	import logic.QuestionPredefined;
	import logic.Survey;
	import logic.SurveyPredefined;
	import logic.Training;
	import logic.User;
	import logic.AnswerPredefined;
	import logic.Certificate_upload;

	//import logic.Session;

	public class HibernateCSV {
		private SessionFactory myFactory = null;
		
		
		public HibernateCSV()
		{
			super();
			myFactory = SingletonHibernate.getSessionFactory();
		}
		
			

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVTraining(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
		
//		String gekozenpad = "C:\\hibernateoef\\";
		
		String pad = dircetorychooser + " Trainings.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Training A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	Training e = (Training)o;
	    	
	    	writer.print(e.getTrainingID() + ",");
	    	writer.print(e.getTitle()+", ");
	    	writer.print(e.getSubject()+", ");
	    	writer.print(e.getLanguage()+", ");
	    	writer.print(e.getResponsible()+", ");
	    	writer.print(e.getSessions()+", ");
	    	writer.print(e.getArchive()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVUser(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Users.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from User A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	User e= (User)o;
	    	
	    	writer.print(e.getUserID()+", ");
	    	writer.print(e.getUsername() + ",");
	    	writer.print(e.getPassword()+", ");
	    	writer.print(e.getPrivilege()+", ");
	    	writer.print(e.getArchive()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVLocation(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Locations.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Location A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Location e= (Location)o;
	    	
	    	writer.print(e.getID() + ",");
	    	writer.print(e.getStreetName()+", ");
	    	writer.print(e.getNumber()+", ");
	    	writer.print(e.getPostalCode()+", ");
	    	writer.print(e.getCity()+", ");
	    	writer.print(e.getCountry()+", ");
	    	writer.print(e.getInfo()+", ");
	    	writer.print(e.getArchive());
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVSurvey(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Surveys.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Survey A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Survey e= (Survey)o;
	    	
	    	writer.print(e.getSurveyID() + ",");
	    	writer.print(e.getTrainingsID()+", ");
	    	writer.print(e.getTitle()+", ");
	    	writer.print(e.getDescription()+", ");
	    	writer.print(e.getAantalIngevuld()+", ");
	    	writer.print(e.getArchive()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVAnswer(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Answers.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Answer A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Answer e= (Answer)o;
	    	
	    	writer.print(e.getAnswerID() + ",");
	    	writer.print(e.getAnswer()+", ");
	    	writer.print(e.getAantal()+", ");
	    	writer.print(e.getQuestion().getQuestionId()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVQuestion(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Questions.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Question A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Question e= (Question)o;
	    	
	    	writer.print(e.getQuestionId() + ",");
	    	writer.print(e.getQuestion()+", ");
	    	writer.print(e.getSurvey().getSurveyID()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }





	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVBooks(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Books.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Book A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();


	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Book e= (Book)o;
	    	
	    	writer.print(e.getIsbn() + ",");
	    	writer.print(e.getAuthor()+", ");
	    	writer.print(e.getTitle()+", ");
	    	//writer.print(e.getReleaseDate()+", ");
	    	
	    	Calendar cal = e.getReleaseDate();
	    	java.util.Date date = cal.getTime();
	    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	        String date2 = DATE_FORMAT.format(date);
	        writer.print(date2 +", ");
	    
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVCertificate(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Certificate_upload.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Certificate_upload A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 Certificate_upload e= (Certificate_upload)o;
	    	
	    	writer.print(e.getCertificateID()+ ",");
	    	writer.print(e.getEmployeeID()+", ");
	    	writer.print(e.getFile()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVPredefinedAnswers(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " PredefinedAnswers.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from AnswerPredefined A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 AnswerPredefined e= (AnswerPredefined)o;
	    	
	    	writer.print(e.getAnswerID() + ",");
	    	writer.print(e.getAnswer()+", ");
	    	writer.print(e.getQuestion().getQuestionId()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }



	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVPredefinedQuestions(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " PredefinedQuestions.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from QuestionPredefined A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 QuestionPredefined e= (QuestionPredefined)o;
	    	
	    	writer.print(e.getQuestionId() + ",");
	    	writer.print(e.getQuestion()+", ");
	    	writer.print(e.getSurvey().getSurveyPrID()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVPredefinedSurveys(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad =dircetorychooser + " PredefinedSurveys.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from SurveyPredefined A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 SurveyPredefined e= (SurveyPredefined)o;
	    	
	    	writer.print(e.getSurveyPrID() + ",");
	    	writer.print(e.getTitle()+", ");
	    	writer.print(e.getDescription()+", ");
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }


	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void hibernateCSVSessions(String dircetorychooser) throws IOException {

		Session session = myFactory.openSession();
		Transaction t = null;
	 
	 
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " Sessions.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));

	    Query qry = session.createQuery("SELECT A from Session A");
	    List l =(List) qry.list();
	    System.out.println("Total Number Of Records : "+((java.util.List) l).size());
	    Iterator it = ((java.util.List) l).iterator();

	    while(it.hasNext())
	    {
	    	 Object o = (Object)it.next();
	    	 logic.Session e= (logic.Session)o;
	    	
	    	writer.print(e.getSessionID()+ ",");
	    	writer.print(e.getTrainingID()+", ");
	    	writer.print(e.getLocationID()+", ");
	    	writer.print(e.getPart()+", ");
	    	
	    	Calendar cal = e.getDate();
	    	java.util.Date date = cal.getTime();
	    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	        String date2 = DATE_FORMAT.format(date);
	        writer.print(date2 + ", ");
	    	
	    	
	    	//writer.print(e.getDate()+", ");
	    	
	    	
	    	writer.print(e.getStartTime()+", ");
	    	writer.print(e.getEndTime()+", ");
	    	writer.print(e.getArchive()+", ");
	    	
	    	
	    	writer.println();
	    	
	   //     System.out.println("----------------------");
	  //     bw.write(e.getTrainingID()); // Here instead of Id some junk value is getting inserted
	      
	    } 
	  //  bw.flush();
//	    bw.close();
	    
	    writer.close();
	    }




	public void sessionStudentsEnrolledCSV(String dircetorychooser) throws IOException
	{
		
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " SessionsEnrolled.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));
		//FILE_HEADER = "sessionID, employeeID";
		SessionDB db = new SessionDB();
		List<logic.Session> sessions = db.getAllSessions();
		try {
		
		for (logic.Session s: sessions)
		{			
			for (int i: s.getStudentsEnrolled())
			{
				
				writer.print(String.valueOf(s.getSessionID())+ ", ");
				writer.print(String.valueOf(i) +", ");
				writer.println();
			}	
		}
		System.out.println("CVS file of Students_enrolled_in_session was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			//fileWriter.flush();
//		fileWriter.close();
			 writer.close();
		}
	}

	public void sessionStudentsPresentCSV(String dircetorychooser) throws IOException
	{
		
		String gekozenpad = "C:\\hibernateoef\\";
		String pad = dircetorychooser + " StudentsPresent.csv";
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(pad)));
		//FILE_HEADER = "sessionID, employeeID";
		SessionDB db = new SessionDB();
		List<logic.Session> sessions = db.getAllSessions();
		try {
		
		for (logic.Session s: sessions)
		{			
			for (int i: s.getStudentsPresent())
			{
				
				writer.print(String.valueOf(s.getSessionID())+ ", ");
				writer.print(String.valueOf(i) +", ");
				writer.println();
			}	
		}
		System.out.println("CVS file of StudentsPresent was created succesfully");
		} catch (Exception e)
		{
			System.out.println("Error in CsvFileWriter");
			e.printStackTrace();
		} finally 
		{
			//fileWriter.flush();
//		fileWriter.close();
			 writer.close();
		}
	}	
	
}
