package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.candidate;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.YetToStartRequest;
import webrix.hr.repo.candidateRepo;

@Service
public class yetToStartService extends ExceptionController {
	@Autowired
	private candidateRepo candidRepo;

	public ResponseEntity<Object> updateyettostart(YetToStartRequest yettostart) {

		candidate obj = candidRepo.findById(yettostart.getCandidId()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCandidateStatus(yettostart.getStatus());
		obj.setCandidateStatusMsg(yettostart.getMsg());
		candidRepo.save(obj);

		List<candidate> candidates = candidRepo.findAll();
		return response(HttpStatus.OK.value(), "Updated sucessfull",candidates);
	}

}
