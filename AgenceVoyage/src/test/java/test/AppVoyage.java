package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import model.Activite;
import model.Admin;
import model.Client;
import model.Compte;
import model.Passager;
import model.Planete;
import model.Reservation;
import model.Trajet;
import model.TypePlanete;
import model.Vaisseau;
import repository.ActiviteRepository;
import repository.AdminRepository;
import repository.ClientRepository;
import repository.CompteRepository;
import repository.PassagerRepository;
import repository.PlaneteRepository;
import repository.ReservationRepository;
import repository.TrajetRepository;
import repository.VaisseauRepository;

public class AppVoyage {
	
	
	
	@Autowired
	private ActiviteRepository activiteRepo;
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private PassagerRepository passagerRepo;
	@Autowired
	private PlaneteRepository planeteRepo;
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	private TrajetRepository trajetRepo;
	@Autowired
	private VaisseauRepository vaisseauRepo;

	
	public static void main(String[] args) {
	//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//PlaneteRepository planeteRepo = ctx.getBean(PlaneteRepository.class);
		//VaisseauRepository vaisseauRepo = ctx.getBean(VaisseauRepository.class);
		
		//vaisseauRepo.findAll();
		//planeteRepo.findAll();
		//System.out.println(vaisseauRepo);

		
	}
}
