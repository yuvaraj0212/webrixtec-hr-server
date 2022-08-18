package webrix.hr.pojo;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class candidateRequest {
	@NotEmpty(message = "candidate name empty")
	private String cname;
	@NotEmpty(message = "candidate email empty")
	private String cemail;
	@NotEmpty(message = "candidate phone empty")
	private String cphone;
	@NotEmpty(message = "candidate d.o.b empty")
	private Date cdob;
	@NotEmpty(message = "candidate job Id empty")
	private String jobID;
	private String imagUrl;
	private String fileName;
	@Transient
	private MultipartFile mfile;

	@NotEmpty(message = " user ID empty")
	private int userId;

	private Date cDOB;
	@NotEmpty(message = "candidate cmsg empty")
	private String cMSG;
	private String createdBy;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public Date getcDOB() {
		return cDOB;
	}

	public void setcDOB(Date cDOB) {
		this.cDOB = cDOB;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public String getImagUrl() {
		return imagUrl;
	}

	public void setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getMfile() {
		return mfile;
	}

	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}

	public String getcMSG() {
		return cMSG;
	}

	public void setcMSG(String cMSG) {
		this.cMSG = cMSG;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public candidateRequest(int userId, String cname, String cemail, String cphone, Date cDOB, String jobID,
			String imagUrl, String fileName, MultipartFile mfile, String cMSG, String createdBy) {
		super();
		this.userId = userId;
		this.cname = cname;
		this.cemail = cemail;
		this.cphone = cphone;
		this.cDOB = cDOB;
		this.jobID = jobID;
		this.imagUrl = imagUrl;
		this.fileName = fileName;
		this.mfile = mfile;
		this.cMSG = cMSG;
		this.createdBy = createdBy;
	}

	public candidateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
