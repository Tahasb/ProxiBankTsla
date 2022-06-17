package org.formation.projet.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Value;

@MappedSuperclass
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "EMP_SEQ")
	private Long id;
	private String numeroCompte;
	private Date dateOuverture;
	private Double solde;
	private Boolean vip;



	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
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

	public Compte( String numeroCompte, Date dateOuverture, Double solde, Boolean vip) {
		this.numeroCompte = numeroCompte;
		this.dateOuverture = dateOuverture;
		this.solde = solde;
		this.vip = vip;
	}

	public Compte() {

	}

}
