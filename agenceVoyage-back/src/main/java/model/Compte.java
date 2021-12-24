package model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
public abstract class Compte implements Serializable {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )

	protected Long id;
	@JsonView(JsonViews.Common.class)
	protected String login;
	@JsonView(JsonViews.Common.class)
	protected String password;
	
	public Compte () {
		
		
	}
	
	public Compte(Long id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
		
	}
	
	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	
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

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}


	
	
}
