package org.formation.projet.entity;

import java.beans.JavaBean;

@JavaBean
public class Virement {
	
	private Long numeroCompteDebit; 
	private Long numeroCompteCredit; 
	private double montant;
	

	

	public Virement(Long numeroCompteDebit, Long numeroCompteCredit, double montant) {
		super();
		this.numeroCompteDebit = numeroCompteDebit;
		this.numeroCompteCredit = numeroCompteCredit;
		this.montant = montant;
	}


	@Override
	public String toString() {
		return "Virement [numeroCompteDebit=" + numeroCompteDebit + ", numeroCompteCredit=" + numeroCompteCredit
				+ ", montant=" + montant + "]";
	}


	public Virement() {
		
	}


	public Long getNumeroCompteDebit() {
		return numeroCompteDebit;
	}


	public void setNumeroCompteDebit(Long numeroCompteDebit) {
		this.numeroCompteDebit = numeroCompteDebit;
	}


	public Long getNumeroCompteCredit() {
		return numeroCompteCredit;
	}


	public void setNumeroCompteCredit(Long numeroCompteCredit) {
		this.numeroCompteCredit = numeroCompteCredit;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}



}
