package webrixtec.pojo;

import java.util.Date;

public class resumePojo {
	private String status;
	private Date date;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public resumePojo(String status, Date date) {
		super();
		this.status = status;
		this.date = date;
	}
	
	
	
}
