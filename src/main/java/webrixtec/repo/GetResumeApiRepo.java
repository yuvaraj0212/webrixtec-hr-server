package webrixtec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrixtec.model.getResumeApiEntity;

@Repository
public interface GetResumeApiRepo extends JpaRepository<getResumeApiEntity, Integer> {

	boolean existsByEmail(String name);

	boolean existsByPhone(String phone);

}
