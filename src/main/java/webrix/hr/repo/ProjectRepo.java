package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.controler.ProjectController;
import webrix.hr.entity.ProjectEntity;

@Repository

public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer >{
	

}
