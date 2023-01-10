package webrix.hr.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webrix.hr.entity.ProjectEntity;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.candidateRequest;
import webrix.hr.repo.ProjectRepo;
import webrix.hr.service.ProjectService;
import webrix.hr.service.userService;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController extends ExceptionController {

	@Autowired
	ProjectRepo repo;

	@Autowired
	ProjectService projectService;

	@PostMapping("/create-project")
	public ResponseEntity<Object> createProject(@RequestBody ProjectEntity data) throws Exception {

		return projectService.createProject(data);

	}

	@GetMapping("/get-all-project")
	public ResponseEntity<Object> getAllproject() {
		return projectService.getAllproject();
	}

	@PutMapping("/update-project")
	public ResponseEntity<Object> updateProject(@RequestParam("id") int updateid ,@RequestBody ProjectEntity data) {
		return projectService.updateproject(updateid,data);

	}
   @DeleteMapping("/delete-project")
   public ResponseEntity<Object> deleteproject(@RequestParam("id")int deleteid){
   return projectService.deleteproject(deleteid);
   }
   @GetMapping("/get-project")
   public ResponseEntity<Object> getproject(@RequestParam("id")int getid){
	   return projectService.getproject(getid);
   }
}
