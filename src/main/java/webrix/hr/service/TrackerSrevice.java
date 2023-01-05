package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Tracker;
import webrix.hr.entity.candidate;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.TrackerRequest;
import webrix.hr.repo.TrackerRepo;
import webrix.hr.repo.candidateRepo;

@Service
public class TrackerSrevice extends ExceptionController {
	@Autowired
	TrackerRepo trackerRepo;
	@Autowired
	candidateRepo candidRepo;

	public ResponseEntity<Object> updateTracker(TrackerRequest tracker) {
		candidate obj = candidRepo.findById(tracker.getTracker_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCandidateStatusMsg(tracker.getTrack_msg());
		obj.setCandidateStatus(tracker.getTrackStaus());
		candidRepo.save(obj);
		return response(HttpStatus.OK.value(), "tracker Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllTracker() {
		List<Tracker> tracker = trackerRepo.findAll();
		return response(HttpStatus.OK.value(), "Offer details", tracker);
	}
}
