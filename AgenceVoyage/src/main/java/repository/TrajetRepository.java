package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Planete;
import model.Trajet;
import model.Vaisseau;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {
	
	/*
	Optional<Trajet> findById(Long id);
	
	List<Trajet> findByPlaneteDepart(Planete planeteDepart);
	List<Trajet> findByPlaneteArrivee(Planete planeteArrivee);
	List<Trajet> findByDateDepart(LocalDate dateDepart);
	//Optional<Trajet> findByAttribut(TypeAttribut attribut)
	//List<Trajet>
	
	//@Query("select <instance> from Class <instance>")
	//	   ("select <instance> from Class <instance> where <instance>.<attribut>=:<variable>") @Param("variable")
	// 	   ("selct <instance> from Class <instance> left join fetch <instance>.<attribut de type list ou set> as <nom> where <instance>.<attribut> ou <nom>.<atributde la collection>=<:variable>)
	
	
	List<Trajet> findByPrixLessThanEqual(double prix);
	
	
	Optional<Trajet> findByVaisseau(Vaisseau vaisseau);
	*/
}
