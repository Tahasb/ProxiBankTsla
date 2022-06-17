package org.formation.projet.DTO;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.formation.projet.entity.CompteCourantTaha;
import org.formation.projet.entity.CompteEpargneTaha;
import org.formation.projet.entity.ConseillerTaha;

public class ClientDTOTaha {

	private ConseillerTaha conseiller;

	private Boolean compteCourant;

	private Boolean compteEpargne;
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String date;

	public ClientDTOTaha() {

	}

	public ClientDTOTaha(ConseillerTaha conseiller, Boolean compteCourant, Boolean compteEpargne, String nom, String prenom,
			String email, String adresse, String date) {

		this.conseiller = conseiller;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.date = date;
	}

	public ConseillerTaha getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerTaha conseiller) {
		this.conseiller = conseiller;
	}

	public Boolean getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(Boolean compteCourant) {
		this.compteCourant = compteCourant;
	}

	public Boolean getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(Boolean compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
