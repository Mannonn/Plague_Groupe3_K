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

import exception.AdminException;
import model.Admin;
import model.JsonViews;
import service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	private AdminService adminService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Admin> getAll() {
		return adminService.getAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Admin create(@Valid @RequestBody Admin admin, BindingResult br) {
		if (br.hasErrors()) {
			throw new AdminException();
		}
		adminService.creation(admin);
		return admin;
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin put(@Valid @RequestBody Admin admin, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new AdminException();
		}
		if (admin.getId() == null) {
			admin.setId(id);
		}
		adminService.update(admin);
		return admin;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Admin admin = adminService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Admin.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, admin, v);

		});
		adminService.update(admin);
		return admin;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminService.suppression(adminService.getById(id));
	}
}