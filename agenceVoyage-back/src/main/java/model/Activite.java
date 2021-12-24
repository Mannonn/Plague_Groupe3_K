package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Activite {
	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	@Column(name="id_activite")
	private Long id;
	
	@Column(name="nom_activite")
	private String nom;
	
	@Column(name="prix_activite")
	private double prix;
	
	@JoinColumn(name="id_planete")
	@ManyToOne
	private Planete Planete;
	
	public Activite() {}


	
	public Activite(Long id, String nom, double prix, model.Planete planete) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		Planete = planete;
	}

	public Activite(String nom, double prix, model.Planete planete) {
		super();
		this.nom = nom;
		this.prix = prix;
		Planete = planete;
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
		return Planete;
	}

	public void setPlanete(Planete planete) {
		Planete = planete;
	}
	
	

	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	@Override
	public String toString() {
		return "Activite [id=" + id + ", nom=" + nom + ", Planete=" + Planete + "]";
	}
	

}
