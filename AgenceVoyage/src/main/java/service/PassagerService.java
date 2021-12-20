package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PassagerException;
import exception.ClientException;

import model.Client;
import model.Passager;

import repository.PassagerRepository;

@Service
public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepo;
	
	//A modifier avec le module à venir !
	@Autowired
	private ClientService clientService;

	public void creation(Passager passager) {
		if (passager.getNom() == null) {
			throw new PassagerException();
		}
		passagerRepo.save(passager);
	}

	public void suppression(Passager passager) {
		Passager passagerEnBase = null;
		if (passager.getId() != null) {
			passagerEnBase = passagerRepo.findById(passager.getId()).orElseThrow(PassagerException::new);
			passagerRepo.delete(passagerEnBase);
		} else {
			throw new PassagerException();
		}
	}

	public void suppression(Client client) {
		if (client.getId() != null) {
			Client clientEnBase = clientService.getBy(client.getId());
			passagerRepo.deleteByMaitre(clientEnBase);
		} else {
			throw new ClientException();
		}
	}

	public Passager getById(Long id) {
		if (id != null) {
			return passagerRepo.findById(id).orElseThrow(PassagerException::new);
		}
		throw new PassagerException();
	}

	public List<Passager> getAll() {
		return passagerRepo.findAll();
	}

}

