package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ReservationException;
import model.Passager;
import model.Reservation;
import repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private PassagerService passagerService;


	public void creation(Reservation reservation) {
		if (reservation.getId() == null) {
			throw new ReservationException();
		}
		reservationRepo.save(reservation);
	}

	//Lorsqu'on supprime la resa, on supprime les passagers aussi
	/*public void suppression(Reservation reservation, Passager passager) {
		Reservation reservationEnBase = null;
		if (reservation.getId() != null) {
			reservationEnBase = reservationRepo.findById(reservation.getId()).orElseThrow(ReservationException::new);
			passagerService.suppression(passager, reservationEnBase);
		} else {
			throw new ReservationException();
		}
	}*/
	
	public Reservation getById(Long id) {
		if (id != null) {
			return reservationRepo.findById(id).orElseThrow(ReservationException::new);
		}
		throw new ReservationException();
	}

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

}

