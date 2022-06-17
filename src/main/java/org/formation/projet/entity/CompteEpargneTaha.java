package org.formation.projet.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CompteEpargneTaha extends CompteTaha {
	
	@OneToOne
	private ClientTaha client;
	public static final String NOM = "Compte epargne";

	private Double tauxRem;

	public CompteEpargneTaha() {
	}

	public CompteEpargneTaha(Long numeroCompte, String dateOuverture, Double solde, Boolean vip, Double tauxRem) {
		super(numeroCompte, dateOuverture, solde, vip);
		this.setTauxRem(tauxRem);
	}

	

	@Override
	public String toString() {
		return "CompteCourant";
	}

	public Double getTauxRem() {
		return tauxRem;
	}

	public void setTauxRem(Double tauxRem) {
		this.tauxRem = tauxRem;
	}

}
