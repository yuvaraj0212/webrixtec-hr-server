package webrix.hr.pojo;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class procesingRequest {
	@NotEmpty(message = "Process Id is empty")
	private long process_id;
	@NotEmpty(message = "Technolgy field empty")
	private String technolgy;
//	@NotEmpty(message = "srtarDate field empty")
	private Date startDate;
	@NotEmpty(message = "budjet field empty")
	private String budjet;

	public String getTechnolgy() {
		return technolgy;
	}

	public void setTechnolgy(String technolgy) {
		this.technolgy = technolgy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getBudjet() {
		return budjet;
	}

	public void setBudjet(String budjet) {
		this.budjet = budjet;
	}

	public long getProcess_id() {
		return process_id;
	}

	public void setProcess_id(long process_id) {
		this.process_id = process_id;
	}

}
