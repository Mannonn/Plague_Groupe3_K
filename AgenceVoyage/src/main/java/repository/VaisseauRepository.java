package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Trajet;
import model.Vaisseau;
//Niquel g fini adios 
public interface VaisseauRepository extends JpaRepository<Vaisseau, Long>{

	List<Trajet> findByNomContaining(String nom);
	
	Optional<Vaisseau> findById(Long id);
	
	Optional<Vaisseau> findByNom(String nom);

}
