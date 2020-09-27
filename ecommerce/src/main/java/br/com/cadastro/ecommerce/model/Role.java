package br.com.cadastro.ecommerce.model;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	@ManyToMany
	private List<Admin> admins;
	
	@Id
	private String emailRole;

	@Override
	public String getAuthority() {
		
		return this.emailRole;
	}

	public String getEmailRole() {
		return emailRole;
	}

	public void setEmailRole(String emailRole) {
		this.emailRole = emailRole;
	}
	

}
