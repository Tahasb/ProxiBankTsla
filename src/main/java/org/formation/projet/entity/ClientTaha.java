package org.formation.projet.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ClientTaha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private ConseillerTaha conseiller;

	@OneToOne(cascade = CascadeType.ALL)
	private CompteCourantTaha compteCourant;

	@OneToOne(cascade = CascadeType.ALL)
	private CompteEpargneTaha compteEpargne;

	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private Date date;

	public ClientTaha() {
	}

	public ClientTaha(String nom, String prenom, String email, String adresse, CompteCourantTaha compteCourant,
			CompteEpargneTaha compteEpargne) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.email = email;
	}

	public ConseillerTaha getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerTaha conseiller) {
		this.conseiller = conseiller;
	}

	public CompteEpargneTaha getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargneTaha compteEpargne) {
		this.compteEpargne = compteEpargne;
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

	public CompteCourantTaha getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourantTaha compteCourant) {
		this.compteCourant = compteCourant;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Client [compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + ", nom=" + nom + "]";
	}

}
