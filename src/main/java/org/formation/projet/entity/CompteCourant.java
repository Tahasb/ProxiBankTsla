package org.formation.projet.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CompteCourant extends Compte {

	private static final Double decouvert=1000.00;
//	private CarteBancaire cb;
	
	@JsonIgnore
	@OneToOne
	private Client client;
 
	public CompteCourant() {
	}

	public CompteCourant(String numeroCompte, Date dateOuverture, Double solde, Boolean vip, Double decouvert,
			CarteBancaire cb) {
		super(numeroCompte, dateOuverture, solde, vip);

	}

	public Double getDecouvert() {
		return decouvert;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

//	public CarteBancaire getCb() {
//		return cb;
//	}
//
//	public void setCb(CarteBancaire cb) {
//		this.cb = cb;
//	}

}
