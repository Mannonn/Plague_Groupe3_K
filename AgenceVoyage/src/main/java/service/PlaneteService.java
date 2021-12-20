package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PlaneteException;
import model.Activite;
import model.Planete;
import model.Trajet;
import repository.PlaneteRepository;

@Service
public class PlaneteService {

	@Autowired
	private PlaneteRepository planeteRepo;
	@Autowired
	private TrajetService trajetService;
	@Autowired
	private ActiviteService activiteService;
	

	public void creation(Planete planete) {
		if (planete.getNom() == null) {
			throw new PlaneteException();
		}
		planeteRepo.save(planete);
	}

	public void suppression(Planete planete, Trajet trajet, Activite activite) {
		Planete planeteEnBase = null;
		if (planete.getId() != null) {
			planeteEnBase = planeteRepo.findById(planete.getId()).orElseThrow(PlaneteException::new);
			planeteRepo.delete(planeteEnBase);
			trajetService.suppression(trajet);
			activiteService.suppression(activite);
			
		} else {
			throw new PlaneteException();
		}
	}

	
	public Planete getById(Long id) {
		if (id != null) {
			return planeteRepo.findById(id).orElseThrow(PlaneteException::new);
		}
		throw new PlaneteException();
	}

	public List<Planete> getAll() {
		return planeteRepo.findAll();
	}

}

