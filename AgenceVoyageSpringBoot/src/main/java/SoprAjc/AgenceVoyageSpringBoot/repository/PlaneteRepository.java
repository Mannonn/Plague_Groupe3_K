package SoprAjc.AgenceVoyageSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoprAjc.AgenceVoyageSpringBoot.model.Planete;
//Test concluant, aucun pb detecte
public interface PlaneteRepository extends JpaRepository<Planete, Long>{

	Optional<Planete> findByNom(String nom);
	 
	  List<Planete> findByNomContaining(String nom);
	
	  Optional<Planete> findById(Long id);

}
