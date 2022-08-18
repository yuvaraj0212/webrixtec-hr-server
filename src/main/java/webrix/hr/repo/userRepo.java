package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.userModel;

@Repository
public interface userRepo extends JpaRepository<userModel, Integer> {

	userModel findByEmail(String email);

	boolean existsByEmail(String email);
	
}
