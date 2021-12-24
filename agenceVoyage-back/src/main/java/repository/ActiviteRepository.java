package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	List<Activite> findByNom(String nom);

	Optional<Activite> findById(Long id);
	
	
	@Query ("select a from Activite a left join fetch a.planete where a.id=:id")
	Optional<Activite> findByIdWithPlanete(@Param("id") Long id); 
	
	List<Activite> findByPrixLessThanEqual(double prix);
}
