package org.formation.projet.service;

import java.util.Optional;

import org.formation.projet.entity.Conseiller;

public interface ICrudServiceConseiller {

	public Iterable<Conseiller> listConseillers();

	public void deleteById(Long id);

	public boolean checkConseiller(Long id);

	public void editConseiller(long id, Conseiller conseiller);

	void save(Conseiller conseiller);

	public Optional<Conseiller> getConseillerbyId(Long id);

}
