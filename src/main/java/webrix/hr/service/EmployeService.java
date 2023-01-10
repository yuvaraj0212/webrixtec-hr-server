package webrix.hr.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Employe;
import webrix.hr.entity.candidate;
import webrix.hr.entity.roleModel;
import webrix.hr.entity.userModel;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.repo.EmployeRepo;
import webrix.hr.repo.roleRepo;
import webrix.hr.repo.userRepo;

@Service
public class EmployeService extends ExceptionController {
	@Autowired
	private userRepo userRepo;
	
	@Autowired
	private EmployeRepo empRepo;
	@Autowired
	private roleRepo roleRepo;
	@Value("${file.upload-dir}")
	String dir;
	
	
	public ResponseEntity<Object> createEmploye(Employe emp) throws IOException {

		Employe obj = new Employe();
//		****** [ local storage ] ********
		if (emp.getMfile() != null) {
		String f = Path.of(dir, emp.getMfile().getOriginalFilename()).toString();
		BufferedOutputStream stream;
		stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
		stream.write(emp.getMfile().getBytes());
		stream.close();
		obj.setImageUrl(f);
		obj.setFileName(emp.getMfile().getOriginalFilename().toString());
//		obj.setMfile(emp.getMfile());
		}
		obj.setAadhar(emp.getAadhar());
		obj.setAccountNumber(emp.getAccountNumber());
		obj.setAddress(emp.getAddress());
		obj.setAltEmail(emp.getAltEmail());
		obj.setAltPhone(emp.getAltPhone());
		obj.setBankcode(emp.getBankcode());
		obj.setBranchName(emp.getBranchName());
		obj.setCity(emp.getCity());
		obj.setCountry(emp.getCountry());
		obj.setCreateDate(new Date());
		obj.setCurrentProject(emp.getCurrentProject());
		obj.setDegree(emp.getDegree());
		obj.setDepart(emp.getDepart());
		obj.setDepartment(emp.getDepartment());
		obj.setDob(emp.getDob());
		obj.setEmail(emp.getEmail());
		obj.setExperience(emp.getExperience());
		obj.setIfsc(emp.getIfsc());
		obj.setJlpt(emp.getJlpt());
		obj.setJobType(emp.getJobType());
		obj.setName(emp.getName());
		obj.setPan(emp.getPan());
		obj.setPassword(emp.getPassword());
		obj.setPhone(emp.getPhone());
		obj.setPosition(emp.getPosition());
		obj.setRole("ROLE_EMPLOYE");
		obj.setSkills(emp.getSkills());
		obj.setYearPassout(emp.getYearPassout());
		userModel userObj = new userModel();
		userObj.setEmail(emp.getEmail());
		userObj.setCreateDate(new Date());
		userObj.setName(emp.getName());
		userObj.setAltEmail(emp.getAltEmail());
		userObj.setAltPhone(emp.getAltPhone());
		userObj.setCity(emp.getCity());
		userObj.setCountry(emp.getCountry());
		userObj.setPhone(emp.getPhone());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(emp.getPassword());
		userObj.setPassword(encode);
		Set<roleModel> role = roleRepo.findByRolename("ROLE_EMPLOYE");
		userObj.setRoles(role);
		userRepo.save(userObj);
		empRepo.save(obj);
		return response(HttpStatus.OK.value(), "Employee Created SecssusFully", obj);
		}


	public ResponseEntity<Object> updateEmploye(Employe emp) throws IOException {
		Employe obj = empRepo.findById(emp.getId()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Candidate Not exists");
		}
//		****** [ local storage ] ********
		if (emp.getMfile() != null) {
		String f = Path.of(dir, emp.getMfile().getOriginalFilename()).toString();
		BufferedOutputStream stream;
		stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
		stream.write(emp.getMfile().getBytes());
		stream.close();
		obj.setImageUrl(f);
		obj.setFileName(emp.getMfile().getOriginalFilename().toString());
//		obj.setMfile(emp.getMfile());
		}
		obj.setAadhar(emp.getAadhar());
		obj.setAccountNumber(emp.getAccountNumber());
		obj.setAddress(emp.getAddress());
		obj.setAltEmail(emp.getAltEmail());
		obj.setAltPhone(emp.getAltPhone());
		obj.setBankcode(emp.getBankcode());
		obj.setBranchName(emp.getBranchName());
		obj.setCity(emp.getCity());
		obj.setCountry(emp.getCountry());
		obj.setCurrentProject(emp.getCurrentProject());
		obj.setDegree(emp.getDegree());
		obj.setDepart(emp.getDepart());
		obj.setDepartment(emp.getDepartment());
		obj.setDob(emp.getDob());
		obj.setExperience(emp.getExperience());
		obj.setIfsc(emp.getIfsc());
		obj.setJlpt(emp.getJlpt());
		obj.setJobType(emp.getJobType());
		obj.setName(emp.getName());
		obj.setPan(emp.getPan());
		obj.setPhone(emp.getPhone());
		obj.setPosition(emp.getPosition());
		obj.setRole("ROLE_EMPLOYE");
		obj.setSkills(emp.getSkills());
		obj.setYearPassout(emp.getYearPassout());
		empRepo.save(obj);
		return response(HttpStatus.OK.value(), "Employe updated SecssusFully", obj);
	}


	public ResponseEntity<Object> getAllEmploye() {
		List<Employe> emp = empRepo.findAll();
		Collections.reverse(emp);
		return response(HttpStatus.OK.value(), "Employe", emp);
	}


	public ResponseEntity<Object> getDelEmploye(int id) {
		Employe user = empRepo.findById(id).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		empRepo.delete(user);
		return response(HttpStatus.OK.value(), "Employe deleted SecssusFully");
	}

}
