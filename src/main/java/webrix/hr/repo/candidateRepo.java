package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.candidate;

@Repository
public interface candidateRepo extends JpaRepository<candidate, Long> {

	boolean existsByCemail(String cemail);

}
