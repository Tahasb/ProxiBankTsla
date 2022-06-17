package org.formation.projet.entity;

import java.beans.JavaBean;

@JavaBean
public class Virement {
	
	private String numeroCompteDebit; 
	private String numeroCompteCredit; 
	private double montant;
	
	public Virement(String numeroCompteDebit, String numeroCompteCredit, double montant) {
		super();
		this.numeroCompteDebit = numeroCompteDebit;
		this.numeroCompteCredit = numeroCompteCredit;
		this.montant = montant;
	}

	public String getNumeroCompteDebit() {
		return numeroCompteDebit;
	}

	public void setNumeroCompteDebit(String numeroCompteDebit) {
		this.numeroCompteDebit = numeroCompteDebit;
	}

	public String getNumeroCompteCredit() {
		return numeroCompteCredit;
	}

	public void setNumeroCompteCredit(String numeroCompteCredit) {
		this.numeroCompteCredit = numeroCompteCredit;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	} 
	

}
