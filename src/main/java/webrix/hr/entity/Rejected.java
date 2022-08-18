package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rejected_tbl")
public class Rejected {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String rof;
	private String rejected_msg;
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRof() {
		return rof;
	}

	public void setRof(String rof) {
		this.rof = rof;
	}

	public String getRejected_msg() {
		return rejected_msg;
	}

	public void setRejected_msg(String rejected_msg) {
		this.rejected_msg = rejected_msg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}
