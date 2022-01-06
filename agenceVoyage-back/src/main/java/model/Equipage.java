package model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

public class Equipage implements Serializable {

	@JsonView(JsonViews.Common.class)
	private Long id;

	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@JsonView(JsonViews.Common.class)
	private Grade grade;

	public Equipage() {
	}

	public Equipage(Long id, String nom, String prenom, Grade grade) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
	}

	public Equipage(String nom, String prenom, Grade grade) {
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Equipage [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", grade=" + grade + "]";
	}

}
