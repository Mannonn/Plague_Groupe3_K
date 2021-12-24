package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ActiviteRepository;
import repository.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;
}
