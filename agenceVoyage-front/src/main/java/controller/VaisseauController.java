package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Vaisseau;
import service.VaisseauService;

@Controller
@RequestMapping("/vaisseau")
public class VaisseauController {

	@Autowired
	private VaisseauService vaisseauService;

	@GetMapping({ "", "/" })
	public String allVaisseau(Model model) {
		model.addAttribute("vaisseaux", vaisseauService.getAll());
		return "vaisseau/list";
	}

	private String goEdit(Vaisseau vaisseau, Model model) {
		model.addAttribute("vaisseau", vaisseau);
		return "vaisseau/editSpring";
	}

	@PostMapping("")
	private String save(Vaisseau vaisseau,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(vaisseau, model);
		}
		if (vaisseau.getId() != null) {
			vaisseauService.update(vaisseau);
		} else {
			vaisseauService.creation(vaisseau);
		}
		return "redirect:/vaisseau";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		return goEdit(vaisseauService.getById(id), model);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		vaisseauService.suppression(id);
		return "redirect:/vaisseau";
	}
	
}
