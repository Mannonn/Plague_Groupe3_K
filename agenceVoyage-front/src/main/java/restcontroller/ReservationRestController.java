package restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exception.ReservationException;
import model.JsonViews;
import model.Reservation;
import service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {
	@Autowired
	private ReservationService reservationService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		reservationService.creation(reservation);
		return reservation;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Reservation put(@Valid @RequestBody Reservation reservation, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		if (reservation.getId() == null) {
			reservation.setId(id);
		}
		reservationService.update(reservation);
		return reservation;
	}

//A voir avec Olivier!!
//	@PatchMapping("/{id}")
//	@JsonView(JsonViews.Common.class)
//	public Reservation patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
//		Reservation reservation = reservationService.getById(id);
//		fields.forEach((k, v) -> {
//			Field field = ReflectionUtils.findField(Reservation.class, k);
//			ReflectionUtils.makeAccessible(field);
//			ReflectionUtils.setField(field, reservation, v);
//		});
//		reservationService.update(reservation);
//		return reservation;
//	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservationService.suppression(reservationService.getById(id));
	}
}