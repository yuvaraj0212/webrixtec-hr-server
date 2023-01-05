package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Duplication;
import webrix.hr.entity.candidate;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.duplicationRequest;
import webrix.hr.repo.DuplicationRepo;
import webrix.hr.repo.candidateRepo;

@Service
public class duplicationService extends ExceptionController {

	@Autowired
	DuplicationRepo dupRepo;

	public ResponseEntity<Object> updateDuplication(duplicationRequest dup) {
		Duplication obj = dupRepo.findById(dup.getDup_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCreateDate(new Date());
		obj.setDuplication_msg(dup.getDuplication_msg());
		obj.setDuplication_status(dup.getDuplication_status());
		dupRepo.save(obj);
		return response(HttpStatus.OK.value(), "duplition Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllDuplication() {
		List<Duplication> dup = dupRepo.findAll();
		return response(HttpStatus.OK.value(), "Duplication", dup);
	}

}
