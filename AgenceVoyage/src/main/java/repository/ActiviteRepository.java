package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	/*
	 List<Activite> findByNom(String nom);


	Optional<Activite> findById(Long id);
	
	List<Activite> findByPlanete(Planete planete);
	
	List<Activite> findByPrixLessThanEqual(double prix);
	

>>>>>>> developp
*/
}
