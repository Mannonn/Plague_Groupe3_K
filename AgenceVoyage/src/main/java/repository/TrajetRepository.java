package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Integer> {

}
