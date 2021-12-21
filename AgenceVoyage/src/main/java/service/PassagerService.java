package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PassagerException;
import model.Passager;
import model.Reservation;
import repository.PassagerRepository;

@Service
public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepo;
	@Autowired
	private ReservationService reservationService;

	public void creation(Passager passager) {
		if (passager.getId() == null) {
			throw new PassagerException();
		}
		passagerRepo.save(passager);
	}

	//Supprime le passager et la réservation si la liste de passagers est nulle
	public void suppression(Passager passager, Reservation reservation) {
		Passager passagerEnBase = null;
		if (passager.getId() != null ) {
			passagerEnBase = passagerRepo.findById(passager.getId()).orElseThrow(PassagerException::new);
			if (passagerRepo.CountByPassagerContaining(passager)>1) {passagerRepo.delete(passagerEnBase);}
			else  {
				reservationService.suppression(reservation, passagerEnBase);}
		} else {
			throw new PassagerException();}
	}

	public Passager getById(Long id) {
		if (id != null) {
			return passagerRepo.findById(id).orElseThrow(PassagerException::new);
		}
		throw new PassagerException();
	}

	public List<Passager> getAll() {
		return passagerRepo.findAll();
	}

}

