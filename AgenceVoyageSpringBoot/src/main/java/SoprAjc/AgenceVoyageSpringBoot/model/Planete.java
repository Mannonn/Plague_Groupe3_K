package SoprAjc.AgenceVoyageSpringBoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "planete")
public class Planete implements Serializable {

	@JsonView(JsonViews.Common.class)
	@Id // Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonView(JsonViews.Common.class)
	@Column(name = "nom_planete")
	private String nom;
	@JsonView(JsonViews.Planete.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "type_planete", columnDefinition = "enum('Glaciaire','Desertique','Urbaine','Montagneuse','Tropicale')")
	private TypePlanete type;

	public Planete(String nom, TypePlanete type) {
		this.nom = nom;
		this.type = type;
	}

	public Planete(Long id, String nom, TypePlanete type) {
		this.id = id;
		this.nom = nom;
		this.type = type;
	}

	public Planete() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePlanete getType() {
		return type;
	}

	public void setType(TypePlanete type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}

}
