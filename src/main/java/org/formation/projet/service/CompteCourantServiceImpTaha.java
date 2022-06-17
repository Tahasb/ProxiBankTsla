package org.formation.projet.service;

import org.formation.projet.entity.CompteCourantTaha;
import org.formation.projet.repository.CompteCourantRepositoryTaha;
import org.springframework.stereotype.Service;

@Service
public class CompteCourantServiceImpTaha implements CompteCourantServiceTaha {

	CompteCourantRepositoryTaha crRepository;

	CompteCourantServiceImpTaha(CompteCourantRepositoryTaha crRepository) {
		this.crRepository = crRepository;
	}

	@Override
	public CompteCourantTaha findById(Long id) {
		return crRepository.findCompteCourantById(id);

	}

	@Override
	public void updateCompte(CompteCourantTaha cr) {
		crRepository.save(cr);

	}

}