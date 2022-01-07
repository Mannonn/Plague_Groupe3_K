package SoprAjc.AgenceVoyageSpringBoot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {
	@JsonView(JsonViews.Common.class)
	@Column(name = "nom")
	private String nom;
	@JsonView(JsonViews.Common.class)
	@Column(name = "prenom")
	private String prenom;

	@JsonView(JsonViews.Client.class)
	@OneToMany(mappedBy = "client", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<Reservation> reservations;

	public Client() {

	}

	public Client(Long id, String login, String password, String nom, String prenom, boolean enabled) {
		super(id, login, password, enabled);
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client(String login, String password, String nom, String prenom) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.enabled =true;
	}

	public Client(String login, String password, String nom, String prenom, Set<Reservation> reservations) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.reservations = reservations;
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

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", reservations=" + reservations + "]";
	}

}
