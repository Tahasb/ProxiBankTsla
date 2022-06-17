package org.formation.projet.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String nom;
	public String prenom;
	public Boolean direction;

	public Staff() {
	}

	public Staff(String nom, String prenom, Boolean direction) {

		this.nom = nom;
		this.prenom = prenom;
		this.direction = direction;
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

	public Boolean getDirection() {
		return direction;
	}

	public void setDirection(Boolean direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
