package SoprAjc.AgenceVoyageSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.exception.CompteException;
import SoprAjc.AgenceVoyageSpringBoot.model.Compte;
import SoprAjc.AgenceVoyageSpringBoot.repository.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;
	
	public void creation(Compte compte) {
		if (compte.getId() == null) {
			throw new CompteException();
		}
		compteRepo.save(compte);
	}
	
	public Compte update(Compte compte) {
        if (compte.getId() == null) {
            throw new CompteException();
        }
        Compte compteEnBase = compteRepo.findById(compte.getId()).orElseThrow(CompteException::new);
        creation(compteEnBase);
        return compteRepo.save(compte);

    }

	public void suppression(Compte compte) {
		Compte compteEnBase = null;
		if (compte.getId() != null) {
			compteEnBase = compteRepo.findById(compte.getId()).orElseThrow(CompteException::new);
			compteRepo.delete(compteEnBase);
		} else {
			throw new CompteException();
		}
	}

	public Compte getById(Long id) {
		if (id != null) {
			return compteRepo.findById(id).orElseThrow(CompteException::new);
		}
		throw new CompteException();
	}

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

}
