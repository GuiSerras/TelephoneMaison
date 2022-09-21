package com.cda.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Bien {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBien;
	@NotEmpty
	private String image ;
	@NotEmpty
	private String adresseB;
	@NotNull
	private int numeroB; 

	private String indiceRepB;
	@NotEmpty
	private String villeB;
	@NotNull
	private int codePostalB;
	@NotNull
	private Double prix;
	@NotNull
	private Double superficie;

	private Boolean isEnableB = true;
	
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	//getter and Setter//
	public Long getIdBien() {
		return idBien;
	}
	public void setIdBien(Long idBien) {
		this.idBien = idBien;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAdresseB() {
		return adresseB;
	}
	public void setAdresseB(String adresseB) {
		this.adresseB = adresseB;
	}
	public int getNumeroB() {
		return numeroB;
	}
	public void setNumeroB(int numeroB) {
		this.numeroB = numeroB;
	}
	public String getIndiceRepB() {
		return indiceRepB;
	}
	public void setIndiceRepB(String indiceRepB) {
		this.indiceRepB = indiceRepB;
	}
	public String getVilleB() {
		return villeB;
	}
	public void setVilleB(String villeB) {
		this.villeB = villeB;
	}
	public int getCodePostalB() {
		return codePostalB;
	}
	public void setCodePostalB(int codePostalB) {
		this.codePostalB = codePostalB;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}
	public Boolean getIsEnableB() {
		return isEnableB;
	}
	public void setIsEnableB(Boolean isEnableB) {
		this.isEnableB = isEnableB;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
