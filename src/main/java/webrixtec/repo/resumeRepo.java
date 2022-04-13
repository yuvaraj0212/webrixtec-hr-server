package webrixtec.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrixtec.model.resumeModel;

@Repository
public interface resumeRepo extends JpaRepository<resumeModel, Long> {

}
