package main;

import org.springframework.beans.factory.annotation.Autowired;

import model.Planete;
import model.TypePlanete;
import repository.ActiviteRepository;
import repository.AdminRepository;
import repository.ClientRepository;
import repository.CompteRepository;
import repository.PassagerRepository;
import repository.PlaneteRepository;
import repository.ReservationRepository;
import repository.TrajetRepository;
import repository.VaisseauRepository;

public class InitBase {

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

	
	

	public void run(String... args)
	{
		initDataBase();
	}
	
	
	
	
	private void initDataBase() 
	{
		// Planete et activite
		Planete terre = new Planete("Terre",TypePlanete.Urbaine);
		Planete mars = new Planete("Mars",TypePlanete.Desertique);
		// Vaisseau
		
		
		// Trajet
		
		
		//Compte admin et client
		
		
		//Passager
		
		
		//RESERVATION
		
	
	}
	
	

}
