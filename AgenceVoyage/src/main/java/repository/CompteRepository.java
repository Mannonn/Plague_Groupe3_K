package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	/*
	Optional<Compte> findByNom(String nom);

	List<Compte> findByNomContaining(String nom);
	
	Optional<Compte> findById(Long id);
	*/
}
