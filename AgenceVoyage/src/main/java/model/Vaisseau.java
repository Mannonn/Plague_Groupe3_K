package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vaisseau implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int capacite;
	private String nom;
	private String equipage;

	public Vaisseau() {
	}
	
	public Vaisseau(long id, int capacite, String nom, String equipage) {
		super();
		this.id = id;
		this.capacite = capacite;
		this.nom = nom;
		this.equipage = equipage;
	}

	public Vaisseau(int capacite, String nom, String equipage) {
		super();
		this.capacite = capacite;
		this.nom = nom;
		this.equipage = equipage;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEquipage() {
		return equipage;
	}

	public void setEquipage(String equipage) {
		this.equipage = equipage;
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
		return "Vaisseau [id=" + id + ", capacite=" + capacite + ", nom=" + nom + ", equipage=" + equipage + "]";
	}

	
	






}
