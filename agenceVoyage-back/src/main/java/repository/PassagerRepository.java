package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long>{

	
	Optional<Passager> findByNom(String nom);

	List<Passager> findByNomContaining(String nom);
	
	Optional<Passager> findById(Long id);
	
	//int CountByPassagerContaining(Passager passager);  //erreur detecter 
	
}
