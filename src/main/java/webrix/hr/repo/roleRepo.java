package webrix.hr.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.roleModel;

@Repository
public interface roleRepo extends JpaRepository<roleModel, Long> {

	Set<roleModel> findByRolename(String string);

	
}
