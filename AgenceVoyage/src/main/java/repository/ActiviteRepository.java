package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;
import model.Planete;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	List<Activite> findByNom(String nom);

<<<<<<< HEAD
	List<Activite> findByNomContaining(String nom);
/*
	@Query("select a from Compagnon c left join fetch c.maitre where c.id=:id")
	Optional<Compagnon> findByIdWithMaitre(@Param("id") Long id);

//	@Transactional
//	@Modifying
//	@Query("update Compagnon c set c.maitre=null where c.maitre=:maitre")
//	void updateMaitreCompagnon(@Param("maitre") Personnage maitre);
//
	@Transactional
	@Modifying
	@Query("delete Compagnon c where c.maitre=:maitre")
	void deleteByMaitre(@Param("maitre") Personnage maitre);
	*/
=======
	List<Activite> findById(Long id);
	
	List<Activite> findByPlanete(Planete planete);
	
	List<Activite> findByPrixLessThanEqual(double prix);

>>>>>>> developp
}
