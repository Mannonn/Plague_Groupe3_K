package SoprAjc.AgenceVoyageSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoprAjc.AgenceVoyageSpringBoot.exception.AdminException;
import SoprAjc.AgenceVoyageSpringBoot.model.Admin;
import SoprAjc.AgenceVoyageSpringBoot.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public void creation(Admin admin) {
		if (admin.getLogin() == null) {
			throw new AdminException();
		}
		adminRepo.save(admin);
	}
	
	public Admin update(Admin admin) {
        if (admin.getId() == null) {
            throw new AdminException();
        }
        Admin adminEnBase = adminRepo.findById(admin.getId()).orElseThrow(AdminException::new);
        creation(adminEnBase);
        return adminRepo.save(admin);

    }


	public void suppression(Admin admin) {
		Admin adminEnBase = null;
		if (admin.getId() != null) {
			adminEnBase = adminRepo.findById(admin.getId()).orElseThrow(AdminException::new);
			adminRepo.delete(adminEnBase);
		} else {
			throw new AdminException();
		}
	}

	public Admin getById(Long id) {
		if (id != null) {
			return adminRepo.findById(id).orElseThrow(AdminException::new);
		}
		throw new AdminException();
	}

	public List<Admin> getAll() {
		return adminRepo.findAll();
	}

}
