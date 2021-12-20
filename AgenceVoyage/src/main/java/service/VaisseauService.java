package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.VaisseauException;


import model.Vaisseau;

import repository.VaisseauRepository;

@Service
public class VaisseauService {

	@Autowired
	private VaisseauRepository vaisseauRepo;
	/*@Autowired
	private PersonnageService personnageService;*/

	public void creation(Vaisseau vaisseau) {
		if (vaisseau.getNom() == null) {
			throw new VaisseauException();
		}
		vaisseauRepo.save(vaisseau);
	}

	public void suppression(Vaisseau vaisseau) {
		Vaisseau vaisseauEnBase = null;
		if (vaisseau.getId() != null) {
			vaisseauEnBase = vaisseauRepo.findById(vaisseau.getId()).orElseThrow(VaisseauException::new);
			vaisseauRepo.delete(vaisseauEnBase);
		} else {
			throw new VaisseauException();
		}
	}

	/*public void suppression(Personnage personnage) {
		if (personnage.getId() != null) {
			Personnage personnageEnBase = personnageService.getBy(personnage.getId());
			vaisseauRepo.deleteByMaitre(personnageEnBase);
		} else {
			throw new vaisseauException();
		}
	}*/

	public Vaisseau getById(Long id) {
		if (id != null) {
			return vaisseauRepo.findById(id).orElseThrow(VaisseauException::new);
		}
		throw new VaisseauException();
	}

	public List<Vaisseau> getAll() {
		return vaisseauRepo.findAll();
	}

}
