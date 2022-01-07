package SoprAjc.AgenceVoyageSpringBoot.model;

public class JsonViews {
	public static class Common {

	}

	public static class Reservation extends Common {

	}

	public static class ReservationWithPassagers extends Reservation {

	}
	
	public static class ReservationWithActivites extends Reservation {

	}

	public static class Vaisseau extends Common {

	}

	public static class Trajet extends Common {
	}

	public static class Planete extends Common {

	}
	/*
	 * public static class PlaneteWithTrajet extends Planete{
	 * 
	 * } public static class PlaneteWithActivite extends Planete{
	 * 
	 * }
	 */

	public static class Activite extends Common {

	}

	public static class ActiviteWithIdPlanete extends Activite {

	}

	public static class Passager extends Common {

	}

	public static class Compte extends Common {

	}

	public static class Client extends Common {

	}

	public static class ClientWithReservations extends Client {

	}

	public static class Admin extends Common {

	}
}
