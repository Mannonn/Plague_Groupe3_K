package SoprAjc.AgenceVoyageSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.exception.PassagerException;
import SoprAjc.AgenceVoyageSpringBoot.model.Passager;
import SoprAjc.AgenceVoyageSpringBoot.model.Reservation;
import SoprAjc.AgenceVoyageSpringBoot.repository.PassagerRepository;

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

	public Passager update(Passager passager) {
		if (passager.getId() == null) {
			throw new PassagerException();
		}
		Passager passagerEnBase = passagerRepo.findById(passager.getId()).orElseThrow(PassagerException::new);
		creation(passagerEnBase);
		return passagerRepo.save(passager);

	}

	// Supprime le passager et la r�servation si la liste de passagers est vide --> impossible car si resa nulle exception 
	public void suppression(Passager passager) {
		Passager passagerEnBase = null;
		if (passager.getId() != null ) {
			passagerEnBase = passagerRepo.findById(passager.getId()).orElseThrow(PassagerException::new);
			passagerRepo.delete(passagerEnBase);
		} else {
			throw new PassagerException();
		}
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
