package org.formation.projet.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CompteTaha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroCompte;
	private String dateOuverture;
	private Double solde;

	private Boolean vip;



	public CompteTaha(Long id, Long numeroCompte, String dateOuverture, Double solde, Boolean vip) {
		
		this.id = id;
		this.numeroCompte = numeroCompte;
		this.dateOuverture = dateOuverture;
		this.solde = solde;
		this.vip = vip;
	}



	public CompteTaha() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}



	public Long getNumeroCompte() {
		return numeroCompte;
	}



	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	

}
