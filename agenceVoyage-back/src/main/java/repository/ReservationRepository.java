package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Client;
import model.Reservation;
import model.Trajet;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Optional<Reservation> findById(Long id);

	List<Reservation> findByClient(Client client);
	
	@Query("select r from Reservation r left join fetch r.passagers where r.id=:id")
	Optional<Reservation> findByIdWithPassagers(@Param("id") Long id); //erreur detecter
	
	List<Reservation> findByDateReservation(LocalDate dateReservation);
	
	List<Reservation> findByAller(Trajet trajet);
	
	List<Reservation> findByRetour(Trajet trajet);
	

}
