package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
public class Trajet implements Serializable {
	@JsonView(JsonViews.Common.class)
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private Long id;
	@JsonView(JsonViews.Common.class)
	@Column(name="date_depart",columnDefinition = "DATE")
	private LocalDate dateDepart;
	@JsonView(JsonViews.Common.class)
	@Column(name="heure_depart",columnDefinition = "TIME")
	private LocalTime heureDepart;
	@JsonView(JsonViews.Common.class)
	@Column(name="date_arrivee",columnDefinition = "DATE")
	private LocalDate dateArrivee;
	@JsonView(JsonViews.Common.class)
	@Column(name="heure_arrivee",columnDefinition = "TIME")
	private LocalTime heureArrivee;
	@JsonView(JsonViews.Common.class)
	@Column(name="prix_trajet")
	private double prix;
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name="depart")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Planete depart;
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name="arrivee")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Planete arrivee;
	@JsonView(JsonViews.Common.class)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="vaisseau")
	private Vaisseau vaisseau;

	
	public Trajet() {
	
	}
	public Trajet(Long id, LocalDate dateDepart, LocalTime heureDepart, LocalDate dateArrivee, LocalTime heureArrivee,
			Planete depart, Planete arrivee, Vaisseau vaisseau, double prix) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
		this.dateArrivee = dateArrivee;
		this.heureArrivee = heureArrivee;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
		this.prix = prix;
	}
	public Trajet(LocalDate dateDepart, LocalTime heureDepart, LocalDate dateArrivee, LocalTime heureArrivee,
			Planete depart, Planete arrivee, Vaisseau vaisseau, double prix) {
		super();
		this.dateDepart = dateDepart;
		this.heureDepart = heureDepart;
		this.dateArrivee = dateArrivee;
		this.heureArrivee = heureArrivee;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public LocalDate getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}
	public LocalTime getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}
	public LocalTime getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(LocalTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public Planete getDepart() {
		return depart;
	}
	public void setDepart(Planete depart) {
		this.depart = depart;
	}
	public Planete getArrivee() {
		return arrivee;
	}
	public void setArrivee(Planete arrivee) {
		this.arrivee = arrivee;
	}
	public Vaisseau getVaisseau() {
		return vaisseau;
	}
	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	@Override
	public String toString() {
		return "Trajet [id=" + id + ", dateDepart=" + dateDepart + ", heureDepart=" + heureDepart + ", dateArrivee="
				+ dateArrivee + ", heureArrivee=" + heureArrivee + ", depart=" + depart + ", arrivee=" + arrivee
				+ ", vaisseau=" + vaisseau + ", prix=" + prix + "]";
	}
	
	
	
	
	
}
