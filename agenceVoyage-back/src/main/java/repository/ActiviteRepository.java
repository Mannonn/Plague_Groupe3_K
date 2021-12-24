package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Activite;
import model.Planete;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	List<Activite> findByNom(String nom);

	Optional<Activite> findById(Long id);
	
	
	@Query ("select a from Activite a left join fetch a.planete where a.id=:id")
	Optional<Activite> findByIdWithPlanete(@Param("planete") Planete planete); //Cette méthode plante, à modifier
	
	List<Activite> findByPrixLessThanEqual(double prix);
}
