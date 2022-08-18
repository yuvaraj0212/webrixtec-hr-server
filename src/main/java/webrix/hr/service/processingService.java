package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.ProcessingEntity;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.procesingRequest;
import webrix.hr.repo.processingRepo;

@Service
public class processingService extends ExceptionController {

	@Autowired
	processingRepo processRepo;

	public ResponseEntity<Object> updateProcessing(procesingRequest process) {
		ProcessingEntity obj = processRepo.findById(process.getProcess_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setStartDate(new Date());
		obj.setBudjet(process.getBudjet());
		obj.setTechnolgy(process.getTechnolgy());
		processRepo.save(obj);
		return response(HttpStatus.OK.value(), "Procesing Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllProcessing() {
		List<ProcessingEntity> process = processRepo.findAll();
		return response(HttpStatus.OK.value(), "Processing details", process);
	}

}
