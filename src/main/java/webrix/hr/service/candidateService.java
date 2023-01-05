package webrix.hr.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Duplication;
import webrix.hr.entity.Offer;
import webrix.hr.entity.ProcessingEntity;
import webrix.hr.entity.Rejected;
import webrix.hr.entity.Tracker;
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
	private JavaMailSender mailSender;

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
		} else if (candid.getMfile() == null ) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"File must not empty");
		}

		candidate obj = new candidate();
		obj.setCandidateStatus(null);
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
//		obj.setMfile(candid.getMfile());
//		###### [ duplication entity ] #########
		Duplication dup = new Duplication();
		obj.setDuplication(dup);
//		###### [ Processing entity ] #########
		ProcessingEntity process = new ProcessingEntity();
		obj.setProcessing(process);
//		###### [ Offer entity ] #########
		Offer offer = new Offer();
		obj.setOffer(offer);
//		###### [ Rejcted entity ] #########
		Rejected reject = new Rejected();
		obj.setRejected(reject);
//		###### [ trecker entity ] #########
		Tracker tracker = new Tracker();
		obj.setTracker(tracker);
		candidRepo.save(obj);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = "Hi "+user.getName()+"," + "<br>" +

				"Thank you for your interest in <b>WEBRIXTEC<b>. We have received your application for the open Developer position and will review your materials thoroughly."
				+

				"Someone from our team will be in touch to update you on the status of your application within 48 hrs."
				+

				"In the meantime, please visit <a href='https://www.webrixtec.com'>webrixtec</a> to learn more about our company.<br>"

				+ "Best,<br>" + "<b>WEBRIXTEC<b> Recruiting Team";
		helper.setText(htmlMsg, true); // Use this or above line.
		helper.setTo(candid.getCemail());
		helper.setSubject(user.getName() + "— We Received Your Application");
		helper.setFrom("WEBRIXTEC <webrixtec@gamil.com>");
		mailSender.send(mimeMessage);
//		String htmlMsg1 = "Hi " + candid.getCname() + "<br /> "
//				+ " Thanks for choosing<b> webrixtec.</b><br />";
//		helper.setText(htmlMsg, true); // Use this or above line.
//		helper.setTo("webrixtec@gmail.com");
//		helper.setSubject(" New candidate added from "+user.getName());
//		helper.setFrom("JOB PARTNER <jobpartner.webrixtec@gamil.com>");
//		mailSender.send(mimeMessage);
		List<candidate> candidates = candidRepo.findAll();
		Collections.reverse(candidates);
		return response(HttpStatus.OK.value(), "Candidate Created SecssusFully", candidates);
	}

	public ResponseEntity<Object> getAllcandidates() {
		List<candidate> candidates = candidRepo.findAll();
		Collections.reverse(candidates);
		return response(HttpStatus.OK.value(), "candidates", candidates);
	}

	public ResponseEntity<Object> updateCandidate(long id, candidateRequest candid) throws Exception {
		candidate obj = candidRepo.findById(id).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"Candidate Not exists");
		}
		if (candid.getMfile() != null) {
//			local storage
			String f = Path.of(dir, candid.getMfile().getOriginalFilename()).toString();
			BufferedOutputStream stream;
			stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
			stream.write(candid.getMfile().getBytes());
			stream.close();
			obj.setImagUrl(f);
			obj.setFileName(candid.getMfile().getOriginalFilename().toString());
//			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
//					"File must not empty");
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
//		String f = Path.of(dir, candid.getMfile().getOriginalFilename()).toString();
//		BufferedOutputStream stream;
//		stream = new BufferedOutputStream(new FileOutputStream(new File(f)));
//		stream.write(candid.getMfile().getBytes());
//		stream.close();
//		obj.setImagUrl(f);
//		obj.setFileName(candid.getMfile().getOriginalFilename().toString());
//		update details

		candidRepo.save(obj);
//		List<candidate> candidates = candidRepo.findAll();
		return response(HttpStatus.OK.value(), "Candidate updated SecssusFully", obj);
	}

	public ResponseEntity<Object> getDelcandidates(Long id) {
		candidate user = candidRepo.findById(id).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		candidRepo.delete(user);
		return response(HttpStatus.OK.value(), "Candidate deleted SecssusFully");
	}

}
