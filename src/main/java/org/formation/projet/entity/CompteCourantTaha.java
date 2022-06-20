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

	public CompteCourantTaha(Long id, Long numeroCompte, String dateOuverture, Double solde, Boolean vip,
			ClientTaha client, Double decouvert) {
		super(id, numeroCompte, dateOuverture, solde, vip);
		this.client = client;
		this.decouvert = decouvert;
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
