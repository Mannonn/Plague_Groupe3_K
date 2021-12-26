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

import exception.PassagerException;
import model.JsonViews;
import model.Passager;
import service.PassagerService;
import service.ReservationService;

@RestController
@RequestMapping("/api/passager")
public class PassagerRestController {
	@Autowired
	private PassagerService passagerService;
	@Autowired
	private ReservationService reservationService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Passager> getAll() {
		return passagerService.getAll();
	}
	
//	@PostMapping("")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	@JsonView(JsonViews.Common.class)
//	public Passager create(@Valid @RequestBody Passager passager, BindingResult br) {
//		if (br.hasErrors()) {
//			throw new PassagerException();
//		}
//		passagerService.creation(passager);
//		return passager;
//	}
//	
//	@PutMapping("/{id}")
//	@JsonView(JsonViews.Common.class)
//	public Passager put(@Valid @RequestBody Passager passager, BindingResult br, @PathVariable Long id) {
//		if (br.hasErrors()) {
//			throw new PassagerException();
//		}
//		if (passager.getId() == null) {
//			passager.setId(id);
//		}
//		passagerService.update(passager);
//		return passager;
//	}
//
//	@PatchMapping("/{id}")
//	@JsonView(JsonViews.Common.class)
//	public Passager patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
//		Passager passager = passagerService.getById(id);
//		fields.forEach((k, v) -> {
//			Field field = ReflectionUtils.findField(Passager.class, k);
//			ReflectionUtils.makeAccessible(field);
//			ReflectionUtils.setField(field, passager, v);
//
//		});
//		passagerService.update(passager);
//		return passager;
//	}
//
//	@DeleteMapping("/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) {
//		passagerService.suppression(passagerService.getById(id), reservationService.getById(id));
//	}
}