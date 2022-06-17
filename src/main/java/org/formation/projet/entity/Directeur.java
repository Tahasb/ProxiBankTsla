package org.formation.projet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Directeur extends Staff {

	@OneToMany(mappedBy = "directeur", cascade = CascadeType.ALL)
	List<Conseiller> conseillers;

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Directeur() {
	}

	public Directeur(List<Conseiller> conseillers) {
		super();
		this.conseillers = conseillers;
	}


}
