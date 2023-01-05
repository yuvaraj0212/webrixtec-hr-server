package webrix.hr.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "candidate_tbl")
public class candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "candidate name empty")
	private String cname;
	@NotEmpty(message = "candidate email empty")
	private String cemail;
	@NotEmpty(message = "candidate phone empty")
	private String cphone;
	private Date cdob;
	@NotEmpty(message = "candidate job Id empty")
	private String jobID;
	private String imagUrl;
	private String fileName;
	private String candidateStatus;
	private String candidateStatusMsg;
	@Transient
	private MultipartFile mfile;
	@NotEmpty(message = "candidate cmsg empty")
	private String cmsg;
	private Date createDate;
	@NotEmpty(message = "candidate by empty")
	private String createdBy;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "trcaker_id", referencedColumnName = "id")
	private Tracker tracker;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	private userModel user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "duplication_id", referencedColumnName = "id")
	private Duplication duplication;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "processing_id", referencedColumnName = "id")
	private ProcessingEntity processing;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id", referencedColumnName = "id")
	private Offer offer;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rejected_id", referencedColumnName = "id")
	private Rejected rejected;
		


	public Rejected getRejected() {
		return rejected;
	}

	public void setRejected(Rejected rejected) {
		this.rejected = rejected;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

	public String getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public Date getCdob() {
		return cdob;
	}

	public void setCdob(Date cdob) {
		this.cdob = cdob;
	}

	public String getCmsg() {
		return cmsg;
	}

	public void setCmsg(String cmsg) {
		this.cmsg = cmsg;
	}

	public userModel getUser() {
		return user;
	}

	public void setUser(userModel user) {
		this.user = user;
	}

	public Duplication getDuplication() {
		return duplication;
	}

	public void setDuplication(Duplication duplication) {
		this.duplication = duplication;
	}

	public ProcessingEntity getProcessing() {
		return processing;
	}

	public void setProcessing(ProcessingEntity processing) {
		this.processing = processing;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

	public String getCandidateStatusMsg() {
		return candidateStatusMsg;
	}

	public void setCandidateStatusMsg(String candidateStatusMsg) {
		this.candidateStatusMsg = candidateStatusMsg;
	}

	public candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
