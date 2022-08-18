package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Rejected;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.RejectedRequest;
import webrix.hr.repo.RejectedRepo;

@Service
public class RejectedService extends ExceptionController {

	@Autowired
	RejectedRepo rejectedRepo;

	public ResponseEntity<Object> updateRejected(RejectedRequest rejected) {
		Rejected obj = rejectedRepo.findById(rejected.getRejected_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCreateDate(new Date());
		obj.setRof(rejected.getRof());
		obj.setRejected_msg(rejected.getRejected_msg());
		rejectedRepo.save(obj);
		return response(HttpStatus.OK.value(), "Rejected Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllRejected() {
		List<Rejected> offer = rejectedRepo.findAll();
		return response(HttpStatus.OK.value(), "Rejected details", offer);
	}

}
