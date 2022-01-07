package SoprAjc.AgenceVoyageSpringBoot.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

import SoprAjc.AgenceVoyageSpringBoot.exception.TrajetException;
import SoprAjc.AgenceVoyageSpringBoot.model.JsonViews;
import SoprAjc.AgenceVoyageSpringBoot.model.Trajet;
import SoprAjc.AgenceVoyageSpringBoot.service.PlaneteService;
import SoprAjc.AgenceVoyageSpringBoot.service.TrajetService;
import SoprAjc.AgenceVoyageSpringBoot.service.VaisseauService;

@RestController
@RequestMapping("/api/trajet")
public class TrajetRestController {
	@Autowired
	private TrajetService trajetService;

	@Autowired
	private VaisseauService vaisseauService;
	
	@Autowired
	private PlaneteService planeteService;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Trajet> getAll() {
		return trajetService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Trajet.class)
	private Trajet getByIdBase(@PathVariable Long id) {
		return trajetService.getById(id);
	}

	public Trajet getById(Long id) {
		return getByIdBase(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Trajet.class)
	public Trajet create(@Valid @RequestBody Trajet trajet, BindingResult br) {
		if (br.hasErrors()) {
			throw new TrajetException();
		}
		trajetService.creation(trajet);
		return trajet;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Trajet.class)
	public Trajet put(@Valid @RequestBody Trajet trajet, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new TrajetException();
		}
		if (trajet.getId() == null) {
			trajetService.creation(trajet);
		}
		trajetService.update(trajet);
		return trajet;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Trajet.class)
	public Trajet patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Trajet trajet = trajetService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Trajet.class, k);
			ReflectionUtils.makeAccessible(field);
			if (k.equals("dateDepart")|| k.equals("dateArrivee")) {
				int annee =((ArrayList<Integer>) v).get(0);
				int mois =((ArrayList<Integer>) v).get(1);
				int jour =((ArrayList<Integer>) v).get(2);
				if (k.equals("dateDepart"))
					{trajet.setDateDepart(LocalDate.of(annee,mois,jour));}
				else
					{trajet.setDateArrivee(LocalDate.of(annee,mois,jour));}
			}
			else if(k.equals("heureDepart")|| k.equals("heureArrivee"))
			{
				int heure =((ArrayList<Integer>) v).get(0);
				int minute =((ArrayList<Integer>) v).get(1);
				if (k.equals("heureDepart"))
					{trajet.setHeureDepart(LocalTime.of(heure,minute));}
				else
					{trajet.setHeureArrivee(LocalTime.of(heure,minute));}
			}
			else if (k.equals("vaisseau")||k.equals("depart")||k.equals("arrivee"))
			{
				Map<String,String> objetJson=(Map<String,String>) v;
				Object a=objetJson.get("id");
				Long idPatch=Long.valueOf((int)a);
				if (k.equals("vaisseau"))
					{trajet.setVaisseau(vaisseauService.getById(idPatch));}
				else if (k.equals("depart"))
					{trajet.setDepart(planeteService.getById(idPatch));}
				else
					{trajet.setArrivee(planeteService.getById(idPatch));}
			}
			else {
				ReflectionUtils.setField(field, trajet, v);}
		});
		trajetService.update(trajet);
		return trajet;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		trajetService.suppression(trajetService.getById(id));
	}
}