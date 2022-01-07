package SoprAjc.AgenceVoyageSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.exception.TrajetException;
import SoprAjc.AgenceVoyageSpringBoot.model.Trajet;
import SoprAjc.AgenceVoyageSpringBoot.repository.TrajetRepository;

@Service
public class TrajetService {

	@Autowired
	private TrajetRepository trajetRepo;
	

	public void creation(Trajet trajet) {
		if (trajet.getId() == null) {
			throw new TrajetException();
		}
		trajetRepo.save(trajet);
	}
	
	public Trajet update(Trajet trajet) {
        if (trajet.getId() == null) {
            throw new TrajetException();
        }
        Trajet trajetEnBase = trajetRepo.findById(trajet.getId()).orElseThrow(TrajetException::new);
        creation(trajetEnBase);
        return trajetRepo.save(trajet);

    }


	public void suppression(Trajet trajet) {
		Trajet trajetEnBase = null;
		if (trajet.getId() != null) {
			trajetEnBase = trajetRepo.findById(trajet.getId()).orElseThrow(TrajetException::new);
			trajetRepo.delete(trajetEnBase);
		} else {
			throw new TrajetException();
		}
	}

	public Trajet getById(Long id) {
		if (id != null) {
			return trajetRepo.findById(id).orElseThrow(TrajetException::new);
		}
		throw new TrajetException();
	}

	public List<Trajet> getAll() {
		return trajetRepo.findAll();
	}

}
