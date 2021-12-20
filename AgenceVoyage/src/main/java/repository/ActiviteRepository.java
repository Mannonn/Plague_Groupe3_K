package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

}
