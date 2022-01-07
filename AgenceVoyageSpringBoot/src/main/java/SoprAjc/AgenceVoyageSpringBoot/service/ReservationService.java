package SoprAjc.AgenceVoyageSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.exception.ReservationException;
import SoprAjc.AgenceVoyageSpringBoot.model.Client;
import SoprAjc.AgenceVoyageSpringBoot.model.Reservation;
import SoprAjc.AgenceVoyageSpringBoot.repository.ReservationRepository;

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
		Reservation reservationEnBase = reservationRepo.findById(reservation.getId())
				.orElseThrow(ReservationException::new);
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

	public void suppressionAll(Client client) {
		List<Reservation> reservations = reservationRepo.findByClient(client);
		for (Reservation r : reservations) {
			suppression(r);
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

	public Reservation getByIdWithActivites(Long id) {
		if (id != null) {
			return reservationRepo.findByIdWithActivites(id).orElseThrow(ReservationException::new);
		}
		throw new ReservationException();
	}
}
