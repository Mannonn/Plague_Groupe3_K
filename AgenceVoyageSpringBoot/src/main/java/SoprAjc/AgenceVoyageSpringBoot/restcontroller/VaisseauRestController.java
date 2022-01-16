package SoprAjc.AgenceVoyageSpringBoot.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import SoprAjc.AgenceVoyageSpringBoot.exception.VaisseauException;
import SoprAjc.AgenceVoyageSpringBoot.model.JsonViews;
import SoprAjc.AgenceVoyageSpringBoot.model.Vaisseau;
import SoprAjc.AgenceVoyageSpringBoot.service.VaisseauService;

@RestController
@RequestMapping("/api/vaisseau")
@CrossOrigin(origins = "*")
public class VaisseauRestController {
	@Autowired
	private VaisseauService vaisseauService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Vaisseau> getAll() {
		return vaisseauService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Vaisseau.class)
	private Vaisseau getByIdBase(@PathVariable Long id) {
		return vaisseauService.getById(id);
	}

	public Vaisseau getById(Long id) {
		return getByIdBase(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Vaisseau.class)
	public Vaisseau create(@Valid @RequestBody Vaisseau vaisseau, BindingResult br) {
		if (br.hasErrors()) {
			throw new VaisseauException();
		}
		vaisseauService.creation(vaisseau);
		return vaisseau;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Vaisseau.class)
	public Vaisseau put(@Valid @RequestBody Vaisseau vaisseau, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new VaisseauException();
		}
		if (vaisseau.getId() == null) {
			vaisseau.setId(id);
		}
		vaisseauService.update(vaisseau);
		return vaisseau;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Vaisseau patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Vaisseau vaisseau = vaisseauService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Vaisseau.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, vaisseau, v);

		});
		vaisseauService.update(vaisseau);
		return vaisseau;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		vaisseauService.suppression(vaisseauService.getById(id));
	}
}
