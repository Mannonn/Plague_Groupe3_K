package SoprAjc.AgenceVoyageSpringBoot.model;

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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Reservation implements Serializable {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonView(JsonViews.Common.class)
	@Column(name = "date_reservation")
	private LocalDate dateReservation;

	@JsonView(JsonViews.ReservationWithPassagers.class)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "reservation_passager", joinColumns = @JoinColumn(name = "id_reservation"), inverseJoinColumns = @JoinColumn(name = "id_passager"))
	private Set<Passager> passagers;

	@JsonView(JsonViews.Reservation.class)
	@JoinColumn(name = "trajet_aller")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Trajet aller;
	@JsonView(JsonViews.Reservation.class)
	@JoinColumn(name = "trajet_retour")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Trajet retour;

	@JsonView(JsonViews.ReservationWithActivites.class)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "reservation_activite", joinColumns = @JoinColumn(name = "id_reservation"), inverseJoinColumns = @JoinColumn(name = "id_activite"))
	private Set<Activite> activites;

	@JsonView(JsonViews.Reservation.class)
	@JoinColumn(name = "client")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Client client;

	public Reservation() {
	}

	public Reservation(Long id, Compte client, Trajet aller, Set<Passager> passagers, Set<Activite> activites) {
		this.id = id;
		this.dateReservation = LocalDate.now();
		this.passagers = passagers;
		this.aller = aller;
		this.activites = activites;
		this.client = (Client) client;
	}

	public Reservation(Compte client2, Trajet aller, Set<Passager> passagers, Set<Activite> activites) {
		this.dateReservation = LocalDate.now();
		this.passagers = passagers;
		this.aller = aller;
		this.activites = activites;
		this.client = (Client) client2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
