package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ActiviteException;
import exception.ReservationException;
import model.Activite;
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
	
	public Reservation update(Reservation reservation) {
        if (reservation.getId() == null) {
            throw new ReservationException();
        }
        Reservation reservationEnBase = reservationRepo.findById(reservation.getId()).orElseThrow(ReservationException::new);
        creation(reservationEnBase);
        return reservationRepo.save(reservation);

    }


	public void suppression(Reservation reservation) {
		Reservation reservationEnBase = null;
		if (reservation.getId() != null) {
			reservationEnBase = reservationRepo.findById(reservation.getId()).orElseThrow(ReservationException::new);
		} else {
			throw new ReservationException();
		}
	}
	
	public Reservation getById(Long id) {
		if (id != null) {
			return reservationRepo.findById(id).orElseThrow(ReservationException::new);
		}
		throw new ReservationException();
	}

	public List<Reservation> getAll() {
		return reservationRepo.findAll();
	}

	public Reservation getByIdWithPassagers(Long id) {
		if (id != null) {
			return reservationRepo.findByIdWithPassagers(id).orElseThrow(ReservationException::new);
		}
		throw new ReservationException();
	}
}

