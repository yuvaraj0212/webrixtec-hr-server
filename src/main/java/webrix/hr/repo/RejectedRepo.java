package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.Rejected;

@Repository
public interface RejectedRepo extends JpaRepository<Rejected, Long> {

}
