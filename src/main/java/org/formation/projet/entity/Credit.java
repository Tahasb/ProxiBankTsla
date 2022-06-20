package org.formation.projet.entity;

import java.beans.JavaBean;

@JavaBean
public class Credit {

	private double montant;
	private double taux;
	private int duree;

	public Credit(double montant, double taux, int duree) {
		super();
		this.montant = montant;
		this.taux = taux;
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Credit [montant=" + montant + ", taux=" + taux + ", duree=" + duree + "]";
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Credit() {
		super();
	}

}
