package org.formation.projet.repository;

import org.formation.projet.entity.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteCourantRepository extends JpaRepository<CompteCourant, Long> {

	CompteCourant findByNumeroCompte(Long numeroCompte);

}
