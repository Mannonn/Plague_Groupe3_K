package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;
import model.Planete;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	List<Activite> findByNom(String nom);

	Optional<Activite> findById(Long id);
	
	List<Activite> findByPlanete(Planete planete);
	
	List<Activite> findByPrixLessThanEqual(double prix);

}
