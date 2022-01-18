package SoprAjc.AgenceVoyageSpringBoot.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import SoprAjc.AgenceVoyageSpringBoot.exception.CompteException;
import SoprAjc.AgenceVoyageSpringBoot.model.Compte;
import SoprAjc.AgenceVoyageSpringBoot.model.JsonViews;
import SoprAjc.AgenceVoyageSpringBoot.service.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {
	@Autowired
	private CompteService compteService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Compte> getAll() {
		return compteService.getAll();
	}
	
	@GetMapping("/connexion")
	@JsonView(JsonViews.Common.class)
	public Compte connexion(@AuthenticationPrincipal Compte compte) {
		return compte;
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	private Compte getByIdBase(@PathVariable Long id) {
		return compteService.getById(id);
	}

	public Compte getById(Long id) {
		return getByIdBase(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Compte.class)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		compteService.creation(compte);
		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Compte put(@Valid @RequestBody Compte compte, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		if (compte.getId() == null) {
			compte.setId(id);
		}
		compteService.update(compte);
		return compte;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Compte.class)
	public Compte patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Compte compte = compteService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Compte.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, compte, v);
		});
		compteService.update(compte);
		return compte;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compteService.suppression(compteService.getById(id));
	}
}