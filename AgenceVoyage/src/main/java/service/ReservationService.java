package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ReservationException;
import model.Activite;
import model.Passager;
import model.Reservation;
import model.Trajet;
import repository.ActiviteRepository;
import repository.PassagerRepository;
import repository.ReservationRepository;
import repository.TrajetRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private PassagerService passagerService;
	
	@Autowired
	private ActiviteService activiteService;
	
	@Autowired
	private TrajetService trajetService;

	public void creation(Reservation reservation) {
		if (reservation.getNom() == null) {
			throw new ReservationException();
		}
		reservationRepo.save(reservation);
	}

	public void suppression(Reservation reservation) {
		Reservation reservationEnBase = null;
		if (reservation.getId() != null) {
			reservationEnBase = reservationRepo.findById(reservation.getId()).orElseThrow(ReservationException::new);
			reservationRepo.delete(reservationEnBase);
		} else {
			throw new ReservationException();
		}
	}

	
	// Supprimer le passager sans supprimer la reservation
	public void suppression(Passager passager, Reservation reservation) {
		if (passager.getId() != null) {
			Passager passagerEnBase = PassagerService.getBy(passager.getId());
			
			//A modifier une fois que les repo seront à jour !
			reservationRepo.deleteByMaitre(passagerEnBase); //Changer le ByMaitre 
			
			// Si y'a pas de passager on supprime la reservation
			if (reservation.getPassagers()==null) {
				suppression(reservation);
			}
			
		} else {
			throw new ReservationException();
		}
	}
	
	// Supprimer l'activité sans supprimer la reservation
	public void suppression(Activite activite) {
		if (activite.getId() != null) {
			Activite activiteEnBase = ActiviteService.getBy(activite.getId());
			
			//A modifier une fois que les repo seront à jour !
			reservationRepo.deleteByMaitre(activiteEnBase); //Changer le ByMaitre 
		} else {
			throw new ReservationException();
		}
	}
	
	// Supprimer le trajet sans supprimer la reservation
		public void suppression(Trajet trajet) {
			if (trajet.getId() != null) {
				Trajet trajetEnBase = TrajetService.getBy(trajet.getId());
				
				//A modifier une fois que les repo seront à jour !
				reservationRepo.deleteByMaitre(trajetEnBase);//Changer le ByMaitre 
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

}

