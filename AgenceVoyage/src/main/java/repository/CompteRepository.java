package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

	Optional<Compte> findByLogin(String login);

	List<Compte> findByLoginContaining(String login);
	
	Optional<Compte> findById(Long id);

}
