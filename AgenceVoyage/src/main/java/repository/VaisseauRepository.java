package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vaisseau;

public interface VaisseauRepository extends JpaRepository<Vaisseau, Integer>{

}
