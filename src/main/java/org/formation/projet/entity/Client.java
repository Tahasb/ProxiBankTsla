package org.formation.projet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	
	@Value("${some.key:Non renseignee")
	private String adresse;

	@JsonIgnore
	@ManyToOne
	private Conseiller conseiller;

	@OneToOne(cascade = CascadeType.ALL)
	private CompteCourant compteCourant;

	@OneToOne(cascade = CascadeType.ALL)
	private CompteEpargne compteEpargne;

	public Client(Long id, String nom, String prenom, String adresse, Conseiller conseiller, CompteCourant compteCourant,
			CompteEpargne compteEpargne) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.conseiller = conseiller;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public Client() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

}
