package webrix.hr.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "employer_tbl")
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dob;
	private String email;
	private String altEmail;
    private String degree;
    private String department;
    private String pan ;
    private String aadhar;
	private String yearPassout;
    private String experience;
    private String skills;
    private String jlpt;
    private String depart;
    private String jobType;
    private String imageUrl;
	private String phone;
	private String altPhone;
    private String fileName;
	private String accountNumber;
	private String ifsc;
	private String branchName;
	private String bankcode;
	private String position;
	private String city;
	
	private String country;
	private String password;
	private Date createDate;
	private String role;
	private String address;
	private String currentProject;
	@Transient
	private MultipartFile mfile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAltEmail() {
		return altEmail;
	}
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getYearPassout() {
		return yearPassout;
	}
	public void setYearPassout(String yearPassout) {
		this.yearPassout = yearPassout;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getJlpt() {
		return jlpt;
	}
	public void setJlpt(String jlpt) {
		this.jlpt = jlpt;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAltPhone() {
		return altPhone;
	}
	public void setAltPhone(String altPhone) {
		this.altPhone = altPhone;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public Employe(Employe emp) {
		super();
//		this.id = emp.getId();
		this.name = emp.getName();
		this.dob = emp.getDob();
		this.email = emp.getEmail();
		this.altEmail = emp.getAltEmail();
		this.degree = emp.getDegree();
		this.department = emp.getDepartment();
		this.pan = emp.getPan();
		this.aadhar = emp.getAadhar();
		this.yearPassout = emp.getYearPassout();
		this.experience = emp.getExperience();
		this.skills = emp.getSkills();
		this.jlpt = emp.getJlpt();
		this.depart = emp.getDepart();
		this.jobType = emp.getJobType();
		this.imageUrl = emp.getImageUrl();
		this.phone = emp.getPhone();
		this.altPhone = emp.getAltPhone();
		this.fileName = emp.getFileName();
		this.accountNumber = emp.getAccountNumber();
		this.ifsc = emp.getIfsc();
		this.branchName = emp.getBranchName();
		this.bankcode = emp.getBankcode();
		this.position = emp.getPosition();
		this.city = emp.getCity();
		this.country = emp.getCountry();
		this.password = emp.getPassword();
		this.createDate = emp.getCreateDate();
		this.role = emp.getRole();
		this.address = emp.getAddress();
		this.currentProject = emp.getCurrentProject();
		this.mfile = emp.getMfile();
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
