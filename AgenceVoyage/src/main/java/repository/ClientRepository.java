package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByNom(String nom);

	List<Client> findByNomContaining(String nom);
	
	Optional<Client> findById(String nom);
}
