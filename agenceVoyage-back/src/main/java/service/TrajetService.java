package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.TrajetException;


import model.Trajet;

import repository.TrajetRepository;

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

