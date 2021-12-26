package restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import exception.ActiviteException;
import model.Activite;
import model.JsonViews;
import model.Vaisseau;
import service.ActiviteService;

@RestController
@RequestMapping("/api/activite")
public class ActiviteRestController {
	@Autowired
	private ActiviteService activiteService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Activite> getAll() {
		return activiteService.getAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Activite create(@Valid @RequestBody Activite activite, BindingResult br) {
		if (br.hasErrors()) {
			throw new ActiviteException();
		}
		activiteService.creation(activite);
		return activite;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Activite put(@Valid @RequestBody Activite activite, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ActiviteException();
		}
		if (activite.getId() == null) {
			activite.setId(id);
		}
		activiteService.update(activite);
		return activite;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Activite patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Activite activite = activiteService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Activite.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, activite, v);

		});
		activiteService.update(activite);
		return activite;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		activiteService.suppression(activiteService.getById(id));
	}
}
