package restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vaisseau;
import service.VaisseauService;

@RestController
@RequestMapping("/api/vaisseau")
public class VaisseauRestController {
	@Autowired
	private VaisseauService vaisseauService;

	@GetMapping("")
	public List<Vaisseau> getAll() {
		return vaisseauService.getAll();
		//return vaisseauService.getAll();
	}
}
