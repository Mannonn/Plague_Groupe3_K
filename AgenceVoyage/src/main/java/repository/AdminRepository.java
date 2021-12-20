package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	Optional<Admin> findByNom(String nom);

	List<Admin> findByNomContaining(String nom);
	
	Optional<Admin> findById(Long id);
}
