package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planete;

public interface PlaneteRepository extends JpaRepository<Planete, Integer>{

}
