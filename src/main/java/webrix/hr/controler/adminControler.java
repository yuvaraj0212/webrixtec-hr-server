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

import webrix.hr.pojo.duplicationRequest;
import webrix.hr.pojo.procesingRequest;
import webrix.hr.service.duplicationService;
import webrix.hr.service.processingService;
import webrix.hr.service.userService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class adminControler {

	@Autowired
	userService userService;

	@Autowired
	duplicationService dupService;

	@Autowired
	processingService processService;

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

//	############ [ candidates details ] ################

	@GetMapping("/get-candidates")
	private ResponseEntity<Object> getAllcandidates() {
		return candidateService.getAllcandidates();
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

}
