package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Activite {
	@JsonView(JsonViews.Common.class)
	@Id // Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Obligatoire*
	@Column(name = "id_activite")
	private Long id;
	@JsonView(JsonViews.Common.class)
	@Column(name = "nom_activite")
	private String nom;
	@JsonView(JsonViews.Common.class)
	@Column(name = "prix_activite")
	private double prix;
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name = "id_planete")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Planete planete;

	public Activite() {
	}

	public Activite(Long id, String nom, double prix, model.Planete planete) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.planete = planete;
	}

	public Activite(String nom, double prix, model.Planete planete) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.planete = planete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Planete getPlanete() {
		return planete;
	}

	public void setPlanete(Planete planete) {
		this.planete = planete;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", nom=" + nom + ", Planete=" + planete + "]";
	}

}
