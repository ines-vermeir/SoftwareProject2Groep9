package logic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="applications")
@Table(name="applications")
public class Application {

	@Override
	public String toString() {
		return "Application [id=" + id + ", training_id=" + training_id + ", user_id=" + user_id + ", manager_id="
				+ manager_id + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	@Column
	private int training_id; 
	@Column
	private int user_id; 
	@Column
	private int manager_id; 
	@Column
	private String status; 
	@Column
	private Date created_at; 
	@Column
	private Date updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTraining_id() {
		return training_id;
	}
	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(int id, int training_id, int user_id, int manager_id, String status, Date created_at,
			Date updated_at) {
		super();
		this.id = id;
		this.training_id = training_id;
		this.user_id = user_id;
		this.manager_id = manager_id;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	} 
	
	
	
}
