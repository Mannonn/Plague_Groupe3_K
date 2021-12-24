package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;
import model.Client;
import model.Passager;
import model.Reservation;
import model.Trajet;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Optional<Reservation> findById(Long id);

	List<Reservation> findByClient(Client client);
	
	//List<Reservation> findByPassagers(Set<Passager> passagers); //erreur detecter
	
	List<Reservation> findByDateReservation(LocalDate dateReservation);
	
	List<Reservation> findByAller(Trajet trajet);
	
	List<Reservation> findByRetour(Trajet trajet);
	
	// int CountByActiviteContaining(Activite activite); //erreur detecter
	// int CountByPassagerContaining(Passager passager); //erreur detecter


}
