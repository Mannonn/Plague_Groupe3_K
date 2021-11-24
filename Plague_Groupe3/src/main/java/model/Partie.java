package model;

public class Partie {
	
	protected int id_partie;
	protected int id_joueur;
	protected int id_virus;
	protected int id_medecin;
	protected Difficulte difficulte;
	protected boolean enCours;
	protected double score;
	
	public Partie(int id_partie, int id_joueur, int id_virus, int id_medecin, Difficulte difficulte, boolean enCours,
			double score) {
		super();
		this.id_partie = id_partie;
		this.id_joueur = id_joueur;
		this.id_virus = id_virus;
		this.id_medecin = id_medecin;
		this.difficulte = difficulte;
		this.enCours = enCours;
		this.score = score;
	}

	public int getId_partie() {
		return id_partie;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int getId_virus() {
		return id_virus;
	}

	public void setId_virus(int id_virus) {
		this.id_virus = id_virus;
	}

	public int getId_medecin() {
		return id_medecin;
	}

	public void setId_medecin(int id_medecin) {
		this.id_medecin = id_medecin;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public boolean isEnCours() {
		return enCours;
	}

	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Partie [id_partie=" + id_partie + ", id_joueur=" + id_joueur + ", id_virus=" + id_virus
				+ ", id_medecin=" + id_medecin + ", difficulte=" + difficulte + ", enCours=" + enCours + ", score="
				+ score + "]";
	}
	
	
	
	
	

}
