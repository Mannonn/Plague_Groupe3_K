package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ActiviteException;
import exception.VaisseauException;
import model.Activite;
import model.Vaisseau;

import repository.VaisseauRepository;

@Service
public class VaisseauService {

	@Autowired
	private VaisseauRepository vaisseauRepo;


	public void creation(Vaisseau vaisseau) {
		if (vaisseau.getNom() == null) {
			throw new VaisseauException();
		}
		vaisseauRepo.save(vaisseau);
	}
	
	public Vaisseau update(Vaisseau vaisseau) {
        if (vaisseau.getId() == null) {
            throw new VaisseauException();
        }
        Vaisseau vaisseauEnBase = vaisseauRepo.findById(vaisseau.getId()).orElseThrow(VaisseauException::new);
        creation(vaisseauEnBase);
        return vaisseauRepo.save(vaisseau);

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

