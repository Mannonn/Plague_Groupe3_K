package model;

public class Activite {
	
	private long id;
	
	private String nom;
	
	private Planete Planete;
	
	public Activite() {}

	public Activite(long id, String nom, model.Planete planete) {
		super();
		this.id = id;
		this.nom = nom;
		Planete = planete;
	}

	public Activite(String nom, model.Planete planete) {
		super();
		this.nom = nom;
		Planete = planete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Activite [id=" + id + ", nom=" + nom + ", Planete=" + Planete + "]";
	}
	

}
