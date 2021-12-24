package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Equipage implements Serializable {

	
		private Long id;
		private String nom;
		private String prenom;
		private Grade grade;
		
		public Equipage () {}

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
