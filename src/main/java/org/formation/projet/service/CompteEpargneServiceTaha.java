package org.formation.projet.service;

import org.formation.projet.entity.CompteEpargneTaha;

public interface CompteEpargneServiceTaha {
	
	CompteEpargneTaha findById(Long id);
	void updateCompte(CompteEpargneTaha cr);
	

}
