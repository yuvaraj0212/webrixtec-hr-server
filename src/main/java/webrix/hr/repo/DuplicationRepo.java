package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.Duplication;

@Repository
public interface DuplicationRepo extends JpaRepository<Duplication, Long>{

}
