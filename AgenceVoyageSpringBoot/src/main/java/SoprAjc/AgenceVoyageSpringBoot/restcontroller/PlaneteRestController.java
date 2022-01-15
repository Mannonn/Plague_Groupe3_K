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

import SoprAjc.AgenceVoyageSpringBoot.exception.PlaneteException;
import SoprAjc.AgenceVoyageSpringBoot.model.JsonViews;
import SoprAjc.AgenceVoyageSpringBoot.model.Planete;
import SoprAjc.AgenceVoyageSpringBoot.model.TypePlanete;
import SoprAjc.AgenceVoyageSpringBoot.service.PlaneteService;

@RestController
@RequestMapping("/api/planete")
@CrossOrigin(origins = "*")
public class PlaneteRestController {
	@Autowired
	private PlaneteService planeteService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Planete> getAll() {
		return planeteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Planete.class)
	private Planete getByIdBase(@PathVariable Long id) {
		return planeteService.getById(id);
	}

	public Planete getById(Long id) {
		return getByIdBase(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Planete.class)
	public Planete create(@Valid @RequestBody Planete planete, BindingResult br) {
		if (br.hasErrors()) {
			throw new PlaneteException();
		}
		planeteService.creation(planete);
		return planete;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Planete.class)
	public Planete put(@Valid @RequestBody Planete planete, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new PlaneteException();
		}
		if (planete.getId() == null) {
			planete.setId(id);
		}
		planeteService.update(planete);
		return planete;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Planete patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Planete planete = planeteService.getById(id);

		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Planete.class, k);
			ReflectionUtils.makeAccessible(field);
			if (k.equals("type")) {
				planete.setType(TypePlanete.valueOf(v.toString()));
			} else {
				ReflectionUtils.setField(field, planete, v);
			}

		});
		planeteService.update(planete);
		return planete;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		planeteService.suppression(planeteService.getById(id));
	}
}
