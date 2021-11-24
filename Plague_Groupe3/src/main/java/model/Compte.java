package model;


public class Compte {
	
protected int id;
protected String login;
protected String password;
protected Type_compte type_compte;
protected String nom;
protected String prenom;


public Compte(int id, String login, String password, Type_compte type_compte, String nom, String prenom) {
	super();
	this.id = id;
	this.login = login;
	this.password = password;
	this.type_compte = type_compte;
	this.nom = nom;
	this.prenom = prenom;
}


public Compte(String login, String password, Type_compte type_compte, String nom, String prenom) {
	super();
	this.login = login;
	this.password = password;
	this.type_compte = type_compte;
	this.nom = nom;
	this.prenom = prenom;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Type_compte getType_compte() {
	return type_compte;
}


public void setType_compte(Type_compte type_compte) {
	this.type_compte = type_compte;
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


@Override
public String toString() {
	return "Compte [id=" + id + ", login=" + login + ", password=" + password + ", type_compte=" + type_compte
			+ ", nom=" + nom + ", prenom=" + prenom + "]";
}











}

	
	
	
	
	


