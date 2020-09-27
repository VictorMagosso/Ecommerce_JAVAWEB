package br.com.cadastro.ecommerce.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name="ADMINS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admin implements UserDetails{
//	
//	explicacao:
//		1. ManyToMany nessa e na classe Role
//		2. É necessario dar um nome para essa table intermediaria, no caso, vai se chamar "admins_roles"
//		3. com o JoinColumn, vamos referenciar os ids dessa nova table, no caso vamos pegar o email da model Admin e o emailRole da model Role
	@ManyToMany
	@JoinTable(name = "admins_roles", joinColumns = @JoinColumn(
			name = "admin_id", referencedColumnName = "email"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "emailRole"))
	private List<Role> roles;
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	private String senha;
	private String rg;
	
	@Column(name="data_nasc")
	private String dataNasc;
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Admin(String firstName, String lastName, String email, String senha, String rg, String dataNasc) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.senha = senha;
		this.rg = rg;
		this.dataNasc = dataNasc;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}

