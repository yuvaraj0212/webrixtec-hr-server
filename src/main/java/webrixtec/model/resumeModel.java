package webrixtec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_uploaded_resumes")
public class resumeModel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Sino;
	private String PositionHNO;
	private String Industry;
	private String PositionType;
	private String ContractDetails;
	private String Requirements;
	private String JobDescription;
	private String Language;
	private String MinimumSalary;
	private String MaximumSalary;
	private String Location;
	private String Japanese;
	private String Residing;
	private String Positions;
	
//	private String status;
//	private String date;
//	
//	
//	
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getDate() {
//		return date;
//	}
//	public void setDate(String date) {
//		this.date = date;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSino() {
		return Sino;
	}
	public void setSino(String sino) {
		Sino = sino;
	}
	public String getPositionHNO() {
		return PositionHNO;
	}
	public void setPositionHNO(String positionHNO) {
		PositionHNO = positionHNO;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public String getPositionType() {
		return PositionType;
	}
	public void setPositionType(String positionType) {
		PositionType = positionType;
	}
	public String getContractDetails() {
		return ContractDetails;
	}
	public void setContractDetails(String contractDetails) {
		ContractDetails = contractDetails;
	}
	public String getRequirements() {
		return Requirements;
	}
	public void setRequirements(String requirements) {
		Requirements = requirements;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getMinimumSalary() {
		return MinimumSalary;
	}
	public void setMinimumSalary(String minimumSalary) {
		MinimumSalary = minimumSalary;
	}
	public String getMaximumSalary() {
		return MaximumSalary;
	}
	public void setMaximumSalary(String maximumSalary) {
		MaximumSalary = maximumSalary;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getJapanese() {
		return Japanese;
	}
	public void setJapanese(String japanese) {
		Japanese = japanese;
	}
	public String getResiding() {
		return Residing;
	}
	public void setResiding(String residing) {
		Residing = residing;
	}
	public String getPositions() {
		return Positions;
	}
	public void setPositions(String positions) {
		Positions = positions;
	}
	
	
}
