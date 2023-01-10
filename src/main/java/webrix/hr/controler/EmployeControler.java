package webrix.hr.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webrix.hr.entity.Employe;
import webrix.hr.pojo.candidateRequest;
import webrix.hr.service.EmployeService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class EmployeControler {

	@Autowired
	EmployeService employeService;
	
	@PostMapping("/create-employe")
	public ResponseEntity<Object> createCandidate(Employe emp) throws Exception {
		return employeService.createEmploye(emp);
	}
	
	@PostMapping("/update-employe")
	public ResponseEntity<Object> updateCandidate( Employe emp)
			throws Exception {
		return employeService.updateEmploye(emp);
	}
	
	@GetMapping("/get-all-employe")
	private ResponseEntity<Object> getAllEmploye() {
		return employeService.getAllEmploye();
	}
	
	@DeleteMapping("/delete-employe")
	private ResponseEntity<Object> deleteEmploye(@RequestParam(name = "id") int Id) {
		return employeService.getDelEmploye(Id);
	}
}
