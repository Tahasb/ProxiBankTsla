package org.formation.projet.service;

import java.util.Optional;

import org.formation.projet.entity.Conseiller;
import org.formation.projet.repository.ConseillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudConseillerServiceImpl implements ICrudServiceConseiller {
	@Autowired
	ConseillerRepository conseillerRepository;

	@Override
	public void save(Conseiller conseiller) {
		conseillerRepository.save(conseiller);
	}

	@Override
	public Iterable<Conseiller> listConseillers() {
		System.out.println(conseillerRepository.findAll());
		return (conseillerRepository.findAll());

	}

	@Override
	public void deleteById(Long id) {
		conseillerRepository.deleteById(id);
	}

	@Override
	public boolean checkConseiller(Long id) {
		if (conseillerRepository.existsById(id)) {
			return true;
		}
		return false;
	}

	@Override
	public void editConseiller(long id, Conseiller conseiller) {

		conseillerRepository.findById(conseiller.getId()).get().setId(id);

		conseillerRepository.findById(id).get().setNom(conseiller.getNom());
		conseillerRepository.findById(id).get().setPrenom(conseiller.getPrenom());

	}

	@Override
	public Optional<Conseiller> getConseillerbyId(Long id) {
		return conseillerRepository.findById(id);

	}

}
