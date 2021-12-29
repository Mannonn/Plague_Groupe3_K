package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PlaneteException;
import model.Planete;
import model.Trajet;
import repository.ActiviteRepository;
import repository.PlaneteRepository;
import repository.TrajetRepository;

@Service
public class PlaneteService {

	@Autowired
	private PlaneteRepository planeteRepo;
	@Autowired
	private TrajetRepository trajetRepo;

	@Autowired
	private ActiviteRepository activiteRepo;
	@Autowired
	private TrajetService trajetService;
	@Autowired
	private ActiviteService activiteService;

	public void creation(Planete planete) {
		if (planete.getId() == null) {
			throw new PlaneteException();
		}
		planeteRepo.save(planete);
	}

	public Planete update(Planete planete) {
        if (planete.getId() == null) {
            throw new PlaneteException();
        }
        Planete planeteEnBase = planeteRepo.findById(planete.getId()).orElseThrow(PlaneteException::new);
        creation(planeteEnBase);
        return planeteRepo.save(planete);

    }

	public void suppression(Planete planete) {
		Planete planeteEnBase = null;

		if (planete.getId() != null) {
			planeteEnBase = planeteRepo.findById(planete.getId()).orElseThrow(PlaneteException::new);
			List<Trajet> trajetsDepart = trajetRepo.findByDepart(planete);
			List<Trajet> trajetsArrivee = trajetRepo.findByArrivee(planete);

			if (trajetsDepart.isEmpty() && trajetsArrivee.isEmpty()) {
				activiteRepo.deleteByPlanete(planeteEnBase);
				planeteRepo.delete(planeteEnBase);

			}
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
