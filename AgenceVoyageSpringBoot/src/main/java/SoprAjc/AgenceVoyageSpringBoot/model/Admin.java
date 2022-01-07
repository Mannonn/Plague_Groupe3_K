package SoprAjc.AgenceVoyageSpringBoot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {

	public Admin() {
	}

	public Admin(String login, String password) {
		super(login, password);
		this.enabled=true;
	}

	public Admin(Long id, String login, String password, boolean enabled) {
		super(id, login, password, enabled);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

}
