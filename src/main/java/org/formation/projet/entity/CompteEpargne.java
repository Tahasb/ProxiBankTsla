package org.formation.projet.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CompteEpargne extends Compte {

	private double remuneration;

	@JsonIgnore
	@OneToOne
	private Client client;

	public CompteEpargne(String numeroCompte, Date dateOuverture, Double solde, Boolean vip,
			double remuneration) {
		super(numeroCompte, dateOuverture, solde, vip);
		this.remuneration = remuneration;
	}

	public CompteEpargne() {
	}

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

}
