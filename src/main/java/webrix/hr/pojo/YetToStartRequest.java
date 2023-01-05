package webrix.hr.pojo;

import javax.validation.constraints.NotEmpty;

public class YetToStartRequest {
	@NotEmpty(message = "candidate id must not be null")
	private Long candidId;
	private String email;
	private String name;
	private String companyName;
	private String status;
	private String msg;
	public Long getCandidId() {
		return candidId;
	}
	public void setCandidId(Long candidId) {
		this.candidId = candidId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
