package org.formation.projet.service;

import org.formation.projet.entity.CompteEpargneTaha;
import org.formation.projet.repository.CompteEpargneRepositoryTaha;
import org.springframework.stereotype.Service;

@Service
public class CompteEpargneServiceImpTaha implements CompteEpargneServiceTaha {

	CompteEpargneRepositoryTaha crRepository;

	CompteEpargneServiceImpTaha(CompteEpargneRepositoryTaha crRepository) {
		this.crRepository = crRepository;
	}

	@Override
	public CompteEpargneTaha findById(Long id) {
		return crRepository.findCompteEpargneById(id);

	}

	@Override
	public void updateCompte(CompteEpargneTaha cr) {
		crRepository.save(cr);
		
	}

	

}
