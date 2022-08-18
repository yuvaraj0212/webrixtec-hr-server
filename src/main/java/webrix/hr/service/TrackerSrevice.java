package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Tracker;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.TrackerRequest;
import webrix.hr.repo.TrackerRepo;

@Service
public class TrackerSrevice extends ExceptionController {
	@Autowired
	TrackerRepo trackerRepo;

	public ResponseEntity<Object> updateTracker(TrackerRequest tracker) {
		Tracker obj = trackerRepo.findById(tracker.getTracker_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCreateDate(new Date());
		obj.setTrack_msg(tracker.getTrack_msg());
		obj.setTrackStaus(tracker.getTrackStaus());
		trackerRepo.save(obj);
		return response(HttpStatus.OK.value(), "tracker Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllTracker() {
		List<Tracker> tracker = trackerRepo.findAll();
		return response(HttpStatus.OK.value(), "Offer details", tracker);
	}
}
