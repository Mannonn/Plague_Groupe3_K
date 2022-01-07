package SoprAjc.AgenceVoyageSpringBoot.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoprAjc.AgenceVoyageSpringBoot.model.Planete;
import SoprAjc.AgenceVoyageSpringBoot.model.Trajet;
import SoprAjc.AgenceVoyageSpringBoot.model.Vaisseau;
// c ok
public interface TrajetRepository extends JpaRepository<Trajet, Long> {

	Optional<Trajet> findById(Long id);
	
	List<Trajet> findByDepart(Planete depart);
	
	List<Trajet> findByArrivee(Planete arrivee);
	
	List<Trajet> findByDateDepart(LocalDate dateDepart);
	
	List<Trajet> findByHeureDepart(LocalTime heureDepart);
	
	List<Trajet> findByDateArrivee(LocalDate dateArrivee);
	
	List<Trajet> findByHeureArrivee(LocalTime heureArrivee);
	
	List<Trajet> findByPrixLessThanEqual(double prix);
	
	Optional<Trajet> findByVaisseau(Vaisseau vaisseau);

}

//Cours

//Optional<Trajet> findByAttribut(TypeAttribut attribut)
//List<Trajet>

//@Query("select <instance> from Class <instance>")
//	   ("select <instance> from Class <instance> where <instance>.<attribut>=:<variable>") @Param("variable")
// 	   ("selct <instance> from Class <instance> left join fetch <instance>.<attribut de type list ou set> as <nom> where <instance>.<attribut> ou <nom>.<atributde la collection>=<:variable>)
