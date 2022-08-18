package webrix.hr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import webrix.hr.entity.Offer;
import webrix.hr.exceptioControler.ExceptionController;
import webrix.hr.pojo.OfferRequest;
import webrix.hr.repo.OfferRepo;

@Service
public class OfferService extends ExceptionController {
	@Autowired
	OfferRepo offerRepo;

	public ResponseEntity<Object> updateOffer(OfferRequest offer) {
		Offer obj = offerRepo.findById(offer.getOffer_id()).get();
		if (obj == null) {
			return failure(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
					"User id not exists");
		}
		obj.setCreateDate(new Date());
		obj.setAnnualCTC(offer.getAnnualCTC());
		obj.setJoiningDate(offer.getJoiningDate());
		obj.setOfferDate(offer.getOfferDate());
		obj.setOffer_msg(offer.getOffer_msg());
		offerRepo.save(obj);
		return response(HttpStatus.OK.value(), "Offer Updated SecssusFully", obj);

	}

	public ResponseEntity<Object> getAllOffer() {
		List<Offer> offer = offerRepo.findAll();
		return response(HttpStatus.OK.value(), "Offer details", offer);
	}

	
}
