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

import exception.ClientException;
import model.Client;
import model.JsonViews;
import service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
	@Autowired
	private ClientService clientService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Client> getAll() {
		return clientService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	private Client getByIdBase(@PathVariable Long id) {
		return clientService.getById(id);
	}

	public Client getById(Long id) {
		return getByIdBase(id);
	}
	
	@GetMapping("/{id}/reservation")
	@JsonView(JsonViews.ClientWithReservations.class)
	private Client getByIdWithReservation (@PathVariable Long id) {
		return clientService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Client.class)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		clientService.creation(client);
		return client;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client put(@Valid @RequestBody Client client, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		if (client.getId() == null) {
			client.setId(id);
		}
		clientService.update(client);
		return client;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Client client = clientService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Client.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, client, v);
		});
		clientService.update(client);
		return client;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientService.suppression(clientService.getById(id));
	}
}