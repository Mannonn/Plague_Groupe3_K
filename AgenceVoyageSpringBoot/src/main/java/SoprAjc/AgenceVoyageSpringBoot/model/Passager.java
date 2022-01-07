package SoprAjc.AgenceVoyageSpringBoot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "passager")
public class Passager implements Serializable {
	@JsonView(JsonViews.Common.class)
	@Id // Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonView(JsonViews.Common.class)
	@Column(name = "nom")
	private String nom;
	@JsonView(JsonViews.Common.class)
	@Column(name = "prenom")
	private String prenom;
	@JsonView(JsonViews.Passager.class)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "client")
	private Client client;

	public Passager(String nom, String prenom, Client client) {
		this.nom = nom;
		this.prenom = prenom;
		this.client = client;
	}

	public Passager(Long id, String nom, String prenom, Client client) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.client = client;
	}

	public Passager() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Passager [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", client=" + client + "]";
	}

}