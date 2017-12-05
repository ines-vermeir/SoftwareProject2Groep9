package logic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

//Deze annotation is voor uw klasse/tabel op uw database
@Entity
//@Table(name="") wordt gebruikt als de naam van de klasse en de naam van de table op de database anders is
@Table(name="Books")
public class Book {
	//Extra uitleg rond Hibernate hier: https://www.youtube.com/playlist?list=PLBgMUB7xGcO0cujAlaeDDEOdZkeNZUScM
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY) annotation wordt gebruikt als je parameter op MYSQL database als  AUTO_INCREMENT staat op de database
	//@GeneratedValue(strategy = GenerationType.AUTO) kan ook gebruikt worden als jij auto increment hebt op je kolom
	//@GeneratedValue(generator="newGenerator") 
	//@GenericGenerator(name="newGenerator", strategy="foreign", parameters={@Parameter(value="test", name="property")}) 
	/*Voor One to one relationship volgende annotaties
	 *    @OneToOne(cascade = CascadeType.ALL) // bij deleten/updaten van de parameter op de parent table wordt de parameter ook in de child tables verwijderd/geupdatet
	 *    @JoinColum(name="test_id")     //naam van foreign key kolom of parameter
	 *    
	 *    private Test test;  //declaratie van object van andere tabel waarmee een relationship is
	 * */
	
	/*Voor one to many/many to one relationship
	 * 
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL) //annotation toevoegen 
	 *   
	 * @OneToMany(cascade = CascadeType.ALL,mappedBy="test") //mappedBy = table die de mapping zal doen( moet unidirectioneel zijn, dus zeker mappedBy gebruiken)
	 * private Set<Test> testen = new HashSet<Test>();
	 */
	
	/*Voor many to many relationship
	 * 
	 * 
	 * @ManyToMany(cascade= CascadeType.ALL)
	 * private Set<Test> testen = new HashSet<Test>();  //declaratie table/object waarmee een many to many relationship bestaat
	 * public Set<Test> getTesten(){      //getter en setter zijn ook nodig bij many to many relationship
	 * return testen;
	 * }
	 * public void setTesten(Set<Test> testen){
	 *     this.testen = testen;
	 * }
	 * 
	 * */
	//Deze annotation is voor uw primary key
    @Id	
    
    
	private String isbn;
	private String title; 
	private String author;
	private  Calendar releaseDate;
	
	public Book(String isbn, String title, String author,Calendar releaseDate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}
   
//Voor Hibernate moet je voorzien van een default constructor
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public  Calendar  getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", releaseDate=" +  myFormat.format(releaseDate.getTime()) + "]";
	}
	
	

}

//Book b1 = new Book("9781328994967","Timothy Ferriss","Tribe of mentors",new GregorianCalendar(2017,11,21));
//Book b2 = new Book("9781501178139","Isabel Allende","In the midst of winter",new GregorianCalendar(2017,10,31));
//Book b3 = new Book("9780062820754","Marc Sumerak","The Art of Harry Potter",new GregorianCalendar(2017,11,21));
//Book b4 = new Book("test","test","testen",new GregorianCalendar(2017,8,16));	
//Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
//BookDAO dao = new BookDAO();
//Book b5 = new Book("test1","test1","testen1",new GregorianCalendar(2017,8,16));
//BookDAO dao = new BookDAO();
//dao.insertBook(b1);
//dao.insertBook(b2);
//dao.insertBook(b3);
//dao.insertBook(b4);
//dao.insertBook(b5);		

//ArrayList<Book> lijst = dao.getAllBooks();
//
//for(Book b: lijst) {
//	System.out.println(b.toString());
//}
//ArrayList<Book> lijst = dao.getAllBooks();
//System.out.println(lijst.toString());

//System.out.println("---- GET BOOK by ISBN------------");	
//if(dao.getBook("9780062820754") == null) {
//	
//	System.out.println("Sorry het boek dat jij zoekt bestaat niet");
//}else {
//	System.out.println(dao.getBook("9780062820754").toString());
//}	
/*
System.out.println("---- UPDATE BOOK------------");
Book b6 = dao.getBook("test");
b6.setAuthor("testUpdated");
b6.setTitle("New title");
dao.updateBook(b6);
System.out.println(dao.getBook("test").toString());  */


//------------ Volgende code is om de connectie met de database met Hibernate te testen (By Sebastian G)  ----------
//Calendar myCal =  new GregorianCalendar();
//
//myCal.set(GregorianCalendar.YEAR, 2015);
//myCal.set(GregorianCalendar.MONTH,8);
//myCal.set(GregorianCalendar.DATE,23);
//Book myBook = new Book("test6","Last Title","Last Author", myCal);
//
//
//	BookDB db = new BookDB();



//Book myBook = new Book("testH","testH","testH",new GregorianCalendar(2017,9,22));
//
//db1.insertBook(myBook);

//Book newBook = db.getBook("testH");

//System.out.println(dao.getBook("test").toString());

/*	 Book newBook = db.getBook("Last Book");
branch 'SebastianG' of https://github.com/ines-vermeir/SoftwareProject2Groep9.git

if(newBook != null) {
 
 System.out.println(newBook.toString());
}else {
 System.out.println("Sorry, het boek bestaat niet");
 
}

newBook.setTitle("Last Book Hier");
db.updateBook(newBook);

System.out.println("-----UPDATE-------");		
System.out.println(newBook.toString());
*/

//	db.deleteBook(myBook);

/*		ArrayList<Book> books = db.getAllBooks();

for(int i=0; i< books.size(); i++) {
	System.out.println(books.get(i).toString());
}
*/


//--------------- Odata lezen Employees---------------------------
/*	ArrayList<Employee> employees= (ArrayList<Employee>) TestJackson.getEmployees();


for(int i=0; i< employees.size(); i++) {
	System.out.println(employees.get(i).toString());
*/    
//	System.out.println(employees.get(i).getEmployeeID());
	
	
	



//Odata google Books Api test-----------------------------------------------------------------


/*
ArrayList<BookGoogleAPI> books = TestJackson.getBooksByContent("php programming");



	for(BookGoogleAPI book : books) {
				System.out.println(book.toString());
					//System.out.println(book.getTitle());
	}

*/
	

	

	
	
	
	
	
	


//ArrayList<BookGoogleAPI> books = TestJackson.getBooksByContent("php programming");
//
//
//
//	for(BookGoogleAPI book : books) {
//				System.out.println(book.toString());
//					//System.out.println(book.getTitle());
//	}
//

