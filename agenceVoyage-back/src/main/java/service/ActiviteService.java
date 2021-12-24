package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ActiviteException;
import model.Activite;
import repository.ActiviteRepository;

@Service
public class ActiviteService {

	@Autowired
	private ActiviteRepository activiteRepo;

	public void creation(Activite activite) {
		if (activite.getId() == null) {
			throw new ActiviteException();
		}
		activiteRepo.save(activite);
	} 
	
	public Activite update(Activite activite) {
        if (activite.getId() == null) {
            throw new ActiviteException();
        }
        Activite activiteEnBase = activiteRepo.findById(activite.getId()).orElseThrow(ActiviteException::new);
        creation(activiteEnBase);
        return activiteRepo.save(activite);

    }

	public void suppression(Activite activite) {
		Activite activiteEnBase = null;
		if (activite.getId() != null) {
			activiteEnBase = activiteRepo.findById(activite.getId()).orElseThrow(ActiviteException::new);
			activiteRepo.delete(activiteEnBase);
		} else {
			throw new ActiviteException();
		}
	}
	
		public Activite update(Activite activite) {
			if (activite.getId() == null) {
				throw new ActiviteException();
			}
			Activite activiteEnBase = activiteRepo.findById(activite.getId()).orElseThrow(ActiviteException::new);
			creation(activiteEnBase);
			return activiteRepo.save(activite);
	
		}

	public Activite getById(Long id) {
		if (id != null) {
			return activiteRepo.findById(id).orElseThrow(ActiviteException::new);
		}
		throw new ActiviteException();
	}
	
	public Activite getByPlanete(Long id) {
		if (id != null) {
			return activiteRepo.findByIdWithPlanete(id).orElseThrow(ActiviteException::new);
		}
		throw new ActiviteException();
	}

	public List<Activite> getAll() {
		return activiteRepo.findAll();
	}

}

