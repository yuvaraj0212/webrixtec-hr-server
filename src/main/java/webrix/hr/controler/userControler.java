package webrix.hr.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webrix.hr.entity.userModel;
import webrix.hr.pojo.candidateRequest;
import webrix.hr.pojo.signinRequest;
import webrix.hr.service.userService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class userControler {
	@Autowired
	private userService userService;
	@Autowired
	webrix.hr.service.candidateService candidateService;

	@PostMapping("/signup")
	private ResponseEntity<Object> signUp(@RequestBody userModel user) {
		return userService.signup(user);
	}

	@PostMapping("/signin")
	private ResponseEntity<Object> sigin(@RequestBody signinRequest user) throws Exception {
		return userService.sigin(user);
	}

	@GetMapping("/getmsg")
	private String getmsg() {
		return "user getMsg";
	}

	@PostMapping("/create-candidate")
	public ResponseEntity<Object> createCandidate(candidateRequest candid) throws Exception {
		return candidateService.createCandidate(candid);
	}

	@PostMapping("/update-candidate")
	public ResponseEntity<Object> updateCandidate(@RequestParam(name = "candidId") long id, candidateRequest candid)
			throws Exception {
		return candidateService.updateCandidate(id, candid);
	}

}
