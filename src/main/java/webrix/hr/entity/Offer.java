package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer_tbl")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String annualCTC;
	private String joiningDate;
	private String offerDate;
	private String offer_msg;
	private Date createDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	


	public String getAnnualCTC() {
		return annualCTC;
	}

	public void setAnnualCTC(String annualCTC) {
		this.annualCTC = annualCTC;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public String getOffer_msg() {
		return offer_msg;
	}

	public void setOffer_msg(String offer_msg) {
		this.offer_msg = offer_msg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
