package org.formation.projet.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ConseillerTaha {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;

	@OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
	private List<ClientTaha> clients;

	public ConseillerTaha() {

	}

	public ConseillerTaha(String nom, String prenom) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Client1 [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
