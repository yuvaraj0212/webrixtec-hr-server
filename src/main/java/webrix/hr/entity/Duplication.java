package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duplication_tbl")
public class Duplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String duplication_status;
	private String duplication_msg;
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDuplication_status() {
		return duplication_status;
	}

	public void setDuplication_status(String duplication_status) {
		this.duplication_status = duplication_status;
	}

	public String getDuplication_msg() {
		return duplication_msg;
	}

	public void setDuplication_msg(String duplication_msg) {
		this.duplication_msg = duplication_msg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Duplication() {
		super();
		// TODO Auto-generated constructor stub
	}

}
