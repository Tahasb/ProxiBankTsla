package org.formation.projet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conseiller extends Staff {

	private String nom;
	private String prenom;
	private Date date;

	@OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
	private List<Client> clients = new ArrayList<>();

	@ManyToOne
	private Directeur directeur;

	public Conseiller() {

	}

	public Conseiller(String nom, String prenom, List<Client> clients, Directeur directeur) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.clients = clients;
		this.directeur = directeur;
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

	@Override
	public String toString() {
		return "Client1 [id=" + getId() + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
