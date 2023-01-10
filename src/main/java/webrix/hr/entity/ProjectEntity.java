package webrix.hr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_tbl")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int clientId;
	private String clientName;
	private String projectName;
	private String feTechnology;
	private String beTechnology;
	private String projectDuration;
	private String projectStartdate;
	private String testDate;
	private String realseDate;
	private String projectScope;
	private String clientContact;
	private String projectMangers;
	private String projectDevelopers;
	private String projectBudget;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getFeTechnology() {
		return feTechnology;
	}
	public void setFeTechnology(String feTechnology) {
		this.feTechnology = feTechnology;
	}
	public String getBeTechnology() {
		return beTechnology;
	}
	public void setBeTechnology(String beTechnology) {
		this.beTechnology = beTechnology;
	}
	public String getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}
	public String getProjectStartdate() {
		return projectStartdate;
	}
	public void setProjectStartdate(String projectStartdate) {
		this.projectStartdate = projectStartdate;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getRealseDate() {
		return realseDate;
	}
	public void setRealseDate(String realseDate) {
		this.realseDate = realseDate;
	}
	public String getProjectScope() {
		return projectScope;
	}
	public void setProjectScope(String projectScope) {
		this.projectScope = projectScope;
	}
	public String getClientContact() {
		return clientContact;
	}
	public void setClientContact(String clientContact) {
		this.clientContact = clientContact;
	}
	public String getProjectMangers() {
		return projectMangers;
	}
	public void setProjectMangers(String projectMangers) {
		this.projectMangers = projectMangers;
	}
	public String getProjectDevelopers() {
		return projectDevelopers;
	}
	public void setProjectDevelopers(String projectDevelopers) {
		this.projectDevelopers = projectDevelopers;
	}
	public String getProjectBudget() {
		return projectBudget;
	}
	public void setProjectBudget(String projectBudget) {
		this.projectBudget = projectBudget;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
