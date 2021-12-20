package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;
	
	
	public Client () {
		
	}
	
	
	public Client(long id,String login, String password, String nom, String prenom) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
	}
	
	

	public Client(String login, String password, String nom, String prenom) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", reservations=" + reservations + "]";
	}

	

	
	

	
	
	
}
