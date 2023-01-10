package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer> {

}
