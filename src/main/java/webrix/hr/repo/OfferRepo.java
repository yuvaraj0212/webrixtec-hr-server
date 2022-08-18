package webrix.hr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webrix.hr.entity.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Long> {

}
