package model;

public class Specialite {
	
	protected int id;
	protected String libelle;
	
	public Specialite(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
	

}
