package model;

public class JsonViews {
	public static class Common {

	}

	public static class Reservation extends Common {

	}
	public static class ReservationWithActivites extends Reservation{
		
	}
	public static class ReservationWithPassagers extends Reservation{
		
	}
	public static class ReservationWithClients extends Reservation{
		
	}
	public static class ReservationWithTrajetAller extends Reservation{
		
	}
	public static class ReservationWithTrajetRetour extends Reservation{
		
	}
	public static class ReservationWithDateResa extends Reservation{
		
	}
	
	
	public static class Vaisseau extends Common{
		
	}
	public static class VaisseauWithCapacite extends Vaisseau{
		
	}
	public static class VaisseauWithNom extends Vaisseau{
		
	}
	public static class VaisseauWithCapitaine extends Vaisseau{
		
	}

		
	public static class Trajet extends Common {

	}
	public static class TrajetWithDateDepart extends Trajet{
		
	}
	public static class TrajetWithHeuredepart extends Trajet{
		
	}
	public static class TrajetWithDateArrivee extends Trajet{
		
	}
	public static class TrajetWithHeureArrivee extends Trajet{
		
	}
	public static class TrajetWithDepart extends Trajet{
		
	}
	public static class TrajetWithArrivee extends Trajet{
		
	}
	public static class TrajetWithVaisseau extends Trajet{
		
	}
	public static class TrajetWithPrix extends Trajet{
		
	}

	
	public static class Planete extends Common {

	}
	public static class PlaneteWithNom extends Planete {

	}
	public static class PlaneteWithType extends Planete {

	}
	/*
	public static class PlaneteWithTrajet extends Planete{
		
	}
	public static class PlaneteWithActivite extends Planete{
		
	}
	*/
	
	public static class Activite extends Common {

	}
	public static class ActiviteWithNom extends Activite {

	}
	public static class ActiviteWithPrix extends Activite {

	}
	public static class ActiviteWithIdPlanete extends Activite {

	}
	
	

	public static class Passager extends Common {

	}
	public static class PassagerWithNomPrenom extends Passager {

	}
	public static class PassagerWithClients extends Passager {

	}

	public static class Compte extends Common {

	}
	public static class CompteWithLogin extends Compte {

	}
	public static class CompteWithPassword extends Compte {

	}
	
	public static class Client extends Common {

	}
	public static class ClientWithNomPrenom extends Client {

	}
	public static class ClientWithReservations extends Client {

	}
	
	
}
