package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ActiviteRepository;
import repository.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository adminRepo;
}
