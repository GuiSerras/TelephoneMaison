package com.cda.blog.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cda.blog.constraint.ValidPassword;

@Entity
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
			name = "users_roles", 
			joinColumns = @JoinColumn(
					name = "id_user", referencedColumnName = "idUser"), 
			inverseJoinColumns = @JoinColumn(
					name = "id_role", referencedColumnName = "idRole")) 
	private Collection<Role> roles;

	@OneToMany(mappedBy = "user")
	private Collection<Bien> biens;

	@Email(regexp=".+@.+\\..+" , message="Mail pas conforme.")
	@NotEmpty(message="Le mail ne doit pas etre vide.")
	private String email;

	@NotEmpty(message="Le nom ne doit pas etre vide.")
	private String nom;

	@NotEmpty(message="Le prenom ne doit pas etre vide.")
	private String prenom;

	@ValidPassword
	@NotEmpty(message="Le mot de passe ne doit pas etre vide.")
	private String password;

	@NotEmpty(message="Le numéro de telephone ne doit pas etre vide.")
	private String telephone;

	private Date dateN;
	private LocalDate dateI;

	private boolean enabled = false;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Bien> getBiens() {
		return biens;
	}

	public void setBiens(Collection<Bien> biens) {
		this.biens = biens;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public LocalDate getDateI() {
		return dateI;
	}

	public void setDateI(LocalDate dateI) {
		this.dateI = dateI;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


}
