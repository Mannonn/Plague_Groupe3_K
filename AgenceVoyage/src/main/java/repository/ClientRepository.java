package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Client;
import model.Trajet;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Optional<Client> findByNom(String nom);

	List<Client> findByNomContaining(String nom);
	
	Optional<Client> findById(Long id);
	

}
