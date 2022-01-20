package SoprAjc.AgenceVoyageSpringBoot.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.model.Activite;
import SoprAjc.AgenceVoyageSpringBoot.model.Admin;
import SoprAjc.AgenceVoyageSpringBoot.model.Client;
import SoprAjc.AgenceVoyageSpringBoot.model.Compte;
import SoprAjc.AgenceVoyageSpringBoot.model.Passager;
import SoprAjc.AgenceVoyageSpringBoot.model.Planete;
import SoprAjc.AgenceVoyageSpringBoot.model.Reservation;
import SoprAjc.AgenceVoyageSpringBoot.model.Trajet;
import SoprAjc.AgenceVoyageSpringBoot.model.TypePlanete;
import SoprAjc.AgenceVoyageSpringBoot.model.Vaisseau;
import SoprAjc.AgenceVoyageSpringBoot.repository.ActiviteRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.AdminRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.ClientRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.CompteRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.PassagerRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.PlaneteRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.ReservationRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.TrajetRepository;
import SoprAjc.AgenceVoyageSpringBoot.repository.VaisseauRepository;

@Service
public class InitBase implements CommandLineRunner {

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
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	public void run(String... args)
	{
//		initDataBase();
	}
	
	
	
	
	private void initDataBase() 
	{
		
		
		
		// Planete 
		Planete terre = new Planete("Terre",TypePlanete.Urbaine);
		Planete mars = new Planete("Mars",TypePlanete.Desertique);
		Planete atlantide = new Planete("Atlantide",TypePlanete.Tropicale);
		Planete saturne = new Planete("Neptune",TypePlanete.Glaciaire);
		Planete lune = new Planete("Lune",TypePlanete.Montagneuse);
		Planete mercure = new Planete("Mercure", TypePlanete.Tropicale);
		Planete venus = new Planete("Venus", TypePlanete.Desertique);
		Planete pluto = new Planete("Pluto", TypePlanete.Urbaine);
		Planete uranus = new Planete("Uranus", TypePlanete.Glaciaire);
		Planete jupiter = new Planete("Jupiter", TypePlanete.Montagneuse);
		Planete neptune = new Planete("Neptune", TypePlanete.Tropicale);
		Planete soleil = new Planete("Soleil", TypePlanete.Desertique);
		
		planeteRepo.save(terre);
		planeteRepo.save(mars);
		planeteRepo.save(atlantide);
		planeteRepo.save(saturne);
		planeteRepo.save(lune);
		planeteRepo.save(mercure);
		planeteRepo.save(venus);
		planeteRepo.save(pluto);
		planeteRepo.save(uranus);
		planeteRepo.save(neptune);
		planeteRepo.save(jupiter);
		planeteRepo.save(soleil);
		
		
		// Activite
		Activite visitParis = new Activite("VisiterParis", 100, terre);
		Activite visitFuji = new Activite("VisiterMontFuji", 200, terre);
		Activite everest = new Activite("Gravir l'everest", 10000, terre);
		
		Activite chameau = new Activite("Chameau", 150, mars);
		Activite escalade = new Activite("Escalade", 50, mars);
		
		Activite surf = new Activite("Surf", 75, atlantide);
		Activite plongee = new Activite("Plongee", 100, atlantide);
		
		Activite coucherSoleil = new Activite("Soleil", 75, saturne);
		Activite surfAnneau = new Activite("SurfAnneau", 500, saturne);
		Activite bronzage = new Activite("Bronzage", 1000, soleil);
		
		Activite buggycratere = new Activite("Cratere", 75, lune);
		Activite siteHisto = new Activite("1erPasLune", 500, lune);
		Activite cyclisme = new Activite("Cyclisme", 30, lune);
		Activite trampoline = new Activite("Trampoline", 60, lune);
		
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
		activiteRepo.save(cyclisme);
		activiteRepo.save(trampoline);
		activiteRepo.save(bronzage);
		activiteRepo.save(everest);
		
		
		Set<Activite> activites1 = new HashSet();
		Set<Activite> activites2 = new HashSet();
		Set<Activite> activites3 = new HashSet();
		Set<Activite> activites4 = new HashSet();
		
		activites1.add(chameau);
		activites1.add(escalade);
		
		activites2.add(siteHisto);
		activites2.add(buggycratere);
		
		activites3.add(trampoline);
		activites3.add(cyclisme);
		activites3.add(siteHisto);
		
		activites4.add(visitParis);
		activites4.add(visitFuji);
		activites4.add(everest);
		
		
		// Vaisseau;
		 Vaisseau jaxxSparrow  = new Vaisseau(100, "JaxxSaprrow", "Jordan");
		 Vaisseau fauconMill  = new Vaisseau(5, "Faucon Millenium", "Chewbaca");
		 Vaisseau Soprate = new Vaisseau(13,"Soprate","Olivier");
		 Vaisseau Ufo = new Vaisseau(20, "Ufo", "Jeanne");
		 Vaisseau quinjet = new Vaisseau(45, "Quinjet", "Barbe Rousse");
		 Vaisseau tardis = new Vaisseau(2, "Tardis", "Le docteur");
		 Vaisseau express = new Vaisseau(6, "Planet Express", "Leela");
		 Vaisseau voyage = new Vaisseau(58, "Voyager 1", "Chris Kirk");
		 Vaisseau voyageez = new Vaisseau(5, "Voyageez", "CAMAS");
		 
		 
		 vaisseauRepo.save(jaxxSparrow);
		 vaisseauRepo.save(fauconMill);
		 vaisseauRepo.save(Soprate);
		 vaisseauRepo.save(Ufo);
		 vaisseauRepo.save(quinjet);
		vaisseauRepo.save(tardis);
		vaisseauRepo.save(express);
		vaisseauRepo.save(voyage);
		vaisseauRepo.save(voyageez);
		// Trajet
		
		 Trajet terreMars = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), terre, mars, Soprate, 500);
		 Trajet terreAtlantide = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), terre, atlantide, fauconMill, 250);
		 Trajet saturneLune = new Trajet(LocalDate.parse("2021-11-15"), LocalTime.parse("20:05:00"), LocalDate.parse("2021-11-16"), LocalTime.parse("20:05:00"), saturne, lune, jaxxSparrow, 1500);
		 Trajet terreLune = new Trajet(LocalDate.parse("2077-11-15"), LocalTime.parse("00:00:00"), LocalDate.parse("2077-12-12"), LocalTime.parse("01:00:00"), terre, lune, tardis, 9999  );
		 Trajet soleilMars = new Trajet(LocalDate.parse("2597-02-30"), LocalTime.parse("04:00:00"), LocalDate.parse("3000-08-23"), LocalTime.parse("01:08:00"), soleil, mars, voyageez, 1  );
		 Trajet mercureAtlantide = new Trajet(LocalDate.parse("3446-08-20"), LocalTime.parse("04:15:00"), LocalDate.parse("3446-08-23"), LocalTime.parse("01:56:00"), mercure, atlantide, Ufo, 5678  );
		 Trajet venusPluto = new Trajet(LocalDate.parse("2022-03-01"), LocalTime.parse("12:00:00"), LocalDate.parse("2024-03-23"), LocalTime.parse("21:54:00"), venus, pluto, express, 543  );
		 
		 
		 trajetRepo.save(terreMars);
		 trajetRepo.save(terreAtlantide);
		 trajetRepo.save(saturneLune);
		 trajetRepo.save(terreLune);
		 trajetRepo.save(soleilMars);
		 trajetRepo.save(mercureAtlantide);
		
		 //Compte admin et client
		
		 Compte admin1 = new Admin("admin1",passwordEncoder.encode("admin1"));
		 Compte admin2 = new Admin("admin2",passwordEncoder.encode("admin2"));
	
		 Compte client1 = new Client("client1",passwordEncoder.encode("client1"),"Dupond","Martin");
		 Compte client2 = new Client("client2",passwordEncoder.encode("client2"),"Dupont","Martine");
		 
		 compteRepo.save(admin1);
		 compteRepo.save(admin2);
		 compteRepo.save(client1);
		 compteRepo.save(client2);
		 
		//Passager
		
		 Passager donatelo = new Passager("Tortue", "ninja", (Client) client1);
		 Passager tintin = new Passager("Belge", "Tintin", (Client) client1);
		 Passager potter = new Passager("Potter", "Harry", (Client) client2);
		 Passager zemmour = new Passager("Zemmour", "Eric", (Client) client2);
		 Passager hermione = new Passager("Granger", "Hermione",(Client) client2 );
		 Passager ron = new Passager("Weasley", "Ron", (Client) client2 );

		 passagerRepo.save(donatelo);
		 passagerRepo.save(tintin);
		 passagerRepo.save(potter);
		 passagerRepo.save(zemmour);
		 passagerRepo.save(hermione);
		 passagerRepo.save(ron);
		 
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
