package webrix.hr.entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_tbl")
public class roleModel {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rolename;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public roleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public roleModel(Long id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}
	
}
