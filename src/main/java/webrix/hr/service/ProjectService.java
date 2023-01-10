package webrix.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.ProjectEntity;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.repo.ProjectRepo;

@Service


public class ProjectService extends ExceptionController{
@Autowired
ProjectRepo repo;
	public ResponseEntity<Object> createProject(ProjectEntity data) {
 ProjectEntity obj = new ProjectEntity();
		 
		
		 obj.setClientId(data.getClientId());
		 obj.setClientName(data.getClientName());
		 obj.setProjectName(data.getProjectName());
		 obj.setFeTechnology(data.getFeTechnology());
		 obj.setBeTechnology(data.getBeTechnology());
		 obj.setProjectDuration(data.getProjectDuration());
		 obj.setProjectStartdate(data.getProjectStartdate());
		 obj.setTestDate(data.getTestDate());
		 obj.setRealseDate(data.getRealseDate());
		 obj.setProjectScope(data.getProjectScope());
		 obj.setClientContact(data.getClientContact());
		 obj.setProjectMangers(data.getProjectMangers());
		 obj.setProjectDevelopers(data.getProjectDevelopers());
		 obj.setProjectBudget(data.getProjectBudget());
		 obj.setStatus(data.getStatus());
		repo.save(obj);
		return  response(HttpStatus.OK.value(), "project created successfully", obj);
	}
	
	
	public ResponseEntity<Object> getAllproject() {
		List <ProjectEntity> obj = repo.findAll();
		return  response(HttpStatus.OK.value(), "project getall successfully", obj);
	}
	
	
	public ResponseEntity<Object> updateproject(int updateid, ProjectEntity data) {
		ProjectEntity obj = repo.findById(updateid).get();
		obj.setClientId(data.getClientId());
		 obj.setClientName(data.getClientName());
		 obj.setProjectName(data.getProjectName());
		 obj.setFeTechnology(data.getFeTechnology());
		 obj.setBeTechnology(data.getBeTechnology());
		 obj.setProjectDuration(data.getProjectDuration());
		 obj.setProjectStartdate(data.getProjectStartdate());
		 obj.setTestDate(data.getTestDate());
		 obj.setRealseDate(data.getRealseDate());
		 obj.setProjectScope(data.getProjectScope());
		 obj.setClientContact(data.getClientContact());
		 obj.setProjectMangers(data.getProjectMangers());
		 obj.setProjectDevelopers(data.getProjectDevelopers());
		 obj.setProjectBudget(data.getProjectBudget());
		 obj.setStatus(data.getStatus());
		repo.save(obj);
		return  response(HttpStatus.OK.value(), "project update successfully" + updateid,obj);
	}
	public ResponseEntity<Object> deleteproject(int deleteid) {
		 repo.deleteById(deleteid);
		 return  response(HttpStatus.OK.value(), "project delete successfully");
	}


	public ResponseEntity<Object> getproject(int getid) {
		Optional<ProjectEntity> obj = repo.findById(getid);
		return  response(HttpStatus.OK.value(), "get project id successfully",obj);
	}

	

}
