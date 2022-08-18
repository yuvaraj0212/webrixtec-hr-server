package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Procesing_tbl")
public class ProcessingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String technolgy;
	private Date startDate;
	private String budjet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

}
