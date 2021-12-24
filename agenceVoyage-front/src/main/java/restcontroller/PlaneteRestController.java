package restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Planete;
import service.PlaneteService;

@RestController
@RequestMapping("/api/planete")
public class PlaneteRestController {
	@Autowired
	private PlaneteService planeteService;

	@GetMapping("")
	public List<Planete> getAll() {
		return planeteService.getAll();
		//return vaisseauService.getAll();
	}
}

