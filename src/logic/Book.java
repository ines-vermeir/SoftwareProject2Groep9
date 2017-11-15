package logic;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
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
