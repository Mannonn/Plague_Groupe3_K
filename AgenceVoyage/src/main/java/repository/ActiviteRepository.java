package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;
import model.Planete;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	List<Activite> findByNom(String nom);

	List<Activite> findById(Long id);
	
	List<Activite> findByPlanete(Planete planete);
	
	List<Activite> findByPrixLessThanEqual(double prix);

}
