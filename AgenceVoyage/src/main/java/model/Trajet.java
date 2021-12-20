package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trajet implements Serializable {

	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private long id;
	
	@Column(name="date_depart",columnDefinition = "DATE")
	private LocalDate dateDepart;
	
	@Column(name="heure_depart",columnDefinition = "TIME")
	private LocalTime heureDepart;
	
	@Column(name="date_arrivee",columnDefinition = "DATE")
	private LocalDate dateArriveet;
	
	@Column(name="heure_arrivee",columnDefinition = "TIME")
	private LocalTime heureArrivee;
	
	@JoinColumn(name="depart")
	@ManyToOne
	private Planete depart;
	
	@JoinColumn(name="arrivee")
	@ManyToOne
	private Planete arrivee;
	
	@ManyToOne
	@JoinColumn(name="vaisseau")
	private Vaisseau vaisseau;
	
	@Column(name="prix_trajet")
	private double prix;
	
	public Trajet () {
		
	}
	public Trajet(LocalDate dateDepart,LocalTime heureDepart, Planete depart, Planete arrivee, Vaisseau vaisseau) {
		this.dateDepart = dateDepart;
		this.heureDepart=heureDepart;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
	}

	public Trajet(int id,LocalDate dateDepart,LocalTime heureDepart, Planete depart, Planete arrivee, Vaisseau vaisseau) {
		this.id=id;
		this.dateDepart = dateDepart;
		this.heureDepart=heureDepart;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public LocalDate getDateArriveet() {
		return dateArriveet;
	}
	public void setDateArriveet(LocalDate dateArriveet) {
		this.dateArriveet = dateArriveet;
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
		return "Trajet [id=" + id + ", dateDepart=" + dateDepart + ", heureDepart=" + heureDepart + ", dateArriveet="
				+ dateArriveet + ", heureArrivee=" + heureArrivee + ", depart=" + depart + ", arrivee=" + arrivee
				+ ", vaisseau=" + vaisseau + ", prix=" + prix + "]";
	}
	
	
	
	
	
}
