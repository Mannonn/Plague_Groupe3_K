package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_reservation")
	private LocalDate dateReservation;
	
	@JoinColumn(name="reservation_passager")
	@OneToMany
	private Set<Passager> passagers;
	
	@JoinColumn(name="trajet_aller")
	@ManyToOne
	private Trajet aller;
	
	@JoinColumn(name="trajet_retour")
	@ManyToOne
	private Trajet retour;
	
	@ManyToMany
	@JoinTable(name = "reservation_activite", 
			joinColumns = @JoinColumn(name = "id_reservation"), 
			inverseJoinColumns = @JoinColumn(name = "id_activit�") 
	)
	private List<Activite> activites;
	
	@JoinColumn(name = "client")
	@ManyToOne
	private Client client;
	
	public Reservation () {}
	
	public Reservation(Trajet aller, Client client) {
		this.aller = aller;
		this.client = client;
		this.dateReservation=LocalDate.now();
	}

	
	public Reservation(Long id, Trajet aller, Client client,LocalDate dateReservation) {
		this.id=id;
		this.aller = aller;
		this.client = client;
		this.dateReservation=dateReservation;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Set<Passager> getPassagers() {
		return passagers;
	}

	public void setPassagers(Set<Passager> passagers) {
		this.passagers = passagers;
	}

	public Trajet getAller() {
		return aller;
	}

	public void setAller(Trajet aller) {
		this.aller = aller;
	}

	public Trajet getRetour() {
		return retour;
	}

	public void setRetour(Trajet retour) {
		this.retour = retour;
	}

	public Set<Activite> getActivites() {
		return activites;
	}

	public void setActivites(Set<Activite> activites) {
		this.activites = activites;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", passagers=" + passagers
				+ ", aller=" + aller + ", retour=" + retour + ", activites=" + activites + ", client=" + client + "]";
	}

	

	
	
	
	
	
}
