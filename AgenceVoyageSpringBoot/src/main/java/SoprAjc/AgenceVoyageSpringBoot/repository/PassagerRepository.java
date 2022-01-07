package SoprAjc.AgenceVoyageSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoprAjc.AgenceVoyageSpringBoot.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long> {

	Optional<Passager> findByNom(String nom);

	List<Passager> findByNomContaining(String nom);

	Optional<Passager> findById(Long id);

}
