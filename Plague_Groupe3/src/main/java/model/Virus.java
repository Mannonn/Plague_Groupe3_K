package model;

public class Virus {
	
	protected int id;
	protected String nom;
	protected Difficulte difficulte;
	protected double propagation;
	protected double mortalite;
	
	public Virus(int id, String nom, Difficulte difficulte, double propagation, double mortalite) {
		super();
		this.id = id;
		this.nom = nom;
		this.difficulte = difficulte;
		this.propagation = propagation;
		this.mortalite = mortalite;
	}

	public Virus(String nom, Difficulte difficulte, double propagation, double mortalite) {
		super();
		this.nom = nom;
		this.difficulte = difficulte;
		this.propagation = propagation;
		this.mortalite = mortalite;
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

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public double getPropagation() {
		return propagation;
	}

	public void setPropagation(double propagation) {
		this.propagation = propagation;
	}

	public double getMortalite() {
		return mortalite;
	}

	public void setMortalite(double mortalite) {
		this.mortalite = mortalite;
	}

	@Override
	public String toString() {
		return "Virus [id=" + id + ", nom=" + nom + ", difficulte=" + difficulte + ", propagation=" + propagation
				+ ", mortalite=" + mortalite + "]";
	}
	
}
