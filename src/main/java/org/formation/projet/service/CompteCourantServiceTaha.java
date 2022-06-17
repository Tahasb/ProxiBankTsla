package org.formation.projet.service;

import org.formation.projet.entity.CompteCourantTaha;

public interface CompteCourantServiceTaha {
	
	CompteCourantTaha findById(Long id);
	void updateCompte(CompteCourantTaha cr);
	

}