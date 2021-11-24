package model;

public class Medecin {
	
	protected int id;
	protected String nom;
	protected int id_specialite;
	protected Difficulte difficulte;
	
	public Medecin(int id, String nom, int id_specialite, Difficulte difficulte) {
		super();
		this.id = id;
		this.nom = nom;
		this.id_specialite = id_specialite;
		this.difficulte = difficulte;
	}

	public Medecin(String nom, int id_specialite, Difficulte difficulte) {
		super();
		this.nom = nom;
		this.id_specialite = id_specialite;
		this.difficulte = difficulte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId_specialite() {
		return id_specialite;
	}

	public void setId_specialite(int id_specialite) {
		this.id_specialite = id_specialite;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", nom=" + nom + ", id_specialite=" + id_specialite + ", difficulte=" + difficulte
				+ "]";
	}
	
	
	

}
