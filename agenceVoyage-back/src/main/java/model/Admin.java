package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonView;
@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {
	

	public Admin() {
	}
	
	public Admin(String login, String password) {
		super(login, password);
	}
	
	
	public Admin(Long id,String login, String password) {
		super(id, login, password);
	}
	
	/*public String getLogin() {
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
	}*/
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
}
