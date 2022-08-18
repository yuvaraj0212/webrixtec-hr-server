package webrix.hr.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name ="user_tbl")
public class userModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private Date createDate;
	private String token;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role_tbl",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<roleModel> roles= new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Set<roleModel> getRoles() {
		return roles;
	}
	public void setRoles(Set<roleModel> roles) {
		this.roles = roles;
	}
	public userModel(int id, String name, String email, String password, Date createDate, String token,
			Set<roleModel> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.token = token;
		this.roles = roles;
	}
	public userModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	
}
