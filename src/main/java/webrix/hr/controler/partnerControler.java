package webrix.hr.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
public class partnerControler {

	@GetMapping("/getmsg")
	private String getmsg() {
		// TODO Auto-generated method stub
		return "partner getMsg";
	}

}
