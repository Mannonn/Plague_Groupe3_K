package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;
//test valide, aucun pb detecte
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Admin> findByLogin(String login);

	List<Admin> findByLoginContaining(String login);
	
	Optional<Admin> findById(Long id);

}
