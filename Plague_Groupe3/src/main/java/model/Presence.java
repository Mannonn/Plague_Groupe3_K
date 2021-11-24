package model;

public class Presence {
	
	protected int id;
	protected int id_planete;
	protected int id_partie;
	protected int population_malade;
	protected int population_totale;
	protected int cadavres;
	protected Attractiv attractivite;
	protected Politique politique;
	
	public Presence(int id, int id_planete, int id_partie, int population_malade, int population_totale, int cadavres,
			Attractiv attractivite, Politique politique) {
		super();
		this.id = id;
		this.id_planete = id_planete;
		this.id_partie = id_partie;
		this.population_malade = population_malade;
		this.population_totale = population_totale;
		this.cadavres = cadavres;
		this.attractivite = attractivite;
		this.politique = politique;
	}

	public Presence(int id_planete, int id_partie, int population_malade, int population_totale, int cadavres,
			Attractiv attractivite, Politique politique) {
		super();
		this.id_planete = id_planete;
		this.id_partie = id_partie;
		this.population_malade = population_malade;
		this.population_totale = population_totale;
		this.cadavres = cadavres;
		this.attractivite = attractivite;
		this.politique = politique;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_planete() {
		return id_planete;
	}

	public void setId_planete(int id_planete) {
		this.id_planete = id_planete;
	}

	public int getId_partie() {
		return id_partie;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public int getPopulation_malade() {
		return population_malade;
	}

	public void setPopulation_malade(int population_malade) {
		this.population_malade = population_malade;
	}

	public int getPopulation_totale() {
		return population_totale;
	}

	public void setPopulation_totale(int population_totale) {
		this.population_totale = population_totale;
	}

	public int getCadavres() {
		return cadavres;
	}

	public void setCadavres(int cadavres) {
		this.cadavres = cadavres;
	}

	public Attractiv getAttractivite() {
		return attractivite;
	}

	public void setAttractivite(Attractiv attractivite) {
		this.attractivite = attractivite;
	}

	public Politique getPolitique() {
		return politique;
	}

	public void setPolitique(Politique politique) {
		this.politique = politique;
	}

	@Override
	public String toString() {
		return "Presence [id=" + id + ", id_planete=" + id_planete + ", id_partie=" + id_partie + ", population_malade="
				+ population_malade + ", population_totale=" + population_totale + ", cadavres=" + cadavres
				+ ", attractivite=" + attractivite + ", politique=" + politique + "]";
	}
	
	
	
	



	}
