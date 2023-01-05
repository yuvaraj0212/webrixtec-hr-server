package webrix.hr.pojo;


import javax.validation.constraints.NotEmpty;


public class OfferRequest {

	@NotEmpty(message = "offer id is empty")
	private long offer_id;
	@NotEmpty(message = "annual CTC id is empty")
	private String annualCTC;
	private String joiningDate;
	private String offerDate;
	private String offer_msg;
	private String clientRef;
	
	public long getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(long offer_id) {
		this.offer_id = offer_id;
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
	public String getClientRef() {
		return clientRef;
	}
	public void setClientRef(String clientRef) {
		this.clientRef = clientRef;
	}

	

}
