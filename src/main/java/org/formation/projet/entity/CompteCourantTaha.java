package org.formation.projet.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CompteCourantTaha extends CompteTaha {

	@OneToOne
	private ClientTaha client;
	public static final String NOM = "Compte courant";

	private Double decouvert;

	public CompteCourantTaha() {
	}

	public CompteCourantTaha(Long numeroCompte, String dateOuverture, Double solde, Boolean vip, Double decouvert) {
		super(numeroCompte, dateOuverture, solde, vip);
		this.setDecouvert(decouvert);
	}

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant";
	}

}
