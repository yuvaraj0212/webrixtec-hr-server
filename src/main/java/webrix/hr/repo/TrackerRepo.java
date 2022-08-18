package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.Tracker;

@Repository
public interface TrackerRepo extends JpaRepository<Tracker, Long>{

}
