package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="planete")
public class Planete implements Serializable {

	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_planete",columnDefinition = "ENUM{Glaciaire, Desertique, Urbaine, Montagneuse, Tropicale}") 
	private TypePlanete type;
	
	
	
	public Planete(String nom, TypePlanete type) {
		this.nom = nom;
		this.type = type;
	}
	
	public Planete(int id,String nom, TypePlanete type) {
		this.id=id;
		this.nom = nom;
		this.type = type;
	}
	
	public Planete() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePlanete getType() {
		return type;
	}

	public void setType(TypePlanete type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}

	
	
	
	
}
