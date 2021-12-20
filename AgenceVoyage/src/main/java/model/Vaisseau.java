package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vaisseau implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="capacite_vaisseau")
	private int capacite;
	
	@Column(name="nom_vaisseau")
	private String nom;
	
	@Column(name="capitaine_vaisseau")
	private String capitaine;

	public Vaisseau() {
	}
	
	public Vaisseau(Long id, int capacite, String nom, String capitaine) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.nom = nom;
		this.capitaine = capitaine;
	}

	public Vaisseau(int capacite, String nom, String capitaine) {
		super();
		this.capacite = capacite;
		this.nom = nom;
		this.capitaine = capitaine;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcapitaine() {
		return capitaine;
	}

	public void setcapitaine(String capitaine) {
		this.capitaine = capitaine;
	}


	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Vaisseau [id=" + id + ", capacite=" + capacite + ", nom=" + nom + ", capitaine=" + capitaine + "]";
	}

	
	






}
