package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.ProcessingEntity;

@Repository
public interface processingRepo extends JpaRepository<ProcessingEntity, Long>{

}
