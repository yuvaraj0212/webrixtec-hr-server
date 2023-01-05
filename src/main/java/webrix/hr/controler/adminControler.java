package webrix.hr.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webrix.hr.pojo.OfferRequest;
import webrix.hr.pojo.RejectedRequest;
import webrix.hr.pojo.TrackerRequest;
import webrix.hr.pojo.YetToStartRequest;
import webrix.hr.pojo.duplicationRequest;
import webrix.hr.pojo.procesingRequest;
import webrix.hr.service.OfferService;
import webrix.hr.service.RejectedService;
import webrix.hr.service.TrackerSrevice;
import webrix.hr.service.duplicationService;
import webrix.hr.service.processingService;
import webrix.hr.service.userService;
import webrix.hr.service.yetToStartService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class adminControler {

	@Autowired
	userService userService;

	@Autowired
	duplicationService dupService;
	
	@Autowired
	yetToStartService yettostartService;
	
	@Autowired
	processingService processService;

	@Autowired
	OfferService offerService;

	@Autowired
	RejectedService rejectedService;
	
	@Autowired
	TrackerSrevice trackerService;
	
	@Autowired
	webrix.hr.service.candidateService candidateService;

//	********** hello woeld ************//
	@GetMapping("/getmsg")
	private String getmsg() {
		return "Admin getMsg";
	}

//	############ [ users ] ################

	@GetMapping("/get/userdetails")
	private ResponseEntity<Object> getAllUserDetails() {
		return userService.getAllUserDetails();
	}

	@DeleteMapping("/del/user")
	private ResponseEntity<Object> deleteuser(@RequestParam(name = "Id") int Id) {
		return userService.getDelUser(Id);
	}

//	############ [ yet to start ] ################
	@PostMapping("/update-yettostart")
	public ResponseEntity<Object> updateyettostart(@RequestBody YetToStartRequest yettostart) throws Exception {
		return yettostartService.updateyettostart(yettostart);
	}
//	############ [ candidates details ] ################

	@GetMapping("/get-candidates")
	private ResponseEntity<Object> getAllcandidates() {
		return candidateService.getAllcandidates();
	}
	
	@DeleteMapping("/del/candidates")
	private ResponseEntity<Object> deletecandidates(@RequestParam(name = "Id") Long Id) {
		return candidateService.getDelcandidates(Id);
	}

//	############ [ duplication ] ################

	@PostMapping("/update-duplication")
	public ResponseEntity<Object> updateDuplication(@RequestBody duplicationRequest dup) throws Exception {
		return dupService.updateDuplication(dup);
	}

	@GetMapping("/get-duplication")
	private ResponseEntity<Object> getAllDuplication() {
		return dupService.getAllDuplication();
	}

//	############ [ Processing ] ################

	@PostMapping("/update-processing")
	public ResponseEntity<Object> updateProcessing(@RequestBody procesingRequest process) throws Exception {
		return processService.updateProcessing(process);
	}

	@GetMapping("/get-processing")
	private ResponseEntity<Object> getAllProcessing() {
		return processService.getAllProcessing();
	}

//	############ [ Offer ] ################

	@PostMapping("/update-offer")
	public ResponseEntity<Object> updateOffer(@RequestBody OfferRequest Offer) throws Exception {
		return offerService.updateOffer(Offer);
	}

	@GetMapping("/get-offer")
	private ResponseEntity<Object> getAllOffer() {
		return offerService.getAllOffer();
	}
//	############ [ REJECTED ] ################

	@PostMapping("/update-rejected")
	public ResponseEntity<Object> updateRejected(@RequestBody RejectedRequest rejected) throws Exception {
		return rejectedService.updateRejected(rejected);
	}

	@GetMapping("/get-rejected")
	private ResponseEntity<Object> getAllRejected() {
		return rejectedService.getAllRejected();
	}
	
//	############ [ Tracker ] ################

	@PostMapping("/update-tracker")
	public ResponseEntity<Object> updateTracker(@RequestBody TrackerRequest tracker) throws Exception {
		return trackerService.updateTracker(tracker);
	}

	@GetMapping("/get-tracker")
	private ResponseEntity<Object> getAllTracker() {
		return trackerService.getAllTracker();
	}

}
