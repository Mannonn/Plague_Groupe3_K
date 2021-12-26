package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ActiviteException;
import exception.ClientException;
import model.Activite;
import model.Client;
import repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;

	public void creation(Client client) {
		if (client.getId() == null) {
			throw new ClientException();
		}
		clientRepo.save(client);
	}
	
	public Client update(Client client) {
        if (client.getId() == null) {
            throw new ClientException();
        }
        Client clientEnBase = clientRepo.findById(client.getId()).orElseThrow(ClientException::new);
        creation(clientEnBase);
        return clientRepo.save(client);

    }


	public void suppression(Client client) {
		Client clientEnBase = null;
		if (client.getId() != null) {
			clientEnBase = clientRepo.findById(client.getId()).orElseThrow(ClientException::new);
			clientRepo.delete(clientEnBase);
		} else {
			throw new ClientException();
		}
	}

	public Client getById(Long id) {
		if (id != null) {
			return clientRepo.findById(id).orElseThrow(ClientException::new);
		}
		throw new ClientException();
	}

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

}

