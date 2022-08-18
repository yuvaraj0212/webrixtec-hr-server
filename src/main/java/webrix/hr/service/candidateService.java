package webrix.hr.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Duplication;
import webrix.hr.entity.ProcessingEntity;
import webrix.hr.entity.candidate;
import webrix.hr.entity.userModel;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.candidateRequest;
import webrix.hr.repo.candidateRepo;
import webrix.hr.repo.userRepo;

@Service
public class candidateService extends ExceptionController {

	@Autowired
	private candidateRepo candidRepo;

	@Autowired
	private userRepo userRepo;

	@Value("${file.upload-dir}")
	String dir;

	public ResponseEntity<Object> createCandidate(candidateRequest candid) throws Exception {
		boolean emailExist = candidRepo.existsByCemail(candid.getCemail());
		if (emailExist) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Email already exists");
		}
		userModel user = userRepo.findById(candid.getUserId()).get();
		if (user == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		} else if (candid.getMfile() == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"File must not empty");
		}

		candidate obj = new candidate();
		obj.setCdob(candid.getcDOB());
		obj.setCemail(candid.getCemail());
		obj.setCmsg(candid.getcMSG());
		obj.setCname(candid.getCname());
		obj.setCphone(candid.getCphone());
		obj.setCreateDate(new Date());
		obj.setCreatedBy(candid.getCreatedBy());
		obj.setJobID(candid.getJobID());
		obj.setUser(user);
//		****** [ local storage ] ********
		String f = Path.of(dir, candid.getMfile().getOriginalFilename()).toString();
		BufferedOutputStream stream;
		stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
		stream.write(candid.getMfile().getBytes());
		stream.close();
		obj.setImagUrl(f);
		obj.setFileName(candid.getMfile().getOriginalFilename().toString());
//		###### [ duplication entity ] #########
		Duplication dup = new Duplication();
		obj.setDuplication(dup);
//		###### [ Processing entity ] #########
		ProcessingEntity process = new ProcessingEntity();
		obj.setProcessing(process);

		candidRepo.save(obj);
		return response(HttpStatus.OK.value(), "Candidate Created SecssusFully", obj);
	}

	public ResponseEntity<Object> getAllcandidates() {
		List<candidate> users = candidRepo.findAll();
		return response(HttpStatus.OK.value(), "candidates", users);
	}

	public ResponseEntity<Object> updateCandidate(long id, candidateRequest candid) throws Exception {
		candidate obj = candidRepo.findById(id).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Candidate Not exists");
		}
		if (candid.getMfile() == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"File must not empty");
		}
		obj.setCdob(candid.getcDOB());
		obj.setCemail(candid.getCemail());
		obj.setCmsg(candid.getcMSG());
		obj.setCname(candid.getCname());
		obj.setCphone(candid.getCphone());
		obj.setCreateDate(new Date());
		obj.setCreatedBy(candid.getCreatedBy());
		obj.setJobID(candid.getJobID());
//		local storage
		String f = Path.of(dir, candid.getMfile().getOriginalFilename()).toString();
		BufferedOutputStream stream;
		stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
		stream.write(candid.getMfile().getBytes());
		stream.close();
		obj.setImagUrl(f);
		obj.setFileName(candid.getMfile().getOriginalFilename().toString());
		candidRepo.save(obj);
		return response(HttpStatus.OK.value(), "Candidate updated SecssusFully", obj);
	}

}
