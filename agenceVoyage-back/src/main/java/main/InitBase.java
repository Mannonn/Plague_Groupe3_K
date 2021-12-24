package main;

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
		// Planete 
		Planete terre = new Planete("Terre",TypePlanete.Urbaine);
		Planete mars = new Planete("Mars",TypePlanete.Desertique);
		Planete atlantide = new Planete("Atlantide",TypePlanete.Tropicale);
		Planete saturne = new Planete("Neptune",TypePlanete.Glaciaire);
		Planete lune = new Planete("Lune",TypePlanete.Montagneuse);
		
		planeteRepo.save(terre);
		planeteRepo.save(mars);
		planeteRepo.save(atlantide);
		planeteRepo.save(saturne);
		planeteRepo.save(lune);
		
		
		// Activite
		Activite visitParis = new Activite("VisiterParis", 100, terre);
		Activite visitFuji = new Activite("VisiterMontFuji", 200, terre);
		
		Activite chameau = new Activite("Chameau", 150, mars);
		Activite escalade = new Activite("Escalade", 50, mars);
		
		Activite surf = new Activite("Surf", 75, atlantide);
		Activite plongee = new Activite("Plongee", 100, atlantide);
		
		Activite coucherSoleil = new Activite("Soleil", 75, saturne);
		Activite surfAnneau = new Activite("SurfAnneau", 500, saturne);
		
		Activite buggycratere = new Activite("Cratere", 75, lune);
		Activite siteHisto = new Activite("1erPasLune", 500, lune);
		
		activiteRepo.save(visitParis);
		activiteRepo.save(visitFuji);
		activiteRepo.save(chameau);
		activiteRepo.save(escalade);
		activiteRepo.save(surf);
		activiteRepo.save(plongee);
		activiteRepo.save(coucherSoleil);
		activiteRepo.save(surfAnneau);
		activiteRepo.save(buggycratere);
		activiteRepo.save(siteHisto);
		
		Set<Activite> activites1 = new HashSet();
		Set<Activite> activites2 = new HashSet();
		
		activites1.add(chameau);
		activites1.add(escalade);
		
		activites2.add(siteHisto);
		activites2.add(buggycratere);
		
		// Vaisseau;
		 Vaisseau jaxxSparrow  = new Vaisseau(100, "JaxxSaprrow", "Jordan");
		 Vaisseau fauconMill  = new Vaisseau(5, "Faucon Millenium", "Chewbaca");
		 Vaisseau Soprate = new Vaisseau(13,"Soprate","Olivier");
		 
		 vaisseauRepo.save(jaxxSparrow);
		 vaisseauRepo.save(fauconMill);
		 vaisseauRepo.save(Soprate);
		
		// Trajet
		
		 Trajet terreMars = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), terre, mars, Soprate, 500);
		 Trajet terreAtlantide = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), terre, atlantide, fauconMill, 250);
		 Trajet saturneLune = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), saturne, lune, jaxxSparrow, 1500);
		 
		 trajetRepo.save(terreMars);
		 trajetRepo.save(terreAtlantide);
		 trajetRepo.save(saturneLune);
		
		 //Compte admin et client
		
		 Compte admin1 = new Admin("admin1","admin1");
		 Compte admin2 = new Admin("admin2","admin2");
		 Compte client1 = new Client("client1","client1","Dupond","Martin");
		 Compte client2 = new Client("client2","client2","Dupont","Martine");
		 
		 compteRepo.save(admin1);
		 compteRepo.save(admin2);
		 compteRepo.save(client1);
		 compteRepo.save(client2);
		 
		//Passager
		
		 Passager donatelo = new Passager("Tortue", "ninja", (Client) client1);
		 Passager tintin = new Passager("Belge", "Tintin", (Client) client1);
		 Passager potter = new Passager("Potter", "Harry", (Client) client2);
		 Passager zemmour = new Passager("Zemmour", "Eric", (Client) client2);

		 passagerRepo.save(donatelo);
		 passagerRepo.save(tintin);
		 passagerRepo.save(potter);
		 passagerRepo.save(zemmour);
		 
		//RESERVATION
		Set<Passager> passagers1 = new HashSet();
		Set<Passager> passagers2 = new HashSet();
		passagers1.add(donatelo);
		passagers1.add(tintin);
		passagers2.add(potter);
		passagers2.add(zemmour);
		Reservation resa1 = new Reservation(client1,terreMars, passagers1, activites1);
		Reservation resa2 = new Reservation(client2,saturneLune, passagers2, activites2);
		 
		reservationRepo.save(resa1);
		reservationRepo.save(resa2); 
	}
	
	

}
